package de.tu_bs.ccc.contracting.core.diagram;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.ContextEntryHelper;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonEntry;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IContextMenuEntry;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.ImageDecorator;

import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.core.guiFeatures.CollapseFeature;
import de.tu_bs.ccc.contracting.core.guiFeatures.EditAbstractFeature;
import de.tu_bs.ccc.contracting.core.guiFeatures.EditDescriptionFeature;
import de.tu_bs.ccc.contracting.core.guiFeatures.EditModuleFeature;
import de.tu_bs.ccc.contracting.core.guiFeatures.EditPortFeature;
import de.tu_bs.ccc.contracting.core.guiFeatures.EditPropertyFeature;
import de.tu_bs.ccc.contracting.core.guiFeatures.OpenEditorFeature;
import de.tu_bs.ccc.contracting.core.guiFeatures.ReloadImportFeature;
import de.tu_bs.ccc.contracting.core.guiFeatures.VerifyCustomFeature;
import de.tu_bs.ccc.contracting.core.synchronize.DeSynchronizeFeature;
import de.tu_bs.ccc.contracting.core.synchronize.SynchronizeFeature;

public class ContractModellingToolBehaviorProvider extends DefaultToolBehaviorProvider {

	@Override
	public IContextButtonPadData getContextButtonPad(IPictogramElementContext context) {
		IContextButtonPadData data = super.getContextButtonPad(context);
		PictogramElement pe = context.getPictogramElement();
		CustomContext cc = new CustomContext(new PictogramElement[] { pe });

		// 1. set the generic context buttons
		// note, that we do not add 'remove' (just as an example)
		setGenericContextButtons(data, pe, CONTEXT_BUTTON_DELETE);
		ICustomFeature[] cf = getFeatureProvider().getCustomFeatures(cc);
		ICustomFeature[] cf2 = getFeatureProvider().getCustomFeatures(cc);
		for (int i = 0; i < cf2.length; i++) {
			ICustomFeature iCustomFeature = cf2[i];
			if (iCustomFeature instanceof CollapseFeature) {
				IContextButtonEntry collapseButton = ContextEntryHelper.createCollapseContextButton(true,
						iCustomFeature, cc);
				data.setCollapseContextButton(collapseButton);
				break;
			}
		}
		for (int i = 0; i < cf.length; i++) {
			ICustomFeature iCustomFeature = cf[i];
			if (iCustomFeature instanceof VerifyCustomFeature) {
				ContextButtonEntry button = new ContextButtonEntry((VerifyCustomFeature) iCustomFeature, cc);
				button.setText("Verify Component");
				button.setDescription("Verifies the Compound or Interface");
				data.getDomainSpecificContextButtons().add(button);

				break;
			}
		}
		for (int i = 0; i < cf.length; i++) {
			ICustomFeature iCustomFeature = cf[i];
			if (iCustomFeature instanceof EditAbstractFeature) {
				ContextButtonEntry button = new ContextButtonEntry((EditAbstractFeature) iCustomFeature, cc);
				button.setText("Edit Interface relation");
				button.setDescription("Allows to edit the interface or refinements");
				data.getDomainSpecificContextButtons().add(button);

				break;
			}
		}
		for (int i = 0; i < cf.length; i++) {
			ICustomFeature iCustomFeature = cf[i];
			if (iCustomFeature instanceof SynchronizeFeature) {
				ContextButtonEntry button = new ContextButtonEntry((SynchronizeFeature) iCustomFeature, cc);
				button.setText("Synchronize Component");
				button.setDescription("Allows to edit the interface or refinements");
				data.getDomainSpecificContextButtons().add(button);

				break;
			}
		}
		for (int i = 0; i < cf.length; i++) {
			ICustomFeature iCustomFeature = cf[i];
			if (iCustomFeature instanceof ReloadImportFeature) {
				ContextButtonEntry button = new ContextButtonEntry((ReloadImportFeature) iCustomFeature, cc);
				button.setText("Reload Import");
				button.setDescription("Allows to update and reload the importted Components");
				data.getDomainSpecificContextButtons().add(button);

				break;
			}
		}
		for (int i = 0; i < cf.length; i++) {
			ICustomFeature iCustomFeature = cf[i];
			if (iCustomFeature instanceof DeSynchronizeFeature) {
				ContextButtonEntry button = new ContextButtonEntry((DeSynchronizeFeature) iCustomFeature, cc);
				button.setText("DeSynch Component");
				button.setDescription("Deletes the connection to the original");
				data.getDomainSpecificContextButtons().add(button);

				break;
			}
		}

		return data;
	}

	@Override
	public IContextMenuEntry[] getContextMenu(ICustomContext context) {
		List<IContextMenuEntry> menuEntries = new ArrayList<IContextMenuEntry>();

		// create a menu-entry for each custom feature
		ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(context);
		for (int i = 0; i < customFeatures.length; i++) {
			ICustomFeature customFeature = customFeatures[i];
			if (customFeature.isAvailable(context)) {
				ContextMenuEntry menuEntry = new ContextMenuEntry(customFeature, context);
				menuEntries.add(menuEntry);
			}
		}

		ICustomFeature changeDesc = new EditDescriptionFeature(getFeatureProvider());
		if (changeDesc.canExecute(context)) {
			ContextMenuEntry menuEntry = new ContextMenuEntry(changeDesc, context);
			menuEntry.setText("Edit Description");
			menuEntry.setDescription("Opens Dialog to Edit the Description");
			menuEntries.add(menuEntry);
		}
		
		ICustomFeature openFile = new OpenEditorFeature(getFeatureProvider());
		if (openFile.canExecute(context)) {
			ContextMenuEntry menuEntry = new ContextMenuEntry(openFile, context);
			menuEntry.setText("Open Module");
			menuEntry.setDescription("Opens Module in anew Editor.");
			menuEntries.add(menuEntry);
		}

		return (IContextMenuEntry[]) menuEntries.toArray(new IContextMenuEntry[0]);
	}

	@Override
	public IDecorator[] getDecorators(PictogramElement pe) {
		IFeatureProvider featureProvider = getFeatureProvider();
		Object bo = featureProvider.getBusinessObjectForPictogramElement(pe);
		if ((bo instanceof Compound) || (bo instanceof Component)) {
			Module module = (Module) bo;
			
			if (!module.getRealizedBy().isEmpty()) {
				IDecorator imageRenderingDecorator = new ImageDecorator(
						IPlatformImageConstants.IMG_ECLIPSE_INFORMATION_TSK);
				imageRenderingDecorator.setMessage("At least one abstract component is refined.");
				return new IDecorator[] { imageRenderingDecorator };
			}
		}

		return super.getDecorators(pe);
	}

	@Override
	public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
		ICustomFeature customFeature = new EditPortFeature(getFeatureProvider());
		// canExecute() tests especially if the context contains a EClass
		if (customFeature.canExecute(context)) {
			return customFeature;
		}

		ICustomFeature customFeature2 = new EditPropertyFeature(getFeatureProvider());
		// canExecute() tests especially if the context contains a EClass
		if (customFeature2.canExecute(context)) {
			return customFeature2;
		}
		ICustomFeature customFeature3 = new EditModuleFeature(getFeatureProvider());
		// canExecute() tests especially if the context contains a EClass

		if (customFeature3.canExecute(context)) {
			return customFeature3;
		}

		return super.getDoubleClickFeature(context);
	}

	public ContractModellingToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
		// TODO Auto-generated constructor stub
	}

}
