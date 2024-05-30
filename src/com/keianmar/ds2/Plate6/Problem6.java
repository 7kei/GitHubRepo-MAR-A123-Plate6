/* 6. Write a java program that receives the vertex pairs associated to the edges of a graph, 
the program should construct an adjacency matrix for the graph. 
(Produce a version that works when loops, multiple edges, or directed edges are present.) */

package com.keianmar.ds2.Plate6;

import java.util.*;
import com.keianmar.ds2.Common.*;

public class Problem6 {

    public static int[][] graphToAdjacencyMatrix(Graph inputGraph_Mar) {
        int numberOfVertices_Mar = inputGraph_Mar.getGraphVertices().size();
        int[][] matrix_Mar = new int[numberOfVertices_Mar][numberOfVertices_Mar];

        for (int i_Mar = 0; i_Mar < numberOfVertices_Mar; i_Mar++) {
            Vertex vertex_Mar = inputGraph_Mar.getGraphVertices().get(i_Mar);
            for (Vertex neighborVertex : vertex_Mar.getAdjacentVertices()) {
                int j_Mar = inputGraph_Mar.getGraphVertices().indexOf(neighborVertex);
                matrix_Mar[i_Mar][j_Mar] = 1;
            }
        }
        return matrix_Mar;
    }

    public static void main(Scanner scanner_Mar) {
        System.out.println("\n Problem 6 -- Created by Keian Mar \n");

        System.out.print("Is the graph directed? (y/n): ");
        String directed_Mar = scanner_Mar.nextLine();
        boolean isDirected_Mar = directed_Mar.equalsIgnoreCase("y");

        System.out.println("Enter the edges of the graph as pairs of vertices, e.g. 'ab,bc,cd,da'.");
        Graph graph_Mar = new Graph();
        graph_Mar.graphFromEdgeList(scanner_Mar.nextLine().split(","), isDirected_Mar);

        int[][] adjacencyMatrix_Mar = graphToAdjacencyMatrix(graph_Mar);

        System.out.println("\nAdjacency Matrix:");
        for (int[] row_Mar : adjacencyMatrix_Mar) {
            for (int value_Mar : row_Mar) { System.out.print(value_Mar + " "); }
            System.out.println();
        }
    }
}
