/* 2. Write a java program that accepts an adjacency matrix of a graph. 
The program should list the edges of this graph and give the number of times each edge appears. */

package com.keianmar.ds2.Plate6;

import java.util.*;
import com.keianmar.ds2.Common.*;

public class Problem2 {

    private static Map<String, Integer> getEdges(Graph inputGraph_Mar) {
        Map<String, Integer> edgeFrequencies_Mar = new HashMap<>();
        for (Vertex vertex_Mar : inputGraph_Mar.getGraphVertices()) {
            for (Vertex neighbor_Mar : vertex_Mar.getAdjacentVertices()) {
                String edge_Mar = vertex_Mar.getName() + "-" + neighbor_Mar.getName();
                edgeFrequencies_Mar.put(edge_Mar, edgeFrequencies_Mar.getOrDefault(edge_Mar, 0) + 1);
            }
        }
        return edgeFrequencies_Mar;
    }

    public static void main(Scanner scanner_Mar) {
        System.out.println("\n Problem 2 -- Created by Keian Mar \n");

        System.out.print("Enter the number of vertices: ");
        int numberOfVertices_Mar = Integer.parseInt(scanner_Mar.nextLine());
        int[][] adjacencyMatrix_Mar = new int[numberOfVertices_Mar][numberOfVertices_Mar]; // n x n matrix

        System.out.print("Enter the labels for the vertices (a,b,c,d): ");
        String[] labelStrings_Mar = scanner_Mar.nextLine().split(",");

        System.out.println("Enter the adjacency matrix of the graph: ");
        for (int i = 0; i < numberOfVertices_Mar; i++) {
            for (int j = 0; j < numberOfVertices_Mar; j++) {
                adjacencyMatrix_Mar[i][j] = Integer.parseInt(scanner_Mar.nextLine());
            }
        }

        Graph graph_Mar = new Graph();
        graph_Mar.undirectedGraphFromAdjacencyMatrix(labelStrings_Mar, adjacencyMatrix_Mar);

        System.out.println("Edges of the graph:");

        Map<String, Integer> edgesCount_Mar = getEdges(graph_Mar);

        for (String edge : edgesCount_Mar.keySet()) {
            System.out.println("Edge "+ edge + " : " + edgesCount_Mar.get(edge) + " time(s).");
        }
    }
}

