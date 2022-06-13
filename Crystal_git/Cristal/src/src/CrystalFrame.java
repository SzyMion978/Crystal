package src;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import src.panels.AnalisingPanel;
import src.panels.EastPanel;

public class CrystalFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 1400;
	public static final int HEIGHT = 900;
	EastPanel ep;
	FileMenu fm;
	AnalisingPanel analasingPanel;

	public CrystalFrame() throws HeadlessException {
		Dimension size = new Dimension(WIDTH, HEIGHT);
		this.setSize(size);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Crystallographic analysis");
		
		// Panel z ustawieniami
		ep = new EastPanel();
		this.add(ep, BorderLayout.EAST);
		
		// Panel renderowania
		this.analasingPanel = new AnalisingPanel(this);
		this.add(analasingPanel);
		
		fm = new FileMenu();
		this.setJMenuBar(fm);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				CrystalFrame cf = new CrystalFrame();
				cf.setVisible(true);
				cf.analasingPanel.start();
			}			
		});		
	}
}
