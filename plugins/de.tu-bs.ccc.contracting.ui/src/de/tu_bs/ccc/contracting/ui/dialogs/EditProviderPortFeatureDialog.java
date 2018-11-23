package de.tu_bs.ccc.contracting.ui.dialogs;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.ProviderType;
import de.tu_bs.ccc.contracting.idl.cidl.Interface;
import de.tu_bs.ccc.contracting.ui.localization.StringTable;

public class EditProviderPortFeatureDialog extends EditPortFeatureDialog {
	private Label labelMaxClients;
	private Text portMaxClients;
	private Label labelProviderType;
	private Combo comboProviderType;
	private int currentMaxClients;
	private int currentProviderType;

	public EditProviderPortFeatureDialog(Shell parentShell, List<Interface> interfaces) {
		super(parentShell, interfaces);
	}

	protected void createMaxClients(Composite container) {
		labelMaxClients = new Label(container, SWT.NONE);
		labelMaxClients.setText(StringTable.EDIT_PORT_DIALOG_MAX_CLIENTS);

		GridData dataName = new GridData();
		dataName.grabExcessHorizontalSpace = true;
		dataName.horizontalAlignment = GridData.FILL;
		
		portMaxClients = new Text(container, SWT.BORDER);
		portMaxClients.setLayoutData(dataName);
		portMaxClients.setText(currentMaxClients + "");
	}

	private void createProviderType(Composite container) {
		labelProviderType = new Label(container, SWT.NONE);
		labelProviderType.setText(StringTable.EDIT_PORT_DIALOG_PROVIDER_TYPE);

		comboProviderType = new Combo(container, SWT.DROP_DOWN);

		String[] items = new String[] { ProviderType.get(0).getName(), ProviderType.get(1).getName(),
				ProviderType.get(2).getName() };

		GridData dataName = new GridData();
		dataName.grabExcessHorizontalSpace = true;
		dataName.horizontalAlignment = GridData.FILL;

		comboProviderType.setItems(items);
		comboProviderType.select(currentProviderType);
	}
	
	protected void createAdditionalControls(Composite container) {
		// TODO Auto-generated method stub
		super.createAdditionalControls(container);
		createMaxClients(container);
		createProviderType(container);
	}

	@Override
	protected void okPressed() {
		setNewProperties();
		super.okPressed();
	}

	@Override
	public void setOldProperties(Object object) {
		super.setOldProperties(object);
		Ports port = (Ports) object;
		currentMaxClients = port.getMaxClients();
		currentProviderType = port.getProviderType().getValue();
	}

	@Override
	public void setNewProperties() {
		super.setNewProperties();
		Ports port = (Ports) object;
		port.setMaxClients(Integer.parseInt(portMaxClients.getText()));
		port.setProviderType(ProviderType.get(comboProviderType.getText()));
	}
}