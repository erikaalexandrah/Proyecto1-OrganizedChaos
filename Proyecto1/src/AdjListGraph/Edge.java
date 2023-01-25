/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph;

/**
 *
 * @author user
 */
public class Edge {
    private String direction; // Al numNode al cual va a ir, no el nombre. 
    private int weight; 
    
    public Edge(String vertex){
        this.direction = vertex;
        this.weight = 0;   
    }
 
    public Edge(String vertex, int weight){
        this.direction = vertex;
        this.weight = weight;   
    }
    
    public int getDirection(){
        return direction;
    }
    
    public boolean equals(Edge b){
        return direction == b.direction;
    }
    
}
