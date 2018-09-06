package general;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

public class LogWriter {
	
	
	public static void writeLog(String text, String dirt) {
		org.eclipse.core.resources.IResource iresource;
		 File file = new File(ResourcesPlugin.getWorkspace().getRoot().getLocation()  +dirt+".info");
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		    FileWriter writer = null;
		    try {
		        writer = new FileWriter(file, true);
		        writer.write(timestamp.toString()+"\n");
		        writer.write(text);
		    } catch (IOException e) {
		        e.printStackTrace(); // I'd rather declare method with throws IOException and omit this catch.
		    } finally {
		        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
		    }
		    for(IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()){
		        try {
					project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		
	}
}
