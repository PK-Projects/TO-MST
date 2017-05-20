package com.pk_projects.to_mst;

import com.pk_projects.to_mst.structure.Graph;
import com.pk_projects.to_mst.structure.Node;
import com.pk_projects.to_mst.structure.Vector;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        Node n = new Node("node1", new Vector(0,0));
        Node n2 = new Node("node2", new Vector(1,0));
        Node n3 = new Node("node3", new Vector(2,2));
        Node n4 = new Node("node4", new Vector(3,3));
        graph.addElement(n);
        graph.addElement(n2, n3, 4);
        graph.addElement(n, n4, 1);

        System.out.println(graph);
    }
}
