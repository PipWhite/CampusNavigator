package com.example.campusnavigator40;

public class Edge{
    private Vertex start;
    private Vertex end;
    private Double weight;

    //Edge constructor
    public Edge(Vertex startV, Vertex endV, Double inputWeight){
        this.start = startV;
        this.end = endV;
        this.weight = inputWeight;
    }

    //Returns the vertex at the start of the edge
    public Vertex getStart(){
        return this.start;
    }

    //Returns the vertex at the end of the edge
    public Vertex getEnd(){
        return this.end;
    }

    //Returns the weight of the edge
    public Double getWeight(){
        return this.weight;
    }

}