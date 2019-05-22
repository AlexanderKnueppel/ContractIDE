package de.tu_bs.ccc.contracting.ui.dialogs;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;

import de.tu_bs.ccc.contracting.Verification.Abstract;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.ui.localization.StringTable;

public class EditModuleFeatureDialog extends TitleAreaDialog implements IEditFeatureDialog {

	private Text moduleName;
	private Text moduleVersion;
	private Combo moduleType;
	private List list;

	private String currentName;
	private String currentVersion;
	private ArrayList<Abstract> realizes = new ArrayList<Abstract>();
	private Object object;
	private int currentModuleType = 0;

	public EditModuleFeatureDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	public void create() {
		super.create();
		setTitle(StringTable.EDIT_MODULE_DIALOG_TITLE);
		setMessage(StringTable.EDIT_MODULE_DIALOG_MSG, IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		createName(container);
		createVersion(container);
		createAbstractComponentList(container);

		return area;
	}

	private void createName(Composite container) {
		Label lbName = new Label(container, SWT.NONE);
		lbName.setText(StringTable.EDIT_MODULE_DIALOG_NAME);

		GridData dataName = new GridData();
		dataName.grabExcessHorizontalSpace = true;
		dataName.horizontalAlignment = GridData.FILL;

		moduleName = new Text(container, SWT.BORDER);
		moduleName.setLayoutData(dataName);
		moduleName.setText(currentName);
	}

	private void createVersion(Composite container) {
		Label lbDescription = new Label(container, SWT.NONE);
		lbDescription.setText(StringTable.EDIT_MODULE_DIALOG_VERSION);

		GridData dataVersion = new GridData();
		dataVersion.grabExcessHorizontalSpace = true;
		dataVersion.horizontalAlignment = GridData.FILL;
		moduleVersion = new Text(container, SWT.BORDER);
		moduleVersion.setLayoutData(dataVersion);
		moduleVersion.setText(currentVersion);
	}

	private void createAbstractComponentList(Composite container) {

		GridData dataVersion = new GridData();
		dataVersion.grabExcessHorizontalSpace = true;
		dataVersion.horizontalAlignment = GridData.FILL;

		Label label = new Label(container, SWT.WRAP);
		label.setText(StringTable.EDIT_MODULE_DIALOG_REALIZES);

		list = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		list.setLayoutData(dataVersion);

		for (Abstract a : realizes) {
			list.add(a.getName() + " (" + a.getVersion() + ")");
		}

		list.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.keyCode == SWT.DEL) {
					ArrayList<Abstract> selected = new ArrayList<Abstract>();
					int[] indices = list.getSelectionIndices();
					for (int index : indices) {
						selected.add(realizes.get(index));
					}
					list.remove(indices);

					for (Abstract a : selected) {
						realizes.remove(a);
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

	private void createModuleType(Composite container) {
		Label lbType = new Label(container, SWT.NONE);
		lbType.setText(StringTable.EDIT_PORT_DIALOG_TYPE);

		moduleType = new Combo(container, SWT.DROP_DOWN);

		String[] items = new String[] { "Function", "Proxy", "Mux", "Protocol", "Filter" };
		moduleType.setItems(items);
		moduleType.select(currentModuleType);
		moduleType.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
//				if (comboType.getText().equals("SERVICE")) {
//					portServicename.setVisible(true);
//					lbService.setVisible(true);
//				} else {
//					portServicename.setVisible(false);
//					lbService.setVisible(false);
//				}
			}
		});
	}

	@Override
	protected void okPressed() {
		setNewProperties();
		super.okPressed();
	}

	@Override
	public void setOldProperties(Object object) {
		this.object = object;
		Module module = (Module) object;
		currentName = module.getName();
		currentVersion = module.getVersion();
		realizes.addAll(module.getRealizedBy());
	}

	@Override
	public void setNewProperties() {
		Module module = (Module) object;
		module.setName(moduleName.getText());
		module.setVersion(moduleVersion.getText());

		module.getRealizedBy().clear();
		module.getRealizedBy().addAll(realizes);
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
				decoratorManager.update("de.tubs.ccc.contracting.core.decorators.SynchronizeDecorator");
			}
		});
	}
}