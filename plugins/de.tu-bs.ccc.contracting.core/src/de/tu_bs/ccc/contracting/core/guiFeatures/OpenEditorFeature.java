package de.tu_bs.ccc.contracting.core.guiFeatures;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import de.tu_bs.ccc.contracting.Verification.Module;

public class OpenEditorFeature extends AbstractCustomFeature {

	public OpenEditorFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);

			if (bo instanceof Module && (((Module) bo).eContainer() instanceof Module)) {
				ret = true;
			}

		}
		return ret;
	}

	@Override
	public String getName() {
		return "Open Module";
	}

	@Override
	public String getDescription() {
		return "Open Module in new Editor";
	}

	@Override
	public String getImageId() {
		return IPlatformImageConstants.IMG_ECLIPSE_INFORMATION;
	}

	@Override
	public boolean isAvailable(IContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

			Module m = ((Module) pes[0].getLink().getBusinessObjects().get(0));
			m = (Module) EcoreUtil.resolve(m.getModule(), m);
			URI uri = m.eResource().getURI();
			String str = uri.path().replace(".model", ".diagram").replace("/resource", "");

			final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(str));
			try {
				IDE.openEditor(page, file, true);
			} catch (PartInitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
