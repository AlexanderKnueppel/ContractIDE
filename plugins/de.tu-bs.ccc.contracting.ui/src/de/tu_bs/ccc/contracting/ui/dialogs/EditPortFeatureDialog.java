package de.tu_bs.ccc.contracting.ui.dialogs;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;

public class EditPortFeatureDialog extends TitleAreaDialog implements IEditFeatureDialog {

	private Text portName;
	private Combo comboDirection;
	private Combo comboType;
	private Text portServicename;

	String currentName;
	int currentDirection;
	int currentType;
	String currentServicename;
	boolean serviceEditable;

	Object object;

	public EditPortFeatureDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	public void create() {
		super.create();
		setTitle("Edit Port");
		setMessage("Edit the name, direction, type and servicename (if type = Service) of the port.", IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);
		
		createDirection(container);
		createName(container);
		createType(container);
		createServicename(container);
		if (currentType != PortType.get("SERVICE").getValue()) {
			portServicename.setVisible(false);
		}
		return area;
	}

	private void createName(Composite container) {
		Label lbName = new Label(container, SWT.NONE);
		lbName.setText("Name");

		GridData dataName = new GridData();
		dataName.grabExcessHorizontalSpace = true;
		dataName.horizontalAlignment = GridData.FILL;

		portName = new Text(container, SWT.BORDER);
		portName.setLayoutData(dataName);
		portName.setText(currentName);

	}

	private void createDirection(Composite container) {
		Label lbDescription = new Label(container, SWT.NONE);
		lbDescription.setText("Direction");
		
		Label lbProperty = new Label(container, SWT.NONE);
		lbProperty.setText(DirectionType.get(currentDirection).getName());

//		comboDirection = new Combo(container, SWT.DROP_DOWN);
//		String[] items = new String[] { DirectionType.get(0).getName(), DirectionType.get(1).getName() };
//		comboDirection.setItems(items);
//		comboDirection.select(currentDirection);
	}

	private void createType(Composite container) {
		Label lbType = new Label(container, SWT.NONE);
		lbType.setText("Type");

		comboType = new Combo(container, SWT.DROP_DOWN);

		String[] items = new String[] { PortType.get(0).getName(), PortType.get(1).getName(), PortType.get(2).getName(),
				PortType.get(3).getName(), PortType.get(4).getName() };
		comboType.setItems(items);
		comboType.select(currentType);
		comboType.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (comboType.getText().equals("SERVICE")) {
					portServicename.setVisible(true);
				} else {
					portServicename.setVisible(false);
				}
			}
		});
	}

	private void createServicename(Composite container) {
		Label lbService = new Label(container, SWT.NONE);
		lbService.setText("Servicename");

		GridData dataService = new GridData();
		dataService.grabExcessHorizontalSpace = true;
		dataService.horizontalAlignment = GridData.FILL;
		portServicename = new Text(container, SWT.BORDER);
		portServicename.setLayoutData(dataService);
		portServicename.setText(currentServicename);

	}

	@Override
	protected void okPressed() {
		setNewProperties();
		super.okPressed();
	}

	@Override
	public void setOldProperties(Object object) {
		this.object = object;
		Ports port = (Ports) object;
		currentName = port.getName();
		currentDirection = port.getOuterDirection().getValue();
		currentType = port.getType().getValue();
		currentServicename = port.getService();

	}

	@Override
	public void setNewProperties() {
		Ports port = (Ports) object;
		port.setName(portName.getText());
//		port.setOuterDirection(DirectionType.get(comboDirection.getText()));
		port.setType(PortType.get(comboType.getText()));
		if (comboType.getText().equals("SERVICE")) {
			port.setService(portServicename.getText());
		} else {
			port.setService("");
		}

	}
}