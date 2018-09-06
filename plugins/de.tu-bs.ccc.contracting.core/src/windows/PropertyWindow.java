package windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import de.tu_bs.de.ccc.contracting.Verification.PropertyType;
import de.tu_bs.de.ccc.contracting.Verification.ContractType;

public class PropertyWindow extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	JComboBox comboBox1 = new JComboBox();
	JComboBox comboBox2 = new JComboBox();
	int assumption;
	public int getAssumption() {
		return assumption;
	}

	String prop;
	int proptype;

	public String getProp() {
		return prop;
	}

	public int getProptype() {
		return proptype;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the dialog.
	 */
	public PropertyWindow(String property, int propertytype, int viewpoint) {
		this.setModal(true);
		setBounds(100, 100, 393, 250);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(3, 2, 0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblPropertyType = new JLabel("Property Type");
				panel.add(lblPropertyType);
			}
			{
				panel.add(comboBox1);
				
				comboBox1.setModel(new DefaultComboBoxModel(PropertyType.values()));
				comboBox1.setSelectedIndex(propertytype);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblAssumption = new JLabel("Assumption");
				panel.add(lblAssumption);
			}
			{
				panel.add(comboBox2);
				
				comboBox2.setModel(new DefaultComboBoxModel(ContractType.values()));
				comboBox2.setSelectedIndex(viewpoint);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("Propterty");
				panel.add(lblNewLabel);
			}
			{
				textField = new JTextField();
				textField.setText(property);
				panel.add(textField);
				textField.setColumns(30);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(this);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="OK") {
			proptype=comboBox1.getSelectedIndex();
			prop = textField.getText();
			this.assumption=comboBox2.getSelectedIndex();
			this.dispose();
			
		}
		
	}

}
