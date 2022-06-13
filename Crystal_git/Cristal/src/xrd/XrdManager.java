package xrd; 
 
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import src.panels.EastPanel;
import src.renderer.point.MyVector;

public class XrdManager implements Runnable {

	private Thread thread;
	private double thetaMax;
	private double thetaMin;
	private double lambda;
	public static List<Double> intensities;
	public static List<Double> thetas;
	public static File xrdFile;
	private Func func;
	private final static double dtheta = 0.1;
	
	JFreeChart chart = null;
	XYDataset xydataset = null;
	
	public XrdManager() {
		thetaMax = Double.parseDouble( EastPanel.diffp.getMaxText().getText() );
		thetaMin = Double.parseDouble( EastPanel.diffp.getMinText().getText() );
		lambda = Double.parseDouble( EastPanel.diffp.getWaveText().getText() );
		func = new Func();
	}

	public synchronized void start() {
		this.thread = new Thread(this, "Xrd");
		this.thread.start();	
	}
	
	public synchronized void stop() {
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeToFile() {
		try {
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(xrdFile), Charset.forName("UTF-8").newEncoder()); 		        			        
			try (BufferedWriter bw = new BufferedWriter(osw)) {
				int k = 0;
				for(double t : thetas) {
					bw.write( (t-dtheta) + "\t\t\t" +  0.0 + "\n");
					bw.write( t + "\t\t\t" +  intensities.get(k++).toString() + "\n");
					bw.write( (t+dtheta) + "\t\t\t" +  0.0 + "\n");
				}
				System.out.println(xrdFile.getAbsolutePath());
			}
			osw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
			
	@Override
	public void run() {
		intensities = new ArrayList<Double>();
		thetas = new ArrayList<Double>();
		
		double tmp = Math.asin(lambda * Math.sqrt(Func.k_vec.get(0).x * Func.k_vec.get(0).x 
				+ Func.k_vec.get(0).y * Func.k_vec.get(0).y 
				+ Func.k_vec.get(0).z * Func.k_vec.get(0).z)/2) * 180 / Math.PI;
		
		double sum = 0;
		
		for(MyVector k : Func.k_vec) {					
			double theta = Math.asin(lambda * Math.sqrt(k.x * k.x + k.y * k.y + k.z * k.z) / 2);			
			double t = 180*theta/Math.PI;
			// Sprawdzenie_czy_nie_s¹_powielane_k¹ty
			if((int)(1000 * t) != (int)(1000 * tmp)) {
				if(2 * tmp >= thetaMin && 2 * tmp <= thetaMax) {
					thetas.add(2 * tmp);	 						
					intensities.add(sum);
				}
				sum = 0;
				sum += func.Intensity(lambda, theta, k);
				tmp = t;
			}
			else {
				sum += func.Intensity(lambda, theta, k);
				tmp = t;
			}											
		}
		XrdManager.writeToFile();
		this.generateData();
		this.generateFrame();
		this.stop();
	}
	
	private void generateData() {
		XYSeries dataSet = new XYSeries("Intensity");
		dataSet.add(thetaMin, 0.0);
		for(int i = 0; i < thetas.size(); i++) {
			dataSet.add(thetas.get(i) - dtheta, 0.0);
			dataSet.add(thetas.get(i), intensities.get(i));
			dataSet.add(thetas.get(i) + dtheta, 0.0);
		}
		dataSet.add(thetaMax, 0.0);
		this.xydataset = new XYSeriesCollection(dataSet);
			
		this.chart = ChartFactory.createXYLineChart("Diffraction Pattern", "2Theta[degrees]", "Intensity", xydataset, PlotOrientation.VERTICAL, true, true,  false);
		chart.removeLegend();
		chart.setBorderStroke(new BasicStroke(1));
		TextTitle tt = new TextTitle("Diffraction Pattern", new Font("Cambria", 10, 20));
		chart.setTitle(tt);
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setRangeGridlinesVisible(false);
		plot.getRenderer().setSeriesPaint(0, new Color(100, 0, 0));		
	}
	
	private void generateFrame() {
		ChartPanel panel = new ChartPanel(this.chart);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(750, 480);
		
		frame.add(panel);
		frame.setVisible(true);
	}
}
