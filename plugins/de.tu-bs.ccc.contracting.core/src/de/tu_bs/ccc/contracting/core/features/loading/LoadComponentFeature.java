package de.tu_bs.ccc.contracting.core.features.loading;

import java.awt.FileDialog;

import java.awt.Frame;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import general.SaveDomainModel;
import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.MmFactory;
import de.tu_bs.ccc.contracting.Verification.MmPackage;
import windows.Dialog;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class LoadComponentFeature extends AbstractCreateFeature {

	public LoadComponentFeature(IFeatureProvider fp) {
		super(fp, "Load Module", "Loads modeled Component or Compound");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		if (!(context.getTargetContainer() instanceof Diagram)) {
			PictogramElement pict = context.getTargetContainer();
			if (!(pict instanceof ContainerShape)) {

				return false;
			}

			EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
			return businessObjects.size() == 1 && businessObjects.get(0) instanceof Compound;
		} else {
			return false;
		}
	}

	@Override
	public Object[] create(ICreateContext context) {
		Frame frame = null;
		FileDialog dialog = new FileDialog(frame, "Ressource", FileDialog.LOAD);
		dialog.setFilenameFilter(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				String lowercaseName = name.toLowerCase();
				if (lowercaseName.endsWith(".model")) {
					return true;
				} else {
					return false;
				}
			}
		});

		dialog.setVisible(true);

		String result = dialog.getDirectory() + dialog.getFile();

		URI uri = URI.createFileURI(result);

		// Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		ResourceSet rSet = getDiagram().eResource().getResourceSet();
		// JOptionPane.showConfirmDialog(null, uri.toString());
		// Map<String, Object> m = reg.getExtensionToFactoryMap();
		// m.put("model", new XMIResourceFactoryImpl());
		final Resource resource = rSet.getResource(uri, true);
		Dialog d = new Dialog(this.createList(resource.getContents()).toArray());
		d.setVisible(true);
		try {
			Component c = (Component) resource.getContents().get(d.getCount());
			Component copy = EcoreUtil.copy(c);
			addGraphicalRepresentation(context, copy);
			PictogramElement pict = context.getTargetContainer();
			Compound x = (Compound) getBusinessObjectForPictogramElement(pict);
			copy.setIsPartOf(x);
			copy.setModule(c);
			x.getConsitsOf().add(copy);

			return new Object[] { copy };
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Compound c = (Compound) resource.getContents().get(d.getCount());
			Compound copy = EcoreUtil.copy(c);
			for (Module m : copy.getConsitsOf()) {
				EcoreUtil.delete(m);
			}
			addGraphicalRepresentation(context, copy);
			PictogramElement pict = context.getTargetContainer();
			Compound x = (Compound) getBusinessObjectForPictogramElement(pict);
			copy.setIsPartOf(x);
			copy.setModule(c);
			x.getConsitsOf().add(copy);

			return new Object[] { copy };

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	List<String> createList(EList<EObject> list) {
		List<String> names = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			try {
				names.add(((Module) list.get(i)).getName() + " " + ((Module) list.get(i)).getVersion());
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		return names;

	}
}
