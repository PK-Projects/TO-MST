package com.pk_projects.to_mst.factory;

import com.pk_projects.to_mst.structure.Graph;
import com.pk_projects.to_mst.structure.Node;
import com.pk_projects.to_mst.structure.Vector;

public class GraphFactory {

    public Graph createFromXml(String filePath) {
        Graph graph = new Graph();

        return graph;
    }

    public Graph create() {
    	Graph graph = new Graph();
        Node n = new Node("node1", new Vector(0, 0));
        Node n2 = new Node("node2", new Vector(1, 0));
        Node n3 = new Node("node3", new Vector(2, 2));
        Node n4 = new Node("node4", new Vector(3, 3));
        Node n5 = new Node("node5", new Vector(4, 4));
        graph.addElement(n);
        graph.addElement(n2, n3, 4);
        graph.addElement(n, n4, 1);
        graph.addElement(n,n5,10);
        graph.addElement(n2,n5,12);
        graph.addElement(n2,n4,6);
        graph.addElement(n3,n4,6);
        return graph;
    }
}
