package de.tu_bs.ccc.contracting.ui.editors;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ChangeDescriptionDialog extends Dialog {

	private final String title;

	private String message;

	private String value = "";

	private Button okButton;

	private Text text;

	private CLabel label;

	private final String initmessage;

	public ChangeDescriptionDialog(Shell parentShell, String dialogTitle, String dialogMessage, String initialValue) {
		super(parentShell);
		title = dialogTitle;
		message = dialogMessage;
		initmessage = message;
		if (initialValue == null) {
			value = "";
		} else {
			value = initialValue;
		}
	}

	protected void validate() {
		if (text.getText().contains(">") || (text.getText().contains("<"))) {

			if (text.getText().contains(">")) {
				message = "Description contains invalid char '>'";
				label.setText(message);
				label.setImage(null);
				okButton.setEnabled(false);
			}

			if (text.getText().contains("<")) {
				message = "Description contains invalid char '<'";
				label.setText(message);
				label.setImage(null);
				okButton.setEnabled(false);
			}
		} else {
			label.setText(initmessage);
			label.setImage(null);
			okButton.setEnabled(true);
		}
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			value = text.getText();
		} else {
			value = null;
		}
		super.buttonPressed(buttonId);
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		if (title != null) {
			shell.setText(title);
		}
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		text.setFocus();
		if (value != null) {
			text.setText(value);
			text.selectAll();
		}
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite composite = (Composite) super.createDialogArea(parent);
		if (message != null) {
			label = new CLabel(composite, SWT.WRAP);
			label.setText(message);
			final GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL
					| GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_CENTER);
			data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
			label.setLayoutData(data);
			label.setFont(parent.getFont());
		}
		text = new Text(composite, getInputTextStyle());
		text.setLayoutData(new GridData(350, 100));

		text.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				validate();
			}
		});

		applyDialogFont(composite);
		return composite;
	}

	protected Button getOkButton() {
		return okButton;
	}

	protected Text getText() {
		return text;
	}

	protected int getInputTextStyle() {
		return SWT.MULTI | SWT.BORDER | SWT.V_SCROLL;
	}

	public String getValue() {
		if ((value == null) || value.equals("")) {
			return " ";
		}
		return value;
	}
}
