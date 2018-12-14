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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.ProviderType;
import de.tu_bs.ccc.contracting.idl.cidl.Interface;
import de.tu_bs.ccc.contracting.ui.localization.StringTable;
import de.tu_bs.ccc.contracting.ui.provider.ListServiceLabelProvider;

public class EditConsumerPortFeatureDialog extends EditPortFeatureDialog {

	private Label labelLabel;
	private Text portLabel;
	private Label labelFunction;
	private Text portFunction;
	private String currentLabel;
	private String currentFunction;

	public EditConsumerPortFeatureDialog(Shell parentShell, List<Interface> interfaces) {
		super(parentShell, interfaces);
	}

	private void createFunction(Composite container) {
		labelFunction = new Label(container, SWT.NONE);
		labelFunction.setText(StringTable.EDIT_PORT_DIALOG_FUNCTION);

		GridData dataName = new GridData();
		dataName.grabExcessHorizontalSpace = true;
		dataName.horizontalAlignment = GridData.FILL;

		portFunction = new Text(container, SWT.BORDER);
		portFunction.setLayoutData(dataName);
		portFunction.setText(currentFunction != null ? currentFunction : "");
	}

	private void createLabel(Composite container) {
		labelLabel = new Label(container, SWT.NONE);
		labelLabel.setText(StringTable.EDIT_PORT_DIALOG_LABEL);

		GridData dataName = new GridData();
		dataName.grabExcessHorizontalSpace = true;
		dataName.horizontalAlignment = GridData.FILL;

		portLabel = new Text(container, SWT.BORDER);
		portLabel.setLayoutData(dataName);
		portLabel.setText(currentLabel);
	}
	
	@Override
	protected void createAdditionalControls(Composite container) {
		// TODO Auto-generated method stub
		super.createAdditionalControls(container);
		createFunction(container);
		createLabel(container);
	}

	@Override
	public void setOldProperties(Object object) {
		super.setOldProperties(object);
		Ports port = (Ports) object;
		currentLabel = port.getLabel();
		currentFunction = port.getFunction();
	}

	@Override
	public void setNewProperties() {
		super.setNewProperties();
		Ports port = (Ports) object;
		port.setLabel(portLabel.getText());
		port.setFunction(portFunction.getText());
	}
}