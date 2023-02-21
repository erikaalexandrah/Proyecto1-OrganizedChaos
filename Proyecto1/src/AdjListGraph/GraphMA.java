/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph;

import AdjListGraph.linkedList.LinkedList;
import AdjListGraph.linkedList.ListNode;

/**
 * @Descripcion: clase Grafo por Matriz de adyacencia.
 * @author Erika Hernandez & Catalina Matheus
 * @version: 18/02/2023
 * 
 */
public class GraphMA {
    
   private int numVertices; 
   private Warehouse[] vertices;
   private int[][] matAd;

   // Constructor del grafo vacio. 
    public GraphMA(int max) {
        this.matAd = new int[max][max];
        this.vertices = new Warehouse[max];
        for (int i =0; i<max; i++){
            for (int j=0; j<max;j++){
                matAd[i][j]=0;
            }
        }
        this.numVertices = 0;
    }
    
    /** 
     *Se busca por nombre si el vertice existe en el grafo; 
     * Lo busca en el arreglo auxiliar, no directamente en la matriz de adyacencia.
     * Si lo encuentra, retorna su posición en el arreglo auxiliar y por tanto su fila en la matriz.
     * Si no lo encuentra retorna -1 (NO EXISTE EN EL GRAFO).
     */
    
    public int searchVertice(String nameVertice){
        boolean found = false; 
        int i =0;
        for (;i<this.numVertices && !found;){
            found = vertices[i].getName().toLowerCase().equals(nameVertice.toLowerCase());
            if (!found) i++;
        }
        return (i<numVertices)? i: -1;   
    }
    
    public Warehouse findWarehouse(String nameVertice){
        Warehouse warehouse = null; 
        for (int i = 0; i < this.numVertices; i++) {
            if(vertices[i].getName().equals(nameVertice)){
                warehouse = vertices[i]; 
            }
            
        }
        return warehouse; 
    }
    
    
     /** 
      * Anadir el vértice al grafo una vez se haya creado el objeto almacen.
      * Se pasa para que entre dentro del arreglo auxiliar del grafo.
      * AQUI NO se le asignan adyacencias (a traves de los arcos) en la matriz. Se hace en otro método. 
      */
    
    public void addVertice(Warehouse newWarehouse){
        boolean found = this.searchVertice(newWarehouse.getName())>=0;
        if (!found){
            newWarehouse.setNumVertice(numVertices);
            this.vertices[numVertices]= newWarehouse;
            numVertices ++;
        }
        
    }
     
     /** 
      * Se pasa el objeto arco que queremos meter en la matriz.
      *  Se añade el arco en la matriz de adyacencia.
      */
    public void addEdge(Edge newEdge) throws Exception{
        int origin = this.searchVertice(newEdge.getOriginNode());
        int next = this.searchVertice(newEdge.getNextNode());
        // Se verifica que ninguno de los dos vertices sea -1 ya que si es -1 entonces NO EXISTE.
        if (origin<0 || next<0) throw new Exception("Alguno de los dos almacenes NO existe.");
        matAd[origin][next]=newEdge.getWeight();
    }
    /** 
      * Se pasa el NOMBRE de los dos almacenes que se quiere comprobar si son adyacentes o no.
      * En los parametro se deben pasar como ORIGEN y DESTINO. Estrictamente en ese orden ya que es un
      * grafo DIRIGIDO. NO INVERTIR. 
      */
    public boolean isAdjacency(String warehouseName1, String warehouseName2) throws Exception{
        int origin = this.searchVertice(warehouseName1);
        int next = this.searchVertice(warehouseName2);
        if (origin <0 || next<0) throw new Exception ("Alguno de los dos almacenes NO existe.");
        return matAd[origin][next]>=1;
    }
    
    
    
    ////////////////////////////////////////////

    /**
     * @return the numVertices
     */
    public int getNumVertices() {
        return numVertices;
    }

    /**
     * @param numVertices the numVertices to set
     */
    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    /**
     * @return the vertices
     */
    public Warehouse[] getVertices() {
        return vertices;
    }

    /**
     * @param vertices the vertices to set
     */
    public void setVertices(Warehouse[] vertices) {
        this.vertices = vertices;
    }

    /**
     * @return the matAd
     */
    public int[][] getMatAd() {
        return matAd;
    }

    /**
     * @param matAd the matAd to set
     */
    public void setMatAd(int[][] matAd) {
        this.matAd = matAd;
    }
    
    public int getIntMatAd(int i, int j){
        return this.matAd[i][j]; 
        
    }
    
    
    
}
