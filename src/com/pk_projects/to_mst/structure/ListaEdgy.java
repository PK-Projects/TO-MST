package com.pk_projects.to_mst.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
class EdgeComparator implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		Edge a0 = (Edge) arg0;
		Edge a1 = (Edge) arg1;
		Double d = a0.getValue();
		double d2 = a1.getValue();
		return d.compareTo(d2);
		
	}
	
}
public class ListaEdgy {
	List<Edge> lista = new ArrayList<Edge>();

	
	public int addEdge(Edge edge){
		/*if(lista.isEmpty()){
			lista.add(edge);	
			System.out.println("dodaje pierwszy");
			return 1;
			
		}
		int i = 0;
		while (i < lista.size()){
			Edge temp = lista.get(i);
			if(temp.getValue() < edge.getValue()){
				if(i == lista.size() - 1){
					lista.add(edge);
					System.out.println("3");
					break;
				}
				i++;
				continue;
			}else {
				System.out.println("4");
				lista.add(i,edge);
				System.out.println("2");
				break;
			}
			
		}*/
		lista.add(edge);
	lista.sort(new EdgeComparator());
		return 1;
	}
	
	public Edge popFirst(){
		Edge temp = lista.get(0);
		lista.remove(0);
		return temp;
	}
	
	public Edge getFirst() {
		if(lista.isEmpty())
			return null;
		return lista.get(0);
	}

	
	
   

}
