package UI;

import MapEditor.*;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

@SuppressWarnings("serial")
public class PresetsManager extends JFrame {

	JList<String> list;
	
	public PresetsManager() {
		this.setTitle("Presets");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(300, 500);
		getContentPane().setLayout(null);
		
		JButton btnAddPreset = new JButton("Add preset");
		btnAddPreset.setBounds(6, 6, 143, 29);
		btnAddPreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddPreset();
			}			
		});
		getContentPane().add(btnAddPreset);
		
		JButton btnRemovePreset = new JButton("Remove preset");
		btnRemovePreset.setBounds(151, 6, 143, 29);
		getContentPane().add(btnRemovePreset);
		
		list = new JList<String>();
		list.setBounds(6, 35, 288, 437);
		getContentPane().add(list);
		
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		refreshList();
		refreshSelectedPreset();
		repaint();
	}
	
	public void refreshList() {
		if (list.getModel().getSize() != MapEditor.presets.size()) {
			String[] strings = new String[MapEditor.presets.size()];
			for (int i = 0; i < strings.length; i++) {
				strings[i] = MapEditor.presets.get(i).name;
			}
			list.setListData(strings);
		}
	}
	
	public void refreshSelectedPreset() {
		if (list.getSelectedValue() != MapEditor.selectedPresetName) {
			MapEditor.selectedPresetName = list.getSelectedValue();
		}
	}
}
