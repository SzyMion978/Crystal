package src.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.SoftBevelBorder;

import src.ReadingManager;
import src.renderer.entity.EntityManager;
import src.renderer.entity.builder.ComplexEntityBuilder;
import src.renderer.shapes.CristalPlane;

public class MillerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel titleLabel;
	JRadioButton[] hkl;
	
	public MillerPanel() {

	}
	
	public void generatePanel() {
		titleLabel = new JLabel("MILLER INDICES hkl");
		Matrice_hkl matrice = new Matrice_hkl();
		titleLabel.setFont(new Font("Cambria", Font.BOLD, matrice.hkl.length));
		hkl = new JRadioButton[matrice.hkl.length];
		JPanel hklPanel = new JPanel();
		ButtonGroup group = new ButtonGroup();
		
		for(int i = 0; i < matrice.hkl.length; i++) {
			String hklName = matrice.hkl[i];
			hkl[i] = new JRadioButton(hklName);
			hkl[i].setActionCommand(hklName);
			hkl[i].setBackground(Color.lightGray);
			hklPanel.add(hkl[i]);
			group.add(hkl[i]);
			ActionListener action = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(hklName.compareTo("NULL") != 0) {
						ComplexEntityBuilder.plane = true;
						UnitCell.cristalPlane = new CristalPlane(hklName, 
							ReadingManager.unitCell.a*ReadingManager.scale, 
							ReadingManager.unitCell.b*ReadingManager.scale, 
							ReadingManager.unitCell.c*ReadingManager.scale);
						EntityManager.refreshUnitCell(UnitCell.particles, UnitCell.cristalPlane);
					}
					else {
						ComplexEntityBuilder.plane = false;
						EntityManager.refreshUnitCell(UnitCell.particles, UnitCell.cristalPlane);
					}
					
				}
			};
			hkl[i].addActionListener(action);
			if(hklName.compareTo("NULL") == 0) 
				hkl[i].setSelected(true);
		}
		hklPanel.setLayout(new GridLayout(4, 3));
		hklPanel.setBackground(Color.lightGray);
		
		JPanel helpPanel = new JPanel(new GridLayout(2,1));
		helpPanel.add(titleLabel);
		JLabel tmLabel = new JLabel("Crystallographic planes:");
		tmLabel.setFont(new Font("Cambria", Font.BOLD, 12));
		helpPanel.add(tmLabel);
		helpPanel.setBackground(Color.lightGray);
		
		this.add(helpPanel);
		this.add(hklPanel);
		this.setBackground(Color.lightGray);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(new SoftBevelBorder(WIDTH, Color.black, Color.black));
	}

}
