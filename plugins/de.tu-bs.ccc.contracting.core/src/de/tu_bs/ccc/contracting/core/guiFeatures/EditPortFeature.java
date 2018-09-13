package de.tu_bs.ccc.contracting.core.guiFeatures;

import javax.swing.JOptionPane;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;
import windows.PortDialog;

public class EditPortFeature extends AbstractCustomFeature  {

	@Override
	public boolean canExecute(ICustomContext context) {
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof Ports) {
                ret = true;
            }
        }
        return ret;
	}

	public EditPortFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		Object bo = getBusinessObjectForPictogramElement(pes[0]);
		if (bo instanceof Ports) {
			Ports port = (Ports) bo;
			PortDialog x = new PortDialog(port.getName(), port.getModule().getName(), port.getType().getValue(), port.getService(), port.getOuterDirection().getValue());
			x.setVisible(true);
			port.setName(x.getPortname());
			port.setType(PortType.get(x.getSelection()));
			port.setService(x.getService());
			port.setOuterDirection(DirectionType.get(x.getDirection()));
			System.out.println(port.getService());
			updatePictogramElement(pes[0]);
        }
		
	}

}
