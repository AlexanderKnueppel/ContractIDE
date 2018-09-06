package de.tu_bs.ccc.contracting.ui.wizards;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.io.File;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.osgi.framework.Bundle;

import de.tu_bs.ccc.contracting.ui.Activator;

public class CCCProjectNewWizard extends Wizard implements INewWizard {

	private static final String WIZARD_NAME = "New CCC Project";
	
	private WizardNewProjectCreationPage _pageOne;
	private String _folderPath;
	private String _pluginPath;

	public CCCProjectNewWizard() {
		setWindowTitle(WIZARD_NAME);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		if (_pageOne.getProjectName() != null) {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject project = root.getProject(_pageOne.getProjectName());
			_folderPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() + "/" + _pageOne.getProjectName() 
					+ "/src/";

			Bundle wizardBundle = Platform.getBundle(Activator.PLUGIN_ID);
			Path sourcePath = new Path("DummyProject");
			URL sourceURL = FileLocator.find(wizardBundle, sourcePath, null);
			try {
				_pluginPath = (FileLocator.toFileURL(sourceURL).getPath());
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			IFolder srcFolder = project.getFolder("src");
			IFolder systemFolder = project.getFolder("src/system");
			IFolder repositoryFolder = project.getFolder("src/repository");
			try {
				if (!project.exists()) {
					project.create(null);
					project.open(null);
				}

				if (!srcFolder.exists()) {
					srcFolder.create(false, true, null);
				}
				if (!repositoryFolder.exists()) {
					repositoryFolder.create(false, true, null);
				}
				if (!systemFolder.exists()) {
					systemFolder.create(false, true, null);
					try {
						Files.copy(new File(_pluginPath + "/system.diagram").toPath(),
								new File(_folderPath + "system/system.diagram").toPath());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				systemFolder.refreshLocal(1, null);

			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public void addPages() {
		super.addPages();

		_pageOne = new WizardNewProjectCreationPage("New CCC Project");
		_pageOne.setTitle("New CCC Project");
		_pageOne.setDescription("Create a new CCC project from scratch.");

		addPage(_pageOne);
	}

}
