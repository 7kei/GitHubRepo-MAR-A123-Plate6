/* 4. Write a java program, given the pair of vertex associated to the edges of an undirected graph, it will output the degree of vertex. */

package com.keianmar.ds2.Plate6;

import java.util.*;
import com.keianmar.ds2.Common.*;

public class Problem4 {
    public static void main(Scanner scanner_Mar) {
        System.out.println("\n Problem 4 -- Created by Keian Mar \n");

        System.out.println("Enter the edges of the graph as pairs of vertices, e.g. 'ab,bc,cd,da'.");
        Graph graph_Mar = new Graph();
        graph_Mar.graphFromEdgeList(scanner_Mar.nextLine().split(","), false);

        int total_Mar = 0;
        for (Vertex vertex_Mar : graph_Mar.getGraphVertices()){
            total_Mar += vertex_Mar.getAdjacentVertices().size();
            System.out.println("deg(" + vertex_Mar.getName() + "): " + vertex_Mar.getAdjacentVertices().size()); // displays degrees per vertex
        }
        System.out.println("\nTotal Degree of Graph: " + total_Mar); // displays total degrees
    }
}
