package com.pk_projects.to_mst.structure;

public class Edge {
    Node node1, node2;
    double value;

    public Edge(Node node1, Node node2, double value) {
        this.node1 = node1;
        this.node2 = node2;
        this.value = value;
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Edge{" + node1 + ", " + node2 + ", " + value + '}';
    }
}
