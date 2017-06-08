package com.pk_projects.to_mst.paint;

import java.util.List;

import org.graphstream.algorithm.ConnectedComponents;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.DefaultGraph;

import com.pk_projects.to_mst.structure.Edge;
import com.pk_projects.to_mst.structure.Node;

/**
 * Klasa odpowiedzialan za rysowanie grafu. Wykorzystujê zewnêtrzn¹ bibliotekê
 * GraphStream
 * 
 * @see: http://graphstream-project.org/
 *
 */
public class PaintGraph {

	// style css dla grafu
	protected String styleSheet = "node {"
			+ "	size: 30px; shape: box; fill-color: #444, red;  text-color:red; text-background-color: green; text-size:16;"
			+ "}" + "node:clicked {" + "	fill-color: green;" + "}" + "edge {" + "	size: 2px;"
			+ "	fill-color: red, yellow, green, #444;"
			+ "	fill-mode: dyn-plain; text-alignment: along; text-background-color: green; text-size:16;" + "}"
			+ "graph{" + " fill-color: white; " + "}";

	private com.pk_projects.to_mst.structure.Graph graph;
	private List<Node> nodesList;
	private List<Edge> edgesList;

	public PaintGraph(com.pk_projects.to_mst.structure.Graph graph) {
		this.graph = graph;
	}

	/**
	 * Metoda genrujê graf
	 * 
	 * @param namgeGraph
	 */
	public void drawGraph(String namgeGraph) {

		Graph graphToPaint = new DefaultGraph(namgeGraph);
		preapareNodes(graphToPaint);
		preapareEdges(graphToPaint);

		ConnectedComponents cc = new ConnectedComponents();
		cc.init(graphToPaint);

		graphToPaint.addAttribute("ui.stylesheet", styleSheet);
		graphToPaint.addAttribute("ui.quality");
		graphToPaint.addAttribute("ui.antialias");
		graphToPaint.display();
	}

	/**
	 * Zczytuje wierzcho³ki i dodaje je do grafu
	 * 
	 * @param graphToPaint
	 */
	private void preapareNodes(Graph graphToPaint) {
		nodesList = graph.getNodes();
		for (int i = 0; i < nodesList.size(); i++) {
			graphToPaint.addNode(nodesList.get(i).getName()).setAttribute("ui.label", nodesList.get(i).getName());
		}
	}

	/**
	 * Zczytuje krawêdzie i dodaje je do grafu
	 * 
	 * @param graphToPaint
	 */
	private void preapareEdges(Graph graphToPaint) {
		edgesList = graph.getEdges();
		for (int i = 0; i < edgesList.size(); i++) {
			Edge temp = edgesList.get(i);
			graphToPaint.addEdge(temp.getNode1().getName() + temp.getNode2().getName(), temp.getNode1().getName(),
					temp.getNode2().getName()).setAttribute("ui.label", temp.getValue());
		}
	}

}
