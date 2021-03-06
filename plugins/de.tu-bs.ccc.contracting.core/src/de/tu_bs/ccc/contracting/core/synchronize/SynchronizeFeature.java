package de.tu_bs.ccc.contracting.core.synchronize;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.MmFactory;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.core.diagram.ContractModellingImageProvider;

public class SynchronizeFeature extends AbstractCustomFeature {

	public SynchronizeFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement pes = context.getPictogramElements()[0];
		Object bo = getBusinessObjectForPictogramElement(pes);
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		Module m = (Module) bo;
		if (m.getModule() != null) {
			if (m.getModule().getName() == null) {
				MessageBox dialog2 = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
				dialog2.setText("Delete Instance");
				dialog2.setMessage(
						"The original Compoennt doesn't exist anymore, do you want to delete this instance?");
				int n = dialog2.open();
				if (n == SWT.OK) {
					IDeleteContext del = new DeleteContext(pes);
					IDeleteFeature IDF = getFeatureProvider().getDeleteFeature(del);
					IDF.delete(del);

				} else {
					syncComponent(m);

					refresh();
				}
			} else {
				syncComponent(m);
				refresh();
				

			}

		} else {

			MessageDialog dialog = new MessageDialog(shell, "Synchronization mode", null,
					"Do you want the implementations to be updated manually or automatic?", MessageDialog.QUESTION,
					new String[] { "Auto Synch", "Manuel Sync", "Cancel" }, 0);
			int n = dialog.open();
			if (n == 1) {

				refresh();
			} else if (n == 0) {
				
				for (IProject x : org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
					try {
						if (pes != null) {
							processContainer(x, m);
						}

					} catch (CoreException e) {
					
					}
				}
				refresh();
			}
		}
		updatePictogramElement(pes);
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

				return true;
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
			for (int i = 0; i < original.getPorts().size(); i++) {
				if (i + 1 > instance.getPorts().size()) {
					instance.getPorts().add(EcoreUtil.copy(original.getPorts().get(i)));
				}
				instance.getPorts().get(i).setName(original.getPorts().get(i).getName());
				instance.getPorts().get(i).setMaxClients(original.getPorts().get(i).getMaxClients());
				instance.getPorts().get(i).setService(original.getPorts().get(i).getService());
				instance.getPorts().get(i).setType(original.getPorts().get(i).getType());

			}
			while (original.getContract().size() - instance.getContract().size() > 0) {

				instance.getContract().add(MmFactory.eINSTANCE.createContract());
			}
			while (original.getContract().size() - instance.getContract().size() < 0) {

				instance.getContract().remove(instance.getContract().size() - 1);
			}

			for (int i = 0; i < original.getContract().size(); i++) {
				// instance.getContract().set(i,EcoreUtil.copy(original.getContract().get(i)));
				while (instance.getContract().get(i).getGuarantee().size() > 0) {
					EcoreUtil.delete(instance.getContract().get(i).getGuarantee()
							.get(instance.getContract().get(i).getGuarantee().size() - 1));
				}
				while (instance.getContract().get(i).getAssumption().size() > 0) {
					EcoreUtil.delete(instance.getContract().get(i).getAssumption()
							.get(instance.getContract().get(i).getAssumption().size() - 1));
				}
				instance.getContract().get(i).setViewPoint(original.getContract().get(i).getViewPoint());
				for (int j = 0; j < original.getContract().get(i).getAssumption().size(); j++) {
					instance.getContract().get(i).getAssumption().add(EcoreUtil.copy(original.getContract().get(i).getAssumption().get(j)));
				}
				for (int j = 0; j < original.getContract().get(i).getGuarantee().size(); j++) {
					instance.getContract().get(i).getGuarantee().add(EcoreUtil.copy(original.getContract().get(i).getGuarantee().get(j)));
				}

			}
		

	}

	void processContainer(IContainer container, Module original) throws CoreException {

		IResource[] members = container.members();
		for (IResource member : members) {
			if (member instanceof IContainer)
				processContainer((IContainer) member, original);
			else if (member instanceof IFile) {
				processFile((IFile) member, original);
				//member.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			}
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
						if (copy.getModule() != null) {

							if (copy.getModule().getName().equals(original.getName())) {
								
								syncComponent(copy);
								impResource.save(null);
								impResource.setModified(true);

							}
						}
					}

				}
			} catch (Exception e) {
	;
			}

		}
	}

	public static void refresh() {
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
				decoratorManager.update("de.tubs.ccc.contracting.core.decorators.SynchronizeDecorator");
			}
		});
	}

}
