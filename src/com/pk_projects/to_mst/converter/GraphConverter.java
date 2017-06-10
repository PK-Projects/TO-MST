package com.pk_projects.to_mst.converter;

import com.pk_projects.to_mst.structure.Graph;

import java.io.File;

abstract class GraphConverter {
    protected Graph graph;

    GraphConverter(Graph graph) {
        this.graph = graph;
    }

    abstract void getConverted(String name);
}
