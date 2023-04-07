package com.example.campusnavigator40;
import java.util.ArrayList;

public class Vertex {

    private String data;
    private ArrayList<Edge> edges;
    private Double x;
    private Double y;

    //Vertex constructor
    public Vertex(String inputData, Double inputX, Double inputY){
        this.data = inputData;
        this.edges = new ArrayList<Edge>();
        this.x = inputX;
        this.y = inputY;
    }

    //Adds a new edge with weight
    public void addEdge(Vertex endVertex, Double weight){
        this.edges.add(new Edge(this, endVertex, weight));

    }

    //Removes an edge
    public void removeEdge(Vertex endVertex){
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }

    //Returns vertex name
    public String getData(){
        return this.data;
    }
    //returns vertex x value
    public Double getX(){
        return this.x;
    }
    //returns vertex y value
    public Double getY(){
        return this.y;
    }

    //returns a list of edges
    public ArrayList<Edge> getEdges(){
        return this.edges;
    }

    //Prints out a list of all the vertexes and edges along with weight
    public void print(boolean showWeight){
        String message = "";

        if (this.edges.size() == 0){
            System.out.println(this.data + " --");
            return;
        }

        for(int i = 0; i < this.edges.size(); i++){
            if (i==0) {
                message += this.edges.get(i).getStart().data + " -- ";
            }

            message += this.edges.get(i).getEnd().data;

            if (showWeight) {
                message += " (" + this.edges.get(i).getWeight() + ")";
            }

            if (i != this.edges.size() - 1){
                message += ", ";
            }
        }
        System.out.println(message);
    }
}
