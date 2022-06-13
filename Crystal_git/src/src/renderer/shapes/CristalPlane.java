package src.renderer.shapes;

import java.awt.Color;

import src.renderer.point.MyPoint;

public class CristalPlane {

	public String hkl = "";
	public MyPolygon plane;
	double a, b, c;
	
	public CristalPlane() {}
	
	public CristalPlane(String hkl, double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.hkl = hkl;
		
		if(this.hkl.compareTo("(100)") == 0) {
			plane = new MyPolygon(Color.cyan, new MyPoint(-a/2, -b/2, -c/2), new MyPoint(-a/2, b/2, -c/2), new MyPoint(-a/2, b/2, c/2), new MyPoint(-a/2, -b/2, c/2));
		}
		if(this.hkl.compareTo("(010)") == 0) {
			plane = new MyPolygon(Color.cyan, new MyPoint(-a/2, -b/2, -c/2), new MyPoint(a/2, -b/2, -c/2), new MyPoint(a/2, -b/2, c/2), new MyPoint(-a/2, -b/2, c/2));
		}
		if(this.hkl.compareTo("(001)") == 0) {
			plane = new MyPolygon(Color.cyan, new MyPoint(-a/2, -b/2, -c/2), new MyPoint(a/2, -b/2, -c/2), new MyPoint(a/2, b/2, -c/2), new MyPoint(-a/2, b/2, -c/2));
		}
		if(this.hkl.compareTo("(-101)") == 0) {
			plane = new MyPolygon(Color.cyan, new MyPoint(-a/2, -b/2, -c/2), new MyPoint(a/2, -b/2, c/2), new MyPoint(a/2, b/2, c/2), new MyPoint(-a/2, b/2, -c/2));
		}
		if(this.hkl.compareTo("(101)") == 0) {
			plane = new MyPolygon(Color.cyan, new MyPoint(a/2, -b/2, -c/2), new MyPoint(-a/2, -b/2, c/2), new MyPoint(-a/2, b/2, c/2), new MyPoint(a/2, b/2, -c/2));
		}
		if(this.hkl.compareTo("(-110)") == 0) {
			plane = new MyPolygon(Color.cyan, new MyPoint(-a/2, -b/2, -c/2), new MyPoint(a/2, b/2, -c/2), new MyPoint(a/2, b/2, c/2), new MyPoint(-a/2, -b/2, c/2));
		}
		if(this.hkl.compareTo("(110)") == 0) {
			plane = new MyPolygon(Color.cyan, new MyPoint(a/2, -b/2, -c/2), new MyPoint(-a/2, b/2, -c/2), new MyPoint(-a/2, b/2, c/2), new MyPoint(a/2, -b/2, c/2));
		}
		if(this.hkl.compareTo("(0-11)") == 0) {
			plane = new MyPolygon(Color.cyan, new MyPoint(-a/2, -b/2, -c/2), new MyPoint(-a/2, b/2, c/2), new MyPoint(a/2, b/2, c/2), new MyPoint(a/2, -b/2, -c/2));
		}
		if(this.hkl.compareTo("(011)") == 0) {
			plane = new MyPolygon(Color.cyan, new MyPoint(-a/2, -b/2, c/2), new MyPoint(a/2, -b/2, c/2), new MyPoint(a/2, b/2, -c/2), new MyPoint(-a/2, b/2, -c/2));
		}
		if(this.hkl.compareTo("(111)") == 0) {
			plane = new MyPolygon(Color.cyan, new MyPoint(a/2, -b/2, -c/2), new MyPoint(-a/2, b/2, -c/2), new MyPoint(-a/2, -b/2, c/2));
		}
		if(this.hkl.compareTo("(-111)") == 0) {
			plane = new MyPolygon(Color.cyan, new MyPoint(-a/2, -b/2, -c/2), new MyPoint(a/2, b/2, -c/2), new MyPoint(a/2, -b/2, c/2));
		}
		if(this.hkl.compareTo("(1-11)") == 0) {
			plane = new MyPolygon(Color.cyan, new MyPoint(-a/2, -b/2, -c/2), new MyPoint(a/2, b/2, -c/2), new MyPoint(-a/2, b/2, c/2));
		}
		if(this.hkl.compareTo("(11-1)") == 0) {
			plane = new MyPolygon(Color.cyan, new MyPoint(a/2, -b/2, c/2), new MyPoint(-a/2, b/2, c/2), new MyPoint(-a/2, -b/2, -c/2));
		}
		plane.setAlpha(200);
	}
	
}
