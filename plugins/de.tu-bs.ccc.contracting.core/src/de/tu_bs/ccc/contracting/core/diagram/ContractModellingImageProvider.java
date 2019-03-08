package de.tu_bs.ccc.contracting.core.diagram;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;
 
public class ContractModellingImageProvider extends AbstractImageProvider {
 
    // The prefix for all identifiers of this image provider
    protected static final String PREFIX = 
              "de.tu-bs.ccc.contracting.core.";
 
    // The image identifier for an EReference.
    public static final String IMG_PORT_INPUT= PREFIX + "port.input";
    public static final String IMG_PORT_OUTPUT= PREFIX + "port.output";
    public static final String IMG_SYNCHRONIZE= PREFIX + "synchronize";
    public static final String IMG_DESYNCHRONIZE= PREFIX + "desynchronize";
 
    @Override
    protected void addAvailableImages() {
        // register the path for each image identifier
        addImageFilePath(IMG_PORT_INPUT, "icons/ports/input.png");
        addImageFilePath(IMG_PORT_OUTPUT, "icons/ports/output.png");
        addImageFilePath(IMG_SYNCHRONIZE, "icons/synchronize.png");
        addImageFilePath(IMG_DESYNCHRONIZE, "icons/desynchronize.png");
    }
}