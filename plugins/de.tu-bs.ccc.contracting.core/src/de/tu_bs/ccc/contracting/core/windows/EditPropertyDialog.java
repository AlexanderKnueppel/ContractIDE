package de.tu_bs.ccc.contracting.core.windows;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import de.tu_bs.ccc.contracting.Verification.Assumption;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Guarantee;

public class EditPropertyDialog extends Dialog {

	private Contract contract = null;

	public EditPropertyDialog(Shell parentShell, Contract contract) {
		super(parentShell);
		this.contract = contract;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(1, true);
		container.setLayout(layout);

		createAGTable(container);

		return area;
	}

	private void createAGList(Composite container) {
		List list = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		list.setLayoutData(gridData);

		ArrayList<String> entries = new ArrayList<String>();
		entries.addAll(
				contract.getAssumption().stream().map(a -> "(A) " + a.getProperty()).collect(Collectors.toList()));
		entries.addAll(
				contract.getGuarantee().stream().map(g -> "(G) " + g.getProperty()).collect(Collectors.toList()));

		list.setItems(entries.toArray(new String[0]));
	}

	private void createAGTable(Composite container) {
		final Table table = new Table(container, SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
		TableColumn type = new TableColumn(table, SWT.NONE);
		TableColumn content = new TableColumn(table, SWT.NONE);

		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		table.setLayoutData(gridData);

		for (Assumption a : contract.getAssumption()) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[] { "(A)", a.getProperty() });
			item.setData(a);
		}

		for (Guarantee g : contract.getGuarantee()) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[] { "(G)", g.getProperty() });
			item.setData(g);
		}

		type.pack();
		content.pack();

		final TableEditor editor = new TableEditor(table);

		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		editor.minimumWidth = 50;
		// editing the second column
		final int EDITABLECOLUMN = 1;

		table.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// Clean up any previous editor control
				Control oldEditor = editor.getEditor();
				if (oldEditor != null)
					oldEditor.dispose();

				// Identify the selected row
				TableItem item = (TableItem) e.item;
				if (item == null)
					return;

				// The control that will be the editor must be a child of the Table
				Text newEditor = new Text(table, SWT.NONE);
				newEditor.setText(item.getText(EDITABLECOLUMN));
				newEditor.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent me) {
						Text text = (Text) editor.getEditor();
						editor.getItem().setText(EDITABLECOLUMN, text.getText());

						if (item.getData() instanceof Assumption) {
							((Assumption) item.getData()).setProperty(text.getText());
							if (text.getText().trim().equals(""))
								contract.getAssumption().remove(item.getData());
						} else if (item.getData() instanceof Guarantee) {
							((Guarantee) item.getData()).setProperty(text.getText());
							if (text.getText().trim().equals(""))
								contract.getGuarantee().remove(item.getData());
						}

					}
				});
				newEditor.selectAll();
				newEditor.setFocus();
				editor.setEditor(newEditor, item, EDITABLECOLUMN);
			}
		});
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		// createButton(parent, IDialogConstants.NO_ID, "Edit", true);
		// createButton(parent, IDialogConstants.NO_ID, "Delete", true);
		createButton(parent, IDialogConstants.OK_ID, "Ok", false);
	}

	// // overriding this methods allows you to set the
	// // title of the custom dialog
	// @Override
	// protected void configureShell(Shell newShell) {
	// super.configureShell(newShell);
	// newShell.setText("Selection dialog");
	// }

	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
}
