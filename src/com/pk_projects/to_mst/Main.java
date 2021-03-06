package com.pk_projects.to_mst;

import com.pk_projects.to_mst.algorithm.KruskalMST;
import com.pk_projects.to_mst.algorithm.MST;
import com.pk_projects.to_mst.algorithm.PrimMST;
import com.pk_projects.to_mst.converter.ImageGraphConverter;
import com.pk_projects.to_mst.converter.XMLGraphConverter;
import com.pk_projects.to_mst.factory.GraphFactory;
import com.pk_projects.to_mst.structure.Graph;

public class Main {

    public static void main(String[] args) {
        GraphFactory graphFactory = new GraphFactory();
        ImageGraphConverter imageGraphConverter;
        XMLGraphConverter xmlGraphConverter;
        MST kruskalMST = new KruskalMST();
        MST primMST = new PrimMST();

        Graph graph = graphFactory.create();
        imageGraphConverter = new ImageGraphConverter(graph);
        xmlGraphConverter = new XMLGraphConverter(graph);
        imageGraphConverter.getConverted("Graph");
        xmlGraphConverter.getConverted("Graph.xml");

        Graph primGraph = primMST.getMST(graph);
        imageGraphConverter = new ImageGraphConverter(primGraph);
        xmlGraphConverter = new XMLGraphConverter(primGraph);
//        imageGraphConverter.getConverted("Prim Graph");
        xmlGraphConverter.getConverted("Prim Graph.xml");

        Graph kruskalGraph = kruskalMST.getMST(graph);
        imageGraphConverter = new ImageGraphConverter(kruskalGraph);
        xmlGraphConverter = new XMLGraphConverter(kruskalGraph);
        imageGraphConverter.getConverted("Kruskal Graph");
        xmlGraphConverter.getConverted("Kruskal Graph.xml");

        System.out.println(graph);
        System.out.println(primGraph);
        System.out.println(kruskalGraph);
    }
}
