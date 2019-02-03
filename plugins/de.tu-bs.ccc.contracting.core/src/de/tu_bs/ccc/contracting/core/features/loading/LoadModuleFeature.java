package de.tu_bs.ccc.contracting.core.features.loading;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.System;
import de.tu_bs.ccc.contracting.Verification.impl.PortsImpl;
import de.tu_bs.ccc.contracting.core.util.CoreUtil;
import de.tu_bs.ccc.contracting.ui.dialogs.LoadModuleDialog;
import de.tu_bs.ccc.contracting.ui.provider.LoadModuleLabelProvider;

public class LoadModuleFeature extends AbstractCreateFeature {

	public LoadModuleFeature(IFeatureProvider fp) {
		super(fp, "Load Module", "Adds component or interface to a compound.");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		if (!(context.getTargetContainer() instanceof Diagram)) {
			PictogramElement pict = context.getTargetContainer();
			if (!(pict instanceof ContainerShape)) {
				return false;
			}

			EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
			return businessObjects.size() == 1 && (businessObjects.get(0) instanceof Compound || businessObjects.get(0) instanceof System);
		} else {
			return false;
		}
	}

	@Override
	public Object[] create(ICreateContext context) {

		List<Module> modules = (List<Module>) CoreUtil.getRootModules(CoreUtil.getCurrentProject(), m -> {
			PictogramElement pict = context.getTargetContainer();
			EObject x = (EObject) getBusinessObjectForPictogramElement(pict);

			return !x.eResource().getURI().toString().equals(m.eResource().getURI().toString());
		});

		final LoadModuleDialog dialog = new LoadModuleDialog(null, new LoadModuleLabelProvider(),
				"Add Module to this Container", "Add Module", modules);

		if (dialog.open() == LoadModuleDialog.CANCEL) {
			return null;
		}

		for (Object obj : dialog.getResult()) {
			Module c = (Module) obj;
			Module copy = EcoreUtil.copy(c);

			if (copy instanceof Compound) {
				EcoreUtil.deleteAll(((Compound) copy).getConsistsOf(), true);
			}

			PictogramElement pe = addGraphicalRepresentation(context, copy);
			PictogramElement pict = context.getTargetContainer();
			
			//layoutPictogramElement(pe);
			
			
		     int yIn = 30;
		      int yOut = 30;
		      int numberIn = 0;
		      int numberOut = 0;
		        
pe.getGraphicsAlgorithm().setWidth(200);
			
ContainerShape containerShape = (ContainerShape) pe;
			for (Shape shape : containerShape.getChildren()) {
				
				
				if (shape.getLink() != null) {
					if (shape.getLink().getBusinessObjects().get(0) instanceof PortsImpl) {
						PortsImpl port = (PortsImpl) shape.getLink().getBusinessObjects().get(0);
						if (port.getOuterDirection() == DirectionType.EXTERNAL) {
							shape.getGraphicsAlgorithm().setY(yOut);
							shape.getGraphicsAlgorithm().setX(200 - 80);
							yOut += 50;
							numberOut++;
						} else {
							shape.getGraphicsAlgorithm().setY(yIn);
							yIn += 50;
							numberIn ++;
						}
					}
				}
			}
			int maxNumber = numberIn > numberOut? numberIn : numberOut;
			containerShape.getGraphicsAlgorithm().setHeight(maxNumber * 50 + 30);
			layoutPictogramElement(containerShape);
			checkOuterContainerSize(containerShape);
		
			
			
			for(int i = 0; i < containerShape.getContainer().getChildren().size() - 1; i++) {
				orderShapes(containerShape, containerShape.getContainer().getChildren().get(i) );
			}
			/*for(Shape shape : containerShape.getContainer().getChildren()) {
				orderShapes(containerShape, shape);
			}*/
			
			
			
			Object container = getBusinessObjectForPictogramElement(pict);
			if(container instanceof Compound) {
				Compound x = (Compound) getBusinessObjectForPictogramElement(pict);
				copy.setIsPartOf(x);
				copy.getRealizedBy().addAll(c.getRealizedBy());
				copy.setModule(c);
				x.getConsistsOf().add(copy);
			} else if(container instanceof System) {
				System x = (System) getBusinessObjectForPictogramElement(pict);
				copy.setModule(c);
				copy.getRealizedBy().addAll(c.getRealizedBy());
				copy.setIsPartOf(null);
				x.getConsistsOf().add(copy);
			}
			
			return new Object[] { copy };
		}

		return null;
	}
	
	
	//checks if loaded module fits into its outer container, otherwise enlarge container
	private void checkOuterContainerSize(ContainerShape containerShape) {
		int x = containerShape.getGraphicsAlgorithm().getX();
		int y = containerShape.getGraphicsAlgorithm().getY();
		int width = containerShape.getGraphicsAlgorithm().getWidth();
		int height = containerShape.getGraphicsAlgorithm().getHeight();
		int outerX = containerShape.getContainer().getGraphicsAlgorithm().getX();
		int outerY = containerShape.getContainer().getGraphicsAlgorithm().getY();		
		int outerWidth = containerShape.getContainer().getGraphicsAlgorithm().getWidth();
		int outerHeight = containerShape.getContainer().getGraphicsAlgorithm().getHeight();
		if(x + width > outerX + outerWidth) {
			int difference = x + width - (outerX + outerWidth);
			enlargeWidth(containerShape.getContainer(), difference);			
		}else if(y + height > outerY + outerHeight) {
			int difference = y + height - (outerY + outerHeight);
			enlargeHeight(containerShape.getContainer(), difference);
			
		}
		
	}

	private void enlargeHeight(ContainerShape container, int difference) {
		int oldHeight = container.getGraphicsAlgorithm().getHeight();
		container.getGraphicsAlgorithm().setHeight(oldHeight + difference + 40);		
	}

	private void enlargeWidth(ContainerShape container, int difference) {
		int oldWidth = container.getGraphicsAlgorithm().getWidth();
		container.getGraphicsAlgorithm().setWidth(oldWidth + 200);
		//TODO move ports
	}

	//if two input shapes overlap, the second shape is replaced
		public void orderShapes(Shape containerShape1, Shape containerShape2) {
			int x1 = containerShape1.getGraphicsAlgorithm().getX();
			int y1 = containerShape1.getGraphicsAlgorithm().getY();
			int x2 = containerShape2.getGraphicsAlgorithm().getX();
			int y2 = containerShape2.getGraphicsAlgorithm().getY();
			int width1 = containerShape1.getGraphicsAlgorithm().getWidth();
			int height1 = containerShape1.getGraphicsAlgorithm().getHeight();
			int width2 = containerShape2.getGraphicsAlgorithm().getWidth();
			int height2 = containerShape2.getGraphicsAlgorithm().getHeight();
			//if width and height of two shapes are overlapping the shapes are overlapping, find new position for shape2
			if(isOverlapping(x1, x2, width1, width2) & isOverlapping(y1, y2, height1, height2)) {
				if(containerShape2.getLink().getBusinessObjects().get(0) instanceof Ports) {
					//TODO enlarge outer container
					return;
				}
				int newXPosition;
				int newYPosition;
				IGaService gaService = Graphiti.getGaService();
				if(x1 < x2) {
					if(y1 < y2) {
						if(x2 + width2 > x1 + width1) {//move to the right
							newXPosition = x1 + width1 + 10;
							newYPosition = y2;
						} else {//move down
							newXPosition = x2;
							newYPosition = y1 + height1 + 10;
						}
					} else {//move up
						newXPosition = x2;
						newYPosition = y1 - height2 - 10;
					}
				} else {//move left
						newXPosition = x1 - width2 - 10;
						newYPosition = y2;
				}
				gaService.setLocation(containerShape2.getGraphicsAlgorithm(), newXPosition, newYPosition);
				/*for(Shape shape : containerShape1.getContainer().getChildren()) {
					orderShapes(containerShape2, shape);
				}*/
			}
		}

	
	
	private boolean isOverlapping(int start1, int start2, int length1, int length2) {
		if(start1 < start2) {
			if(start1 + length1 < start2) {
				return false;
			} else {
				
				return true;
			}
		}else {
			if(start1 < start2 + length2) {
				return true;
			} else {
				return false;
			}
		}
	}
}
