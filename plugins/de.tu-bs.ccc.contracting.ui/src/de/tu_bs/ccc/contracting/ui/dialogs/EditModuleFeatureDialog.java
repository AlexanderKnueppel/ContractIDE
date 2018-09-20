package de.tu_bs.ccc.contracting.ui.dialogs;


import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.tu_bs.ccc.contracting.Verification.Module;

public class EditModuleFeatureDialog extends TitleAreaDialog implements IEditFeatureDialog {

    private Text moduleName;
    private Text moduleVersion;

	String currentName;
	String currentVersion;
	Object object;

    public EditModuleFeatureDialog(Shell parentShell) {
        super(parentShell);
    }

    
    @Override
    public void create() {
        super.create();
        setTitle("Edit Module");
        setMessage("Edit the name and version of the module.", IMessageProvider.INFORMATION);
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

        return area;
    }

    private void createName(Composite container) {
        Label lbName = new Label(container, SWT.NONE);
        lbName.setText("Name");

        GridData dataName = new GridData();
        dataName.grabExcessHorizontalSpace = true;
        dataName.horizontalAlignment = GridData.FILL;

        moduleName = new Text(container, SWT.BORDER);
        moduleName.setLayoutData(dataName);
        moduleName.setText(currentName);
    }

    private void createVersion(Composite container) {
        Label lbDescription = new Label(container, SWT.NONE);
        lbDescription.setText("Version");

        GridData dataVersion = new GridData();
        dataVersion.grabExcessHorizontalSpace = true;
        dataVersion.horizontalAlignment = GridData.FILL;
        moduleVersion = new Text(container, SWT.BORDER);
        moduleVersion.setLayoutData(dataVersion);
        moduleVersion.setText(currentVersion);
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
		
	}


	@Override
	public void setNewProperties() {
		Module module = (Module) object;
		module.setName(moduleName.getText());
		module.setVersion(moduleVersion.getText());
		
	}
}