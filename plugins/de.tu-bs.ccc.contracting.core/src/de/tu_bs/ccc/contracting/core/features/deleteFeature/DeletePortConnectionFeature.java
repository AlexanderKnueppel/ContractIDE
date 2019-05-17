package de.tu_bs.ccc.contracting.core.features.deleteFeature;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

import de.tu_bs.ccc.contracting.Verification.Ports;

public class DeletePortConnectionFeature extends DefaultDeleteFeature {

	@Override
	public void delete(IDeleteContext context) {
		if (context.getPictogramElement() instanceof Connection) {
			Connection con = (Connection) context.getPictogramElement();
			Ports port1 = (Ports) getBusinessObjectForPictogramElement(con.getStart().getParent());
			Ports port2 = (Ports) getBusinessObjectForPictogramElement(con.getEnd().getParent());
//			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(port1.eResource().getResourceSet());
//			final CommandStack commandStack = editingDomain.getCommandStack();
//			commandStack.execute(new RecordingCommand(editingDomain) {
//
//				@Override
//				protected void doExecute() {
					if(port1.getInsidePorts().contains(port2)) {
						port1.getInsidePorts().remove(port2);
						port2.setInsidePortseOpposite(null);
					}
					
					else if(port1.getInsidePortseOpposite()==port2) {
						port2.getInsidePorts().remove(port1);
						port1.setInsidePortseOpposite(null);
					}
					else if(port1.getPorts().contains(port2)) {
						port1.getPorts().remove(port2);
						port2.setPortseOpposite(null);
					}
					else if(port1.getPortseOpposite()==port2) {
						port2.getPorts().remove(port2);
						port1.setPortseOpposite(null);
					}
				}
//			
		super.delete(context);
	}

	public DeletePortConnectionFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}
	
}
