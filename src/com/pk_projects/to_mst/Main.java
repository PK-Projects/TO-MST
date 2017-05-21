package com.pk_projects.to_mst;

import com.pk_projects.to_mst.converter.GraphConverter;
import com.pk_projects.to_mst.converter.ImageGraphConverter;
import com.pk_projects.to_mst.converter.XMLGraphConverter;
import com.pk_projects.to_mst.factory.GraphFactory;
import com.pk_projects.to_mst.factory.XMLGraphFactory;
import com.pk_projects.to_mst.structure.Graph;

public class Main {

    public static void main(String[] args) {
        GraphFactory graphFactory = new XMLGraphFactory();
        GraphConverter imageGraphConverter = new ImageGraphConverter();
        GraphConverter xmlGraphConverter = new XMLGraphConverter();

        Graph graph = graphFactory.create();

        System.out.println(graph);
    }
}
