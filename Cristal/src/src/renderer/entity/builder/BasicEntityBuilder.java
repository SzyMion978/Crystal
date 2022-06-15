package src.renderer.entity.builder;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import src.renderer.entity.Entity;
import src.renderer.entity.IEntity;
import src.renderer.entity.LineEntity;
import src.renderer.point.MyPoint;
import src.renderer.shapes.CristalPlane;
import src.renderer.shapes.MyLine;
import src.renderer.shapes.MyPolygon;
import src.renderer.shapes.Polyhedron;

public class BasicEntityBuilder {
	
	public static IEntity createCube(double size, double centerX, double centerY, double centerZ) {
		MyPoint p1 = new MyPoint(centerX + size/2, centerY + -size/2, centerZ + -size/2);
		MyPoint p2 = new MyPoint(centerX + size/2, centerY + size/2, centerZ + -size/2);
		MyPoint p3 = new MyPoint(centerX + size/2, centerY + size/2, centerZ + size/2);
		MyPoint p4 = new MyPoint(centerX + size/2, centerY + -size/2, centerZ + size/2);
		MyPoint p5 = new MyPoint(centerX + -size/2, centerY + -size/2, centerZ + -size/2);
		MyPoint p6 = new MyPoint(centerX + -size/2, centerY + size/2, centerZ + -size/2);
		MyPoint p7 = new MyPoint(centerX + -size/2, centerY + size/2, centerZ + size/2);
		MyPoint p8 = new MyPoint(centerX + -size/2, centerY + -size/2, centerZ + size/2);
		
		Polyhedron tetra = new Polyhedron(
				new MyPolygon(Color.BLUE, p5, p6, p7, p8),
				new MyPolygon(Color.WHITE, p1, p2, p6, p5),
				new MyPolygon(Color.YELLOW, p1, p5, p8, p4),
				new MyPolygon(Color.GREEN, p2, p6, p7, p3),
				new MyPolygon(Color.ORANGE, p4, p3, p7, p8),
				new MyPolygon(Color.RED, p1, p2, p3, p4));
		
		List<Polyhedron> tetras = new ArrayList<Polyhedron>();
		tetras.add(tetra);
		
		return new Entity(tetras);
	}
	
	public static IEntity createDiamond(Color color, double size, double centerX, double centerY, double centerZ) {
		List<Polyhedron> tetras = new ArrayList<Polyhedron>();
		
		int edges = 10;
		double inFactor = 0.55;
		MyPoint bottom = new MyPoint(centerX, centerY, centerZ - size/2);
		MyPoint[] outerPoints = new MyPoint[edges];
		MyPoint[] innerPoints = new MyPoint[edges];
		for(int i = 0; i < edges; i++) {
			double theta = 2 * Math.PI / edges * i;
			double xPos = -Math.sin(theta) * size/2;
			double yPos = Math.cos(theta) * size/2;
			double zPos = size/2;
			outerPoints[i] = new MyPoint(centerX + xPos, centerY + yPos, centerZ + zPos * inFactor);
			innerPoints[i] = new MyPoint(centerX + xPos * inFactor, centerY + yPos * inFactor, centerZ + zPos);
		}
		
		MyPolygon polygons[] = new MyPolygon[2 * edges + 1];
		for(int i = 0; i < edges; i++) {
			polygons[i] = new MyPolygon(outerPoints[i], bottom, outerPoints[(i+1)%edges]);
		}
		for(int i = 0; i < edges; i++) {
			polygons[i + edges] = new MyPolygon(outerPoints[i], outerPoints[(i+1)%edges], innerPoints[(i+1)%edges], innerPoints[i]);
		}
		polygons[edges * 2] = new MyPolygon(innerPoints);
		
		Polyhedron tetra = new Polyhedron(color, false, polygons);
		tetras.add(tetra);
		
		return new Entity(tetras);
	}
	
	// SPHERE !!!
	public static IEntity createSphere(Color color, double size, int resolution, double centerX, double centerY, double centerZ) {
		List<Polyhedron> polyhedrons = new ArrayList<Polyhedron>();
		List<MyPolygon> polygons = new ArrayList<MyPolygon>();

		MyPoint bottom = new MyPoint(centerX, centerY, centerZ - size / 2);
		MyPoint top = new MyPoint(centerX, centerY, centerZ + size / 2);
		
		MyPoint[][] points = new MyPoint[resolution - 1][resolution];
		
		for(int i = 1; i < resolution; i++) {
			double theta = Math.PI / resolution * i;
			double zPos = -Math.cos(theta) * size / 2;
			double currentRadius = Math.abs(Math.sin(theta) * size / 2);
			for(int j = 0; j < resolution; j++) {
				double alpha = 2 * Math.PI / resolution * j;
				double xPos = -Math.sin(alpha) * currentRadius;
				double yPos = Math.cos(alpha) * currentRadius;
				points[i-1][j] = new MyPoint(centerX + xPos, centerY + yPos, centerZ + zPos);
			}
		}
		
		for(int i = 1; i <= resolution; i++) {
			for(int j = 0; j < resolution; j++) {
				if(i == 1) {
					polygons.add(
							new MyPolygon(color,
									points[i-1][j],
									points[i-1][(j+1)%resolution],
									bottom));
				}
				else if(i == resolution) {
					polygons.add(
							new MyPolygon(color,
									points[i-2][(j+1)%resolution],
									points[i-2][j],
									top));
				}
				else {
					polygons.add(
							new MyPolygon(color,
									points[i-1][j],
									points[i-1][(j+1)%resolution],
									points[i-2][(j+1)%resolution],
									points[i-2][j]));
				}
			}
		}
		
		MyPolygon[] polygonArray = new MyPolygon[polygons.size()];
		polygonArray = polygons.toArray(polygonArray);
		
		Polyhedron polyhedron = new Polyhedron(color, false, polygonArray);
		polyhedrons.add(polyhedron);
		
		return new Entity(polyhedrons);
	}
	
	public static IEntity createPlane(CristalPlane cp) {
		List<Polyhedron> polyhedrons = new ArrayList<Polyhedron>();
		Polyhedron poly = new Polyhedron(Color.cyan , true, cp.plane);
		
		polyhedrons.add(poly);
		
		return new Entity(polyhedrons);
	}
	
	public static IEntity createbox(double a, double b, double c) {
		MyLine[] myLines = new MyLine[12];
		
		myLines[0] = new MyLine(new MyPoint(-a/2,-b/2,-c/2), new MyPoint(a/2,-b/2,-c/2));
		myLines[1] = new MyLine(new MyPoint(a/2,-b/2,-c/2), new MyPoint(a/2,b/2,-c/2));
		myLines[2] = new MyLine(new MyPoint(a/2,b/2,-c/2), new MyPoint(-a/2,b/2,-c/2));
		myLines[3] = new MyLine(new MyPoint(-a/2,b/2,-c/2), new MyPoint(-a/2,-b/2,-c/2));
		
		myLines[4] = new MyLine(new MyPoint(-a/2,-b/2,c/2), new MyPoint(a/2,-b/2,c/2));
		myLines[5] = new MyLine(new MyPoint(a/2,-b/2,c/2), new MyPoint(a/2,b/2,c/2));
		myLines[6] = new MyLine(new MyPoint(a/2,b/2,c/2), new MyPoint(-a/2,b/2,c/2));
		myLines[7] = new MyLine(new MyPoint(-a/2,b/2,c/2), new MyPoint(-a/2,-b/2,c/2));
		
		myLines[8] = new MyLine(new MyPoint(-a/2,-b/2,-c/2), new MyPoint(-a/2,-b/2,c/2));
		myLines[9] = new MyLine(new MyPoint(a/2,-b/2,-c/2), new MyPoint(a/2,-b/2,c/2));
		myLines[10] = new MyLine(new MyPoint(-a/2,b/2,-c/2), new MyPoint(-a/2,b/2,c/2));
		myLines[11] = new MyLine(new MyPoint(a/2,b/2,-c/2), new MyPoint(a/2,b/2,c/2));
			
		LineEntity box = new LineEntity(myLines);
		
		return box;
	}
	
	public static IEntity createPolyBox(double a, double b, double c) {
		List<Polyhedron> polyhedrons = new ArrayList<Polyhedron>();
		double d = 0.4;
		
		MyPolygon[] polygons = new MyPolygon[48];
		
		polygons[0] = new MyPolygon(Color.white, new MyPoint(-(a/2+d), -(b/2+d), -c/2), new MyPoint(-(a/2-d), -(b/2+d), -c/2),
												 new MyPoint(-(a/2-d), -(b/2+d), c/2), new MyPoint(-(a/2+d), -(b/2+d), c/2));
		polygons[1] = new MyPolygon(Color.white, new MyPoint(-(a/2+d), -(b/2+d), -c/2), new MyPoint(-(a/2+d), -(b/2-d), -c/2),
				 new MyPoint(-(a/2+d), -(b/2-d), c/2), new MyPoint(-(a/2+d), -(b/2+d), c/2));
		polygons[2] = new MyPolygon(Color.white, new MyPoint(-(a/2+d), -(b/2-d), -c/2), new MyPoint(-(a/2-d), -(b/2-d), -c/2),
				 new MyPoint(-(a/2-d), -(b/2-d), c/2), new MyPoint(-(a/2+d), -(b/2-d), c/2));
		polygons[3] = new MyPolygon(Color.white, new MyPoint(-(a/2-d), -(b/2-d), -c/2), new MyPoint(-(a/2-d), -(b/2+d), -c/2),
				 new MyPoint(-(a/2-d), -(b/2+d), c/2), new MyPoint(-(a/2-d), -(b/2-d), c/2));
		
		polygons[4] = new MyPolygon(Color.white, new MyPoint((a/2+d), -(b/2+d), -c/2), new MyPoint((a/2-d), -(b/2+d), -c/2),
				 new MyPoint((a/2-d), -(b/2+d), c/2), new MyPoint((a/2+d), -(b/2+d), c/2));
		polygons[5] = new MyPolygon(Color.white, new MyPoint((a/2+d), -(b/2+d), -c/2), new MyPoint((a/2+d), -(b/2-d), -c/2),
				new MyPoint((a/2+d), -(b/2-d), c/2), new MyPoint((a/2+d), -(b/2+d), c/2));
		polygons[6] = new MyPolygon(Color.white, new MyPoint((a/2+d), -(b/2-d), -c/2), new MyPoint((a/2-d), -(b/2-d), -c/2),
				new MyPoint((a/2-d), -(b/2-d), c/2), new MyPoint((a/2+d), -(b/2-d), c/2));
		polygons[7] = new MyPolygon(Color.white, new MyPoint((a/2-d), -(b/2-d), -c/2), new MyPoint((a/2-d), -(b/2+d), -c/2),
				new MyPoint((a/2-d), -(b/2+d), c/2), new MyPoint((a/2-d), -(b/2-d), c/2));

		polygons[8] = new MyPolygon(Color.white, new MyPoint((a/2+d), (b/2+d), -c/2), new MyPoint((a/2-d), (b/2+d), -c/2),
				 new MyPoint((a/2-d), (b/2+d), c/2), new MyPoint((a/2+d), (b/2+d), c/2));
		polygons[9] = new MyPolygon(Color.white, new MyPoint((a/2+d), (b/2+d), -c/2), new MyPoint((a/2+d), (b/2-d), -c/2),
				new MyPoint((a/2+d), (b/2-d), c/2), new MyPoint((a/2+d), (b/2+d), c/2));
		polygons[10] = new MyPolygon(Color.white, new MyPoint((a/2+d), (b/2-d), -c/2), new MyPoint((a/2-d), (b/2-d), -c/2),
				new MyPoint((a/2-d), (b/2-d), c/2), new MyPoint((a/2+d), (b/2-d), c/2));
		polygons[11] = new MyPolygon(Color.white, new MyPoint((a/2-d), (b/2-d), -c/2), new MyPoint((a/2-d), (b/2+d), -c/2),
				new MyPoint((a/2-d), (b/2+d), c/2), new MyPoint((a/2-d), (b/2-d), c/2));
		
		polygons[12] = new MyPolygon(Color.white, new MyPoint(-(a/2+d), (b/2+d), -c/2), new MyPoint(-(a/2-d), (b/2+d), -c/2),
				 new MyPoint(-(a/2-d), (b/2+d), c/2), new MyPoint(-(a/2+d), (b/2+d), c/2));
		polygons[13] = new MyPolygon(Color.white, new MyPoint(-(a/2+d), (b/2+d), -c/2), new MyPoint(-(a/2+d), (b/2-d), -c/2),
				new MyPoint(-(a/2+d), (b/2-d), c/2), new MyPoint(-(a/2+d), (b/2+d), c/2));
		polygons[14] = new MyPolygon(Color.white, new MyPoint(-(a/2+d), (b/2-d), -c/2), new MyPoint(-(a/2-d), (b/2-d), -c/2),
				new MyPoint(-(a/2-d), (b/2-d), c/2), new MyPoint(-(a/2+d), (b/2-d), c/2));
		polygons[15] = new MyPolygon(Color.white, new MyPoint(-(a/2-d), (b/2-d), -c/2), new MyPoint(-(a/2-d), (b/2+d), -c/2),
				new MyPoint(-(a/2-d), (b/2+d), c/2), new MyPoint(-(a/2-d), (b/2-d), c/2));

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		polygons[16] = new MyPolygon(Color.white, new MyPoint(-(a/2+d), -b/2, -(c/2+d)), new MyPoint(-(a/2+d), -b/2, -(c/2-d)),
				 new MyPoint(-(a/2+d), b/2, -(c/2-d)), new MyPoint(-(a/2+d), b/2, -(c/2+d)));
		polygons[17] = new MyPolygon(Color.white, new MyPoint(-(a/2+d), -b/2, -(c/2+d)), new MyPoint(-(a/2-d), -b/2, -(c/2+d)),
				 new MyPoint(-(a/2-d), b/2, -(c/2+d)), new MyPoint(-(a/2+d), b/2, -(c/2+d)));
		polygons[18] = new MyPolygon(Color.white, new MyPoint(-(a/2-d), -b/2, -(c/2+d)), new MyPoint(-(a/2-d), -b/2, -(c/2-d)),
				 new MyPoint(-(a/2-d), b/2, -(c/2-d)), new MyPoint(-(a/2-d), b/2, -(c/2+d)));
		polygons[19] = new MyPolygon(Color.white, new MyPoint(-(a/2-d), -b/2, -(c/2-d)), new MyPoint(-(a/2+d), -b/2, -(c/2-d)),
				 new MyPoint(-(a/2+d), b/2, -(c/2-d)), new MyPoint(-(a/2-d), b/2, -(c/2-d)));
		
		polygons[20] = new MyPolygon(Color.white, new MyPoint((a/2+d), -b/2, -(c/2+d)), new MyPoint((a/2+d), -b/2, -(c/2-d)),
				 new MyPoint((a/2+d), b/2, -(c/2-d)), new MyPoint((a/2+d), b/2, -(c/2+d)));
		polygons[21] = new MyPolygon(Color.white, new MyPoint((a/2+d), -b/2, -(c/2+d)), new MyPoint((a/2-d), -b/2, -(c/2+d)),
				 new MyPoint((a/2-d), b/2, -(c/2+d)), new MyPoint((a/2+d), b/2, -(c/2+d)));
		polygons[22] = new MyPolygon(Color.white, new MyPoint((a/2-d), -b/2, -(c/2+d)), new MyPoint((a/2-d), -b/2, -(c/2-d)),
				 new MyPoint((a/2-d), b/2, -(c/2-d)), new MyPoint((a/2-d), b/2, -(c/2+d)));
		polygons[23] = new MyPolygon(Color.white, new MyPoint((a/2-d), -b/2, -(c/2-d)), new MyPoint((a/2+d), -b/2, -(c/2-d)),
				 new MyPoint((a/2+d), b/2, -(c/2-d)), new MyPoint((a/2-d), b/2, -(c/2-d)));
		
		polygons[24] = new MyPolygon(Color.white, new MyPoint((a/2+d), -b/2, (c/2+d)), new MyPoint((a/2+d), -b/2, (c/2-d)),
				 new MyPoint((a/2+d), b/2, (c/2-d)), new MyPoint((a/2+d), b/2, (c/2+d)));
		polygons[25] = new MyPolygon(Color.white, new MyPoint((a/2+d), -b/2, (c/2+d)), new MyPoint((a/2-d), -b/2, (c/2+d)),
				 new MyPoint((a/2-d), b/2, (c/2+d)), new MyPoint((a/2+d), b/2, (c/2+d)));
		polygons[26] = new MyPolygon(Color.white, new MyPoint((a/2-d), -b/2, (c/2+d)), new MyPoint((a/2-d), -b/2, (c/2-d)),
				 new MyPoint((a/2-d), b/2, (c/2-d)), new MyPoint((a/2-d), b/2, (c/2+d)));
		polygons[27] = new MyPolygon(Color.white, new MyPoint((a/2-d), -b/2, (c/2-d)), new MyPoint((a/2+d), -b/2, (c/2-d)),
				 new MyPoint((a/2+d), b/2, (c/2-d)), new MyPoint((a/2-d), b/2, (c/2-d)));
		
		polygons[28] = new MyPolygon(Color.white, new MyPoint(-(a/2+d), -b/2, (c/2+d)), new MyPoint(-(a/2+d), -b/2, (c/2-d)),
				 new MyPoint(-(a/2+d), b/2, (c/2-d)), new MyPoint(-(a/2+d), b/2, (c/2+d)));
		polygons[29] = new MyPolygon(Color.white, new MyPoint(-(a/2+d), -b/2, (c/2+d)), new MyPoint(-(a/2-d), -b/2, (c/2+d)),
				 new MyPoint(-(a/2-d), b/2, (c/2+d)), new MyPoint(-(a/2+d), b/2, (c/2+d)));
		polygons[30] = new MyPolygon(Color.white, new MyPoint(-(a/2-d), -b/2, (c/2+d)), new MyPoint(-(a/2-d), -b/2, (c/2-d)),
				 new MyPoint(-(a/2-d), b/2, (c/2-d)), new MyPoint(-(a/2-d), b/2, (c/2+d)));
		polygons[31] = new MyPolygon(Color.white, new MyPoint(-(a/2-d), -b/2, (c/2-d)), new MyPoint(-(a/2+d), -b/2, (c/2-d)),
				 new MyPoint(-(a/2+d), b/2, (c/2-d)), new MyPoint(-(a/2-d), b/2, (c/2-d)));
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		polygons[32] = new MyPolygon(Color.white, new MyPoint(-a/2, -(b/2+d), -(c/2+d)), new MyPoint(-a/2, -(b/2+d), -(c/2-d)),
				 new MyPoint(a/2, -(b/2+d), -(c/2-d)), new MyPoint(a/2, -(b/2+d), -(c/2+d)));
		polygons[33] = new MyPolygon(Color.white, new MyPoint(-a/2, -(b/2+d), -(c/2+d)), new MyPoint(-a/2, -(b/2-d), -(c/2+d)),
				 new MyPoint(a/2, -(b/2-d), -(c/2+d)), new MyPoint(a/2, -(b/2+d), -(c/2+d)));
		polygons[34] = new MyPolygon(Color.white, new MyPoint(-a/2, -(b/2+d), -(c/2-d)), new MyPoint(-a/2, -(b/2-d), -(c/2-d)),
				 new MyPoint(a/2, -(b/2-d), -(c/2-d)), new MyPoint(a/2, -(b/2+d), -(c/2-d)));
		polygons[35] = new MyPolygon(Color.white, new MyPoint(-a/2, -(b/2-d), -(c/2-d)), new MyPoint(-a/2, -(b/2-d), -(c/2+d)),
				 new MyPoint(a/2, -(b/2+d), -(c/2-d)), new MyPoint(a/2, -(b/2-d), -(c/2-d)));
		
		polygons[36] = new MyPolygon(Color.white, new MyPoint(-a/2, (b/2+d), -(c/2+d)), new MyPoint(-a/2, (b/2+d), -(c/2-d)),
				 new MyPoint(a/2, (b/2+d), -(c/2-d)), new MyPoint(a/2, (b/2+d), -(c/2+d)));
		polygons[37] = new MyPolygon(Color.white, new MyPoint(-a/2, (b/2+d), -(c/2+d)), new MyPoint(-a/2, (b/2-d), -(c/2+d)),
				 new MyPoint(a/2, (b/2-d), -(c/2+d)), new MyPoint(a/2, (b/2+d), -(c/2+d)));
		polygons[38] = new MyPolygon(Color.white, new MyPoint(-a/2, (b/2+d), -(c/2-d)), new MyPoint(-a/2, (b/2-d), -(c/2-d)),
				 new MyPoint(a/2, (b/2-d), -(c/2-d)), new MyPoint(a/2, (b/2+d), -(c/2-d)));
		polygons[39] = new MyPolygon(Color.white, new MyPoint(-a/2, (b/2-d), -(c/2-d)), new MyPoint(-a/2, (b/2-d), -(c/2+d)),
				 new MyPoint(a/2, (b/2+d), -(c/2-d)), new MyPoint(a/2, (b/2-d), -(c/2-d)));
		
		polygons[40] = new MyPolygon(Color.white, new MyPoint(-a/2, -(b/2+d), (c/2+d)), new MyPoint(-a/2, -(b/2+d), (c/2-d)),
				 new MyPoint(a/2, -(b/2+d), (c/2-d)), new MyPoint(a/2, -(b/2+d), (c/2+d)));
		polygons[41] = new MyPolygon(Color.white, new MyPoint(-a/2, -(b/2+d), (c/2+d)), new MyPoint(-a/2, -(b/2-d), (c/2+d)),
				 new MyPoint(a/2, -(b/2-d), (c/2+d)), new MyPoint(a/2, -(b/2+d), (c/2+d)));
		polygons[42] = new MyPolygon(Color.white, new MyPoint(-a/2, -(b/2+d), (c/2-d)), new MyPoint(-a/2, -(b/2-d), (c/2-d)),
				 new MyPoint(a/2, -(b/2-d), (c/2-d)), new MyPoint(a/2, -(b/2+d), (c/2-d)));
		polygons[43] = new MyPolygon(Color.white, new MyPoint(-a/2, -(b/2-d), (c/2-d)), new MyPoint(-a/2, -(b/2-d), (c/2+d)),
				 new MyPoint(a/2, -(b/2+d), (c/2-d)), new MyPoint(a/2, -(b/2-d), (c/2-d)));
		
		polygons[44] = new MyPolygon(Color.white, new MyPoint(-a/2, (b/2+d), (c/2+d)), new MyPoint(-a/2, (b/2+d), (c/2-d)),
				 new MyPoint(a/2, (b/2+d), (c/2-d)), new MyPoint(a/2, (b/2+d), (c/2+d)));
		polygons[45] = new MyPolygon(Color.white, new MyPoint(-a/2, (b/2+d), (c/2+d)), new MyPoint(-a/2, (b/2-d), (c/2+d)),
				 new MyPoint(a/2, (b/2-d), (c/2+d)), new MyPoint(a/2, (b/2+d), (c/2+d)));
		polygons[46] = new MyPolygon(Color.white, new MyPoint(-a/2, (b/2+d), (c/2-d)), new MyPoint(-a/2, (b/2-d), (c/2-d)),
				 new MyPoint(a/2, (b/2-d), (c/2-d)), new MyPoint(a/2, (b/2+d), (c/2-d)));
		polygons[47] = new MyPolygon(Color.white, new MyPoint(-a/2, (b/2-d), (c/2-d)), new MyPoint(-a/2, (b/2-d), (c/2+d)),
				 new MyPoint(a/2, (b/2+d), (c/2-d)), new MyPoint(a/2, (b/2-d), (c/2-d)));
		
		polyhedrons.add(new Polyhedron(polygons));
		return new Entity(polyhedrons);
	}
	
	public static IEntity createAxisPointer(double x, double y, double z) {
		MyLine[] myLines = new MyLine[22];
		
		myLines[0] = new MyLine(new MyPoint(x,y,z), new MyPoint(x + 20, y, z));
		myLines[1] = new MyLine(new MyPoint(x,y,z), new MyPoint(x, y + 20, z));
		myLines[2] = new MyLine(new MyPoint(x,y,z), new MyPoint(x, y, z + 20));
		
		myLines[3] = new MyLine(new MyPoint(x + 20, y, z), new MyPoint(x + 17.5, y - 2, z));
		myLines[4] = new MyLine(new MyPoint(x + 20, y, z), new MyPoint(x + 17.5, y + 2, z));
		myLines[9] = new MyLine(new MyPoint(x + 20, y, z), new MyPoint(x + 17.5, y, z - 2));
		myLines[10] = new MyLine(new MyPoint(x + 20, y, z), new MyPoint(x + 17.5, y, z + 2));
		
		myLines[5] = new MyLine(new MyPoint(x, y + 20, z), new MyPoint(x, y + 17.5, z - 2));
		myLines[6] = new MyLine(new MyPoint(x, y + 20, z), new MyPoint(x, y + 17.5, z + 2));
		myLines[11] = new MyLine(new MyPoint(x, y + 20, z), new MyPoint(x - 2, y + 17.5, z));
		myLines[12] = new MyLine(new MyPoint(x, y + 20, z), new MyPoint(x + 2, y + 17.5, z));
		
		myLines[7] = new MyLine(new MyPoint(x, y, z + 20), new MyPoint(x, y - 2, z + 17.5));
		myLines[8] = new MyLine(new MyPoint(x, y, z + 20), new MyPoint(x, y + 2, z + 17.5));
		myLines[13] = new MyLine(new MyPoint(x, y, z + 20), new MyPoint(x - 2, y, z + 17.5));
		myLines[14] = new MyLine(new MyPoint(x, y, z + 20), new MyPoint(x + 2, y, z + 17.5));
		
		myLines[15] = new MyLine(new MyPoint(x + 17, y - 6.5, z - 1.5), new MyPoint(x + 17, y - 3.5, z + 1.5));
		myLines[16] = new MyLine(new MyPoint(x + 17, y - 6.5, z + 1.5), new MyPoint(x + 17, y - 3.5, z - 1.5));
		
		myLines[17] = new MyLine(new MyPoint(x, y + 16.5, z + 2), new MyPoint(x, y + 18.5, z + 5));
		myLines[18] = new MyLine(new MyPoint(x, y + 16.5, z + 5), new MyPoint(x, y + 17.5, z + 3.5));
		
		myLines[19] = new MyLine(new MyPoint(x, y - 6, z + 18), new MyPoint(x, y - 4, z + 18));
		myLines[20] = new MyLine(new MyPoint(x, y - 6, z + 15), new MyPoint(x, y - 4, z + 15));
		myLines[21] = new MyLine(new MyPoint(x, y - 4, z + 18), new MyPoint(x, y - 6, z + 15));
				
		for(MyLine l : myLines) {
			l.axis = true;
		}
		for(int i = 15; i < 22; i++)
			myLines[i].stroke = 3;
		
		LineEntity box = new LineEntity(myLines);
		box.centerPoint = new MyPoint(x,y,z);
		
		return box;
	}
}
