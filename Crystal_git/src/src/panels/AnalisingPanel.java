package src.panels;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import src.renderer.entity.EntityManager;
import src.renderer.input.UserInput;

public class AnalisingPanel extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Thread thread;
	private JFrame frame;
	private static String title = "Crystallographic analysis";
	public static final int WIDTH = 850;
	public static final int HEIGHT = 625;
	private static boolean running = false;

	public static EntityManager entityManager;

	private UserInput userInput;
	
	public AnalisingPanel(JFrame jf) {
		this.frame = jf;
		Dimension size = new Dimension(WIDTH, HEIGHT);
		this.setPreferredSize(size);
		this.userInput = new UserInput();
		entityManager = new EntityManager();
		
		this.addMouseListener(this.userInput.mouse);
		this.addMouseMotionListener(this.userInput.mouse);
		this.addMouseWheelListener(this.userInput.mouse);
		this.addKeyListener(this.userInput.keyboard);
	}

	public synchronized void start() {
		running = true;
		this.thread = new Thread(this, "Display");
		this.thread.start();
	} 
	
	public synchronized void stop() {
		running = false;
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH * 2, HEIGHT * 2);
		
		entityManager.render(g);
		
		g.dispose();
		bs.show();
	}
	
	private void update() {
		entityManager.update();	
		ParticlePanel.update();
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60;
		double delta = 0;
		int frames = 0;
		
		entityManager.init(this.userInput);
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				update();
				delta--;
				render();			
				frames++;
			}
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				this.frame.setTitle(title + " | " + frames + " fps");
			}
			frames = 0;
		}
		stop();
	}


}
