package de.tu_bs.ccc.contracting.idl;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class CidlPersistenceManager {
	public static final String FILE_EXTENSION = "cidl";
	
	private ResourceSet resourceSet;
	
	/**
	 * Map used to handle generically different model files. 
	 */
	//private static Map<String, ImportsProvider> fileHandlerRegistry = new HashMap<String, ImportsProvider>();


	/**
	 * Creating an object used to save or to load a set of related models from files.
	 * 
	 * @param newResourceSet
	 *            the resource set to save all the loaded files/ where all the models to be saved exist
	 * @param newPrependPath
	 *            a relative path to work in
	 */
	public CidlPersistenceManager(ResourceSet newResourceSet) {
		resourceSet = newResourceSet;
	}
	
	public EObject loadModel(URI uri, URI root) {
		// resolve the input uri, in case it is a relative path
		URI absURI = uri.resolve(root);
		if (! uri.equals(absURI)) {
			// add this pair to URI converter so that others can get the URI by its relative path
			resourceSet.getURIConverter().getURIMap().put(uri, absURI);
		}
		
		// load root model
		Resource resource = null;
		try {
			resource = resourceSet.getResource(absURI, true);
			resource.load(Collections.EMPTY_MAP);
			//System.out.println("ModelPersistenceHandler: Loaded model from " + resource.getURI());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		EObject model = resource.getContents().get(0);
		
//		// load all its imports recursively
//		for (Iterator<String> it = fileHandlerRegistry.get(absURI.fileExtension()).importsIterator(model); it.hasNext();) {
//			String importURIStr = it.next();
//			URI importURI = URI.createURI(importURIStr);
//			URI resolvedURI = importURI.resolve(absURI);
//			
//			// add this pair to URI converter so that others can get the URI by its relative path
//			resourceSet.getURIConverter().getURIMap().put(importURI, resolvedURI);
//			
//			loadModel(resolvedURI, root);
//		}
		return model;
	}

	public static URI normalizeURI(URI path) {
		if (path.isFile()) {
			return URI.createURI(path.toString().replaceAll("\\\\", "/"));
		}
		return path;
	}
}
