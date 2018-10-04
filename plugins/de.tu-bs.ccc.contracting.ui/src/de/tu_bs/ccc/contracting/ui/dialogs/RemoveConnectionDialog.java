package de.tu_bs.ccc.contracting.ui.dialogs;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public abstract class RemoveConnectionDialog {

	public static boolean removeConnectionDialog(Shell shell, String portname) {
		String text = "You are going to change a direction-type. This will delete the current connections of " + portname + ".";
		boolean result = MessageDialog.openConfirm(shell, "Remove Connections", text);
		return result;
	}	
}
