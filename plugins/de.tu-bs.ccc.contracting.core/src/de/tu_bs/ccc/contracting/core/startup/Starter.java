package de.tu_bs.ccc.contracting.core.startup;

import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IStartup;

import de.tu_bs.ccc.contracting.core.synchronize.mapping.ComponentmportMapping;
import de.tu_bs.ccc.contracting.core.synchronize.mapping.ProjectMapping;

public class Starter implements IStartup {

	public Starter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void earlyStartup() {
		for (IProject x : org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			ComponentmportMapping m = new ComponentmportMapping();
			m.initialize(x);
			ProjectMapping.getMapPro().put(x, m);
		}
		
//		IWorkspace workspace = ResourcesPlugin.getWorkspace();
//
//		IResourceChangeListener listener = new IResourceChangeListener() {
//			public void resourceChanged(IResourceChangeEvent event) {
//				// to do create Listener creating a compare Function
//			}
//		};
//		workspace.addResourceChangeListener(listener);
//		createCompareObjects();

	}
//
//	void createCompareObjects() {
//		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
//		IProject[] project = root.getProjects();
//		for (IProject iProject : project) {
//			IFolder saveFolder = iProject.getFolder("SAVE");
//			if (!saveFolder.exists()) {
//				try {
//					saveFolder.create(false, true, null);
//				} catch (CoreException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//
//			IFile file = saveFolder.getFile("test.save");
//
//			ResourceSet rSet = new ResourceSetImpl();
//			if (file == null || !file.exists()) {
//				URI uri = URI.createFileURI(file.getFullPath().toString());
//
//				Resource createResource = rSet.createResource(uri);
//
//				try {
//					createResource.setTrackingModification(true);
//
//					createResource.save(new HashMap());
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				List<IFile> list = CoreUtil.getModelFiles(iProject);
//				for (IFile iFile : list) {
//					ResourceSet resourceSet = new ResourceSetImpl();
//
//					URI fileURI = URI.createFileURI(iFile.getLocation().toFile().getAbsolutePath().toString());
//					if (iFile.getName().contains(".model")) {
//						try {
//
//							Resource impResource = resourceSet.getResource(fileURI, true);
//
//							if (impResource.getContents().get(0) instanceof Module) {
//								Module container = (Module) impResource.getContents().get(0);
//								Module copy = EcoreUtil.copy(container);
//								createResource.getContents().add(copy);
//								createResource.save(new HashMap());
//							}
//
//						} catch (Exception e) {
//							// TODO: handle exception
//						}
//					}
//				}
//
//			}
//		}
//	}
}