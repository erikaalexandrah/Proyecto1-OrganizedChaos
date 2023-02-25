/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph;

import AdjListGraph.linkedList.LinkedList;

/**
 *@Descripcion: clase warehouse
 * @author Erika Hernández
 */

public class Warehouse  <T>  {
    private String name;
    private LinkedList <T> products;
    private boolean visited; 
    private int numVertice; 
    private App app = App.getInstance(); 
    
    
    /**
     * @Descripcion: constructor de la clase. Se le pasa nombre y lista de productos
     * @author: Erika Hernández
     * @param name
     * @param products1 
     */
    
    public Warehouse (String name, LinkedList products1){
        this.name = name; 
        this.products= products1;
        this.visited = false;
        this.numVertice = -1;
        
    }
    
    /**
     * @Descripcion: constructor de la clase. Se le pasa unicamente el nombre del almacen
     * @author: Erika Hernández
     * @param name 
     */
    public Warehouse(String name){
        this.name = name; 
        this.numVertice = -1;
    }
    
    /**
     * @Descripcion: determina si ya fue visitado o no este nodo durante busqueda BFS O DFS
     * @author: Erika Hernández
     * @return 
     */
    
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
     * @Descripcion: evalua si dos vertices tienen el mismo nombre
     * @author: Erika Hernández
     * @param b
     * @return 
     */
  
    public boolean equals(Warehouse b){
        return getName().equals(b.getName());
    }
    
    /**
     * @Descripcion: Se muestran los atributos del vértice
     * @author: Erika Hernández
     */
   
    public void showAttr(){
        System.out.println("Almacen:" + "(" + getName() + ")");
    }
    
    
    /////////////////////////////////////////////
    
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

    /**
     * @return the numVertice
     */
    public int getNumVertice() {
        return numVertice;
    }

    /**
     * @param numVertice the numVertice to set
     */
    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }
    
        /**
     * @Descripcion: método que busca el índice de un vértice en la lista de vertices del grafo. Si no encuentra el almacen retorna -1
     * @author: Catalina Matheus 
     * @version: 24/02/2023
     * @param warehouse
     * @return 
     */
    
       public int getIndexVertex(Warehouse warehouse){
           int index = -1; 
           
           for (int i = 0; i < app.getGraph().getVertices().length; i++) {
               
               if(app.getGraph().getVertices()[i] == null) break; 
               else{
                   if (app.getGraph().getVertices()[i].getName().equals(warehouse.getName())) {
                       index = i; 
                       
                   }
               }
               
           } return index; 
        
    }

   
}
