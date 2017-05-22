package com.pk_projects.to_mst.converter;

import com.pk_projects.to_mst.structure.Graph;

import java.io.File;

public class XMLGraphConverter extends GraphConverter {

    public XMLGraphConverter(Graph graph) {
        super(graph);
    }

    @Override
    public File getFile() {
        return null;
    }
}
