package de.tu_bs.ccc.contracting.ui.views.enviromentalView;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

import de.tu_bs.ccc.contracting.Verification.EnviromentalProperties;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Property;

public class ValueEditingSupport extends EditingSupport {

	public ValueEditingSupport(ColumnViewer viewer) {
		super(viewer);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean canEdit(Object arg0) {
		return true;
	}

	@Override
	protected CellEditor getCellEditor(Object arg0) {
		return new TextCellEditor((Composite) getViewer().getControl());
	}

	@Override
	protected Object getValue(Object arg0) {
		return ((Property) arg0).getValue();
	}

	@Override
	protected void setValue(Object arg0, Object arg1) {
		Property parameter = ((Property) arg0);
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(parameter);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {

				parameter.setValue(String.valueOf(arg1));

			}
		});
		getViewer().update(arg0, null);
	}

}
