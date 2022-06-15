package src.renderer.shapes;

import java.awt.Color;
import java.awt.Graphics;

import src.renderer.point.MyVector;

public class Polyhedron {

	private MyPolygon[] polygons;
	private Color color;
	
	public Polyhedron(Color color, boolean decayColor, MyPolygon... polygons) {
		this.color = color;
		this.polygons = polygons;
		if(decayColor) {
			this.setDecayingPolygonColor();
		}
		else {
			this.setPolygonColor();
		}
		this.sortPolygons();
	}
	public Polyhedron(MyPolygon... polygons) {
		this.color = Color.white;
		this.polygons = polygons;
		this.sortPolygons();
	}

	public void render(Graphics g) {
		for(MyPolygon poly : this.polygons) {
			poly.render(g);
		}
	}
	
	public void translate(double x, double y, double z) {
		for(MyPolygon p : this.polygons) {
			p.translate(x, y, z);
		}
		this.sortPolygons();
	}
	
	public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees, MyVector lightVector) {
		for(MyPolygon p : this.polygons) {
			p.rotate(CW, xDegrees, yDegrees, zDegrees, lightVector);
			
		}
		this.sortPolygons();
	}
	
	public void setLighting(MyVector lightVector) {
		for(MyPolygon p : this.polygons) {
			p.setLighting(lightVector);
			
		}
	}
	
	private void sortPolygons() {
		this.polygons = MyPolygon.sortPolygons(this.polygons);
	}
	
	private void setPolygonColor() {
		for(MyPolygon poly : this.polygons) {
			poly.setColor(this.color);
		}
	}
	private void setDecayingPolygonColor() {
		double decayFactor = 0.95;
		for(MyPolygon poly : this.polygons) {
			poly.setColor(this.color);
			int r = (int)(this.color.getRed() * decayFactor);
			int g = (int)(this.color.getGreen() * decayFactor);
			int b = (int)(this.color.getBlue() * decayFactor);
			this.color = new Color(r,g,b);
		}
	}
	
	public MyPolygon[] getPolygons() {
		return this.polygons;
	}
}
