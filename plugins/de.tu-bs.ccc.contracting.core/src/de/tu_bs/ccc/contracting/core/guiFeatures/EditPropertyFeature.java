package de.tu_bs.ccc.contracting.core.guiFeatures;

import java.awt.TrayIcon.MessageType;

import javax.swing.JOptionPane;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import de.tu_bs.ccc.contracting.Verification.Assumption;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.ContractProperty;
import de.tu_bs.ccc.contracting.Verification.Guarantee;
import de.tu_bs.ccc.contracting.Verification.Ports;
import windows.EditPropertyWindow;

public class EditPropertyFeature extends AbstractCustomFeature {

	public EditPropertyFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean canExecute(ICustomContext context) {
        boolean ret = false;
        PictogramElement pes = context.getPictogramElements()[0];

        if (pes != null) {
      
            Object bo = getBusinessObjectForPictogramElement(pes);
            if (bo instanceof Contract) {
                ret = true;
            }
        }
        return ret;
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement pes = context.getPictogramElements()[0];
		Contract con = (Contract)getBusinessObjectForPictogramElement(pes);
		EditPropertyWindow win = new EditPropertyWindow(con);
		win.setVisible(true);
		if(win.getDelA()!=null) {
			EcoreUtil.delete(win.getDelA());
		}
		else if(win.getDelG()!=null) {
			EcoreUtil.delete(win.getDelG());
		}
		else if (win.isAs()) {
			Assumption a = con.getAssumption().get(win.getSelectCount());
			a.setProperty(win.getPropertyOfSelect());
			a.setPropertyTipe(win.getTypeofSelect());
			
			
		}
		else if (win.isGa()) {
			Guarantee g = con.getGuarantee().get(win.getSelectCount());
			g.setProperty(win.getPropertyOfSelect());
			g.setPropertyTipe(win.getTypeofSelect());
		}
		
		
		updatePictogramElement(pes);

	}

}