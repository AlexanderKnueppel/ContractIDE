package de.tu_bs.ccc.contracting.core.diagram;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
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

import de.tu_bs.ccc.contracting.Verification.Abstract;
import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.System;
import de.tu_bs.ccc.contracting.core.features.AddAbstractFeature;
import de.tu_bs.ccc.contracting.core.features.AddComponentFeature;
import de.tu_bs.ccc.contracting.core.features.AddCompoundFeature;
import de.tu_bs.ccc.contracting.core.features.AddContractFeature;
import de.tu_bs.ccc.contracting.core.features.AddPortConnetion;
import de.tu_bs.ccc.contracting.core.features.AddPortFeature;
import de.tu_bs.ccc.contracting.core.features.AddSystemFeature;
import de.tu_bs.ccc.contracting.core.features.CreateContractFeature;
import de.tu_bs.ccc.contracting.core.features.CreatePortConnection;
import de.tu_bs.ccc.contracting.core.features.CreatePortFeature;
import de.tu_bs.ccc.contracting.core.features.DeletePortConnectionFeature;
import de.tu_bs.ccc.contracting.core.features.connections.AddContractConnectionFeature;
import de.tu_bs.ccc.contracting.core.features.connections.ReconnectionFeature;
import de.tu_bs.ccc.contracting.core.features.directEditing.DirectEditContractPropertyFeature;
import de.tu_bs.ccc.contracting.core.features.layout.LayoutDiagramFeature;
import de.tu_bs.ccc.contracting.core.features.layout.LayoutPortFeature;
import de.tu_bs.ccc.contracting.core.features.loading.AssignAbstractFeature;
import de.tu_bs.ccc.contracting.core.features.loading.LoadModuleFeature;
import de.tu_bs.ccc.contracting.core.guiFeatures.CollapseFeature;
import de.tu_bs.ccc.contracting.core.guiFeatures.EditAbstractFeature;
import de.tu_bs.ccc.contracting.core.guiFeatures.LayoutFeature;
import de.tu_bs.ccc.contracting.core.guiFeatures.ReloadImportFeature;
import de.tu_bs.ccc.contracting.core.guiFeatures.VerifyCustomFeature;
import de.tu_bs.ccc.contracting.core.move.MovePortFeature;
import de.tu_bs.ccc.contracting.core.propertyFeature.CreateProperty;
import de.tu_bs.ccc.contracting.core.resize.ResizeModuleFeature;
import de.tu_bs.ccc.contracting.core.update.UpdateContractFeature;
import de.tu_bs.ccc.contracting.core.update.UpdateModuleFeature;
import de.tu_bs.ccc.contracting.core.update.UpdatePortFeature;

public class ContractModellingFeatureProvider extends DefaultFeatureProvider {

	@Override
	public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) {
		return new ReconnectionFeature(this);
	}

	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		return new ICustomFeature[] { new VerifyCustomFeature(this), new CollapseFeature(this),
				new EditAbstractFeature(this), new ReloadImportFeature(this), new LayoutDiagramFeature(this) };
	}

	@Override
	public IDeleteFeature getDeleteFeature(IDeleteContext context) {

		if (context.getPictogramElement() instanceof Connection) {
			Connection con = (Connection) context.getPictogramElement();
			if ((getBusinessObjectForPictogramElement(con.getStart().getParent()) instanceof Ports)
					&& (getBusinessObjectForPictogramElement(con.getEnd().getParent()) instanceof Ports)) {

				return new DeletePortConnectionFeature(this);
			}

		}
		return super.getDeleteFeature(context);
	}

	public ContractModellingFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}
	
//	@Override
//	public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context) {
//	    PictogramElement pe = context.getPictogramElement();
//	    if (pe.eContainer() instanceof ContainerShape &&  ((ContainerShape)pe.eContainer()).getLink().getBusinessObjects().get(0) instanceof Contract) {
//	        return new DirectEditContractPropertyFeature(this);
//	    }
//	    return super.getDirectEditingFeature(context);
//	}

	@Override
	public ICreateFeature[] getCreateFeatures() {

		return new ICreateFeature[] {
				// new CreateComponentFeature(this),
				new CreateContractFeature(this),
				// new CreateAbstractFeature(this),
				new CreatePortFeature(this), new LoadModuleFeature(this), new CreateProperty(this, true), new CreateProperty(this, false),
				new AssignAbstractFeature(this) };
	}

	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] { new CreatePortConnection(this) };
	}

	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		Object obj = context.getNewObject();

		if (obj instanceof Component) {
			return new AddComponentFeature(this);
		} else if (obj instanceof Contract) {
			return new AddContractFeature(this);
		} else if (obj instanceof Abstract) {
			return new AddAbstractFeature(this);
		} else if (obj instanceof Compound) {
			return new AddCompoundFeature(this);
		} else if (obj instanceof System) {
			return new AddSystemFeature(this);
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
		if (bo instanceof Module || bo instanceof Contract || bo instanceof System) {
			return new LayoutFeature(this);
		} else if (bo instanceof Ports) {
			return new LayoutPortFeature(this);
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
