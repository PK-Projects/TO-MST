package com.pk_projects.to_mst.converter;

import com.pk_projects.to_mst.structure.Graph;

import java.io.File;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

public class XMLGraphConverter extends GraphConverter {


    private Graph graph;
    private Document dom;
    private Element e = null;

    public XMLGraphConverter(Graph graph) {
        super(graph);
	this.graph = graph;
    }

    @Override
    public void getConverted(String name) {
	Element e = null;
    	try {
    		DocumentBuilderFactory dbFactory =
    		DocumentBuilderFactory.newInstance();
    		DocumentBuilder dBuilder = 
    		            dbFactory.newDocumentBuilder();
    		
    		Document doc = dBuilder.newDocument();
    		
    		// root element
    		Element rootElement = doc.createElement("graph");
    		doc.appendChild(rootElement);
    		
    		// nodes element
    		Element nodes = doc.createElement("nodes");
    		rootElement.appendChild(nodes);
    		
    		//loop to write node items
    		for(Node n : graf.getNodes()) {
            	Element node = doc.createElement("node");
            	nodes.appendChild(node);
                
            	Attr attr = doc.createAttribute("name");
                attr.setValue("node" + n.getName() );
                node.setAttributeNode(attr);
                
                attr = doc.createAttribute("x");
                attr.setValue(Double.toString(n.getVector().getX()));
                node.setAttributeNode(attr);
                
                attr = doc.createAttribute("y");
                attr.setValue(Double.toString(n.getVector().getY()));
                node.setAttributeNode(attr);
                
            }
    		
    		// edges element
    		Element edges = doc.createElement("edges");
    		rootElement.appendChild(edges);
    		
    		
    		// loop to write edge items
    		for(Edge edg : graf.getEdges()) {
            	Element node = doc.createElement("edge");
            	edges.appendChild(node);
                
            	Attr attr = doc.createAttribute("node1");
                attr.setValue("node" + edg.getNode1().getName());
                node.setAttributeNode(attr);
                
                attr = doc.createAttribute("node2");
                attr.setValue("node" + edg.getNode2().getName());
                node.setAttributeNode(attr);
            
                attr = doc.createAttribute("value");
                attr.setValue(Double.toString(edg.getValue()));
                node.setAttributeNode(attr);
                
            }
    		
    		//saving to xml
            TransformerFactory transformerFactory =
            TransformerFactory.newInstance();
            Transformer transformer =
            transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
	    String pathName = name + ".xml";
            StreamResult result =
            		new StreamResult(new File(pathName));
            transformer.transform(source, result);
                    
            
        } catch (Exception pce) {
            System.out.println( pce);
        }
    }
}
