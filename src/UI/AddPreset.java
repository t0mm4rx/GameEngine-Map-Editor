package UI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import MapEditor.Component;
import MapEditor.Preset;

@SuppressWarnings("serial")
public class AddPreset extends JFrame{
	private JTextField name;
	private String file;
	private JCheckBox chckbxNewCheckBox;
	private JFrame addPreset;
	private JList<String> list;
	private ArrayList<Component> comps;
	
	public AddPreset() {
		this.setTitle("Create a new preset");
		this.setSize(291, 358);
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		addPreset = this;
		file = "images/none.png";
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(168, 301, 117, 29);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected() && file.equals("images/none.png")) {
					JOptionPane.showMessageDialog(addPreset, "Please select an image file");
					return;
				}
				if (name.getText().equals("")) {
					JOptionPane.showMessageDialog(addPreset, "Please enter a name");
					return;
				}
				MapEditor.MapEditor.addPreset(new Preset(name.getText(), file));
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
		
		JLabel lblImageSource = new JLabel("Image source :");
		lblImageSource.setBounds(6, 70, 99, 16);
		getContentPane().add(lblImageSource);
		
		JButton btnChoose = new JButton("Choose");
		btnChoose.setBounds(100, 65, 117, 29);
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
    "Image files", ImageIO.getReaderFileSuffixes()));
				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.showOpenDialog(addPreset);
				file = fileChooser.getSelectedFile().getAbsolutePath();
			}	
		});
		getContentPane().add(btnChoose);
		
		chckbxNewCheckBox = new JCheckBox("Has image");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(0, 34, 128, 23);
		chckbxNewCheckBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
					btnChoose.setEnabled(true);
				} else {
					btnChoose.setEnabled(false);
				}
			}
		});
		getContentPane().add(chckbxNewCheckBox);
		
		JLabel lblComponents = new JLabel("Components");
		lblComponents.setBounds(6, 105, 80, 16);
		getContentPane().add(lblComponents);
		
		list = new JList<String>();
		list.setBounds(6, 133, 279, 163);
		getContentPane().add(list);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(139, 100, 80, 29);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ComponentCreator();
			}
		});
		getContentPane().add(btnAdd);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.setBounds(211, 100, 80, 29);
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
		if (list.getModel().getSize() != comps.size()) {
			String[] model = new String[comps.size()];
			for (int i = 0; i < model.length; i++) {
				model[i] = comps.get(i).name;
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
