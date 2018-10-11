package de.tu_bs.ccc.contracting.idl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.tu_bs.ccc.contracting.idl.cidl.Model;

public class CidlPersistenceManager {
	public static final String FILE_EXTENSION = "cidl";
	
//	private ResourceSet resourceSet;
//	
//	/**
//	 * Map used to handle generically different model files. 
//	 */
//	//private static Map<String, ImportsProvider> fileHandlerRegistry = new HashMap<String, ImportsProvider>();
//
//
//	/**
//	 * Creating an object used to save or to load a set of related models from files.
//	 * 
//	 * @param newResourceSet
//	 *            the resource set to save all the loaded files/ where all the models to be saved exist
//	 * @param newPrependPath
//	 *            a relative path to work in
//	 */
//	public CidlPersistenceManager(ResourceSet newResourceSet) {
//		resourceSet = newResourceSet;
//	}
//	
//	public EObject loadModel(URI uri, URI root) {
//		// resolve the input uri, in case it is a relative path
//		URI absURI = uri.resolve(root);
//		if (! uri.equals(absURI)) {
//			// add this pair to URI converter so that others can get the URI by its relative path
//			resourceSet.getURIConverter().getURIMap().put(uri, absURI);
//		}
//		
//		// load root model
//		Resource resource = null;
//		try {
//			resource = resourceSet.getResource(absURI, true);
//			resource.load(Collections.EMPTY_MAP);
//			//System.out.println("ModelPersistenceHandler: Loaded model from " + resource.getURI());
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//		EObject model = resource.getContents().get(0);
//		
////		// load all its imports recursively
////		for (Iterator<String> it = fileHandlerRegistry.get(absURI.fileExtension()).importsIterator(model); it.hasNext();) {
////			String importURIStr = it.next();
////			URI importURI = URI.createURI(importURIStr);
////			URI resolvedURI = importURI.resolve(absURI);
////			
////			// add this pair to URI converter so that others can get the URI by its relative path
////			resourceSet.getURIConverter().getURIMap().put(importURI, resolvedURI);
////			
////			loadModel(resolvedURI, root);
////		}
//		return model;
//	}
	
	public static Collection<EObject> getIdlModels(IProject p) {
		final List<IFile> files = getIdlModelFiles(p);
		final List<EObject> modelList = new ArrayList<EObject>();
		final ResourceSet rSet = new ResourceSetImpl();
		for (final IFile file : files) {
			final EObject model = getIdlModelFromFile(file, rSet);
			if (model != null) {
				modelList.add(model);
			}
		}
		return modelList;
	}
	
	public static List<IFile> getIdlModelFiles(IContainer folder) {
		final List<IFile> ret = new ArrayList<IFile>();
		try {
			final IResource[] members = folder.members();
			for (final IResource resource : members) {
				if (resource instanceof IContainer) {
					ret.addAll(getIdlModelFiles((IContainer) resource));
				} else if (resource instanceof IFile) {
					final IFile file = (IFile) resource;
					if (file.getName().endsWith(FILE_EXTENSION)) {
						ret.add(file);
					}
				}
			}
		} catch (final CoreException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public static EObject getIdlModelFromFile(IFile file, ResourceSet resourceSet) {
		// Get the URI of the model file.
		final URI resourceURI = getFileURI(file, resourceSet);
		// Demand load the resource for this file.
		Resource resource;
		try {
			resource = resourceSet.getResource(resourceURI, true);
			if (resource != null) {
				// does resource contain a diagram as root object?
				final EObject root = resource.getContents().get(0);
				if (root instanceof Model) {
					return root;
				}
			}
		} catch (final WrappedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static URI normalizeURI(URI path) {
		if (path.isFile()) {
			return URI.createURI(path.toString().replaceAll("\\\\", "/"));
		}
		return path;
	}
	
	private static URI getFileURI(IFile file, ResourceSet resourceSet) {
		final String pathName = file.getFullPath().toString();
		URI resourceURI = URI.createFileURI(pathName);
		resourceURI = resourceSet.getURIConverter().normalize(resourceURI);
		return resourceURI;
	}
}
