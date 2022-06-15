package src.renderer.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import src.renderer.point.MyPoint;
import src.renderer.point.PointConverter;

public class MyLine {

	private MyPoint[] points;
	public boolean axis = false;
	public int stroke = 1;
	
	public MyLine(MyPoint... points) {
		this.points = new MyPoint[points.length];
		for(int i = 0; i < points.length; i++) {
			MyPoint p = points[i];
			this.points[i] = new MyPoint(p.x, p.y, p.z);
		}
	}
	
	public void render(Graphics g) {
		Point[] convpoints  = new Point[this.points.length];
		if(axis) {
			for(int i = 0; i < this.points.length; i++) {
				Point p = PointConverter.convertPointAxis(this.points[i]);
				convpoints[i] = p;
			}
		}
		else if(!axis) {
			for(int i = 0; i < this.points.length; i++) {
			Point p = PointConverter.convertPoint(this.points[i]);
			convpoints[i] = p;
			}
		}
		Graphics2D g2D = (Graphics2D) g;
		g2D.setStroke(new BasicStroke(stroke));
		g2D.setColor(Color.white);
		g2D.drawLine(convpoints[0].x, convpoints[0].y, convpoints[1].x, convpoints[1].y);
	}

	public void translate(double x, double y, double z) {
		if(!axis) {
			for(MyPoint p : points) {
			p.xOffset += x;
			p.yOffset += y;
			p.zOffset += z;
			}
		}
		
		
	}
	
	public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees) {
		for(MyPoint p : points) {
			PointConverter.rotateAxisX(p, CW, xDegrees);
			PointConverter.rotateAxisY(p, CW, yDegrees);
			PointConverter.rotateAxisZ(p, CW, zDegrees);
		}
	}
	
	public void rotate(MyPoint p0, boolean CW, double xDegrees, double yDegrees, double zDegrees) {
		for(MyPoint p : points) {
			PointConverter.rotateAxisX(p0, p, CW, xDegrees);
			PointConverter.rotateAxisY(p0, p, CW, yDegrees);
			PointConverter.rotateAxisZ(p0, p, CW, zDegrees);
		}
	}
}
