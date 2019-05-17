package de.tu_bs.ccc.contracting.core.features.directEditing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import de.tu_bs.ccc.contracting.Verification.Assumption;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Guarantee;
import de.tu_bs.ccc.contracting.Verification.MmFactory;
import de.tu_bs.ccc.contracting.Verification.PropertyType;
import de.tu_bs.ccc.contracting.Verification.ViewPoint;
import de.tu_bs.ccc.contracting.core.localization.StringTable;

public class DirectEditContractPropertyFeature extends AbstractDirectEditingFeature {

	List<String> blacklist = new ArrayList<String>(Arrays.asList("FUNCTIONAL", "Assumptions", "Guarantees"));

	public DirectEditContractPropertyFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}

	@Override
	public boolean canDirectEdit(IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = ((ContainerShape)pe.eContainer()).getLink().getBusinessObjects().get(0);
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		// support direct editing, if it is a EClass, and the user clicked
		// directly on the text and not somewhere else in the rectangle
		if (bo instanceof Contract && ((Contract) bo).getViewPoint().equals(ViewPoint.FUNCTIONAL) && ga instanceof Text
				&& !blacklist.contains(((Text) ga).getValue())) {
			return true;
		}
		// direct editing not supported in all other cases
		return false;
	}

	@Override
	public String getInitialValue(IDirectEditingContext context) {
		return ((Text) context.getGraphicsAlgorithm()).getValue();
	}

	@Override
	public String checkValueValid(String value, IDirectEditingContext context) {
		// if (value.length() < 1)
		// return "Please enter any text as class name.";
		// if (value.contains(" "))
		// return "Spaces are not allowed in class names.";
		// if (value.contains("\n"))
		// return "Line breakes are not allowed in class names.";

		// null means, that the value is valid
		return null;
	}

	public void setValue(String value, IDirectEditingContext context) {
		((Text) context.getGraphicsAlgorithm()).setValue(value);

		// Build new contract
		PictogramElement pe = context.getPictogramElement();
		List<String> assumptions = new ArrayList<String>();
		List<String> guarantees = new ArrayList<String>();

		boolean assumption = true;
		for (Shape sh : ((ContainerShape) pe).getChildren()) {
			if (sh.getGraphicsAlgorithm() instanceof Text) {
				String val = ((Text) sh.getGraphicsAlgorithm()).getValue();

				if (val.equals(StringTable.CONTRACT_GUARANTEES)) {
					assumption = false;
				} else if (blacklist.contains(val) || val.trim().equals("")) {
					// skip
				} else {
					if (assumption)
						assumptions.add(val);
					else
						guarantees.add(val);
				}

			}
		}

		if (assumptions.isEmpty()) {
			assumptions.add(StringTable.CONTRACT_ASSUMPTION_DEFAULT_FUNC);
		}

		if (guarantees.isEmpty()) {
			assumptions.add(StringTable.CONTRACT_GUARANTEE_DEFAULT_FUNC);
		}

		Contract contract = (Contract) getBusinessObjectForPictogramElement(pe);
		contract.getAssumption().clear();
		contract.getGuarantee().clear();

		for (String aval : assumptions) {
			Assumption a = MmFactory.eINSTANCE.createAssumption();
			a.setProperty(aval);
			a.setPropertyTipe(PropertyType.EQUATION);
			a.setContract(contract);
			contract.getAssumption().add(a);
		}
		for (String gval : assumptions) {
			Guarantee g = MmFactory.eINSTANCE.createGuarantee();
			g.setProperty(gval);
			g.setPropertyTipe(PropertyType.EQUATION);
			g.setContract(contract);
			contract.getGuarantee().add(g);
		}

		updatePictogramElement(((Shape) pe).getContainer());
	}
}
