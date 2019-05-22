package de.tu_bs.ccc.contracting.core.features.guiFeatures;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;

import de.tu_bs.ccc.contracting.core.localization.StringTable;

public class CollapseFeature extends AbstractCustomFeature {

	public CollapseFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			
				ret = true;
			}
		
		return ret;
	}

	@Override
	public String getName() {
		return StringTable.COLLAPSE_NAME;
	}

	@Override
	public String getDescription() {

		return StringTable.COLLAPSE_DESC;
	}

	@Override
	public String getImageId() {
		return IPlatformImageConstants.IMG_EDIT_COLLAPSE;
	}

	@Override
	public boolean isAvailable(IContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement pict = context.getPictogramElements()[0];
		GraphicsAlgorithm gA = pict.getGraphicsAlgorithm();
		gA.setWidth(40);
		gA.setHeight(40);

	}

}
