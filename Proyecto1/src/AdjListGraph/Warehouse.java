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

public class Warehouse  <T>  {
    private String name;
    private LinkedList <T> products;
    private boolean visited; 
    public LinkedList <T> neighbors; 
    
    
    public Warehouse (String name, LinkedList products1){
        this.name = name; 
        this.products= products1;
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
    public boolean equals(Warehouse b){
        return getName().equals(b.getName());
    }
    
    // Se muestran los atributos del vértice
    public void showAttr(){
        System.out.println("Almacen:" + "(" + getName() + ")");
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the products
     */
    public LinkedList <T> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(LinkedList <T> products) {
        this.products = products;
    }

   
}
