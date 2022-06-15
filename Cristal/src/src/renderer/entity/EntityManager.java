package src.renderer.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import src.ReadingManager;
import src.panels.AnalisingPanel;
import src.panels.Particle;
import src.panels.ParticlePanel;
import src.panels.UnitCell;
import src.renderer.entity.builder.BasicEntityBuilder;
import src.renderer.entity.builder.ComplexEntityBuilder;
import src.renderer.input.ClickType;
import src.renderer.input.Keyboard;
import src.renderer.input.Mouse;
import src.renderer.input.UserInput;
import src.renderer.point.MyVector;
import src.renderer.point.PointConverter;
import src.renderer.shapes.CristalPlane;
import src.renderer.world.Camera;

public class EntityManager {

	private static List<IEntity> entities;
	private int initialX, initialY;
	private double mouseSensitivity = 2.5;
	private double moveSpeed = 2;
	private MyVector lightVector = MyVector.normalize(new MyVector(1, 1, 1));
	private Mouse mouse;
	private Keyboard keyboard;
	private Camera camera;
	public static boolean unitCellLoaded = false;
	
	
	public EntityManager() {
		entities = new ArrayList<IEntity>();
		this.camera = new Camera(0, 0, 0);
	}

	public void init(UserInput userInput) {
		this.mouse = userInput.mouse;
		this.keyboard = userInput.keyboard;
		//EntityManager.entities.add(ComplexEntityBuilder.createRubiksCube(100, 0, 0, 0));
		EntityManager.entities.add(BasicEntityBuilder.createDiamond(Color.CYAN, 100, 0, 0, 0));
		
		this.setLighting();
	}
	
	public void update() {
		int x = this.mouse.getX();
		int y = this.mouse.getY();
		if(this.mouse.getButton() == ClickType.LeftClick) {
			int xDif = x - initialX;
			int yDif = y - initialY;
			
			this.rotate(true, 0, -yDif/mouseSensitivity, -xDif/mouseSensitivity);
		}
		else if(this.mouse.getButton() == ClickType.RightClick) {
			int xDif = x - initialX;
			
			this.rotate(true, -xDif/mouseSensitivity, 0, 0);
		}
		
		if(this.mouse.isScrollingUp()) {
			PointConverter.zoomIn();
		}
		else if(this.mouse.isScrollingDown()) {
			PointConverter.zoomOut();
		}
		
		if(this.keyboard.getLeft()) {
			this.camera.translate(0, moveSpeed, 0);
			for(IEntity entity : entities) {
				entity.translate(0, -moveSpeed, 0);
			}
		}
		if(this.keyboard.getRight()) {
			this.camera.translate(0, -moveSpeed, 0);
			for(IEntity entity : entities) {
				entity.translate(0, moveSpeed, 0);
			}
		}
		if(this.keyboard.getUp()) {
			this.camera.translate(0, 0, -moveSpeed);
			for(IEntity entity : entities) {
				entity.translate(0, 0, moveSpeed);
			}
		}
		if(this.keyboard.getDown()) {
			this.camera.translate(0, 0, moveSpeed);
			for(IEntity entity : entities) {
				entity.translate(0, 0, -moveSpeed);
			}
		}
		if(this.keyboard.getForward()) {
			this.camera.translate(moveSpeed, 0, 0);
			for(IEntity entity : entities) {
				entity.translate(-moveSpeed, 0, 0);
			}
		}
		if(this.keyboard.getBackward()) {
			this.camera.translate(-moveSpeed, 0, 0);
			for(IEntity entity : entities) {
				entity.translate(moveSpeed, 0, 0);
			}
		}
		if(this.keyboard.getRefresh() && EntityManager.unitCellLoaded) {
			UnitCell.refreshRadians(ParticlePanel.getRadians());
			if(ComplexEntityBuilder.plane) {
				UnitCell.cristalPlane = new CristalPlane(UnitCell.cristalPlane.hkl, ReadingManager.unitCell.a*ReadingManager.scale, 
					ReadingManager.unitCell.b*ReadingManager.scale, 
					ReadingManager.unitCell.c*ReadingManager.scale); 
			}
			EntityManager.refreshUnitCell(UnitCell.particles, UnitCell.cristalPlane);
		}
		
		this.mouse.resetScroll();
		this.keyboard.update();

		initialX = x;
		initialY = y;
	}
	
	public void render(Graphics g) {
		for(IEntity entity : entities) {
			entity.render(g);
		}
		this.setLighting();
	}
	
	private void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees) {
		for(IEntity entity : entities) {
			entity.rotate(CW, xDegrees, yDegrees, zDegrees, this.lightVector);
		}
	}
	
	private void setLighting() {
		for(IEntity entity : entities) {
			entity.setLighting(this.lightVector);
		}
	}
	
	public static void addUnitCell(Particle[] partTab) {
		entities = new ArrayList<>();
		entities.add(ComplexEntityBuilder.createUnitCell(partTab));
		entities.add(BasicEntityBuilder.createAxisPointer(0, -0.1*AnalisingPanel.WIDTH, -0.1*AnalisingPanel.HEIGHT));
		EntityManager.unitCellLoaded = true;
	}
	public static void refreshUnitCell(Particle[] partTab, CristalPlane cp) {
		entities = new ArrayList<>();
		entities.add(ComplexEntityBuilder.createUnitCell(partTab, cp));
		entities.add(BasicEntityBuilder.createAxisPointer(0, -0.1*AnalisingPanel.WIDTH, -0.1*AnalisingPanel.HEIGHT));
	}	

}
