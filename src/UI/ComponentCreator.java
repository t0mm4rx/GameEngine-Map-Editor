package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import MapEditor.Component;

@SuppressWarnings("serial")
public class ComponentCreator extends JFrame{
	private JTextField name;
	private JComboBox<String> comboBox;
	private JTextField width;
	private JTextField height;
	private JTextField text;
	private JTextField radius;
	JComboBox<String> bodyType;
	JButton btnColor;
	JButton btnFont;
	JButton btnImage;
	private JLabel lblSize;
	private JTextField size;
	private JButton btnOk;
	private JButton btnCancel;
	private JFrame _this;
	private String imageSrc, fontSrc;
	public float r, g, b, a;
	
	public ComponentCreator(AddPreset frame) {
		this.setTitle("Create a new component");
		this.setSize(281, 381);
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		_this = this;
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(6, 6, 61, 16);
		getContentPane().add(lblName);
		
		name = new JTextField();
		name.setBounds(64, 1, 211, 26);
		getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setBounds(6, 34, 48, 16);
		getContentPane().add(lblType);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Sprite Renderer", "Box Body", "Circle Body", "Box Renderer", "Text"}));
		comboBox.setBounds(64, 30, 211, 27);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshProperties();
			}
		});
		getContentPane().add(comboBox);
		
		JLabel lblSource = new JLabel("Image source :");
		lblSource.setBounds(6, 71, 97, 16);
		getContentPane().add(lblSource);
		
		btnImage = new JButton("Choose");
		btnImage.setBounds(158, 66, 117, 29);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
    "Image files", ImageIO.getReaderFileSuffixes()));
				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.showOpenDialog(_this);
				imageSrc = fileChooser.getSelectedFile().getAbsolutePath();
			}});
		getContentPane().add(btnImage);
		
		JLabel lblWidth = new JLabel("Width :");
		lblWidth.setBounds(6, 99, 61, 16);
		getContentPane().add(lblWidth);
		
		JLabel lblHeight = new JLabel("Height :");
		lblHeight.setBounds(6, 127, 61, 16);
		getContentPane().add(lblHeight);
		
		width = new JTextField();
		width.setBounds(105, 94, 170, 26);
		getContentPane().add(width);
		width.setColumns(10);
		
		height = new JTextField();
		height.setBounds(105, 122, 170, 26);
		getContentPane().add(height);
		height.setColumns(10);
		
		JLabel lblColor = new JLabel("Color :");
		lblColor.setBounds(6, 155, 61, 16);
		getContentPane().add(lblColor);
		
		btnColor = new JButton("Choose");
		btnColor.setBounds(158, 150, 117, 29);
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				Color color = JColorChooser.showDialog(null, "Choose a color", null);
				r = color.getRed();
				g = color.getGreen();
				b = color.getBlue();
				a = color.getAlpha();
			}
		});
		getContentPane().add(btnColor);
		
		JLabel lblText = new JLabel("Text :");
		lblText.setBounds(6, 183, 61, 16);
		getContentPane().add(lblText);
		
		text = new JTextField();
		text.setBounds(105, 178, 170, 26);
		getContentPane().add(text);
		text.setColumns(10);
		
		JLabel lblFontSource = new JLabel("Font source :");
		lblFontSource.setBounds(6, 211, 82, 16);
		getContentPane().add(lblFontSource);
		
		btnFont = new JButton("Choose");
		btnFont.setBounds(158, 206, 117, 29);
		btnFont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
    "Font files", "ttf"));
				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.showOpenDialog(_this);
				fontSrc = fileChooser.getSelectedFile().getAbsolutePath();
			}
		});
		getContentPane().add(btnFont);
		
		JLabel lblRadius = new JLabel("Radius :");
		lblRadius.setBounds(6, 239, 61, 16);
		getContentPane().add(lblRadius);
		
		radius = new JTextField();
		radius.setBounds(105, 234, 170, 26);
		getContentPane().add(radius);
		radius.setColumns(10);
		
		JLabel lblBodyType = new JLabel("Body type :");
		lblBodyType.setBounds(6, 267, 82, 16);
		getContentPane().add(lblBodyType);
		
		bodyType = new JComboBox<String>();
		bodyType.setModel(new DefaultComboBoxModel<String>(new String[] {"Static", "Dynamic", "Kinematic"}));
		bodyType.setBounds(105, 263, 170, 25);
		getContentPane().add(bodyType);
		
		lblSize = new JLabel("Size :");
		lblSize.setBounds(6, 292, 61, 16);
		getContentPane().add(lblSize);
		
		size = new JTextField();
		size.setBounds(105, 287, 170, 26);
		getContentPane().add(size);
		size.setColumns(10);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(158, 324, 117, 29);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (name.getText() != "") {
					switch (comboBox.getSelectedIndex()) {
					case 0:
						if (imageSrc != null) {
							frame.comps.add(new Component(name.getText(), imageSrc));
							dispose();
						} else {
							alert("Please choose an image");
						}
						break;
					case 1:
						if (width.getText() != "" && height.getText() != "") {
							frame.comps.add(new Component(name.getText(), (int) Float.parseFloat(width.getText()), (int) Float.parseFloat(height.getText()), bodyType.getSelectedIndex()));
							dispose();
						} else {
							alert("Please fill all the properties");
						}
						break;
					case 2:
						if (radius.getText() != "") {
							frame.comps.add(new Component(name.getText(), (int) Float.parseFloat(radius.getText()), bodyType.getSelectedIndex()));
							dispose();
						} else {
							alert("Please fill all the properties");
						}
						break;
					case 3:
						if (width.getText() != "" && height.getText() != "") {
							frame.comps.add(new Component(name.getText(), (int) Float.parseFloat(width.getText()), (int) Float.parseFloat(height.getText()), r, g, b, a));
							dispose();
						} else {
							alert("Please fill all the properties");
						}
						break;
					case 4:
						if (text.getText() != "" && fontSrc != "" && size.getText() != "") {
							frame.comps.add(new Component(name.getText(), text.getText(), fontSrc, (int) Float.parseFloat(size.getText())));
							dispose();
						} else {
							alert("Please fill all the properties");
						}
						break;
					}
				} else {
					alert("Please enter a name.");
				}
			}
		});
		getContentPane().add(btnOk);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(40, 324, 117, 29);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnCancel);
		
		refreshProperties();
		
		this.setVisible(true);
	}
	
	public void refreshProperties() {
		disableAll();
		if (comboBox.getSelectedIndex() == 0) {
			btnImage.setEnabled(true);
		}
		if (comboBox.getSelectedIndex() == 1) {
			width.setEnabled(true);
			height.setEnabled(true);
			bodyType.setEnabled(true);
		}
		if (comboBox.getSelectedIndex() == 2) {
			radius.setEnabled(true);
			bodyType.setEnabled(true);
		}
		if (comboBox.getSelectedIndex() == 3) {
			width.setEnabled(true);
			height.setEnabled(true);
			btnColor.setEnabled(true);
		}
		if (comboBox.getSelectedIndex() == 4) {
			text.setEnabled(true);
			btnFont.setEnabled(true);
			size.setEnabled(true);
		}
	}
	
	public void disableAll() {
		width.setEnabled(false);
		height.setEnabled(false);
		text.setEnabled(false);
		btnColor.setEnabled(false);
		btnFont.setEnabled(false);
		btnImage.setEnabled(false);
		radius.setEnabled(false);
		bodyType.setEnabled(false);
		size.setEnabled(false);
	}
	
	public void alert(String message) {
		JOptionPane.showMessageDialog(_this, message);
	}
}
