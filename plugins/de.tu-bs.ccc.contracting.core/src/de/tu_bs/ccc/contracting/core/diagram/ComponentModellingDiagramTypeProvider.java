package de.tu_bs.ccc.contracting.core.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class ComponentModellingDiagramTypeProvider extends AbstractDiagramTypeProvider {
	public ComponentModellingDiagramTypeProvider() {

	
		super();
		setFeatureProvider(new ComponentModellingFeatureProvider(this));
	}
}
