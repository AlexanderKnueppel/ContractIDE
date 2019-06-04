package de.tu_bs.ccc.contracting.ui.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.idl.cidl.Interface;
import de.tu_bs.ccc.contracting.ui.localization.StringTable;
import de.tu_bs.ccc.contracting.ui.provider.ListTypeLabelProvider;

public abstract class EditPortFeatureDialog extends TitleAreaDialog implements IEditFeatureDialog {

	private Text portName;
	private Combo comboType;
	private Label portTypename;
	private Label labelFilter;
	private Text portFilter;
	private String currentName;
	private int currentDirection;
	private int currentType;
	private String currentTypename;
	private String currentFilter;
	private Label lbService;
	private List<Interface> interfaces;
	private List<String> types;
	protected Object object;

	public EditPortFeatureDialog(Shell parentShell, List<String> types, List<Interface> interfaces) {
		super(parentShell);
		this.types = types;
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
		GridLayout layout = new GridLayout(3, false);
		container.setLayout(layout);

		createDirection(container);
		createName(container);

		////createType(container);
		createTypename(container);

		createFilter(container);
		createAdditionalControls(container);

		return area;
	}

	protected void createAdditionalControls(Composite container) {
	}

	private void createName(Composite container) {
		Label lbName = new Label(container, SWT.BEGINNING);
		lbName.setText(StringTable.EDIT_PORT_DIALOG_NAME);

		GridData dataName = new GridData();
		dataName.grabExcessHorizontalSpace = true;
		dataName.horizontalAlignment = GridData.FILL;
		dataName.horizontalSpan = 2;

		portName = new Text(container, SWT.BORDER);
		portName.setLayoutData(dataName);
		portName.setText(currentName);
		
		//Label dummylb = new Label(container, SWT.NONE);

	}

	private void createFilter(Composite container) {
		labelFilter = new Label(container, SWT.NONE);
		labelFilter.setText(StringTable.EDIT_PORT_DIALOG_FILTER);

		GridData dataName = new GridData();
		dataName.grabExcessHorizontalSpace = true;
		dataName.horizontalAlignment = GridData.FILL;
		dataName.horizontalSpan = 2;

		portFilter = new Text(container, SWT.BORDER);
		portFilter.setLayoutData(dataName);
		portFilter.setText(currentFilter);
		
		//Label dummylb = new Label(container, SWT.NONE);
	}

	private void createDirection(Composite container) {
		Label lbDescription = new Label(container, SWT.NONE);
		lbDescription.setText(StringTable.EDIT_PORT_DIALOG_DIRECTION);
		
		GridData dataName = new GridData();
		//dataName.grabExcessHorizontalSpace = true;
		dataName.horizontalAlignment = GridData.FILL;
		dataName.horizontalSpan = 2;

		Label lbProperty = new Label(container, SWT.BORDER);
		lbProperty.setText(DirectionType.get(currentDirection).getName().equals("INTERNAL")
				? StringTable.EDIT_PORT_DIALOG_PORT_CONSUMER
				: StringTable.EDIT_PORT_DIALOG_PORT_PROVIDER);
		lbProperty.setLayoutData(dataName);
	}

//	private void createType(Composite container) {
//		Label lbType = new Label(container, SWT.NONE);
//		lbType.setText(StringTable.EDIT_PORT_DIALOG_TYPE);
//
//		comboType = new Combo(container, SWT.DROP_DOWN);
//		
//		String[] items = new String[PortType.values().length];
//		for(int i = 0; i < items.length; ++i)
//			items[i] = PortType.get(i).getName();
//		
//		comboType.setItems(items);
//		comboType.select(currentType);
//		comboType.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				if (comboType.getText().equals("SERVICE")) {
//					portServicename.setEnabled(true);
//				} else {
//					portServicename.setEnabled(false);
//				}
//			}
//		});
//	}

	private void createTypename(Composite container) {
		lbService = new Label(container, SWT.NONE);
		lbService.setText("Type");

		GridData dataService = new GridData();
		dataService.grabExcessHorizontalSpace = true;
		dataService.horizontalAlignment = GridData.FILL;

		portTypename = new Label(container, SWT.BORDER);
		portTypename.setLayoutData(dataService);
		portTypename.setText(currentTypename);
		
		final Button button = new Button(container, SWT.PUSH);
	    button.setText("Select");
		
//		portServicename = new Text(container, SWT.BORDER);
//		portServicename.setLayoutData(dataService);
//		portServicename.setText(currentServicename);
//		portServicename.setEditable(false);
//		portServicename.setBackground(new Color(container.getDisplay(), new RGB(255, 255, 255)));
		
		button.addSelectionListener(new SelectionListener() {
			@Override
			 public void widgetSelected(SelectionEvent event) {
				final ListTypesDialog dialog = new ListTypesDialog(null, new ListTypeLabelProvider(),
						StringTable.EDIT_PORT_DIALOG_LIST_SERVICES_TITLE,
						StringTable.EDIT_PORT_DIALOG_LIST_SERVICES_MSG, types, interfaces);

				if (dialog.open() != ListServicesDialog.CANCEL) {
					if (dialog.getResult().length > 0) {
						if(dialog.getResult()[0] instanceof String)
							portTypename.setText((String) dialog.getResult()[0]);
						else
							portTypename.setText(((Interface) dialog.getResult()[0]).getName());
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
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
		currentTypename = port.getService();
		currentFilter = port.getFilter() == null ? "" : port.getFilter();
	}

	@Override
	public void setNewProperties() {
		Ports port = (Ports) object;
		port.setName(portName.getText());
		port.setType(PortType.get(types.contains(portTypename.getText()) ? "JAVA" : "SERVICE"));
		port.setService(portTypename.getText());
		port.setFilter(portFilter.getText());
	}
}