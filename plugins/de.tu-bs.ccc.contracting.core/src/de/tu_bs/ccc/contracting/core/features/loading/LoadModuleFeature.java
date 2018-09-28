package de.tu_bs.ccc.contracting.core.features.loading;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.core.util.CoreUtil;
import de.tu_bs.ccc.contracting.ui.dialogs.LoadModuleDialog;
import de.tu_bs.ccc.contracting.ui.provider.LoadModuleLabelProvider;

public class LoadModuleFeature extends AbstractCreateFeature {

	public LoadModuleFeature(IFeatureProvider fp) {
		super(fp, "Load Module", "Adds component or interface to a compound.");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		if (!(context.getTargetContainer() instanceof Diagram)) {
			PictogramElement pict = context.getTargetContainer();
			if (!(pict instanceof ContainerShape)) {
				return false;
			}

			EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
			return businessObjects.size() == 1 && businessObjects.get(0) instanceof Compound;
		} else {
			return false;
		}
	}

	@Override
	public Object[] create(ICreateContext context) {

		List<Module> modules = (List<Module>) CoreUtil.getRootModules(CoreUtil.getCurrentProject());

		final LoadModuleDialog dialog = new LoadModuleDialog(null, new LoadModuleLabelProvider(), "Description", "Name",
				modules);
		dialog.open();

		for (Object obj : dialog.getResult()) {
			Module c = (Module) obj;
			Module copy = EcoreUtil.copy(c);

			if (copy instanceof Compound) {
				EcoreUtil.deleteAll(((Compound) copy).getConsistsOf(), true);
			}

			addGraphicalRepresentation(context, copy);
			PictogramElement pict = context.getTargetContainer();
			Compound x = (Compound) getBusinessObjectForPictogramElement(pict);
			copy.setIsPartOf(x);
			copy.setModule(c);
			x.getConsistsOf().add(copy);

			return new Object[] { copy };
		}

		return null;
	}
}
