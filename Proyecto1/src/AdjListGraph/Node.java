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
public class Node {
    private char name;
    private LinkedList <Object> elements;
    private int numNode;
    LinkedList adjacencyList; 
    
    
    public Node (String name){
        this.name = name; 
        this.numNode = -1; 
        // Todos los vertices nacen con posición -1 por default y luego con el metodo newNumNode se le asigna su numero de vertice.
        this.lad= new LinkedList();
    }
    
    // Evaluar si dos vertices tienen el mismo nombre
    public boolean equals(Node b){
        return name.equals(b.name);
    }
     
    // Asignar el número de vertice al nodo que se está creando
    public void newNumNode(int num){
        numNode = num;
    }
    
    // Se muestran los atributos del vértice
    public String showAttr(){
        return name + "(" + numNode + ")";
    }
}
