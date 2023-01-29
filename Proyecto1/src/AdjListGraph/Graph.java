/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph;

import AdjListGraph.linkedList.LinkedList;
import AdjListGraph.linkedList.ListNode;

/**
 *
 * @author user
 */
public class Graph {
    private int numVerts; 
    private int maxVerts = 10;
    private Node [] nodes; 
    
    public Graph (int max){              // inicialización del grafo vacío
        this.nodes = new Node[max];
        this.maxVerts = max; 
        this.numVerts = 0;  
    }
    
    public Node [] showTable(){
        return nodes;            // Devuelve la tabla de adyacencia completa 
    }
    
    public LinkedList showLinkedList(int v){   // Devuelve la lista de adyacencia de un nodo 
        if (v > 0 && v <numVerts){
            return nodes[v].neighbors;
        } else {
            System.out.println ("Nodo fuera de rango");
        }
        return null;
    }
        
    public int findNodeByName(String name){    // Busca por nombre del nodo y devuelve el numero de nodo
        Node v = new Node(name);
        boolean found = false; 
        for (int i = 0; (i < numVerts) && found; i++){
            if (nodes[i].equals(v)){
                found = true;
                return i; 
            } else {
                i++;
            }
        }
        return -1;
    }
    
    public void newNode (String name){                      // Añadir un nuevo nodo al grafo
        boolean exists = findNodeByName(name)>=0;
        if (!exists){
            Node v = new Node(name); 
            nodes[numVerts]= v;
            numVerts++;
        }
    }
}
