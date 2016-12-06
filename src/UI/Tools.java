package UI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import MapEditor.MapExporter;

@SuppressWarnings("serial")
public class Tools extends JFrame {

	private JButton btnAdd, btnErase;
	
	public Tools() {
		this.setTitle("Tools");
		this.setSize(239, 143);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(0, 6, 117, 29);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MapExporter.export();
			}
		});
		getContentPane().add(btnSave);
		
		JButton btnImport = new JButton("Import");
		btnImport.setBounds(110, 6, 117, 29);
		getContentPane().add(btnImport);
		
		JLabel lblTools = new JLabel("Tools");
		lblTools.setBounds(10, 47, 47, 16);
		getContentPane().add(lblTools);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(0, 75, 117, 29);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MapEditor.MapEditor.selectedTool = MapEditor.MapEditor.ADD;
			}
		});
		getContentPane().add(btnAdd);
		
		btnErase = new JButton("Erase");
		btnErase.setBounds(110, 75, 117, 29);
		btnErase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MapEditor.MapEditor.selectedTool = MapEditor.MapEditor.ERASE;
			}
		});
		getContentPane().add(btnErase);
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		if (MapEditor.MapEditor.selectedTool == MapEditor.MapEditor.ADD) {
			enableAllButons();
			btnAdd.setEnabled(false);
		}
		
		if (MapEditor.MapEditor.selectedTool == MapEditor.MapEditor.ERASE) {
			enableAllButons();
			btnErase.setEnabled(false);
		}
		
		repaint();
	}
	
	public void enableAllButons() {
		btnAdd.setEnabled(true);
		btnErase.setEnabled(true);
	}
	
}
