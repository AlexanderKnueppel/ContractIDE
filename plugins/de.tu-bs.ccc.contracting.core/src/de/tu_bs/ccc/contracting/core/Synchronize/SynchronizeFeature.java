package de.tu_bs.ccc.contracting.core.Synchronize;

import java.awt.TrayIcon.MessageType;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.decorators.DecoratorManager;

import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.core.diagram.ContractModellingImageProvider;
import de.tu_bs.ccc.contracting.ui.dialogs.SynchronizeModuleDialog;

public class SynchronizeFeature extends AbstractCustomFeature {

	public SynchronizeFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement pes = context.getPictogramElements()[0];
		Object bo = getBusinessObjectForPictogramElement(pes);
		Module m = (Module) bo;
		if (m.getModule() != null) {
			syncComponent(m);
		} else {
			Object[] options = { "Auto Synch", "Manuel Sync", "Cancel" };
			int n = JOptionPane.showOptionDialog(null,
					"Du you want the implementations to be updated manually or automatic?", "Synchronization mode",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
			if (n == 1) {
				IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();

				decoratorManager.update("de.tubs.ccc.contracting.core.decorators.SynchronizeDecorator");
			} else if (n == 0) {
				for (IProject x : org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
					try {
						if (pes != null) {

							processContainer(x, m);

						}

					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return super.getDescription();
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement pes = context.getPictogramElements()[0];
		if (pes != null) {
			Object bo = getBusinessObjectForPictogramElement(pes);
			if (bo instanceof Module) {
				ret = true;
			}
		}
		return ret;
	}

	@Override
	public boolean isAvailable(IContext context) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getImageId() {
		return ContractModellingImageProvider.IMG_SYNCHRONIZE;
	}

	public void syncComponent(Module instance) {
		Module original = instance.getModule();
	
		instance.setName(original.getName());

		instance.setDescription(original.getDescription());
		instance.setVersion(original.getVersion());
		instance.setRte(original.getRte());
		instance.setSpec(original.getSpec());
		instance.setRam(original.getRam());
		instance.setCaps(original.getCaps());
	
	}

	void processContainer(IContainer container, Module original) throws CoreException {
		IResource[] members = container.members();
		for (IResource member : members) {
			if (member instanceof IContainer)
				processContainer((IContainer) member, original);
			else if (member instanceof IFile)
				processFile((IFile) member, original);
		}
	}

	public void processFile(IFile member, Module original) {

		IFile resource = member;
		ResourceSet resourceSet = new ResourceSetImpl();

		URI fileURI = URI.createFileURI(resource.getLocation().toFile().getAbsolutePath().toString());
		if (resource.getName().contains(".model")) {
			try {

				Resource impResource = resourceSet.getResource(fileURI, true);

				if (impResource.getContents().get(0) instanceof Compound) {
					Compound container = (Compound) impResource.getContents().get(0);
					for (Module copy : container.getConsistsOf()) {
						if (copy.getModule().getName().equals(original.getName())) {
							
							syncComponent(copy);
							impResource.save(null);

						}
					}


				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}
}
