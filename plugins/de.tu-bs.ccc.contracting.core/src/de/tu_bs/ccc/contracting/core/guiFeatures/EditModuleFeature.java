package de.tu_bs.ccc.contracting.core.guiFeatures;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import de.tu_bs.ccc.contracting.Verification.Module;

public class EditModuleFeature extends AbstractCustomFeature{

	@Override
	public boolean canExecute(ICustomContext context) {
		  boolean ret = false;
	        PictogramElement pes = context.getPictogramElements()[0];

	        if (pes != null) {
	      
	            Object bo = getBusinessObjectForPictogramElement(pes);
	            if (bo instanceof Module) {
	                ret = true;
	            }
	        }
	        return ret;
	}

	public EditModuleFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		Object bo = getBusinessObjectForPictogramElement(pes[0]);
		if(bo instanceof Module) {
			Module m = (Module) bo;
			JTextField xField = new JTextField(5);
			xField.setText(m.getName());
		    JTextField yField = new JTextField(5);
		    yField.setText(m.getVersion());
		    JPanel myPanel = new JPanel();
		    myPanel.add(new JLabel("Name:"));
		    myPanel.add(xField);
		    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
		    myPanel.add(new JLabel("Version:"));
		    myPanel.add(yField);

		    int result = JOptionPane.showConfirmDialog(null, myPanel,
		        "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
		    if (result == JOptionPane.OK_OPTION) {
		      m.setName(xField.getText());
		      m.setVersion(yField.getText());
		    }

		}
			
			
		}
		
	

}
