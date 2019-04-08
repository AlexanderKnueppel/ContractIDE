package de.tu_bs.ccc.contracting.core.update;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import de.tu_bs.ccc.contracting.Verification.Assumption;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Guarantee;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.ViewPoint;

public class UpdateContractFeature extends AbstractUpdateFeature {

	private static IColorConstant E_CLASS_TEXT_FOREGROUND = IColorConstant.BLACK;
	private static IColorConstant E_CLASS_FORE = new ColorConstant(192, 40, 30);

	private static IColorConstant E_CLASS_BACK = new ColorConstant(240, 80, 60);

	public UpdateContractFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
		return (bo instanceof Contract);

	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
	
		PictogramElement pictogramElement = context.getPictogramElement();
		Contract c = (Contract) getBusinessObjectForPictogramElement(context.getPictogramElement());

		ContainerShape cs = (ContainerShape) pictogramElement;
		boolean updateneeded = false;
		for (int i = (cs.getChildren().size() - 1); i >= 0; i--) {
			Shape s = cs.getChildren().get(i);
			if (i >= 3 && i < c.getAssumption().size() + 3) {
				Text t = (Text) s.getGraphicsAlgorithm();
				if (!t.getValue().equals(c.getAssumption().get(i - 3).getPropertyTipe() + ":"
						+ c.getAssumption().get(i - 3).getProperty())) {
					updateneeded = true;
				}

			} else if (i >= c.getAssumption().size() + 4
					&& i <= c.getAssumption().size() + 3 + c.getGuarantee().size()) {
				Text t = (Text) s.getGraphicsAlgorithm();
				if (!t.getValue().equals(c.getGuarantee().get(i - (c.getAssumption().size() + 4)).getPropertyTipe()
						+ ":" + c.getGuarantee().get(i - (c.getAssumption().size() + 4)).getProperty())) {
					updateneeded = true;
				}
			}

		}
		if (updateneeded) {
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(c);
			domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					// Implement your write operations here,
		
					updatePictogramElement(pictogramElement);
				}
			});

			return Reason.createTrueReason("Wrong Constraint");

		}

		return Reason.createFalseReason("Name is out of date");

	}

	@Override
	public boolean update(IUpdateContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();

		if (pictogramElement instanceof ContainerShape) {

			ContainerShape cs = (ContainerShape) pictogramElement;
			for (int i = (cs.getChildren().size() - 1); i >= 0; i--) {
				Shape s = cs.getChildren().get(i);
				if (s.getLink() != null) {
					EcoreUtil.delete(s.getLink());
				}
				EcoreUtil.delete(s);

			}

			IPeCreateService peCreateService = Graphiti.getPeCreateService();
			IGaService gaService = Graphiti.getGaService();
			Contract c = (Contract) getBusinessObjectForPictogramElement(pictogramElement);
			if (c.getViewPoint().getValue() == ViewPoint.FUNCTIONAL_VALUE) {
				E_CLASS_FORE = new ColorConstant(192, 40, 30);

				E_CLASS_BACK = new ColorConstant(240, 80, 60);

			} else if (c.getViewPoint().getValue() == ViewPoint.TIMING_VALUE) {
				E_CLASS_FORE = new ColorConstant(40, 192, 30);

				E_CLASS_BACK = new ColorConstant(80, 240, 60);

			} else {
				E_CLASS_FORE = new ColorConstant(30, 40, 192);

				E_CLASS_BACK = new ColorConstant(120, 190, 250);

			}
			pictogramElement.getGraphicsAlgorithm().setForeground(manageColor(E_CLASS_FORE));
			pictogramElement.getGraphicsAlgorithm().setBackground(manageColor(E_CLASS_BACK));
			{
				// create shape for line
				Shape shape = peCreateService.createShape(cs, false);

				// create and set graphics algorithm
				Polyline polyline = gaService.createPolyline(shape,
						new int[] { 0, 20, pictogramElement.getGraphicsAlgorithm().getWidth(), 20 });
				polyline.setForeground(manageColor(E_CLASS_FORE));
				polyline.setLineWidth(2);
			}

			// SHAPE WITH TEXT
			{
				// create shape for text
				Shape shape = peCreateService.createShape(cs, false);
				int textwidth = 15;
				// create and set text graphics algorithm
				Contract bo = (Contract) getBusinessObjectForPictogramElement(context.getPictogramElement());

				Text text = gaService.createText(shape, c.getViewPoint().getName());
				text.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
				text.setBackground(manageColor(180, 180, 180));
				text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
				// vertical alignment has as default value "center"
				text.setFont(gaService.manageDefaultFont(getDiagram(), true, true));
				gaService.setLocationAndSize(text, 0, 0, pictogramElement.getGraphicsAlgorithm().getWidth(), 20);
				int position = 0;

				position++;
				Shape shapeAssuption = peCreateService.createShape(cs, false);
				Text text4 = gaService.createText(shapeAssuption, "Assumptions");
				text4.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
				text4.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
				
				gaService.setLocationAndSize(text4, 3, textwidth * position,
						pictogramElement.getGraphicsAlgorithm().getWidth() - 3, textwidth * (position + 1));
				text4.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
				for (Assumption a : bo.getAssumption()) {
					position++;
					Shape shapeGuarantees = peCreateService.createShape(cs, false);
					//Text text3 = gaService.createText(shapeGuarantees, a.getPropertyTipe() + ":" + a.getProperty());
					Text text3 = gaService.createText(shapeGuarantees, a.getProperty());
					text3.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
					gaService.setLocationAndSize(text3, 0, textwidth * position,
							pictogramElement.getGraphicsAlgorithm().getWidth(), textwidth * (position + 1));
					text3.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
				}
				position++;
				Shape shapeGuarantee = peCreateService.createShape(cs, false);
				Text text2 = gaService.createText(shapeGuarantee, "Guarantees");
				text2.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
				text2.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
				
				gaService.setLocationAndSize(text2, 0, textwidth * position,
						pictogramElement.getGraphicsAlgorithm().getWidth(), textwidth * (position + 1));
				text2.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
				for (Guarantee g : bo.getGuarantee()) {
					position++;
					Shape shapeGuarantees = peCreateService.createShape(cs, false);
//					Text text3 = gaService.createText(shapeGuarantees, g.getPropertyTipe() + ":" + g.getProperty());
					Text text3 = gaService.createText(shapeGuarantees, g.getProperty());
					text3.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
					gaService.setLocationAndSize(text3, 3, textwidth * position,
							pictogramElement.getGraphicsAlgorithm().getWidth() - 3, textwidth * (position + 1));
					text3.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
				}
			}
			getDiagramBehavior().refreshContent();
		return true;
		}
		return false;

	}
}
