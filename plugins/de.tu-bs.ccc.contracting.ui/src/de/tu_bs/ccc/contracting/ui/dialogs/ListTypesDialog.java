package de.tu_bs.ccc.contracting.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import de.tu_bs.ccc.contracting.idl.cidl.Interface;

public class ListTypesDialog extends ElementListSelectionDialog {

	public ListTypesDialog(Shell parent, ILabelProvider renderer, String dialogTitle, String dialogMessage, List<String> types, List<Interface> services) {
		super(parent, renderer);
		
		setTitle(dialogTitle);
		setMessage(dialogMessage);
		setMultipleSelection(false);
		
		List<Object> elements = new ArrayList<Object>();
		elements.addAll(types);
		elements.addAll(services);
		setElements(elements.toArray());
	}

}
