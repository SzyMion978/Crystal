package src.renderer.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener {

	private int mouseX = -1;
	private int mouseY = -1;
	private int mouseB = -1;
	private int scroll = 0;
	
	public int getX() {
		return this.mouseX;
	}

	public int getY() {
		return this.mouseY;
	}


	public ClickType getButton() {
		switch(this.mouseB) {
		case 1:
			return ClickType.LeftClick;
		case 2:
			return ClickType.ScrollClick;
		case 3:
			return ClickType.RightClick;
		case 4:
			return ClickType.BackPage;
		case 5:
			return ClickType.ForwardPage;
		default:
			return ClickType.Unknown;
		}
		
	}
	
	public void resetButton() {
		this.mouseB = -1;
	}

	public Mouse() {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent event) {
		this.mouseB = event.getButton();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.resetButton();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent event) {
		this.mouseX = event.getX();
		this.mouseY = event.getY();
		
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		this.mouseX = event.getX();
		this.mouseY = event.getY();
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent event) {
		scroll = event.getWheelRotation();
		
	}
	
	public boolean isScrollingUp() {
		return (this.scroll == -1);
	}
	
	public boolean isScrollingDown() {
		return (this.scroll == 1);
	}
	
	public void resetScroll() {
		this.scroll = 0;
	}

}
