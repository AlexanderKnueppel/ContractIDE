package de.tu_bs.ccc.contracting.core.io.handler;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.tu_bs.ccc.contracting.Verification.System;
import de.tu_bs.ccc.contracting.core.io.ccc.CCCExporter;
import de.tu_bs.ccc.contracting.core.io.ccc.CCCImporter;
import de.tu_bs.ccc.contracting.core.localization.StringTable;
import de.tu_bs.ccc.contracting.core.util.CoreUtil;

public class ImportHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	    if (window != null)
	    {
	        IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();
	        Object firstElement = selection.getFirstElement();
	        if (firstElement instanceof IAdaptable && firstElement instanceof IProject)
	        {
	            IProject p = (IProject)((IAdaptable)firstElement).getAdapter(IProject.class);
	    		new CCCImporter().createFiles(p);
	        }
	    }
		return null;
	}

}
