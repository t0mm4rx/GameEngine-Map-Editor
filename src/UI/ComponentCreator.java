package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class ComponentCreator extends JFrame{
	private JTextField name;
	private JComboBox<String> comboBox;
	
	public ComponentCreator() {
		this.setTitle("Create a new component");
		this.setSize(281, 300);
		this.setResizable(false);
		getContentPane().setLayout(null);
		
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
		getContentPane().add(comboBox);
		this.setVisible(true);
	}
}
