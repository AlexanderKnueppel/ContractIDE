package de.tu_bs.ccc.contracting.core.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class ContractModellingDiagramTypeProvider extends AbstractDiagramTypeProvider {
	private IToolBehaviorProvider[] toolBehaviorProviders;

	public ContractModellingDiagramTypeProvider() {
		super();
		setFeatureProvider(new ContractModellingFeatureProvider(this));
	}

	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
		if (toolBehaviorProviders == null) {
			toolBehaviorProviders = new IToolBehaviorProvider[] { new ContractModellingToolBehaviorProvider(this) };
		}
		return toolBehaviorProviders;
	}
	@Override
	public boolean isAutoUpdateAtRuntime() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAutoUpdateAtStartup() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAutoUpdateAtRuntimeWhenEditorIsSaved() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAutoUpdateAtReset() {
		// TODO Auto-generated method stub
		return true;
	}
}
