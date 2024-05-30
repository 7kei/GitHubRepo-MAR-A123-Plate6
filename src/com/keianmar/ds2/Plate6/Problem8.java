/* 8. Write a Java program that checks whether two graphs are isomorphic or not, given a set of vertices. */

package com.keianmar.ds2.Plate6;

import java.util.*;
import com.keianmar.ds2.Common.*;

public class Problem8 {
    public static boolean isIsomorphic(Graph firstGraph_Mar, Graph secondGraph_Mar) {
        List<Vertex> firstGraphVertices_Mar = firstGraph_Mar.getGraphVertices();
        List<Vertex> secondGraphVertices_Mar = secondGraph_Mar.getGraphVertices();

        // Check if vertex count between graphs are the same
        if (firstGraphVertices_Mar.size() != secondGraphVertices_Mar.size()) { return false; }

        // Check if the degrees between graphs are the same
        List<Integer> firstGraphDegrees_Mar = new ArrayList<>();
        List<Integer> secondGraphDegrees_Mar = new ArrayList<>();
        for (Vertex vertex_Mar : firstGraphVertices_Mar) {
            firstGraphDegrees_Mar.add(vertex_Mar.getAdjacentVertices().size());
        }
        for (Vertex vertex_Mar : secondGraphVertices_Mar) {
            secondGraphDegrees_Mar.add(vertex_Mar.getAdjacentVertices().size());
        }
        Collections.sort(firstGraphDegrees_Mar);
        Collections.sort(secondGraphDegrees_Mar); 
        if (!firstGraphDegrees_Mar.equals(secondGraphDegrees_Mar)) { return false; }

        Vertex firstGraphStart_Mar = firstGraphVertices_Mar.get(0);
        Vertex secondGraphStart_Mar = secondGraphVertices_Mar.get(0);
        return isIsomorphicDFS(firstGraphStart_Mar, secondGraphStart_Mar);
    }

    private static boolean isIsomorphicDFS(Vertex firstVertex_Mar, Vertex secondVertex_Mar) {
        firstVertex_Mar.setVisited(true);
        secondVertex_Mar.setVisited(true);

        List<Vertex> firstVertexNeighbors_Mar = firstVertex_Mar.getAdjacentVertices();
        List<Vertex> secondVertexNeighbors_Mar = secondVertex_Mar.getAdjacentVertices();

        // Check if neighboring vertices are the same size
        if (firstVertexNeighbors_Mar.size() != secondVertexNeighbors_Mar.size()) { return false; }

        for (int i = 0; i < firstVertexNeighbors_Mar.size(); i++) {
            Vertex firstVertexNeighbor_Mar = firstVertexNeighbors_Mar.get(i);
            Vertex secondVertexNeighbor_Mar = secondVertexNeighbors_Mar.get(i);

            if (!firstVertexNeighbor_Mar.isVisited() && !secondVertexNeighbor_Mar.isVisited()) {
                if (!isIsomorphicDFS(firstVertexNeighbor_Mar, secondVertexNeighbor_Mar)) {
                    return false;
                }
            } else if (firstVertexNeighbor_Mar.isVisited() != secondVertexNeighbor_Mar.isVisited()) {
                return false; // One neighbor visited, the other not
            }
        }

        return true;
    }

    public static void main(Scanner scanner) {
        System.out.println("\n Problem 8 -- Created by Keian Mar \n");

        System.out.println("Enter the edges of the first graph as pairs of vertices, e.g. 'ab,bc,cd,da'.");
        Graph graph1_Mar = new Graph();
        graph1_Mar.graphFromEdgeList(scanner.nextLine().split(","), false);

        System.out.println("Enter the edges of the second graph as pairs of vertices, e.g. 'ab,bc,cd,da'.");
        Graph graph2_Mar = new Graph();
        graph2_Mar.graphFromEdgeList(scanner.nextLine().split(","), false);

        boolean isIsomorphic_Mar = isIsomorphic(graph1_Mar, graph2_Mar);
        System.out.println("Are the graphs isomorphic? " + isIsomorphic_Mar);
    }
}
