package windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.tu_bs.de.ccc.contracting.Verification.Assumption;
import de.tu_bs.de.ccc.contracting.Verification.Contract;
import de.tu_bs.de.ccc.contracting.Verification.ContractType;
import de.tu_bs.de.ccc.contracting.Verification.Guarantee;
import de.tu_bs.de.ccc.contracting.Verification.PropertyType;

import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class EditPropertyWindow extends JDialog implements ActionListener {
	
	Assumption delA;
	public Assumption getDelA() {
		return delA;
	}

	public Guarantee getDelG() {
		return delG;
	}

	public PropertyType getTypeofSelect() {
		return typeofSelect;
	}

	public boolean isGa() {
		return ga;
	}

	public boolean isAs() {
		return as;
	}

	Guarantee delG;
	String propertyOfSelect;
	public String getPropertyOfSelect() {
		return propertyOfSelect;
	}

	PropertyType typeofSelect;
	int selectCount;
	public int getSelectCount() {
		return selectCount;
	}

	boolean ga = false;
	boolean as = false;
	ArrayList<Assumption> editA;
	ArrayList<Guarantee> editG;
	private final JPanel assumptions = new JPanel();
	JList ass;
	JList gua;
	Contract contract;
	String[] assumption;
	String[] guarantee;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public EditPropertyWindow(Contract c) {
		this.setModal(true);
		contract = c;
		assumption = new String[c.getAssumption().size()];
		guarantee = new String[c.getGuarantee().size()];
		for (int i = 0; i < guarantee.length; i++) {
			guarantee[i] = c.getGuarantee().get(i).getPropertyTipe() + ": " + c.getGuarantee().get(i).getProperty();
		}
		for (int i = 0; i < assumption.length; i++) {
			assumption[i] = c.getAssumption().get(i).getPropertyTipe() + ": " + c.getAssumption().get(i).getProperty();
		}

		setBounds(100, 100, 492, 482);
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.add(assumptions);
			assumptions.setBorder(new EmptyBorder(5, 5, 5, 5));
			assumptions.setLayout(new BorderLayout(0, 0));
			{
				JLabel lblNewLabel = new JLabel("Assumptions");
				lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
				assumptions.add(lblNewLabel, BorderLayout.WEST);
			}
			{
				JList list = new JList<String>(assumption);
				ass = list;
				list.setMinimumSize(new Dimension(80, 100));
				list.setPreferredSize(new Dimension(200, 200));
				list.setVisibleRowCount(assumption.length);
				list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setViewportView(list);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				assumptions.add(scrollPane);
			}
			{

			}
			{
				JPanel guarantees = new JPanel();
				panel.add(guarantees);
				guarantees.setLayout(new BorderLayout(0, 0));
				{
					JLabel lblNewLabel_1 = new JLabel("Guarantees");
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
					guarantees.add(lblNewLabel_1, BorderLayout.WEST);
				}
				{
					JList list = new JList<String>(guarantee);
					gua = list;
					list.setPreferredSize(new Dimension(200, 200));
					list.setVisibleRowCount(guarantee.length);

					list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
					scrollPane.setViewportView(list);
					guarantees.add(scrollPane);
				}
				{

				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("Edit");
				okButton.setActionCommand("Edit");
				buttonPane.add(okButton);
				okButton.addActionListener(this);
				getRootPane().setDefaultButton(okButton);

			}
			{
				JButton delete = new JButton("Delete");
				delete.setActionCommand("Delete");
				delete.addActionListener(this);
				buttonPane.add(delete);

			}
			{
				JButton cancelButton = new JButton("End");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Edit") {
			if (gua.isSelectionEmpty()) {
				if (!ass.isSelectionEmpty()) {
					Assumption a = contract.getAssumption().get(ass.getSelectedIndex());
					PropertyWindow win = new PropertyWindow(a.getProperty(), a.getPropertyTipe().getValue(),
							ContractType.ASSUMPTION_VALUE);
					win.setVisible(true);
					this.propertyOfSelect= win.getProp();
					this.typeofSelect=PropertyType.values()[win.getProptype()];
					this.selectCount=ass.getSelectedIndex();
					as=true;
					
				}} else if (ass.isSelectionEmpty()) {
					if (!gua.isSelectionEmpty()) {
						Guarantee a = contract.getGuarantee().get(gua.getSelectedIndex());
						PropertyWindow win = new PropertyWindow(a.getProperty(), a.getPropertyTipe().getValue(),
								ContractType.GUARANTEE_VALUE);
						win.setVisible(true);
						this.propertyOfSelect= win.getProp();
						this.typeofSelect=PropertyType.values()[win.getProptype()];
						this.selectCount=gua.getSelectedIndex();
						ga=true;
					}

				}

			
			this.dispose();
		} else if (e.getActionCommand() == "Delete") {

			if (gua.isSelectionEmpty()) {
				if (!ass.isSelectionEmpty()) {
					delA = (contract.getAssumption().get(ass.getSelectedIndex()));

				}
			} else if (ass.isSelectionEmpty()) {
				if (!gua.isSelectionEmpty()) {
					delG = (contract.getGuarantee().get(gua.getSelectedIndex()));
				}

			}
			this.dispose();
		} else if (e.getActionCommand() == "Cancel") {
			this.dispose();
		}
	}

}
