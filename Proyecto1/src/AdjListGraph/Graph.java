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
//public class Graph {
//    private int numVerts; 
//    private int maxVerts = 10;
//    private Warehouse [] nodes; 
//    
//    public Graph (int max){              // inicialización del grafo vacío
//        this.nodes = new Warehouse[max];
//        this.maxVerts = max; 
//        this.numVerts = 0;  
//    }
//    
//    public Warehouse [] showTable(){
//        return nodes;            // Devuelve la tabla de adyacencia completa 
//    }
//    
//    public LinkedList showLinkedList(int v){   // Devuelve la lista de adyacencia de un nodo 
//        if (v > 0 && v <numVerts){
//            return nodes[v].neighbors;
//        } else {
//            System.out.println ("Nodo fuera de rango");
//        }
//        return null;
//    }
//        
//    public int findNodeByName(String name){    // Busca por nombre del nodo y devuelve el numero de nodo
//        Warehouse v = new Warehouse(name, products);
//        boolean found = false; 
//        for (int i = 0; (i < numVerts) && found; i++){
//            if (nodes[i].equals(v)){
//                found = true;
//                return i; 
//            } else {
//                i++;
//            }
//        }
//        return -1;
//    }
//    
//    public void newNode (String name){                      // Añadir un nuevo nodo al grafo
//        boolean exists = findNodeByName(name)>=0;
//        if (!exists){
//            Warehouse v = new Warehouse(name, products); 
//            nodes[numVerts]= v;
//            numVerts++;
//        }
//    }
//}
