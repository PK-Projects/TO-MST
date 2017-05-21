package com.pk_projects.to_mst.structure;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> nodes;
    private List<Edge> edges;

    public Graph() {
        nodes = new ArrayList<Node>();
        edges = new ArrayList<Edge>();
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addElement(Node node1, Node node2, double value) {
        if (!nodes.contains(node1)) {
            nodes.add(node1);
        }
        if (!nodes.contains(node2)) {
            nodes.add(node2);
        }
        edges.add(new Edge(node1, node2, value));
    }

    public void addElement(Node node) {
        if (!nodes.contains(node)) {
            nodes.add(node);
        }
    }

    public List<Edge> getEdgesBeginInNode(Node node){
        List<Edge> result = new ArrayList<Edge>();
        for (Edge edge : edges) {
            if (node.equals(edge.getNode1())) {
                result.add(edge);
            }
        }

        return result;
    }

    public List<Edge> getEdgesEndInNode(Node node){
        List<Edge> result = new ArrayList<Edge>();
        for (Edge edge : edges) {
            if (node.equals(edge.getNode2())) {
                result.add(edge);
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "Graph{" + "nodes=" + nodes + ", edges=" + edges + '}';
    }
}
