package com.example.campusnavigator40;

import java.util.ArrayList;

public class Graph {

    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
        this.vertices = new ArrayList<Vertex>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }

    //Add a vertex with the vertex name, x value and y value
    public Vertex addVertex(String data, Double x, Double y){
        Vertex newVertex = new Vertex(data, x, y);
        this.vertices.add(newVertex);
        return newVertex;
    }

    //Adds edge by taking the starting vertex, the end vertex and the weight
    //Also adds an edge the opposite way for undirected graphs
    public void addEdge(Vertex vertex1, Vertex vertex2, Double weight){
        if (!this.isWeighted){
            weight = null;
        }
        vertex1.addEdge(vertex2, weight);
        if (!this.isDirected){
            vertex2.addEdge(vertex1, weight);
        }
    }

    //Removes an edge
    public void removeEdge(Vertex vertex1, Vertex vertex2){
        vertex1.removeEdge(vertex2);
        if(!this.isDirected){
            vertex2.removeEdge(vertex1);
        }
    }

    //Removes a vertex
    public void removeVertex(Vertex vertex){
        this.vertices.remove(vertex);
    }


    public ArrayList<Vertex> getVertices(){
        return this.vertices;
    }

    public boolean isWeighted(){
        return this.isWeighted;
    }

    public boolean isDirected(){
        return this.isDirected;
    }

    //Look up a specific vertex
    public Vertex getVertexByValue(String value){
        for(Vertex v: this.vertices){
            if (v.getData() == value){
                return v;
            }
        }
        return null;
    }

    public void print(){
        for(Vertex v: this.vertices){
            v.print(isWeighted);
        }
    }


}
