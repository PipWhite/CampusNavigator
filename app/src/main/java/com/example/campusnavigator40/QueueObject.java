package com.example.campusnavigator40;

public class QueueObject implements Comparable<QueueObject> {
    public Vertex vertex;
    public Double priority;

    public QueueObject(Vertex v, Double p){
        this.vertex = v;
        this.priority = p;
    }

    @Override
    public int compareTo(QueueObject o){
        if (this.priority == o.priority){
            return 0;
        }
        else if (this.priority > o.priority){
            return 1;
        }
        else{
            return -1;
        }
    }


}
