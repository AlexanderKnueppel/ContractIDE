package de.tu_bs.ccc.contracting.core.io.ccc;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.osgi.framework.Bundle;

import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.core.localization.StringTable;
import de.tu_bs.ccc.contracting.core.util.CoreUtil;
import de.tu_bs.ccc.contracting.ui.wizards.CreateModule;
import de.tu_bs.ccc.contracting.ui.wizards.CreationType;

public class CCCImporter {
	private ObjectFactory factory = new ObjectFactory();

	private IFolder srcFolder;
	private IFolder systemFolder;
	private IFolder repositoryFolder;
	private IFolder serviceFolder;

	public CCCImporter() {

	}

	private void initStructure() {
		IProject project = CoreUtil.getCurrentProject();

		srcFolder = project.getFolder("src");
		systemFolder = project.getFolder("src/system");
		repositoryFolder = project.getFolder("src/repository");
		serviceFolder = project.getFolder("src/repository");

		try {
			if (!srcFolder.exists()) {
				srcFolder.create(false, true, null);
			}
			if (!repositoryFolder.exists()) {
				repositoryFolder.create(false, true, null);
			}
			if (!systemFolder.exists()) {
				systemFolder.create(false, true, null);
			}
			if (!serviceFolder.exists()) {
				serviceFolder.create(false, true, null);
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void saveModule(Module m, IFolder folder, CreationType type) throws Exception {
		String fileName = m.getName() + "." + StringTable.DIAGRAM_FILE_EXTENSION;
		
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(folder.getProjectRelativePath());
		
		if (!resource.exists() || !(resource instanceof IContainer)) {
			throw new Exception("Folder \"" + folder.getName() + "\" does not exist.");
		}
		IContainer container = (IContainer) resource;
		final IFile file = container.getFile(new Path(fileName));

		ResourceSet rSet = new ResourceSetImpl();

		URI uri = URI.createFileURI(file.getFullPath().toString());

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(rSet);
		if (editingDomain == null) {
			// Not yet existing, create one
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rSet);
		}

		CreateModule operation = new CreateModule(editingDomain, folder.getName(), fileName, uri, type);
		editingDomain.getCommandStack().execute(operation);
		editingDomain.dispose();
	}


	public void handleRepository(RepositoryType repo) {
//		for(List<List<Object>> elements : repo.getBinaryOrComponentOrComposite()) {
//			
//		}
	}
	
	public void createFiles(IProject p) {

		try {
			FileDialog dialog = new FileDialog(Display.getDefault().getActiveShell(), SWT.OPEN);
			dialog.setFilterExtensions(new String[] { "*.xml" });
			dialog.setFilterPath("c:\\temp");
			String result = dialog.open();
			java.lang.System.out.println(result);
			File file = new File(result);
			JAXBContext jaxbContext = JAXBContext.newInstance(Xml.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			initStructure();
			
			Xml xml = (Xml) jaxbUnmarshaller.unmarshal(file);
			
			// Handle the repository
			handleRepository(xml.getRepository());
			// Handle the system
			//handleSystem(xml.getSystem());

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
