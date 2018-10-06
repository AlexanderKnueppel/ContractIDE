package de.tu_bs.ccc.contracting.core.io.handler;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.tu_bs.ccc.contracting.Verification.System;
import de.tu_bs.ccc.contracting.core.io.ccc.CCCExporter;
import de.tu_bs.ccc.contracting.core.localization.StringTable;
import de.tu_bs.ccc.contracting.core.util.CoreUtil;

public class ExportHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	    if (window != null)
	    {
	        IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();
	        Object firstElement = selection.getFirstElement();
	        if (firstElement instanceof IAdaptable && firstElement instanceof IFile)
	        {
	            IFile file = (IFile)((IAdaptable)firstElement).getAdapter(IFile.class);
	            
	    		System sys = null;
	    		if(file.getFileExtension().equals(StringTable.MODEL_FILE_EXTENSION))
	    			sys = CoreUtil.getRootSystemFromFile(file, new ResourceSetImpl());
	    		else if(file.getFileExtension().equals(StringTable.DIAGRAM_FILE_EXTENSION)) {
	    			Diagram obj = CoreUtil.getDiagramFromFile(file, new ResourceSetImpl());//.getLink().getBusinessObjects().get(0);
	    			if(obj.getChildren().size() > 0) {
	    				if(obj.getChildren().get(0).getLink().getBusinessObjects().get(0) instanceof System) {
		    				sys = (System)obj.getChildren().get(0).getLink().getBusinessObjects().get(0);
		    			}
	    			}
	    			
	    		}
	    		
	    		if(sys != null)
	    			new CCCExporter(sys).writeToFile(new File("./export.xml"));
	    		else
	    			java.lang.System.out.println("Only System files can be exported!");
	        }
	    }
		return null;
	}

}
