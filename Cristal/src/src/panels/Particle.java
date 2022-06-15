package src.panels;

import java.awt.Color;

public class Particle {

	public double x,y,z;
	public String name;
	public double r;
    public Color color;
	
	public Particle(double[] coordTab, String n, double R, Color c) {
		x = coordTab[0];
		y = coordTab[1];
		z = coordTab[2];
		name = n;
		r = R;
		color = c;
	}
	
	public Particle() {
		x = 0.0;
		y = 0.0;
		z = 0.0;
		name = "X";
		r = 0.1;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
