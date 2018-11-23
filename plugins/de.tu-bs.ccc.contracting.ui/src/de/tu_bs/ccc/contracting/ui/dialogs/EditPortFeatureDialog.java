package de.tu_bs.ccc.contracting.ui.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.idl.cidl.Interface;
import de.tu_bs.ccc.contracting.ui.localization.StringTable;
import de.tu_bs.ccc.contracting.ui.provider.ListServiceLabelProvider;

public abstract class EditPortFeatureDialog extends TitleAreaDialog implements IEditFeatureDialog {

	private Text portName;
	private Combo comboType;
	private Text portServicename;
	private Label labelFilter;
	private Text portFilter;
	private String currentName;
	private int currentDirection;
	private int currentType;
	private String currentServicename;
	private String currentFilter;
	private Label lbService;
	private List<Interface> interfaces;
	protected Object object;

	public EditPortFeatureDialog(Shell parentShell, List<Interface> interfaces) {
		super(parentShell);
		this.interfaces = interfaces;
	}

	@Override
	public void create() {
		super.create();
		setTitle(StringTable.EDIT_PORT_DIALOG_TITLE);
		setMessage(StringTable.EDIT_PORT_DIALOG_MSG, IMessageProvider.INFORMATION);
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

		//Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
		//group.setText("Parameter");

		//Composite container2 = new Composite(group, SWT.NONE);
		//container2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		//container2.setLayout(new GridLayout(2, false));
		createFilter(container);
		createAdditionalControls(container);

		return area;
	}

	protected void createAdditionalControls(Composite container) {
	}

	private void createName(Composite container) {
		Label lbName = new Label(container, SWT.NONE);
		lbName.setText(StringTable.EDIT_PORT_DIALOG_NAME);

		GridData dataName = new GridData();
		dataName.grabExcessHorizontalSpace = true;
		dataName.horizontalAlignment = GridData.FILL;

		portName = new Text(container, SWT.BORDER);
		portName.setLayoutData(dataName);
		portName.setText(currentName);

	}

	private void createFilter(Composite container) {
		labelFilter = new Label(container, SWT.NONE);
		labelFilter.setText(StringTable.EDIT_PORT_DIALOG_FILTER);

		GridData dataName = new GridData();
		dataName.grabExcessHorizontalSpace = true;
		dataName.horizontalAlignment = GridData.FILL;

		portFilter = new Text(container, SWT.BORDER);
		portFilter.setLayoutData(dataName);
		portFilter.setText(currentFilter);
	}

	private void createDirection(Composite container) {
		Label lbDescription = new Label(container, SWT.NONE);
		lbDescription.setText(StringTable.EDIT_PORT_DIALOG_DIRECTION);

		Label lbProperty = new Label(container, SWT.NONE);
		lbProperty.setText(DirectionType.get(currentDirection).getName().equals("INTERNAL")
				? StringTable.EDIT_PORT_DIALOG_PORT_CONSUMER
				: StringTable.EDIT_PORT_DIALOG_PORT_PROVIDER);
	}

	private void createType(Composite container) {
		Label lbType = new Label(container, SWT.NONE);
		lbType.setText(StringTable.EDIT_PORT_DIALOG_TYPE);

		comboType = new Combo(container, SWT.DROP_DOWN);

		String[] items = new String[] { PortType.get(0).getName(), PortType.get(1).getName(), PortType.get(2).getName(),
				PortType.get(3).getName(), PortType.get(4).getName() };
		comboType.setItems(items);
		comboType.select(currentType);
		comboType.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (comboType.getText().equals("SERVICE")) {
					portServicename.setEnabled(true);
				} else {
					portServicename.setEnabled(false);
				}
			}
		});
	}

	private void createServicename(Composite container) {
		lbService = new Label(container, SWT.NONE);
		lbService.setText("Service name");

		GridData dataService = new GridData();
		dataService.grabExcessHorizontalSpace = true;
		dataService.horizontalAlignment = GridData.FILL;
		portServicename = new Text(container, SWT.BORDER);
		portServicename.setLayoutData(dataService);
		portServicename.setText(currentServicename);
		portServicename.setEditable(false);
		portServicename.setBackground(new Color(container.getDisplay(), new RGB(255, 255, 255)));
		portServicename.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(final MouseEvent e) {
				final ListServicesDialog dialog = new ListServicesDialog(null, new ListServiceLabelProvider(),
						StringTable.EDIT_PORT_DIALOG_LIST_SERVICES_TITLE,
						StringTable.EDIT_PORT_DIALOG_LIST_SERVICES_MSG, interfaces);

				if (dialog.open() != ListServicesDialog.CANCEL) {
					if (dialog.getResult().length > 0)
						portServicename.setText(((Interface) dialog.getResult()[0]).getName());
				}
			}
		});

		if (currentType != PortType.get("SERVICE").getValue()) {
			portServicename.setEnabled(false);
		}
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
		currentFilter = port.getFilter();
	}

	@Override
	public void setNewProperties() {
		Ports port = (Ports) object;
		port.setName(portName.getText());
		if (comboType.getText().equals("SERVICE")) {
			port.setService(portServicename.getText());
		} else {
			port.setService("");
		}
		port.setType(PortType.get(comboType.getText()));
		port.setService(portServicename.getText());
		port.setFilter(portFilter.getText());
	}
}