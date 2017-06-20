package com.pk_projects.to_mst.algorithm;

import com.pk_projects.to_mst.structure.*;

import java.util.Comparator;
import java.util.List;

public class PrimMST implements MST{
    @Overrid
    public Graph getMST(Graph graph) {
    	int numberOfNodes = graph.getNumberOfNodes();
    	
    	ListaEdgy edgesPriorityQueue = new ListaEdgy();
    	
    	boolean[] visitedEdge = new boolean[numberOfNodes];
    	
    	Graph returnedGraph = new Graph();
    	
    	Node v = graph.getFirstNode();
    	
    	visitedEdge[v.getNodeNameValue()] = true;
    	
    	for(int i = 0; i < numberOfNodes-1; i++) {
    		List<Node> allNodeNeighbor = graph.getAllNeighborNode(v);
    		for( Node node : allNodeNeighbor) {           
                    //edgesPriorityQueue.addEdge(new Edge(new Node("0", null), new Node("0", null), -1));
    			if(visitedEdge[node.getNodeNameValue()] == false ) {
    				edgesPriorityQueue.addEdge(graph.getEdgeByNodes(node, v));
    			}
            }
                
                try{
                Edge e = edgesPriorityQueue.popFirst();
                        
              Boolean v2= visitedEdge[e.getNode2().getNodeNameValue()] == true;
              Boolean v1 = visitedEdge[e.getNode1().getNodeNameValue()] == true;
              
              while(v1&&v2) {
            	  //System.out.println(i + "!" + edgesPriorityQueue.lista.size());
                    e = edgesPriorityQueue.popFirst();
                    v2= visitedEdge[e.getNode2().getNodeNameValue()] == true;
                    v1 = visitedEdge[e.getNode1().getNodeNameValue()] == true;
                }
                
              
                returnedGraph.addElement(e.getNode1(), e.getNode2(), e.getValue());
                if(!v2)    {    
                visitedEdge[e.getNode2().getNodeNameValue()] = true;
                 
                        v = e.getNode2();}else{
                        	 visitedEdge[e.getNode1().getNodeNameValue()] = true;
                             
                             v = e.getNode1();
                        }
                }catch (Exception e){
                	
                }
    		
    	}
    	
    	return returnedGraph;
    }
}


class EdgesComparator implements Comparator<Edge>
{
    @Override
    public int compare(Edge a, Edge b)
    {

        if (a.getValue() < b.getValue())
        {
            return -1;
        }
        if (a.getValue() >= b.getValue())
        {
            return 1;
        }
        return 0;
    }
}