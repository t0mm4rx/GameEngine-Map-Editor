package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import MapEditor.Preset;

@SuppressWarnings("serial")
public class AddPreset extends JFrame{
	private JTextField name;
	private String file;
	private JCheckBox chckbxNewCheckBox;
	private JFrame addPreset;
	
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
		this.setVisible(true);
	}
}
