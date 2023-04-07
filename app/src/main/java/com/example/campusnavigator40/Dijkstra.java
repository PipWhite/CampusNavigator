package com.example.campusnavigator40;

import java.util.*;

public class Dijkstra {


    //Returns a dictionary
    public static Dictionary[] dijkstra(Graph g, Vertex startingVertex) {
        //dictionary of distances/weights
        Dictionary<String, Double> distances = new Hashtable<>();
        //dictionary of previous vertex
        Dictionary<String, Vertex> previous = new Hashtable<>();
        PriorityQueue<QueueObject> queue = new PriorityQueue<QueueObject>();

        //Adds the starting vertex to the priority queue, set priority to 0
        queue.add(new QueueObject(startingVertex, 0.0));

        //iterates through the graph to find all the vertices
        //for each vertex in the graph
        for(Vertex v: g.getVertices()){
            //if the vertex is not the starting vertex, current distance is set to infinity
            if( v != startingVertex){
                distances.put(v.getData(), Double.MAX_VALUE);
            }
            //
            previous.put(v.getData(), new Vertex("Null", 0.0, 0.0));
        }

        //setting the distance of the starting vertex to 0
        distances.put(startingVertex.getData(), 0.0);

        //iterate through queue
        while (queue.size() != 0){
            //remove current vertex for the queue
            Vertex current = queue.poll().vertex;
            //for every edge of current vertex
            for (Edge e: current.getEdges()){
                //alternative is the cost of the current vertex + the weight of an edge
                Double alternative = distances.get(current.getData()) + e.getWeight();
                // neighborValue is the vertex at the end of the edge
                String neighborValue = e.getEnd().getData();
                //Check if alternative is less than the neighbour value
                //If so add neighbour value to queue
                if(alternative < distances.get(neighborValue)){
                    distances.put(neighborValue, alternative);
                    previous.put(neighborValue, current);
                    queue.add(new QueueObject(e.getEnd(), distances.get(neighborValue)));
                }
            }
        }
        //When all edges are checked returns a dictionary of distances and previous dictionaries
        return new Dictionary[]{distances, previous};

    }

    //Prints all the distances and previous positions
    public static void dijkstraResultPrinter(Dictionary[] d){
        System.out.println("\nDistances:\n");
        for(Enumeration keys = d[0].keys(); keys.hasMoreElements();){
            String nextKey = keys.nextElement().toString();
            System.out.println(nextKey + ": " + d[0].get(nextKey));
        }
        System.out.println("\nPrevious:\n");
        for (Enumeration keys = d[1].keys(); keys.hasMoreElements();){
            String nextKey = keys.nextElement().toString();
            Vertex nextVertex = (Vertex) d[1].get(nextKey);
            System.out.println(nextKey + ": " + nextVertex.getData());
        }
    }

    //prints the shortest distance between the start and target vertex
    //prints the shortest route between start and tartget vertex
    public static void shortestPathBetween(Graph g, Vertex startingVertex, Vertex targetVertex){

        Dictionary[] dijkstraDictionaries = dijkstra(g, startingVertex);
        //distances is graph
        Dictionary distances = dijkstraDictionaries[0];
        //previous is startingVertex
        Dictionary previous = dijkstraDictionaries[1];

        //Total Distance is
        /*
        Double distance = (Double) distances.get(targetVertex.getData());
        System.out.println("Shortest Distance between " + startingVertex.getData() + " and " + targetVertex.getData());
        System.out.println(distance);
        */

        ArrayList<Vertex> path = new ArrayList<>();
        Vertex v = targetVertex;

        while (v.getData() != "Null"){
            path.add(0, v);
            v = (Vertex) previous.get(v.getData());
        }
        System.out.println(path);

        for(int i = 0; i < path.size() - 1; i++){


        }


         /*
        System.out.println("Shortest Path");
        for (Vertex pathVertex: path){
            System.out.println(pathVertex.getData());
        }
        */
    }

    //Method to return the path that needs to be taken in the form of an array list
    public static ArrayList<Vertex> pathArray(Graph g, Vertex startingVertex, Vertex targetVertex){
        Dictionary[] dijkstraDictionaries = dijkstra(g, startingVertex);
        //distances is graph
        Dictionary distances = dijkstraDictionaries[0];
        //previous is startingVertex
        Dictionary previous = dijkstraDictionaries[1];

        ArrayList<Vertex> path = new ArrayList<>();
        Vertex v = targetVertex;

        while (v.getData() != "Null"){
            path.add(0, v);
            v = (Vertex) previous.get(v.getData());
        }

        return path;
    }



}
