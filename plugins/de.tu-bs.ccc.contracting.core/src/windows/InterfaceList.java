package windows;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Dimension;

public class InterfaceList extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7222381101957086411L;
	private final JPanel contentPanel = new JPanel();
	boolean delete = false;
	public boolean isDelete() {
		return delete;
	}

	private JTextField filterInput;
	private int count;
	JList list = new JList();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public InterfaceList(Object[] objectList) {
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Import");
		setBounds(100, 100, 503, 552);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblFilter = new JLabel("FIlter");
				lblFilter.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblFilter);
			}
			{
				filterInput = new JTextField();
				panel.add(filterInput);
				filterInput.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Delete");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(this);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("CANCEL");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				list = new JList(objectList);
				list.setSelectedIndex(-1);
				list.setMaximumSize(new Dimension(1000, 1000));
				list.setPreferredSize(new Dimension(300, 400));
				list.setMinimumSize(new Dimension(100, 500));
				list.setBounds(new Rectangle(0, 0, 100, 100));
				panel.add(list);
				list.setToolTipText("Blaaaaaa");
				list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="OK") {
			delete = true;
			count = list.getSelectedIndex();
			this.dispose();
			
		}
		if(e.getActionCommand()=="CANCEL") {
			this.dispose();
			
		}
		
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	

}
