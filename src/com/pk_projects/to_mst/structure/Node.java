package com.pk_projects.to_mst.structure;

public class Node {
    private String name;
    private Vector vector;

    public Node(String name, Vector vector) {
        this.name = name;
        this.vector = vector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    @Override
    public String toString() {
        return "{'" + name + "', " + vector + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        return name.equals(node.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public int getNodeNameValue() {
    	return Integer.parseInt(name);   
    }
}
