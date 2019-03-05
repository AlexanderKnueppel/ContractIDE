package de.tu_bs.ccc.contracting.core.windows;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import de.tu_bs.ccc.contracting.Verification.Assumption;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Guarantee;
import de.tu_bs.ccc.contracting.Verification.MmFactory;
import de.tu_bs.ccc.contracting.Verification.PropertyType;

public class EditPropertyDialog extends Dialog {

	private Contract contract = null;
	private TableEditor editor;
	private Table table;
	private Button btnAssumption, btnGuarantee;
	private TextStyle highlighting = null;
	private List<String> keywords = Arrays.asList("this", "$ram", "true", "false");

	public EditPropertyDialog(Shell parentShell, Contract contract) {
		super(parentShell);
		this.contract = contract;

		highlighting = new TextStyle(new Font(Display.getDefault(), "Tahoma", 14, SWT.BOLD),
				Display.getDefault().getSystemColor(SWT.COLOR_MAGENTA), null);
	}

	private TextLayout getHighlighted(String text) {
		final TextLayout textLayout = new TextLayout(Display.getDefault());
		textLayout.setText(text);

		for (String search : keywords) {
			int idxFrom = 0, idxAt = 0;

			while ((idxAt = text.indexOf(search, idxFrom)) != -1) {
				textLayout.setStyle(highlighting, idxAt, search.length() - 1);
				idxFrom = idxAt + search.length();
			}
		}

		return textLayout;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Change properties");
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

	private void addSyntaxHighlighting(TableItem item) {

	}

	private void createAGTable(Composite container) {
		table = new Table(container, SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
		TableColumn type = new TableColumn(table, SWT.NONE);
		TableColumn content = new TableColumn(table, SWT.NONE);
		content.setWidth(200);

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

		// Support for syntax highlighting
		
//		table.addListener(SWT.PaintItem, new Listener() {
//			public void handleEvent(Event event) {
//				if (event.item instanceof TableItem) {
//					String text = ((TableItem) event.item).getText(event.index);
//					((TableItem) event.item).setText(event.index, "");
//					getHighlighted(text).draw(event.gc, event.x, event.y);
//					((TableItem) event.item).setText(event.index, text);
//				}
//			}
//		});
//
//		table.addListener(SWT.MeasureItem, new Listener() {
//			public void handleEvent(Event e) {
//				if (e.item instanceof TableItem) {
//					final Rectangle textLayoutBounds = getHighlighted(((TableItem) e.item).getText(e.index)).getBounds();
//					e.width = textLayoutBounds.width;
//					e.height = textLayoutBounds.height;
//				}
//			}
//		});

		type.pack();
		content.pack();

		editor = new TableEditor(table);

		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		editor.minimumWidth = 200;
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
		btnAssumption = createButton(parent, IDialogConstants.NO_ID, "Add Assumption", false);
		btnGuarantee = createButton(parent, IDialogConstants.NO_ID, "Add Guarantee", false);
		createButton(parent, IDialogConstants.OK_ID, "Ok", false);

		// Set behavior for buttons
		btnAssumption.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Assumption a = MmFactory.eINSTANCE.createAssumption();
				a.setProperty("true");
				a.setPropertyTipe(PropertyType.EQUATION);
				a.setContract(contract);
				contract.getAssumption().add(a);

				TableItem item = new TableItem(table, SWT.NONE, contract.getAssumption().size() - 1);
				item.setText(new String[] { "(A)", a.getProperty() });
				item.setData(a);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}

		});

		btnGuarantee.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Guarantee g = MmFactory.eINSTANCE.createGuarantee();
				g.setProperty("true");
				g.setPropertyTipe(PropertyType.EQUATION);
				g.setContract(contract);
				contract.getGuarantee().add(g);

				TableItem item = new TableItem(table, SWT.NONE);
				item.setText(new String[] { "(G)", g.getProperty() });
				item.setData(g);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}

		});
	}

	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
}
