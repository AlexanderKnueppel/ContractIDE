package de.tu_bs.ccc.contracting.ui.dialogs;

import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import de.tu_bs.ccc.contracting.Verification.Module;

public class LoadModuleDialog extends ElementListSelectionDialog {

	public LoadModuleDialog(Shell parent, ILabelProvider renderer, String dialogTitle, String dialogMessage, List<Module> modules) {
		super(parent, renderer);
		// TODO Auto-generated constructor stub
		
		setTitle(dialogTitle);
		setMessage(dialogMessage);
		setMultipleSelection(false);
		setElements(modules.toArray());
	}

}
