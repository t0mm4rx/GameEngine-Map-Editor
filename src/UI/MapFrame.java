package UI;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MapFrame extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;

	MapPanel panel;
	
	public MapFrame() {
		this.setSize(1000, 800);
		this.setTitle("Map editor");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		addKeyListener(this);
		
		panel = new MapPanel();
		panel.setBounds(6, 6, 988, 788);
		addMouseWheelListener(panel);
		addMouseListener(panel);
		addMouseMotionListener(panel);
		getContentPane().add(panel);
		setFocusable(true);
		requestFocusInWindow();
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		repaint();
	}
	

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			panel.y += 32;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			panel.x += 32;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			panel.y -= 32;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			panel.x -= 32;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			panel.zoom(-0.5f);
		}
		if (e.getKeyCode() == KeyEvent.VK_Z) {
			panel.zoom(0.5f);
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}
}
