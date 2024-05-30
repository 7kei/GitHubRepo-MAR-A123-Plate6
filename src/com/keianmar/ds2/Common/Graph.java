package com.keianmar.ds2.Common;

import java.util.*;

public class Graph {
    private List<Vertex> graphVertices;

    public Graph() { this.graphVertices = new ArrayList<>(); }
    public List<Vertex> getGraphVertices() { return this.graphVertices; }

    public void graphFromEdgeList(String[] edgeList, boolean isDirected) {
        for (String vertexPair : edgeList) {
            String a = vertexPair.substring(0, 1);
            String b = vertexPair.substring(1);
            
            Vertex xLeft = findOrCreateVertex(a);

            if (b != "") {
                Vertex xRight = findOrCreateVertex(b);
                xLeft.getAdjacentVertices().add(xRight);
                if (!isDirected && a != b) {
                    xRight.getAdjacentVertices().add(xLeft);
                }
            }
        }
    }

    public void undirectedGraphFromAdjacencyMatrix(String[] labels, int[][] adjacencyMatrix) {
        int numVertices = adjacencyMatrix.length;

        for (int i = 0; i < numVertices; i++) {
            Vertex vertex = new Vertex(labels[i]);
            this.graphVertices.add(vertex);
        }

        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    Vertex source = this.graphVertices.get(i);
                    Vertex target = this.graphVertices.get(j);
                    source.getAdjacentVertices().add(target);
                    target.getAdjacentVertices().add(source);
                }
            }
        }
    }

    private Vertex findOrCreateVertex(String name) {
        for (Vertex v : graphVertices) {
            if (v.getName().equals(name)) { return v; }
        }

        Vertex newVertex = new Vertex(name);
        graphVertices.add(newVertex);
        return newVertex;
    }
}
