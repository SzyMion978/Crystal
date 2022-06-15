package src.renderer.entity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.renderer.point.MyVector;
import src.renderer.shapes.MyPolygon;
import src.renderer.shapes.Polyhedron;

public class Entity implements IEntity {

	private List<Polyhedron> polyhedrons;
	public MyPolygon[] polygons;
	
	
	public Entity(List<Polyhedron> polyhedrons) {
		this.polyhedrons = polyhedrons;
		List<MyPolygon> tempList = new ArrayList<MyPolygon>();
		for(Polyhedron poly : this.polyhedrons) {
			tempList.addAll(Arrays.asList(poly.getPolygons()));
		}
		this.polygons = new MyPolygon[tempList.size()];
		this.polygons = tempList.toArray(this.polygons);
		this.sortPolygons();
	}
	
	@Override
	public void render(Graphics g) {
		for(MyPolygon poly : this.polygons) {
			poly.render(g);
		}
	}

	@Override
	public void translate(double x, double y, double z) {
		for(Polyhedron poly : this.polyhedrons) {
			poly.translate(x, y, z);
		}
		this.sortPolygons();
	}

	@Override
	public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees, MyVector lightVector) {
		for(Polyhedron poly : this.polyhedrons) {
			poly.rotate(CW, xDegrees, yDegrees, zDegrees, lightVector);
		}
		this.sortPolygons();
	}
	
	@Override
	public void setLighting(MyVector lightVector) {
		for(Polyhedron poly : this.polyhedrons) {
			poly.setLighting(lightVector);
		}
	}
	
	private void sortPolygons() {
		this.polygons = MyPolygon.sortPolygons(this.polygons);
	}

	public List<Polyhedron> getPolyhedrons() {
		return polyhedrons;
	}

	public void setPolyhedrons(List<Polyhedron> polyhedrons) {
		this.polyhedrons = polyhedrons;
	}
	
	
}
