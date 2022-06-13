package src;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.swing.JOptionPane;

import src.panels.DataPanel;
import src.panels.EastPanel;
import src.panels.Particle;
import src.panels.UnitCell;
import src.renderer.entity.EntityManager;

public class ReadingManager implements Runnable {

	boolean running = false;
	private Thread thread;
	InputStreamReader streamReader;
	File inputFile = null;
	boolean coord = false;
	public static boolean success = true;
	
	
	public static UnitCell unitCell;
	public static double scale = 20;
	
	public ReadingManager() {
		unitCell = new UnitCell();
	}

	public synchronized void start() {
		running = true;
		this.thread = new Thread(this, "Reading");
		this.thread.start();		
	} 
	
	public synchronized void stop() {
		running = false;
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// analiseLine() odpowiada za w³aœciwe przypisanie wczytywanych danych
	private void analiseLine(String line) {
			String[] words = line.split("\\s");
			if(!coord) {			
				if(words[0].compareTo("types_number") == 0) {
					unitCell.setTypesN(Integer.parseInt(words[1]));
				}
				else if(words[0].compareTo("type") == 0) {
					unitCell.addParticleType(Integer.parseInt(words[1]), words[2]);
				}
				else if(words[0].compareTo("particles_number") == 0) {
					unitCell.setParticlesN(Integer.parseInt(words[1]));
				}
				else if(words[0].compareTo("lattice_constant_a") == 0) {
					unitCell.setA(Double.parseDouble(words[1]));
				}
				else if(words[0].compareTo("lattice_constant_b") == 0) {
					unitCell.setB(Double.parseDouble(words[1]));
				}
				else if(words[0].compareTo("lattice_constant_c") == 0) {
					unitCell.setC(Double.parseDouble(words[1]));
				}
				else if(words[0].compareTo("Coordinates:") == 0) {
					this.coord = true;
				}
			}
			else if(coord) {
				for(int i = 1; i <= unitCell.particlesN; i++) {
					double[] coordinates = {
							scale*(Double.parseDouble(words[2]) - unitCell.a/2),							 
							scale*(Double.parseDouble(words[3]) - unitCell.b/2), 
							scale*(Double.parseDouble(words[4]) - unitCell.c/2)};
					unitCell.addParticle(Integer.parseInt(words[0]), new Particle(coordinates, words[1], 10, Color.GRAY)); 
				}
					
			}
	}
	
	@Override
	public void run() {
			try {
				InputStreamReader streamReader = new InputStreamReader(
			        new FileInputStream(inputFile),
			        Charset.forName("UTF-8").newDecoder());
				try (BufferedReader bufferedReader = new BufferedReader(streamReader)) {
					String line;
					try {
						line = bufferedReader.readLine();
						while (line != null) {
							this.analiseLine(line);
							line = bufferedReader.readLine();
						}
						coord = false;
					} catch (IOException e) {
						success = false;
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					success = false;
					throw e;
				} catch (IOException e) {
					success = false;
					e.printStackTrace();
				}	
			} catch (FileNotFoundException e) {
				success = false;
			}
			if(success) {
				unitCell.setIntialColor();
				EntityManager.addUnitCell(UnitCell.particles);;	
				unitCell.generateRepresentation();	
				EastPanel.generatePanels(unitCell.rapresentation);
				DataPanel.setFileName(this.inputFile.getName());
			}
			else {
				JOptionPane.showMessageDialog(null, "Reading data file failed. Check its correctness by comparing"
						+ " with example data ", "Failure", JOptionPane.ERROR_MESSAGE);
			}
		this.stop();
	}
	
	public File getInputFile() {
		return inputFile;
	}

	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}

	
}
