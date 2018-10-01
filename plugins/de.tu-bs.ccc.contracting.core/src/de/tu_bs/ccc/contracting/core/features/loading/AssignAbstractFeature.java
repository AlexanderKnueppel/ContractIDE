package de.tu_bs.ccc.contracting.core.features.loading;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import de.tu_bs.ccc.contracting.Verification.Abstract;
import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.core.util.CoreUtil;
import de.tu_bs.ccc.contracting.core.util.ModuleFilter;
import de.tu_bs.ccc.contracting.ui.dialogs.LoadModuleDialog;
import de.tu_bs.ccc.contracting.ui.provider.LoadModuleLabelProvider;

public class AssignAbstractFeature extends AbstractCreateFeature {

	public AssignAbstractFeature(IFeatureProvider fp) {
		super(fp, "Assign to Abstract", "Assign a Module to a Abstract Component");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		if (!(context.getTargetContainer() instanceof Diagram)) {
			PictogramElement pict = context.getTargetContainer();
			if (!(pict instanceof ContainerShape)) {

				return false;
			}

			EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
			return businessObjects.size() == 1
					&& (businessObjects.get(0) instanceof Component || businessObjects.get(0) instanceof Compound);
		} else {
			return false;
		}
	}

	@Override
	public Object[] create(ICreateContext context) {

		List<Module> modules = (List<Module>) CoreUtil.getRootModules(CoreUtil.getCurrentProject(), m -> {
			PictogramElement pict = context.getTargetContainer();
			Module x = (Module) getBusinessObjectForPictogramElement(pict);

			boolean result = m instanceof Abstract;

			for (Module realization : x.getRealizedBy()) {
				result = result
						&& !realization.eResource().getURI().toString().equals(m.eResource().getURI().toString());
			}

			return result;
		});

		final LoadModuleDialog dialog = new LoadModuleDialog(null, new LoadModuleLabelProvider(),
				"Choose a realized abstract component from the following list", "Assign Abstract Component", modules);

		if (dialog.open() == LoadModuleDialog.CANCEL) {
			return null;
		}

		for (Object obj : dialog.getResult()) {
			Module c = (Module) obj;
			Abstract i = (Abstract) c;
			PictogramElement pict = context.getTargetContainer();
			Module x = (Module) getBusinessObjectForPictogramElement(pict);

			x.getRealizedBy().add(i);

			for (Ports p : i.getPorts()) {
				addGraphicalRepresentation(context, p);
			}
			x.getPorts().addAll(i.getPorts());
		}

		return null;
	}
}
