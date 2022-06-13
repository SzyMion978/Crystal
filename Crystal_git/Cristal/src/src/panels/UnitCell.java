package src.panels;

import java.awt.Color;

import src.renderer.shapes.CristalPlane;

public class UnitCell {

	int typesN = 1;
	public int particlesN = 1;
	static String[] particleTypes;
	public double a = 0;
	public double b = 0;
	public double c = 0;
	public static Particle[] particles;
	public static CristalPlane cristalPlane = null;
	public Particle[] rapresentation;
	Color[] colors = {Color.CYAN, Color.ORANGE, Color.lightGray, Color.RED, Color.yellow};
	
	public UnitCell() {
		particleTypes = new String[typesN];
		rapresentation = new Particle[typesN];
		particles = new Particle[particlesN];
	}
	
	public void generateRepresentation() {
		int k = 0;
		for(String s : particleTypes) {
			for(Particle p : particles) {
				if(p.name.compareTo(s) == 0) {
					this.rapresentation[k++] = p;
					break;
				}
			}
		}
	}
	
	public static void setPGColor(String s, Color color) {
		for(Particle p : particles) {
			if(s.compareTo(p.name) == 0) {
				p.color = color;
			}
		}
	}
	
	public static void refreshRadians(double[] radians) {
		int t = 0;
		for(String s : particleTypes) {
			for(Particle p : particles) {
				if(s.compareTo(p.name) == 0) {
					p.r = radians[t];
				}		
			}
			t++;
		}
	}
	
	public void setIntialColor() {
		int t = 0;
		for(String s : particleTypes) {
			for(Particle p : particles) {
				if(s.compareTo(p.name) == 0) {
					p.color = colors[t];
				}		
			}
			t++;
		}
	}

	public void addParticle(int n, Particle p) {
		particles[n-1] = p;
		return;
	}
	
	public void addParticleType(int n, String s) {
		particleTypes[n-1] = s;
		return;
	}
	
	public int getTypesN() {
		return typesN;
	}

	public void setTypesN(int typesN) {
		this.typesN = typesN;
		particleTypes = new String[typesN];
		rapresentation = new Particle[typesN];
	}

	public int getParticlesN() {
		return particlesN;
	}

	public void setParticlesN(int particlesN) {
		this.particlesN = particlesN;
		particles = new Particle[particlesN];
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}
}
