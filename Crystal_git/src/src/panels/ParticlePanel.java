package src.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;

import src.ReadingManager;
import src.renderer.entity.EntityManager;
import src.renderer.entity.builder.ComplexEntityBuilder;
import src.renderer.input.Keyboard;
import src.renderer.shapes.CristalPlane;

public class ParticlePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel typesLabel;
	JLabel[] typesLabels;
	JLabel[] radiansLabels;
	public static JTextField[] radians;
	colorTypeBut[] ctb;
	Particle[] PartTab;
	static Keyboard keyboard;
	
	
	public ParticlePanel() {
		
		keyboard = new Keyboard();
	}
	
	public void generatePanel(Particle[] PartTab) {
		this.removeAll();
		typesLabel = new JLabel(PartTab.length + " PARTICLE TYPES:");
		typesLabel.setFont(new Font("Cambria", Font.BOLD, 14));
		
		typesLabels = new JLabel[PartTab.length];
		
		radiansLabels = new JLabel[PartTab.length];
		radians = new JTextField[PartTab.length];
		JLabel[] angstrom = new JLabel[PartTab.length];
		
		ctb = new colorTypeBut[PartTab.length];
				
		for(int i = 0; i < PartTab.length; i++) {
			typesLabels[i] = new JLabel("Type " + (i+1) + ":   " + PartTab[i].name);
			typesLabels[i].setFont(new Font("Cambria", Font.BOLD, 12));
			radiansLabels[i] = new JLabel("       r = ");
			radiansLabels[i].setFont(new Font("Cambria", Font.BOLD, 12));
			radians[i] = new JTextField(Float.toString((float)PartTab[i].r), 4);
			radians[i].addKeyListener(keyboard);
			angstrom[i] = new JLabel("<html>&#8491</html>");
			angstrom[i].setFont(new Font("Cambria", Font.BOLD, 12));
			ctb[i] = new colorTypeBut(PartTab[i].name, PartTab[i].color);
		}	
			
		JPanel helpPanel = new JPanel(new GridLayout(1,1));
		helpPanel.add(typesLabel);
		JPanel tmpPanel = new JPanel(new GridLayout(PartTab.length, 1));
			
		// buttons gate
	
		JPanel[] butPanels = new JPanel[PartTab.length];
		JPanel[] textPanels = new JPanel[PartTab.length];
		
		for(int j = 0; j < PartTab.length; j++) {
			butPanels[j] = new JPanel();
			textPanels[j] = new JPanel();
			ctb[j].setColor(PartTab[j].color);
			butPanels[j].add(ctb[j]);
			textPanels[j].add(radians[j]);
			butPanels[j].setLayout(new FlowLayout());
			butPanels[j].setBackground(Color.gray);
			
			textPanels[j].setLayout(new FlowLayout());
			textPanels[j].setBackground(Color.gray);
		}
		
		// Wczytanie kolejnych wierszy
		JPanel[] rows = new JPanel[PartTab.length];
		for(int j = 0; j < PartTab.length; j++) {
			rows[j] = new JPanel();
			rows[j].setLayout(new FlowLayout());
			rows[j].add(typesLabels[j]);
			rows[j].add(radiansLabels[j]);
			rows[j].add(textPanels[j]);
			rows[j].add(angstrom[j]);
			rows[j].add(butPanels[j]);
			rows[j].setBackground(Color.gray);
		}
		
		for(int j = 0; j < PartTab.length; j++) {
			tmpPanel.add(rows[j]);
		}
		
		
		tmpPanel.setBackground(Color.gray);
		helpPanel.setBackground(Color.gray);
		this.add(helpPanel);
		this.add(tmpPanel);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.gray);
		this.setBorder(new SoftBevelBorder(WIDTH, Color.black, Color.black));
	}
	
	public static double[] getRadians() {
		double[] radians = new double[ParticlePanel.radians.length];
		for(int i = 0; i < ParticlePanel.radians.length; i++) {
			radians[i] = Double.parseDouble(ParticlePanel.radians[i].getText());
		}		
		return radians;
	}
	
	public static void update() {
		if(ParticlePanel.keyboard.getRefresh() && EntityManager.unitCellLoaded) {
			UnitCell.refreshRadians(ParticlePanel.getRadians());
			if(ComplexEntityBuilder.plane) {
				UnitCell.cristalPlane = new CristalPlane(UnitCell.cristalPlane.hkl, 
						ReadingManager.unitCell.a*ReadingManager.scale, 
						ReadingManager.unitCell.b*ReadingManager.scale, 
						ReadingManager.unitCell.c*ReadingManager.scale); 
			}
			EntityManager.refreshUnitCell(UnitCell.particles, UnitCell.cristalPlane);
		}
		ParticlePanel.keyboard.update();
	}
}
