package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

import MapEditor.*;


public class MapPanel extends JPanel implements KeyListener, MouseWheelListener, MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;

	private float zoom;
	int x, y;
	boolean isMousePressed;
	float lastX, lastY;
	
	public MapPanel() {
		zoom = 1f;
		x = getWidth() / 2;
		y = getHeight() / 2;

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.translate(x, y);
		((Graphics2D) g).scale(zoom, zoom);
		for (GameObject go : MapEditor.gameObjects) {
			g.drawImage(MapEditor.getPreset(go.name).image, (int) go.x, (int) go.y, null);
		}
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < getWidth() * 3; i += 64) {
			g.drawLine(i, 0, i, getHeight() * 3);
		}
		for (int i = 0; i < getHeight() * 3; i += 64) {
			g.drawLine(0, i, getWidth() * 3, i);
		}
		((Graphics2D) g).scale(-zoom, -zoom);
		g.translate(-x, -y);
		this.revalidate();
		this.repaint();
	}
	
	public void zoom (float z) {
		if (zoom + z > 0 && zoom + z < 10) {
			zoom += z;
		}
	}


	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("Yes:");
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			y += 10;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= 10;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			y -= 10;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += 10;
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() < 0) {
			zoom(-0.5f);
		} else {
			zoom(0.5f);
		}
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		isMousePressed = true;
		lastX = e.getX();
		lastY = e.getY();
	}

	public void mouseReleased(MouseEvent e) {
		isMousePressed = false;

	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mouseDragged(MouseEvent e) {
		if (isMousePressed) {
			x += -(lastX - e.getX()) / 50;
			y += -(lastY - e.getY()) / 50;
		}
	}

	public void mouseMoved(MouseEvent e) {

	}
	
}
