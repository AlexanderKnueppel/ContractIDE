package de.tu_bs.ccc.contracting.core.features.layout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.graph.CompoundDirectedGraph;
import org.eclipse.draw2d.graph.CompoundDirectedGraphLayout;
import org.eclipse.draw2d.graph.Edge;
import org.eclipse.draw2d.graph.EdgeList;
import org.eclipse.draw2d.graph.Node;
import org.eclipse.draw2d.graph.NodeList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.ui.services.IUiLayoutService;

import de.tu_bs.ccc.contracting.Verification.Abstract;
import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.System;

public class LayoutDiagramFeature extends AbstractCustomFeature {

	private static final int PADDING = 30; // min. distance between components
	private static final int PORT_PADDING = 20; // min. distance between components
	private static final int HEADER_PADDING_VER = 20; // min. distance between components
	private static final int HEADER_PADDING_HOR = 20; // min. distance between components

	public LayoutDiagramFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getDescription() {
		return "Layout diagram";
	}

	@Override
	public String getName() {
		return "&Layout Diagram";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		execute(getDiagram());
	}
	
	public void execute(Module m) {
		PictogramElement pe = getFeatureProvider().getPictogramElementForBusinessObject(m);
		if (m instanceof Compound) {
			layoutCompound((ContainerShape) pe);
		} else if (m instanceof Component || m instanceof Abstract) {
			layoutAtomic((ContainerShape) pe);
		} 
	}

	public void execute(Diagram d) {
		ContainerShape cs = null;
		for (Shape shape : d.getChildren()) {
			if (shape.getLink().getBusinessObjects().get(0) instanceof Compound) {
				layoutCompound((ContainerShape) shape);
				cs = (ContainerShape) shape;
			} else if (shape.getLink().getBusinessObjects().get(0) instanceof Component
					   || shape.getLink().getBusinessObjects().get(0) instanceof Abstract) {
				layoutAtomic((ContainerShape) shape);
				cs = (ContainerShape) shape;
			} else if (shape.getLink().getBusinessObjects().get(0) instanceof System) {
				layoutCompound((ContainerShape) shape);
				cs = (ContainerShape) shape;
			}
		}
		// Layout contracts
		if (cs != null) {
			List<Shape> contracts = d.getChildren().stream()
					.filter(s -> s.getLink().getBusinessObjects().get(0) instanceof Contract)
					.collect(Collectors.toList());
			int padding_x = 30, padding_y = 30;
			int y = cs.getGraphicsAlgorithm().getHeight() / 2 + cs.getGraphicsAlgorithm().getY() - contracts.stream()
					.mapToInt(s -> s.getGraphicsAlgorithm().getHeight() + padding_y).reduce(0, Integer::sum) / 2;
			
			for (Shape shape : contracts) {
				shape.getGraphicsAlgorithm().setY(y);
				shape.getGraphicsAlgorithm()
						.setX(cs.getGraphicsAlgorithm().getX() + cs.getGraphicsAlgorithm().getWidth() + padding_x);
				y += shape.getGraphicsAlgorithm().getHeight() + padding_y;
			}
		}

	}

	public void layoutCompound(ContainerShape compound) {
		List<Shape> inputs = new ArrayList<Shape>();
		List<Shape> outputs = new ArrayList<Shape>();
		Shape headline = null, polyline = null;

		for (Shape shape : compound.getChildren()) {
			if (shape instanceof ContainerShape && shape.getLink().getBusinessObjects().get(0) instanceof Ports) {
				layoutPort((ContainerShape) shape);
			} else if (shape instanceof ContainerShape
					&& (shape.getLink().getBusinessObjects().get(0) instanceof Component
							|| shape.getLink().getBusinessObjects().get(0) instanceof Compound
							|| shape.getLink().getBusinessObjects().get(0) instanceof Abstract)) {
				layoutAtomic((ContainerShape) shape);
			}

			if (shape instanceof ContainerShape && shape.getLink().getBusinessObjects().get(0) instanceof Ports) {
				layoutPort((ContainerShape) shape);
				if (((Ports) shape.getLink().getBusinessObjects().get(0)).getOuterDirection() == DirectionType.INTERNAL)
					inputs.add(shape);
				else
					outputs.add(shape);
			} else if (shape.getGraphicsAlgorithm() instanceof Text) {
				headline = shape;
			} else if (shape.getGraphicsAlgorithm() instanceof Polyline) {
				polyline = shape;
			}
		}

		final CompoundDirectedGraph graph = mapCompoundToGraph(compound);
		graph.setDefaultPadding(new Insets(PADDING));
		graph.setDirection(PositionConstants.EAST);
		new CompoundDirectedGraphLayout().visit(graph);
		mapGraphCoordinatesToCompound(graph);

		// Position ports and resize compound
		GraphicsAlgorithm ga_component = compound.getGraphicsAlgorithm();

		// Calculate width
		ga_component.setWidth(inputs.stream().mapToInt(i -> i.getGraphicsAlgorithm().getWidth()).reduce(0, Integer::max)
				+ outputs.stream().mapToInt(o -> o.getGraphicsAlgorithm().getWidth()).reduce(0, Integer::max)
				+ PORT_PADDING);
		ga_component.setWidth(Math.max(graph.getLayoutSize().width + PORT_PADDING, ga_component.getWidth()));

		// Calculate height
		int h1 = inputs.stream().mapToInt(i -> i.getGraphicsAlgorithm().getHeight()).reduce(0, Integer::sum)
				+ (PORT_PADDING + 1) * inputs.size();
		int h2 = outputs.stream().mapToInt(o -> o.getGraphicsAlgorithm().getHeight()).reduce(0, Integer::sum)
				+ (PORT_PADDING + 1) * outputs.size();
		ga_component.setHeight(PORT_PADDING + HEADER_PADDING_VER + Math.max(h1, h2));
		int maxheight = compound.getChildren().stream()
				.mapToInt(s -> s.getGraphicsAlgorithm().getY() + s.getGraphicsAlgorithm().getHeight())
				.reduce(0, Integer::max) + HEADER_PADDING_VER; // TODO different padding?
		ga_component.setHeight(Math.max(maxheight, ga_component.getHeight()));

		positionPortsAndHeadline(inputs, outputs, headline, polyline, ga_component);
	}

	private CompoundDirectedGraph mapCompoundToGraph(ContainerShape c) {
		Map<AnchorContainer, Node> shapeToNode = new HashMap<AnchorContainer, Node>();
		CompoundDirectedGraph dg = new CompoundDirectedGraph();
		EdgeList edgeList = new EdgeList();
		NodeList nodeList = new NodeList();
		for (Shape shape : c.getChildren()) {
			if (shape instanceof ContainerShape && (shape.getLink().getBusinessObjects().get(0) instanceof Ports
					|| shape.getLink().getBusinessObjects().get(0) instanceof Component
					|| shape.getLink().getBusinessObjects().get(0) instanceof Compound
					|| shape.getLink().getBusinessObjects().get(0) instanceof Abstract)) {
				Node node = new Node();
				GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
				node.x = ga.getX();
				node.y = ga.getY();
				node.width = ga.getWidth();
				node.height = ga.getHeight();
				node.data = shape;
				shapeToNode.put(shape, node);
				nodeList.add(node);
			}
		}
		EList<Connection> connections = ((Diagram) c.getContainer()).getConnections();
		for (Connection connection : connections.stream()
				.filter(con -> con.getStart().getParent().getLink().getBusinessObjects().get(0) instanceof Ports)
				.collect(Collectors.toList())) {
			AnchorContainer source = connection.getStart().getParent();
			AnchorContainer target = connection.getEnd().getParent();

			Node s = null, t = null;
			if (shapeToNode.containsKey(source)) {
				s = shapeToNode.get(source);
			} else {
				s = shapeToNode.get(source.eContainer());
			}
			if (shapeToNode.containsKey(target)) {
				t = shapeToNode.get(target);
			} else {
				t = shapeToNode.get(target.eContainer());
			}

			Edge edge = new Edge(s, t);
			edge.data = connection;
			edgeList.add(edge);
		}
		dg.nodes = nodeList;
		dg.edges = edgeList;
		return dg;
	}

	private Diagram mapGraphCoordinatesToCompound(CompoundDirectedGraph graph) {
		NodeList myNodes = new NodeList();
		myNodes.addAll(graph.nodes);
		myNodes.addAll(graph.subgraphs);
		for (Object object : myNodes) {
			Node node = (Node) object;
			Shape shape = (Shape) node.data;

			shape.getGraphicsAlgorithm().setX(node.x);
			shape.getGraphicsAlgorithm().setY(node.y);
			// shape.getGraphicsAlgorithm().setWidth(node.width);
			// shape.getGraphicsAlgorithm().setHeight(node.height);
			shape.getGraphicsAlgorithm().setWidth(shape.getGraphicsAlgorithm().getWidth());
			shape.getGraphicsAlgorithm().setHeight(shape.getGraphicsAlgorithm().getHeight());
		}
		return null;
	}

	public void layoutPort(ContainerShape port) {
		// TODO
		LayoutContext lfc = new LayoutContext(port.getGraphicsAlgorithm().getPictogramElement());
		getFeatureProvider().layoutIfPossible(lfc);
	}

	public void layoutAtomic(ContainerShape atomic) {
		List<Shape> inputs = new ArrayList<Shape>();
		List<Shape> outputs = new ArrayList<Shape>();
		Shape headline = null, polyline = null;

		for (Shape shape : atomic.getChildren()) {
			if (shape instanceof ContainerShape && shape.getLink().getBusinessObjects().get(0) instanceof Ports) {
				layoutPort((ContainerShape) shape);
				if (((Ports) shape.getLink().getBusinessObjects().get(0)).getOuterDirection() == DirectionType.INTERNAL)
					inputs.add(shape);
				else
					outputs.add(shape);
			} else if (shape.getGraphicsAlgorithm() instanceof Text) {
				headline = shape;
			} else if (shape.getGraphicsAlgorithm() instanceof Polyline) {
				polyline = shape;
			}
		}

		GraphicsAlgorithm ga_component = atomic.getGraphicsAlgorithm();

		// Calculate width
		ga_component.setWidth(inputs.stream().mapToInt(i -> i.getGraphicsAlgorithm().getWidth()).reduce(0, Integer::max)
				+ outputs.stream().mapToInt(o -> o.getGraphicsAlgorithm().getWidth()).reduce(0, Integer::max)
				+ PORT_PADDING);

		// Calculate height
		int h1 = inputs.stream().mapToInt(i -> i.getGraphicsAlgorithm().getHeight()).reduce(0, Integer::sum)
				+ (PORT_PADDING + 1) * inputs.size();
		int h2 = outputs.stream().mapToInt(o -> o.getGraphicsAlgorithm().getHeight()).reduce(0, Integer::sum)
				+ (PORT_PADDING + 1) * outputs.size();
		ga_component.setHeight(PORT_PADDING + HEADER_PADDING_VER + Math.max(h1, h2));

		positionPortsAndHeadline(inputs, outputs, headline, polyline, ga_component);
	}

	private void positionPortsAndHeadline(List<Shape> inputs, List<Shape> outputs, Shape headline, Shape polyline,
			GraphicsAlgorithm ga_component) {

		// Header??
		if (headline != null) {
			GraphicsAlgorithm graphicsAlgorithm = headline.getGraphicsAlgorithm();
			IUiLayoutService uil = GraphitiUi.getUiLayoutService();
			IDimension size = uil.calculateTextSize(((Text) graphicsAlgorithm).getValue(),
					((Text) graphicsAlgorithm).getFont());

			ga_component.setWidth(Math.max(size.getWidth() + 2 * HEADER_PADDING_HOR, ga_component.getWidth()));
			graphicsAlgorithm.setWidth(ga_component.getWidth());
		}

		// Move ports
		int y = HEADER_PADDING_VER + PORT_PADDING;
		for (Shape in : inputs) {
			GraphicsAlgorithm ga = in.getGraphicsAlgorithm();
			ga.setX(0);
			ga.setY(y);
			y += ga.getHeight() + PORT_PADDING;
		}
		y = HEADER_PADDING_VER + PORT_PADDING;
		for (Shape out : outputs) {
			GraphicsAlgorithm ga = out.getGraphicsAlgorithm();
			ga.setX(ga_component.getWidth() - ga.getWidth());
			ga.setY(y);
			y += ga.getHeight() + PORT_PADDING;
		}

		// Update Polyline
		Polyline p = (Polyline) polyline.getGraphicsAlgorithm();
		Point secondPoint = p.getPoints().get(1);
		Point newSecondPoint = Graphiti.getGaService().createPoint(ga_component.getWidth(), secondPoint.getY());
		p.getPoints().set(1, newSecondPoint);
	}
}
