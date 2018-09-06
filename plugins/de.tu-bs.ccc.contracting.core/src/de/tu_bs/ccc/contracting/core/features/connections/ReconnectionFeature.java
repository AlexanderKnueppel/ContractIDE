package de.tu_bs.ccc.contracting.core.features.connections;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;

public class ReconnectionFeature extends DefaultReconnectionFeature {

	@Override
	public boolean canReconnect(IReconnectionContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	public ReconnectionFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

}
