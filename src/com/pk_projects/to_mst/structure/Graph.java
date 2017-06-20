package com.pk_projects.to_mst.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public List<Edge> getEdgesBeginInNode(Node node) {
        List<Edge> result = new ArrayList<Edge>();
        for (Edge edge : edges) {
            if (node.equals(edge.getNode1())) {
                result.add(edge);
            }
        }

        return result;
    }

    public List<Edge> getEdgesEndInNode(Node node) {
        List<Edge> result = new ArrayList<Edge>();
        for (Edge edge : edges) {
            if (node.equals(edge.getNode2())) {
                result.add(edge);
            }
        }

        return result;
    }

    public Node getNodeByName(String name) {
        for (Node node : nodes) {
            if (node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }
    
    public int getNumberOfNodes() {
    	return nodes.size();
    }
    
    public Node getFirstNode() {
    	return nodes.get(0);
    }
    
    public List<Edge> getAllNeighborEdgesConnectedToNode(Node node){
    	 List<Edge> beginEdges = getEdgesBeginInNode(node);
    	 List<Edge> endEdges = getEdgesEndInNode(node);
    	 
    	 List<Edge> result = new ArrayList<Edge>();
    	 result.addAll(beginEdges);
    	 result.addAll(endEdges);
    	 
    	 return result;
    }
    
    public List<Node> getAllNeighborNode(Node node) {
    	List<Node> result = new ArrayList<Node>();
    	List<Edge> connectedEdges = getAllNeighborEdgesConnectedToNode(node);
    	for(Edge edge : connectedEdges) {
    		if ( (!result.contains(edge.getNode1())) && (edge.getNode1().getName() != node.getName()) ) {
    			result.add(edge.getNode1());
    		}
    		if ( (!result.contains(edge.getNode2())) && (edge.getNode2().getName() != node.getName())   ) {
    			result.add(edge.getNode2());
    		}
    	}
    	
    	return result;
    }
    
    public Edge getEdgeByNodes(Node a, Node b) {
        for(Edge edge : edges) {
            if(Objects.equals(edge.getNode1().getName(), a.getName()) && Objects.equals(edge.getNode2().getName(), b.getName())) {
                return edge;
            } else if(Objects.equals(edge.getNode1().getName(), b.getName()) && Objects.equals(edge.getNode2().getName(), a.getName())) {
                return edge;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Graph{" + "nodes=" + nodes + ", edges=" + edges + '}';
    }
}
