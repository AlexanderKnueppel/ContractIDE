package de.tu_bs.ccc.contracting.ui.views.verification;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class VerificationResultDialog extends TitleAreaDialog {

	private VerificationViewElement element;

	public VerificationResultDialog(Shell parentShell, VerificationViewElement element) {
		super(parentShell);
		this.element = element;
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);

		setTitleImage(getShell().getDisplay().getSystemImage(SWT.ICON_WORKING));
		if (element.success()) {
			setMessage("Succesful!", IMessageProvider.INFORMATION);
		} else {
			setMessage("Failed!", IMessageProvider.ERROR);
		}
		setTitle("Viewpoint: " + element.viewPointToString() + " (" + element.getComponent() + ")");

		return contents;
	}

	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(contents, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		container.setLayout(gridLayout);
		Label label = new Label(container, SWT.NONE);
		label.setText("Logical clause:");

		Label clause = new Label(container, SWT.NONE);
		clause.setText(element.getClause());

		GridData gridData1 = new GridData(GridData.FILL_HORIZONTAL);
		GridData gridData2 = new GridData(GridData.FILL_HORIZONTAL);

		label.setLayoutData(gridData1);
		clause.setLayoutData(gridData2);
		return contents;
	}

	@Override
	protected void buttonPressed(int buttonId) {
		// TODO Auto-generated method stub
		super.buttonPressed(buttonId);
		close();
	}
}