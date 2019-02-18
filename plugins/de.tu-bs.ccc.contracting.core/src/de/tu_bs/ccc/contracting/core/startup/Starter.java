package de.tu_bs.ccc.contracting.core.startup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IStartup;

import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.core.mapping.ImportMapping;
import de.tu_bs.ccc.contracting.core.util.CoreUtil;

public class Starter implements IStartup {

	public Starter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void earlyStartup() {
		ImportMapping.initialize();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();

		IResourceChangeListener listener = new IResourceChangeListener() {
			public void resourceChanged(IResourceChangeEvent event) {
				// to do create Listener creating a compare Function
			}
		};
		workspace.addResourceChangeListener(listener);
		createCompareObjects();

	}

	void createCompareObjects() {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject[] project = root.getProjects();
		for (IProject iProject : project) {
			IFolder saveFolder = iProject.getFolder("SAVE");
			if (!saveFolder.exists()) {
				try {
					saveFolder.create(false, true, null);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			IFile file = saveFolder.getFile("test.save");

			ResourceSet rSet = new ResourceSetImpl();
			if (file == null || !file.exists()) {
				URI uri = URI.createFileURI(file.getFullPath().toString());

				Resource createResource = rSet.createResource(uri);

				try {
					createResource.setTrackingModification(true);

					createResource.save(new HashMap());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<IFile> list = CoreUtil.getModelFiles(iProject);
				for (IFile iFile : list) {
					ResourceSet resourceSet = new ResourceSetImpl();

					URI fileURI = URI.createFileURI(iFile.getLocation().toFile().getAbsolutePath().toString());
					if (iFile.getName().contains(".model")) {
						try {

							Resource impResource = resourceSet.getResource(fileURI, true);

							if (impResource.getContents().get(0) instanceof Module) {
								Module container = (Module) impResource.getContents().get(0);
								Module copy = EcoreUtil.copy(container);
								createResource.getContents().add(copy);
								createResource.save(new HashMap());
							}

						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}

			}
		}
	}
}