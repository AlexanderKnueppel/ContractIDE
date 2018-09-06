package de.tu_bs.ccc.contracting.core.features.loading;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import de.tu_bs.de.ccc.contracting.Verification.Component;
import de.tu_bs.de.ccc.contracting.Verification.Compound;
import de.tu_bs.de.ccc.contracting.Verification.Interface;
import de.tu_bs.de.ccc.contracting.Verification.Module;
import windows.Dialog;

public class LoadInterfaceFeature extends AbstractCreateFeature {

	public LoadInterfaceFeature(IFeatureProvider fp) {
		super(fp, "Assign Interface", "Assign an Module to an Interface");
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
			return businessObjects.size() == 1
					&& (businessObjects.get(0) instanceof Component || businessObjects.get(0) instanceof Compound);
		} else {
			return false;
		}
	}

	@Override
	public Object[] create(ICreateContext context) {
		Frame frame = null;
        // JFileChooser-Objekt erstellen
        JFileChooser chooser = new JFileChooser(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
        FileFilter filter = new FileNameExtensionFilter("Dateien", 
                "model");   
        chooser.setFileFilter(filter);
        // Dialog zum Oeffnen von Dateien anzeigen
        int rueckgabeWert = chooser.showOpenDialog(null);
        
        /* Abfrage, ob auf "Öffnen" geklickt wurde */
        if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
        {
        	String result = chooser.getSelectedFile().getPath();
        	URI uri = URI.createFileURI(result);
        	IPath path = new Path(uri.toFileString());
        	IFile file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(path);
        	URI uri2 = URI.createURI(file.getFullPath().toString());
        			System.out.println(file.getFullPath().toString());
    		
 ;			

    		// Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
    		ResourceSet rSet = getDiagram().eResource().getResourceSet();
    		// JOptionPane.showConfirmDialog(null, uri.toString());
    		// Map<String, Object> m = reg.getExtensionToFactoryMap();
    		// m.put("model", new XMIResourceFactoryImpl());
    		final Resource resource = rSet.getResource(uri2, true);
    		Compound m = (Compound) resource.getContents().get(0);
    		Dialog d = new Dialog(this.createList(m.getConsitsOf()).toArray());
    		d.setVisible(true);

    			Compound c = (Compound) resource.getContents().get(0);
    			Interface i = (Interface) c.getConsitsOf().get(d.getCount());
    			PictogramElement pict = context.getTargetContainer();
    			Module x = (Module) getBusinessObjectForPictogramElement(pict);
    			x.getGetsrealized().add(i);

        }
        
		
		
		



		

		return null;
	}

	List<String> createList(EList<Module> list) {
		List<String> names = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {

				try {
					names.add(list.get(i).getName() + " "+ list.get(i).getDescription());
				} catch (Exception e) {
					// TODO: handle exception
			}
			

		}
		return names;

	}



}
