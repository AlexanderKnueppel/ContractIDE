package de.tu_bs.ccc.contracting.core.features.update;

import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IMultiDeleteInfo;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.core.diagram.ContractModellingFeatureProvider;
import de.tu_bs.ccc.contracting.core.localization.StringTable;
import de.tu_bs.ccc.contracting.core.util.CoreUtil;

public class UpdateModuleFeature extends AbstractUpdateFeature {

	private static final IColorConstant E_CLASS_FOREGROUND = new ColorConstant(255, 0, 0);

	private static final IColorConstant E_CLASS_BACKGROUND = new ColorConstant(255, 168, 107);

	public UpdateModuleFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
		return (bo instanceof Module);
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {

		PictogramElement pictogramElement = context.getPictogramElement();
		Module m = (Module) getBusinessObjectForPictogramElement(context.getPictogramElement());
		if (pictogramElement instanceof ContainerShape) {

			ContainerShape cs = (ContainerShape) pictogramElement;
			Shape s2 = cs.getChildren().get(1);
			Text nameText = (Text) s2.getGraphicsAlgorithm();
			boolean nameoutofDate = false;
			if (!nameText.getValue().equals(m.getName() + "   " + m.getVersion())) {
				nameoutofDate = true;

			} else if (m.getModule() != null) {

				if (CoreUtil.isComponentNotSynched(m)) {
					return Reason.createTrueReason(StringTable.UPDATE_MODULE_REASON_NOTSYNCHED);
				} else {
					return Reason.createFalseReason();
				}

			}
			if (nameoutofDate) {
				updatePictogramElement(pictogramElement);
				// update(context);
				return Reason.createTrueReason(StringTable.UPDATE_MODULE_REASON_NAME);
			}

		}

		for (Ports po : m.getPorts()) {
			boolean found = false;

			for (PictogramLink p : getDiagram().getPictogramLinks()) {

				if (p.getBusinessObjects().get(0) == po) {
					found = true;
				}
			}
			if (!found) {
				updatePictogramElement(pictogramElement);
				return Reason.createTrueReason(StringTable.UPDATE_MODULE_REASON_PORT);
			}
		}
		if(m.getModule()==null) {
			
		
		for (Contract c : m.getContract()) {
			boolean found = false;

			for (PictogramLink p : getDiagram().getPictogramLinks()) {

				if (p.getBusinessObjects().get(0) == c) {
					found = true;
				}
			}
			if (!found) {
				updatePictogramElement(pictogramElement);
				return Reason.createTrueReason(StringTable.UPDATE_MODULE_REASON_CONTRACT);
			}
		}
		}
		return Reason.createFalseReason();
	}

	@Override
	public boolean update(IUpdateContext context) {
		Module m = (Module) getBusinessObjectForPictogramElement(context.getPictogramElement());
		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ContainerShape) {

			ContainerShape cs = (ContainerShape) pictogramElement;
			// cs.getChildren().clear();
			Shape s1 = cs.getChildren().get(0);
			Shape s2 = cs.getChildren().get(1);
			Text nameText = (Text) s2.getGraphicsAlgorithm();
			nameText.setValue(m.getName() + "   " + m.getVersion());
			IGaService gaService = Graphiti.getGaService();
			Polyline line = (Polyline) s1.getGraphicsAlgorithm();
			Point secondPoint = line.getPoints().get(1);
			Point newSecondPoint = gaService
					.createPoint(context.getPictogramElement().getGraphicsAlgorithm().getWidth(), secondPoint.getY());
			line.getPoints().set(1, newSecondPoint);
			if (m.getIsPartOf() != null && m.getModule() == null) {

				line.setForeground(manageColor(E_CLASS_FOREGROUND));
				cs.getGraphicsAlgorithm().setBackground(manageColor(E_CLASS_BACKGROUND));
				cs.getGraphicsAlgorithm().setForeground(manageColor(E_CLASS_FOREGROUND));

			}

			for (Ports po : m.getPorts()) {
				boolean found = false;
				for (PictogramLink p : getDiagram().getPictogramLinks()) {

					if (p.getBusinessObjects().get(0) == po) {
						found = true;
						updatePictogramElement(p.getPictogramElement());
					}

				}
				if (!found) {
					AddContext creat = new AddContext();
					creat.setNewObject(po);
					creat.setTargetContainer(cs);
					creat.setLocation(0, 0);
					getFeatureProvider().addIfPossible(creat);
				}

			}

			for (PictogramLink p : getDiagram().getPictogramLinks()) {
				if (p.getBusinessObjects().get(0) instanceof Contract) {

					Contract c = (Contract) p.getBusinessObjects().get(0);
					if (c.getModule() == null) {

						DeleteContext deleteContext = new DeleteContext(p.getPictogramElement());
						IMultiDeleteInfo multiDeleteInfo = new MultiDeleteInfo(false, false, 0);
						deleteContext.setMultiDeleteInfo(multiDeleteInfo);
						IDeleteFeature deleteFeature = getFeatureProvider().getDeleteFeature(deleteContext);
						deleteFeature.execute(deleteContext);
					}
				}
			}
			if(m.getModule()==null) {
			for (Contract c : m.getContract()) {
				boolean found = false;

				for (PictogramLink p : getDiagram().getPictogramLinks()) {

					if (p.getBusinessObjects().get(0) == c) {
						found = true;
						updatePictogramElement(p.getPictogramElement());
					}
				}
				if (!found) {
		
					AddContext creat = new AddContext();
				creat.setNewObject(c);
				creat.setTargetContainer(cs);

					creat.setLocation(cs.getGraphicsAlgorithm().getX(), cs.getGraphicsAlgorithm().getY());
					getFeatureProvider().addIfPossible(creat);
				}

			}
			}
			for (Contract c : m.getContract()) {
				for (PictogramLink p : getDiagram().getPictogramLinks()) {
					if (p.getBusinessObjects().get(0) == c) {
						updatePictogramElement(p.getPictogramElement());
					}
				}
			}
			if (m instanceof Compound) {
				Compound co = (Compound) m;
				for (Module mo : co.getConsistsOf()) {
					for (PictogramLink p : getDiagram().getPictogramLinks()) {
						if (p.getBusinessObjects().get(0) == mo) {
							updatePictogramElement(p.getPictogramElement());
						}
					}
				}
			}
			getDiagramBehavior().refresh();
			return true;
		}

		return false;
	}

}
