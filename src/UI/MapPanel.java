package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

import MapEditor.GameObject;
import MapEditor.MapEditor;


public class MapPanel extends JPanel implements MouseWheelListener, MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;

	private float zoom;
	public int x, y;
	private int mouseX, mouseY;
	
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
		for (int i = -64 * 100; i < getWidth() * 3; i += 64) {
			g.drawLine(i, -64 * 100, i, getHeight() * 3);
		}
		for (int i = -64 * 100; i < getHeight() * 3; i += 64) {
			g.drawLine(-64 * 100, i, getWidth() * 3, i);
		}
		
		g.setColor(new Color(0, 0, 0, 0.2f));
		g.fillRect(((int) mouseX / 64) * 64 + 1, ((int) mouseY / 64) * 64 + 1, 63, 63);
		
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
		if (MapEditor.selectedPresetName != "" && MapEditor.selectedPresetName != null) {
			MapEditor.addGameObject(MapEditor.selectedPresetName, ((int) mouseX / 64) * 64, ((int) mouseY / 64) * 64);
		}
		
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mouseDragged(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = (int) ((int) e.getX() * 1/zoom);
		mouseY = (int) ((e.getY() - 32) * 1/zoom);
	}
	
}
