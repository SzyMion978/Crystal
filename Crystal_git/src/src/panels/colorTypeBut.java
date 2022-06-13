package src.panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import src.ReadingManager;
import src.renderer.entity.EntityManager;
import src.renderer.entity.builder.ComplexEntityBuilder;
import src.renderer.shapes.CristalPlane;

public class colorTypeBut extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String ParticleID;
	Color color;

	public colorTypeBut(String text, Color color) {
		super(" ");
		this.ParticleID = text;
		this.color = color;
		this.addActionListener(this);
		this.setBackground(color);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Color newClolor = JColorChooser.showDialog(this,"Choose a particle type color", this.color);
		this.setBackground(newClolor);
		this.setColor(newClolor);

		UnitCell.setPGColor(this.ParticleID, newClolor);
		if(ComplexEntityBuilder.plane) {
			UnitCell.cristalPlane = new CristalPlane(UnitCell.cristalPlane.hkl, 
					ReadingManager.unitCell.a*ReadingManager.scale, 
					ReadingManager.unitCell.b*ReadingManager.scale, 
					ReadingManager.unitCell.c*ReadingManager.scale); 
		}

		EntityManager.refreshUnitCell(UnitCell.particles, UnitCell.cristalPlane);
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
