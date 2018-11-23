package de.tu_bs.ccc.contracting.ui.views;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;

import de.tu_bs.ccc.contracting.Verification.Module;

public class ValueEditingSupport extends EditingSupport {

	public ValueEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		if (element instanceof ModulePropertyElement)
			return ((ModulePropertyElement) element).getCellEditor();
		return null;
	}

	@Override
	protected boolean canEdit(Object element) {
		// TODO Auto-generated method stub
		return element instanceof ModulePropertyElement && ((ModulePropertyElement)element).canEdit();
	}

	@Override
	protected Object getValue(Object element) {
		// TODO Auto-generated method stub
		return ((ModulePropertyElement)element).getAttribute();
	}

	@Override
	protected void setValue(Object element, Object value) {
		// TODO Auto-generated method stub
		ModulePropertyElement p = ((ModulePropertyElement) element);
		p.setValue((String)value);
		
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((Module)p.getObject());
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				p.update(value);
			}
		});
		//System.out.println(value);
		getViewer().update(element, null);
	}

}
