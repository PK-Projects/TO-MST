package com.pk_projects.to_mst.converter;

import com.pk_projects.to_mst.structure.Graph;

import java.io.File;

public interface GraphConverter {
    File convert(Graph graph, String path);
}
