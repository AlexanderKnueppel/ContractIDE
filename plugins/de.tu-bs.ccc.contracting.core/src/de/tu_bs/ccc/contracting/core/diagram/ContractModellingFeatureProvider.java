package de.tu_bs.ccc.contracting.core.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.System;
import de.tu_bs.ccc.contracting.core.features.addFeature.AddComponentFeature;
import de.tu_bs.ccc.contracting.core.features.addFeature.AddContractConnectionFeature;
import de.tu_bs.ccc.contracting.core.features.addFeature.AddContractFeature;
import de.tu_bs.ccc.contracting.core.features.addFeature.AddPortConnetion;
import de.tu_bs.ccc.contracting.core.features.addFeature.AddPortFeature;
import de.tu_bs.ccc.contracting.core.features.addFeature.AddSystemFeature;
import de.tu_bs.ccc.contracting.core.features.connections.ReconnectionFeature;
import de.tu_bs.ccc.contracting.core.features.createFeatures.CreateContractFeature;
import de.tu_bs.ccc.contracting.core.features.createFeatures.CreatePortConnection;
import de.tu_bs.ccc.contracting.core.features.createFeatures.CreatePortFeature;
import de.tu_bs.ccc.contracting.core.features.deleteFeature.DeleteModuleFeature;
import de.tu_bs.ccc.contracting.core.features.deleteFeature.DeletePortConnectionFeature;
import de.tu_bs.ccc.contracting.core.features.deleteFeature.DeletePortFeature;
import de.tu_bs.ccc.contracting.core.features.guiFeatures.CollapseFeature;
import de.tu_bs.ccc.contracting.core.features.guiFeatures.EditAbstractFeature;
import de.tu_bs.ccc.contracting.core.features.guiFeatures.LayoutFeature;
import de.tu_bs.ccc.contracting.core.features.guiFeatures.ViewpointVerificationFeature;
import de.tu_bs.ccc.contracting.core.features.layout.LayoutDiagramFeature;
import de.tu_bs.ccc.contracting.core.features.loading.AssignAbstractFeature;
import de.tu_bs.ccc.contracting.core.features.loading.LoadModuleFeature;
import de.tu_bs.ccc.contracting.core.features.move.MovePortFeature;
import de.tu_bs.ccc.contracting.core.features.resize.ResizeModuleFeature;
import de.tu_bs.ccc.contracting.core.features.update.UpdateContractFeature;
import de.tu_bs.ccc.contracting.core.features.update.UpdateModuleFeature;
import de.tu_bs.ccc.contracting.core.features.update.UpdatePortFeature;
import de.tu_bs.ccc.contracting.core.propertyFeature.CreateProperty;
import de.tu_bs.ccc.contracting.core.synchronize.SynchronizeFeature;

public class ContractModellingFeatureProvider extends DefaultFeatureProvider {

	@Override
	public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) {
		return new ReconnectionFeature(this);
	}

	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		return new ICustomFeature[] { // new VerifyCustomFeature(this),
				new ViewpointVerificationFeature(this), new CollapseFeature(this), new EditAbstractFeature(this),
				new LayoutDiagramFeature(this), new SynchronizeFeature(this) };
	}

	@Override
	public IDeleteFeature getDeleteFeature(IDeleteContext context) {
		PictogramElement pes = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pes);

		if (context.getPictogramElement() instanceof Connection) {
			Connection con = (Connection) context.getPictogramElement();
			if ((getBusinessObjectForPictogramElement(con.getStart().getParent()) instanceof Ports)
					&& (getBusinessObjectForPictogramElement(con.getEnd().getParent()) instanceof Ports)) {

				return new DeletePortConnectionFeature(this);
			}

		}

		else if (bo instanceof Module) {
			Module m = (Module) bo;
			if (m.getModule() != null) {
				return new DeleteModuleFeature(this);
			}
		} else if (bo instanceof Ports) {

			return new DeletePortFeature(this);

		}

		return super.getDeleteFeature(context);
	}

	public ContractModellingFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	@Override
	public ICreateFeature[] getCreateFeatures() {

		return new ICreateFeature[] {
				// new CreateComponentFeature(this),
				new CreateContractFeature(this),
				// new CreateAbstractFeature(this),
				new CreatePortFeature(this), new LoadModuleFeature(this), new CreateProperty(this, true),
				new CreateProperty(this, false), new AssignAbstractFeature(this) };
	}

	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] { new CreatePortConnection(this) };
	}

	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		Object obj = context.getNewObject();
		if (obj instanceof System) {
			return new AddSystemFeature(this);
		} else if (obj instanceof Contract) {
			return new AddContractFeature(this);
		} else if (obj instanceof Module) {
			return new AddComponentFeature(this);
		} else if (obj instanceof Ports) {
			return new AddPortFeature(this);
		} else if (context instanceof IAddConnectionContext && (getBusinessObjectForPictogramElement(
				((IAddConnectionContext) context).getSourceAnchor().getParent()) instanceof Ports)) {
			return new AddPortConnetion(this);
		} else if (context instanceof IAddConnectionContext) {
			return new AddContractConnectionFeature(this);
		}

		return super.getAddFeature(context);
	}

	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		// TODO: check for right domain object instances below
		PictogramElement pictogramElement = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		if (bo instanceof Ports || bo instanceof Module || bo instanceof Contract || bo instanceof System) {
			return new LayoutFeature(this);
		}
		return super.getLayoutFeature(context);
	}

	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ContainerShape) {
			Object bo = getBusinessObjectForPictogramElement(pictogramElement);
			if (bo instanceof Ports) {
				return new UpdatePortFeature(this);
			} else if (bo instanceof Contract) {
				return new UpdateContractFeature(this);

			} else if (bo instanceof Module) {
				return new UpdateModuleFeature(this);

			}
		}
		return super.getUpdateFeature(context);

	}

	@Override
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ContainerShape) {
			Object bo = getBusinessObjectForPictogramElement(pictogramElement);
			if (bo instanceof Ports) {
				return new MovePortFeature(this);
			}

		}
		return super.getMoveShapeFeature(context);

	}

	@Override
	public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ContainerShape) {
			Object bo = getBusinessObjectForPictogramElement(pictogramElement);
			if (bo instanceof Module) {
				return new ResizeModuleFeature(this);
			}
		}
		return super.getResizeShapeFeature(context);
	}

}
