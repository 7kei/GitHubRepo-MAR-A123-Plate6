/* 7. Write a java program that accepts vertex pairs associated to the edges of an undirected graph 
and the number of times each edge appears. The program should construct an incidence matrix for the graph. */

package com.keianmar.ds2.Plate6;

import java.util.*;
import com.keianmar.ds2.Common.*;

public class Problem7 {
    private static Vertex findVertexByName(List<Vertex> vertices_Mar, String name_Mar) {
        for (Vertex vertex_Mar : vertices_Mar) {
            if (vertex_Mar.getName().equals(name_Mar)) { return vertex_Mar; }
        }
        return null;
    }

    public static int[][] generateIncidenceMatrix(String[] edgeList_Mar, String[] vertexLabelList_Mar) {
        List<Vertex> vertexList_Mar = new ArrayList<>();

        for (String vertexName_Mar: vertexLabelList_Mar) { vertexList_Mar.add(new Vertex(vertexName_Mar)); }

        int numberOfVertices_Mar = vertexList_Mar.size();
        int numberOfEdges_Mar = edgeList_Mar.length;

        int[][] incidenceMatrix_Mar = new int[numberOfVertices_Mar][numberOfEdges_Mar];

        for (int i = 0; i < numberOfEdges_Mar; i++) {
            String vertexPair_Mar = edgeList_Mar[i];
            String a_Mar = vertexPair_Mar.substring(0, 1);
            String b_Mar = vertexPair_Mar.substring(1);

            Vertex vertexA_Mar = findVertexByName(vertexList_Mar, a_Mar);
            Vertex vertexB_Mar = findVertexByName(vertexList_Mar, b_Mar);

            if (vertexA_Mar != null) incidenceMatrix_Mar[vertexList_Mar.indexOf(vertexA_Mar)][i] = 1;
            if (vertexB_Mar != null) incidenceMatrix_Mar[vertexList_Mar.indexOf(vertexB_Mar)][i] = 1;
        }

        return incidenceMatrix_Mar;
    }

    public static void main(Scanner scanner_Mar) {
        System.out.println("\n Problem 7 -- Created by Keian Mar \n");

        System.out.print("Enter the vertices in the graph (a,b,c,d,e,f): ");
        String[] vertices_Mar = scanner_Mar.nextLine().split(",");

        System.out.print("Enter the edges in the graph (ab,cd,ef): ");
        String[] edges_Mar = scanner_Mar.nextLine().split(",");

        int[][] incidenceMatrix_Mar = generateIncidenceMatrix(edges_Mar, vertices_Mar); 

        for (int[] row_Mar : incidenceMatrix_Mar) {
            for (int entry_Mar : row_Mar) {
                System.out.print(entry_Mar + " ");
            }
            System.out.println();
        }
    }
}
