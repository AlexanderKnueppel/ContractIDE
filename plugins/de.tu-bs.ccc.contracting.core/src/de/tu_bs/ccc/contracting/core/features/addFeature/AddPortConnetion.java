package de.tu_bs.ccc.contracting.core.features.addFeature;


import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;

public class AddPortConnetion extends AbstractAddFeature {

	public AddPortConnetion(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canAdd(IAddContext context) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		
		IAddConnectionContext cont = (IAddConnectionContext) context;
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		Connection connection = peCreateService.createManhattanConnection(getDiagram());
		connection.setStart(cont.getSourceAnchor());
		connection.setEnd(cont.getTargetAnchor());
		Polyline polyline = gaService.createPlainPolyline(connection);
		polyline.setLineWidth(3);
		polyline.setForeground(manageColor(IColorConstant.BLACK));
		ConnectionDecorator cd;
	     cd = peCreateService
	           .createConnectionDecorator(connection, false, 1.0, true);
	     createArrow(cd);

		return connection;
	}
	private Polyline createArrow(GraphicsAlgorithmContainer gaContainer) {
	    IGaService gaService = Graphiti.getGaService();
	    Polyline polyline =
	        gaService.createPolyline(gaContainer, new int[] { -15, 10, 0, 0, -15,
	                -10 });
	    polyline.setForeground(manageColor(IColorConstant.BLACK));
	    polyline.setLineWidth(2);
	    return polyline;
	}
}
