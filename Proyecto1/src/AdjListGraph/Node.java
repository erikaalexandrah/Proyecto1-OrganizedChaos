/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph;

import AdjListGraph.linkedList.LinkedList;

/**
 *
 * @author user
 */

public class Node  <T>  {
    private String name;
    private LinkedList <T> products;
    private boolean visited; 
    public LinkedList <T> neighbors; 
    
    
    public Node (String name){
        this.name = name; 
        this.products= new LinkedList();
        this.visited = false;
        this.neighbors = new LinkedList();
        
    }
    
    
    // Determina si ya fue visitado o no este nodo durante busqueda BFS o DFS
    public boolean isVisited(){
        return visited;
    }

    /**
     * @param visited the visited to set
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
   
     /**
     * @param neighbors the neighbors to set
     */
    public void setNeighbors(LinkedList <T> neighbors) {
        this.neighbors = neighbors;
    }
    
    // Evaluar si dos vertices tienen el mismo nombre
    public boolean equals(Node b){
        return name.equals(b.name);
    }
    
    // Se muestran los atributos del vértice
    public void showAttr(){
        System.out.println("Almacen:" + "(" + name + ")");
    }

   
}
