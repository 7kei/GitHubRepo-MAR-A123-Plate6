/* 3. Write a java program that will determine if a graph has a cycle or not. */

package com.keianmar.ds2.Plate6;

import java.util.*;
import com.keianmar.ds2.Common.*;

public class Problem3 {
    private static boolean depthFirstSearch(Vertex startVertex_Mar, Vertex parentVertex_Mar) {
        startVertex_Mar.setVisited(true);

        for (Vertex neighbor_Mar : startVertex_Mar.getAdjacentVertices()) {
            if (!neighbor_Mar.isVisited()) { 
                if (depthFirstSearch(neighbor_Mar, startVertex_Mar)) return true;
            } else if (neighbor_Mar != parentVertex_Mar) return true;
        }
        
        return false;
    }

    public static boolean hasCycle(Graph inputGraph_Mar) {
        for (Vertex vertex : inputGraph_Mar.getGraphVertices()) {
            if (!vertex.isVisited()) {
                if (depthFirstSearch(vertex, null)) return true;
            }
        } 
        return false;
    }

    public static void main(Scanner scanner_Mar) {
        System.out.println("\n Problem 3 -- Created by Keian Mar \n");

        System.out.println("Enter the edges of the graph as pairs of vertices, e.g. 'ab,cd,de,ea'.");
        Graph graph_Mar = new Graph();
        graph_Mar.graphFromEdgeList(scanner_Mar.nextLine().split(","), false);

        if (hasCycle(graph_Mar)) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}
