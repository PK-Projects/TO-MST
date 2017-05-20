package com.pk_projects.to_mst.structure;

import java.util.List;

public class Graph {
    private List<Node> nodes;
    private List<Edge> edges;

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Node node1, Node node2, double value){
        nodes.add(node1);
        nodes.add(node2);
        edges.add(new Edge(node1, node2, value));
    }

    public void addEdge(Node node1){
        nodes.add(node1);
    }
}
