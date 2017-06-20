package com.pk_projects.to_mst.converter;

import com.pk_projects.to_mst.structure.Edge;
import com.pk_projects.to_mst.structure.Graph;
import com.pk_projects.to_mst.structure.Node;
import org.graphstream.algorithm.ConnectedComponents;
import org.graphstream.graph.implementations.DefaultGraph;

import java.util.List;

public class ImageGraphConverter extends GraphConverter {

    public ImageGraphConverter(Graph graph) {
        super(graph);
    }

    @Override
    public void getConverted(String name) {
        DefaultGraph graphToPaint = new DefaultGraph(name);
        prepareNodes(graphToPaint);
        prepareEdges(graphToPaint);

        ConnectedComponents cc = new ConnectedComponents();
        cc.init(graphToPaint);

        String styleSheet = "node {"
                + "	size: 30px; shape: box; fill-color: #444, red;  text-color:red; text-background-color: green; text-size:16;"
                + "}" + "node:clicked {" + "	fill-color: green;" + "}" + "edge {" + "	size: 2px;"
                + "	fill-color: red, yellow, green, #444;"
                + "	fill-mode: dyn-plain; text-alignment: along; text-background-color: green; text-size:16;" + "}"
                + "graph{" + " fill-color: white; " + "}";
        graphToPaint.addAttribute("ui.stylesheet", styleSheet);
        graphToPaint.addAttribute("ui.quality");
        graphToPaint.addAttribute("ui.antialias");
        graphToPaint.display();
    }

    /**
     * Zczytuje wierzcholki i dodaje je do grafu
     *
     * @param graphToPaint
     */
    private void prepareNodes(DefaultGraph graphToPaint) {
        List<Node> nodesList = graph.getNodes();
        for (Node aNodesList : nodesList) {
            graphToPaint.addNode(aNodesList.getName()).setAttribute("ui.label", aNodesList.getName());
        }
    }

    /**
     * Zczytuje krawedzie i dodaje je do grafu
     *
     * @para graphToPaint
     */
    private void prepareEdges(DefaultGraph graphToPaint) {
        List<Edge> edgesList = graph.getEdges();
        for (Edge temp : edgesList) {
            graphToPaint.addEdge(temp.getNode1().getName() + temp.getNode2().getName(), temp.getNode1().getName(),
                    temp.getNode2().getName()).setAttribute("ui.label", temp.getValue());
        }
    }

}
