package com.pk_projects.to_mst.structure;

public class Edge {
    private Node node1, node2;
    private double value;

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
        return "{" + node1 + ", " + node2 + ", " + value + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;

        Edge edge = (Edge) o;

        return Double.compare(edge.value, value) == 0 && node1.equals(edge.node1) && node2.equals(edge.node2);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = node1.hashCode();
        result = 31 * result + node2.hashCode();
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
