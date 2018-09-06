package windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import de.tu_bs.de.ccc.contracting.Verification.DirectionType;
import de.tu_bs.de.ccc.contracting.Verification.PortType;
import java.awt.Dimension;
import java.awt.Component;

public class PortDialog extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField, serviceField;
	private int selection, direction;
	
	public int getDirection() {
		return direction;
	}
	
	public int getSelection() {
		return selection;
	}

	public String getPortname() {
		return portname;
	}
	
	public String getService() {
		return servicename;
	}

	private String portname, servicename;
	private JComboBox comboBox = new JComboBox();
	private JComboBox directionComboBox = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PortDialog dialog = new PortDialog("output","component",1, "", 1);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PortDialog(String portName, String componentName, int portType, String service, int direction) {
		setModal(true);
		setBounds(100, 100, 286, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblNewLabel_1 = new JLabel("Portname:");
				lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel(componentName+".");
				lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
				panel.add(lblNewLabel_2);
			}
			{
				textField = new JTextField();
				textField.setText(portName);
				panel.add(textField);
				textField.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblNewLabel = new JLabel("I/O-Direction");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel);
			}
			{
				
				directionComboBox.setMaximumSize(new Dimension(50, 30));
				directionComboBox.setMaximumRowCount(2);
				directionComboBox.setModel(new DefaultComboBoxModel(DirectionType.values()));
				directionComboBox.setSelectedIndex(direction);
				panel.add(directionComboBox);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblNewLabel = new JLabel("PortType");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel);
			}
			{
				
				comboBox.setMaximumSize(new Dimension(50, 30));
				comboBox.setMaximumRowCount(5);
				comboBox.setModel(new DefaultComboBoxModel(PortType.values()));
				comboBox.setSelectedIndex(portType);
				panel.add(comboBox);
				
				comboBox.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(comboBox.getSelectedIndex() != PortType.SERVICE_VALUE) {
							serviceField.setEnabled(false);
						} else {
							serviceField.setEnabled(true);
						}
					}
				});
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblNewLabel_1 = new JLabel("Servicename:");
				lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
				panel.add(lblNewLabel_1);
			}
			{
				serviceField = new JTextField();
				serviceField.setText(service);
				panel.add(serviceField);
				serviceField.setColumns(10);
				if(portType != PortType.SERVICE_VALUE) {
					serviceField.setEnabled(false);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{

			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="OK") {
			selection = comboBox.getSelectedIndex();
			portname = textField.getText();
			if(selection == PortType.SERVICE_VALUE)
				servicename = serviceField.getText();
			else
				servicename = "";
			direction = directionComboBox.getSelectedIndex();
			this.dispose();
		}
		
	}

}
