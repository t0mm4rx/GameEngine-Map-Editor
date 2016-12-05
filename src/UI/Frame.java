package UI;

import java.awt.Graphics;

import javax.swing.JFrame;

import MapEditor.MapEditor;

import javax.swing.JList;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	MapPanel panel;
	@SuppressWarnings("rawtypes")
	JList objects;
	
	@SuppressWarnings("rawtypes")
	public Frame() {
		this.setSize(1000, 800);
		this.setTitle("Map editor");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		panel = new MapPanel();
		panel.setBounds(6, 6, 988, 547);
		addKeyListener(panel);
		addMouseWheelListener(panel);
		addMouseListener(panel);
		addMouseMotionListener(panel);
		getContentPane().add(panel);
		
		objects = new JList();
		objects.setBounds(6, 556, 550, 216);
		getContentPane().add(objects);
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		refreshList();
		repaint();
	}
	
	@SuppressWarnings("unchecked")
	public void refreshList() {
		String[] names = new String[MapEditor.gameObjectsPresets.size()];
		for (int i = 0; i < MapEditor.gameObjectsPresets.size(); i++) {
			names[i] = MapEditor.gameObjectsPresets.get(i).name;
		}
		objects.setListData(names);
	}
}
