package com.keianmar.ds2.Common;

import java.util.*;

public class Vertex {
    private String name;
    private List<Vertex> adjacentVertices;
    private boolean visited = false;
    private int color = -1;

    public Vertex(String name) {
        this.name = name;
        this.adjacentVertices = new ArrayList<>();
    }

    public List<Vertex> getAdjacentVertices() { return this.adjacentVertices; }
    public String getName() { return this.name; }
    public boolean isVisited() { return this.visited; }
    public void setVisited(boolean set) { this.visited = set; }
    public int getColor() { return this.color; }
    public void setColor(int color) { this.color = color; }
}
