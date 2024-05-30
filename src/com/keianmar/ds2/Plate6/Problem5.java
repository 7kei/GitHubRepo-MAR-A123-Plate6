/* 5. Write a java program that receives a list of edges of a simple graph and determine whether the graph is bipartite. */

package com.keianmar.ds2.Plate6;

import java.util.*;
import com.keianmar.ds2.Common.*;

public class Problem5 {
    private static boolean depthFirstSearch(Vertex startVertex_Mar, int color_Mar) {
        startVertex_Mar.setVisited(true);
        startVertex_Mar.setColor(color_Mar);

        for (Vertex neighborVertex_Mar : startVertex_Mar.getAdjacentVertices()) {
            if (!neighborVertex_Mar.isVisited()) {
                if (!depthFirstSearch(neighborVertex_Mar, 1 - color_Mar)) {
                    return false;
                }
            } else if (neighborVertex_Mar.getColor() == color_Mar) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBipartite(Graph inputGraph_Mar) {
        for (Vertex vertex_Mar : inputGraph_Mar.getGraphVertices()) {
            if (!vertex_Mar.isVisited()) {
                if (!depthFirstSearch(vertex_Mar, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(Scanner scanner_Mar) {
        System.out.println("\n Problem 5 -- Created by Keian Mar \n");

        System.out.println("Enter the edges of the graph as pairs of vertices, e.g. 'ab,bc,cd,da'.");
        Graph graph_Mar = new Graph();
        graph_Mar.graphFromEdgeList(scanner_Mar.nextLine().split(","), false);

        if (isBipartite(graph_Mar)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}

