package com.pk_projects.to_mst.algorithm;

import com.pk_projects.to_mst.structure.Edge;
import com.pk_projects.to_mst.structure.Graph;
import com.pk_projects.to_mst.structure.Node;

import java.util.*;
import java.lang.*;
import java.io.*;


public class KruskalMST implements MST{
    @Override
    public Graph getMST(Graph graph)
    {
        Graph newGraph = new Graph();
        List<Edge> edgesList = new ArrayList<Edge>();
        edgesList = graph.getEdges();
        Edge x;
        List<Node> nodes = new ArrayList<Node>();

        for(int i=0; i<graph.getEdges().size(); i++)
        {
            for (int j = 0; j < graph.getEdges().size() - 1; j++)
            {
                if (edgesList.get(j).getValue() > edgesList.get(j + 1).getValue())
                {
                    x = edgesList.get(j + 1);
                    edgesList.set(j + 1, edgesList.get(j));
                    edgesList.set(j, x);

                }
            }
        }

        for (Edge edge : edgesList)
        {
            if (nodes.size()>0 && !(nodes.contains(edge.getNode1()) && nodes.contains(edge.getNode2())))
            {
                newGraph.addElement(edge.getNode1(), edge.getNode2(), edge.getValue());
                nodes.add(edge.getNode1());
                nodes.add(edge.getNode2());
            }
            if (nodes.size() == 0)
            {
                newGraph.addElement(edge.getNode1(), edge.getNode2(), edge.getValue());
                nodes.add(edge.getNode1());
                nodes.add(edge.getNode2());
            }

        }
        return newGraph;
    }



}