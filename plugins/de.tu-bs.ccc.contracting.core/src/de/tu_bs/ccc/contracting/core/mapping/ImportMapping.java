package de.tu_bs.ccc.contracting.core.mapping;

import java.util.LinkedList;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Module;

public class ImportMapping {

	public static LinkedList<MappingEntry> mapping = new LinkedList<MappingEntry>();
	public static boolean initialized = false;

	public static LinkedList<Module> getMappingEntry(Module searched) {
		if (!initialized) {
			initialize();
		}
		LinkedList<Module> foundEntries = new LinkedList<Module>();
		for (MappingEntry mappingEntry : mapping) {

			if (mappingEntry.getOriginal().getName().equals((searched.getName()))) {

				foundEntries.add(mappingEntry.getInstance());

			}
		}
		return foundEntries;

	}

	public static void deleteMappingEntry(Module component) {
		if (!initialized) {
			initialize();
		}
		for (MappingEntry mappingEntry : mapping) {
			if (mappingEntry.getInstance() == component) {
				mapping.remove(mappingEntry);
			} else if (mappingEntry.getOriginal() == component) {
				mapping.remove(mappingEntry);

			}
		}
	}

	public static void addMappingEntry(Module original, Module instance) {
		if (!initialized) {
			initialize();
		}
		boolean alreadyExists = false;
		for (MappingEntry mappingEntry : mapping) {

			if (mappingEntry.getInstance() == instance && mappingEntry.getOriginal() == original) {
				alreadyExists = true;
			}

		}
		if (!alreadyExists) {
			MappingEntry m = new MappingEntry(instance, original);
			mapping.add(m);

		}

	}

	public static void initialize() {
		if (!initialized) {
			initialized = true;
			for (IProject x : org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
				try {

					processContainer(x);

				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		for (MappingEntry mappingEntry : mapping) {

		}

	}

	private static void processContainer(IContainer container) throws CoreException {
		IResource[] members = container.members();
		for (IResource member : members) {
			if (member instanceof IContainer)
				processContainer((IContainer) member);
			else if (member instanceof IFile)
				processFile((IFile) member);
		}
	}

	private static void processFile(IFile member) {

		IFile resource = member;
		ResourceSet resourceSet = new ResourceSetImpl();

		URI fileURI = URI.createFileURI(resource.getLocation().toFile().getAbsolutePath().toString());
		if (resource.getName().contains(".model")) {
			try {

				Resource impResource = resourceSet.getResource(fileURI, true);

				if (impResource.getContents().get(0) instanceof Compound) {
					Compound container = (Compound) impResource.getContents().get(0);
					for (Module copy : container.getConsistsOf()) {
						addMappingEntry(copy.getModule(), copy);
					}

				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

}
