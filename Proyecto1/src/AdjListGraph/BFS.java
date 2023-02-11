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
    
    private Warehouse startNode;

    public BFS(Warehouse startNode) {
    }

    public BFS() {
    }
    
    public void transverse (Warehouse startNode) {              // Recorrido por anchura del grafo
        LinkedList <Warehouse> queue = new LinkedList();
        queue.append(startNode); 
        while (!queue.isEmpty()){
            Warehouse current;
            current = queue.poll();
            if (current.isVisited()== false){
              current.setVisited(true);
              current.showAttr();
              for (int n =1; n <= (current.neighbors.len()); n++){
                  Warehouse aux;
                  aux = (Warehouse) current.neighbors.getByPosition(n);
                  queue.append(aux);
              }
            }
        }
    }
}
