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

	public LinkedList<MappingEntry> mapping = new LinkedList<MappingEntry>();
	public boolean initialized = false;

	public LinkedList<Module> getMappingEntry(Module searched) {

		LinkedList<Module> foundEntries = new LinkedList<Module>();
		for (MappingEntry mappingEntry : mapping) {

			if (mappingEntry.getOriginal().getName().equals((searched.getName()))) {

				foundEntries.add(mappingEntry.getInstance());

			}
		}
		return foundEntries;

	}

	public void deleteMappingEntry(Module component) {

		for (MappingEntry mappingEntry : mapping) {
			if (mappingEntry.getInstance() == component) {
				mapping.remove(mappingEntry);
			} else if (mappingEntry.getOriginal() == component) {
				mapping.remove(mappingEntry);

			}
		}
	}

	public void addMappingEntry(Module original, Module instance) {

		boolean alreadyExists = false;
		for (MappingEntry mappingEntry : mapping) {

			if (mappingEntry.getInstance() == instance && mappingEntry.getOriginal() == original) {
				alreadyExists = true;
			}

		}
		if (!alreadyExists) {
			MappingEntry m = new MappingEntry(instance, original);
			this.mapping.add(m);

		}

	}

	public void initialize(IProject p) {
		if (!initialized) {
			initialized = true;
			
				try {

					processContainer(p);

				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		
		

	}

	private void processContainer(IContainer container) throws CoreException {
		IResource[] members = container.members();
		for (IResource member : members) {
			if (member instanceof IContainer)
				processContainer((IContainer) member);
			else if (member instanceof IFile)
				processFile((IFile) member);
		}
	}

	private void processFile(IFile member) {

		IFile resource = member;
		ResourceSet resourceSet = new ResourceSetImpl();

		URI fileURI = URI.createFileURI(resource.getLocation().toFile().getAbsolutePath().toString());
		if (resource.getName().contains(".model")) {
			try {

				Resource impResource = resourceSet.getResource(fileURI, true);

				if (impResource.getContents().get(0) instanceof Compound) {
					Compound container = (Compound) impResource.getContents().get(0);
					for (Module copy : container.getConsistsOf()) {
						if (copy.getModule()!=null&&copy!=null) {
							addMappingEntry(copy.getModule(), copy);
						}
						
					}

				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

}
