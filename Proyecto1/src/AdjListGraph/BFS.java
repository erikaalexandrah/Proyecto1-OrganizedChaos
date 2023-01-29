/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph;

import AdjListGraph.linkedList.LinkedList;

/**
 *Descripcion: Clase BFS para recorrido en anchura. 
 * @author Erika Hernández
 * @version: 29/01/2023
 */
public class BFS {
    
    private Node startNode;

    public BFS(Node startNode) {
    }

    public BFS() {
    }
    
    public void transverse (Node startNode) {              // Recorrido por anchura del grafo
        LinkedList <Node> queue = new LinkedList();
        queue.append(startNode); 
        while (!queue.isEmpty()){
            Node current;
            current = queue.poll();
            if (current.isVisited()== false){
              current.setVisited(true);
              current.showAttr();
              for (int n =1; n <= (current.neighbors.len()); n++){
                  Node aux;
                  aux = (Node) current.neighbors.getByPosition(n);
                  queue.append(aux);
              }
            }
        }
    }
}
