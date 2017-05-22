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

        Graph graph = graphFactory.createFromXml("graph.xml");
        imageGraphConverter = new ImageGraphConverter(graph);
        xmlGraphConverter = new XMLGraphConverter(graph);
        imageGraphConverter.getFile();
        xmlGraphConverter.getFile();

        Graph primGraph = primMST.getMST(graph);
        imageGraphConverter = new ImageGraphConverter(primGraph);
        xmlGraphConverter = new XMLGraphConverter(primGraph);
        imageGraphConverter.getFile();
        xmlGraphConverter.getFile();

        Graph kruskalGraph = kruskalMST.getMST(graph);
        imageGraphConverter = new ImageGraphConverter(kruskalGraph);
        xmlGraphConverter = new XMLGraphConverter(kruskalGraph);
        imageGraphConverter.getFile();
        xmlGraphConverter.getFile();

        System.out.println(graph);
        System.out.println(primGraph);
        System.out.println(kruskalGraph);
    }
}
