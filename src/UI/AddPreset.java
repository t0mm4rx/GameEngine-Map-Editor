package UI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import MapEditor.Component;
import MapEditor.Preset;

@SuppressWarnings("serial")
public class AddPreset extends JFrame{
	private JTextField name;
	private String file;
	private AddPreset addPreset;
	private JList<String> list;
	public ArrayList<Component> comps;
	
	public AddPreset() {
		this.setTitle("Create a new preset");
		this.setSize(291, 358);
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		addPreset = this;
		file = "images/none.png";
		comps = new ArrayList<Component>();
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(168, 301, 117, 29);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (name.getText().equals("")) {
					JOptionPane.showMessageDialog(addPreset, "Please enter a name");
					return;
				}
				Preset p = new Preset(name.getText(), file);
				p.comps = comps;
				MapEditor.MapEditor.addPreset(p);
				dispose();
			}
		});
		getContentPane().add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(58, 301, 117, 29);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnCancel);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(6, 6, 61, 16);
		getContentPane().add(lblName);
		
		name = new JTextField();
		name.setBounds(58, 1, 227, 26);
		getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblComponents = new JLabel("Components");
		lblComponents.setBounds(6, 39, 80, 16);
		getContentPane().add(lblComponents);
		
		list = new JList<String>();
		list.setBounds(6, 63, 279, 226);
		getContentPane().add(list);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(127, 34, 80, 29);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ComponentCreator(addPreset);
			}
		});
		getContentPane().add(btnAdd);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.setBounds(205, 34, 80, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeSelectedComp();
			}
		});
		getContentPane().add(btnNewButton);
		
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		refreshList();
		repaint();
	}
	
	public void refreshList() {
		if (comps != null) {
			if (list.getModel().getSize() != comps.size()) {
				String[] model = new String[comps.size()];
				for (int i = 0; i < model.length; i++) {
					model[i] = comps.get(i).name;
				}
				list.setListData(model);
			}
		}
	}
	
	public void removeSelectedComp() {
		Component toDelete = null;
		for (Component c : comps) {
			if (c.name.equals(list.getSelectedValue())) {
				toDelete = c;
			}
		}
		comps.remove(toDelete);
	}
}
