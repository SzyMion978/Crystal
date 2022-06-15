package src.renderer.entity;

import java.awt.Graphics;

import src.renderer.point.MyPoint;
import src.renderer.point.MyVector;
import src.renderer.shapes.MyLine;

public class LineEntity implements IEntity {

	private MyLine[] lines; 
	public MyPoint centerPoint = null;
	
	public LineEntity(MyLine... lines) {
		this.lines = new MyLine[lines.length];
		for(int i = 0; i < lines.length; i++) {
			this.lines[i] = lines[i];
		}
	}

	@Override
	public void render(Graphics g) {
		for(MyLine l : this.lines) {
			l.render(g);
		}
	}

	@Override
	public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees, MyVector lightVector) {
		if(centerPoint == null) {
			for(MyLine l : this.lines) {
			l.rotate(CW, xDegrees, yDegrees, zDegrees);
			}
		}
		else if(centerPoint != null) {
			
			for(MyLine l : this.lines) {
			l.rotate(centerPoint, CW, xDegrees, yDegrees, zDegrees);
			}
		}
		
	}

	@Override
	public void setLighting(MyVector lightningVector) {
		// TODO Auto-generated method stub
	}

	@Override
	public void translate(double x, double y, double z) {
		for(MyLine l : this.lines) {
			l.translate(x, y, z);
		}
	}

}
