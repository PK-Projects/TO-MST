package com.pk_projects.to_mst;

import com.pk_projects.to_mst.algorithm.KruskalMST;
import com.pk_projects.to_mst.algorithm.MST;
import com.pk_projects.to_mst.algorithm.PrimMST;
import com.pk_projects.to_mst.converter.GraphConverter;
import com.pk_projects.to_mst.converter.ImageGraphConverter;
import com.pk_projects.to_mst.converter.XMLGraphConverter;
import com.pk_projects.to_mst.factory.GraphFactory;
import com.pk_projects.to_mst.factory.XMLGraphFactory;
import com.pk_projects.to_mst.structure.Graph;

public class Main {

    public static void main(String[] args) {
        GraphFactory graphFactory = new XMLGraphFactory();
        GraphConverter imageGraphConverter = new ImageGraphConverter();
        GraphConverter xmlGraphConverter = new XMLGraphConverter();
        MST kruskalMST = new KruskalMST();
        MST primMST = new PrimMST();

        Graph graph = graphFactory.create();
        Graph primGraph = primMST.getMST(graph);
        Graph kruskalGraph = kruskalMST.getMST(graph);

        imageGraphConverter.convert(graph, "graph.png");
        imageGraphConverter.convert(primGraph, "graphPrim.png");
        imageGraphConverter.convert(kruskalGraph, "graphKruskal.png");

        xmlGraphConverter.convert(graph, "graph.xml");
        xmlGraphConverter.convert(primGraph, "graphPrim.xml");
        xmlGraphConverter.convert(kruskalGraph, "graphKruskal.xml");
    }
}
