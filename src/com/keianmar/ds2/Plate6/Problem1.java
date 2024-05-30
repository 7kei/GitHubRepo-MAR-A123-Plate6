/* 1. Write a java program that receives a list of edges of a simple graph, the program should determine 
whether it is connected and find the number of connected components if it is not connected. */

package com.keianmar.ds2.Plate6;

import java.util.*;
import com.keianmar.ds2.Common.*;

public class Problem1 {
    private static void depthFirstSearch(Vertex startVertex_Mar) {
        startVertex_Mar.setVisited(true);
        
        for (Vertex neighborVertex_Mar : startVertex_Mar.getAdjacentVertices()) {
            if (!neighborVertex_Mar.isVisited()) { depthFirstSearch(neighborVertex_Mar); }
        }
    }

    private static int[] isConnected(Graph inputGraph_Mar) {
        int connectedComponents_Mar = 0; 
        int isolatedVertices_Mar = 0;
        for (Vertex vertex_Mar: inputGraph_Mar.getGraphVertices()) {
            if (!vertex_Mar.isVisited()) { // if a vertex has not been visited
                depthFirstSearch(vertex_Mar);
                connectedComponents_Mar++;
            }
            if (vertex_Mar.getAdjacentVertices().isEmpty()) { isolatedVertices_Mar++; }
        }
        int[] result_Mar = {connectedComponents_Mar, isolatedVertices_Mar};
        return result_Mar;
    } 

    public static void main(Scanner scanner_Mar) {
        System.out.println("\n Problem 1 -- Created by Keian Mar \n");
        System.out.println("Enter the edges of the graph as pairs of vertices, e.g. 'ab,cd,de,ea'.");
        Graph graph_Mar = new Graph();
        graph_Mar.graphFromEdgeList(scanner_Mar.nextLine().split(","), false);

        int[] result_Mar = isConnected(graph_Mar);
        if (result_Mar[0] == 1) System.out.println("The graph is connected.");
        else System.out.println("The graph has " + result_Mar[0] + " connected components and " + result_Mar[1] + " isolated vertices.");
    }
}
