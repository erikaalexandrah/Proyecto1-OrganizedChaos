/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph;

import AdjListGraph.linkedList.LinkedList;
import AdjListGraph.linkedList.ListNode;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.graphstream.graph.Graph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

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
   private int n; 

   /**
    * @Descripcion: cosntructor del grafo vacío
    * @author: Erika Hernandez
    * @param max 
    */
   
    public GraphMA(int max) {
        this.n = max; 
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
     *@Descripcion: Se busca por nombre si el vertice existe en el grafo; 
     * Lo busca en el arreglo auxiliar, no directamente en la matriz de adyacencia.
     * Si lo encuentra, retorna su posición en el arreglo auxiliar y por tanto su fila en la matriz.
     * Si no lo encuentra retorna -1 (NO EXISTE EN EL GRAFO).
     * @author: Erika Hernández
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
      * @ Descripcion: Anadir el vértice al grafo una vez se haya creado el objeto almacen.
      * Se pasa para que entre dentro del arreglo auxiliar del grafo.
      * AQUI NO se le asignan adyacencias (a traves de los arcos) en la matriz. Se hace en otro método. 
      * @author: Erika Hernández
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
    // PARA EL ALGORITMO DE DIJKSTRA: 
    
    /**
     * @Descripcion: retorna el primer vértice adyacente del vértice especificado
     * @author: Erika Hernández & Catalina Matheus
     * @param index
     * @return 
     */
    public int getFirstVertex(int index){
        for (int i = 0; i < numVertices; i++) {
            if(matAd[index][i]>0) return i;  
        }return n; 
        
    }
    
    /**
     * @Descripcion: devuelve los vertices adyacentes secuenciales del vértice pasado como parámetro
     * @author: Erika Hernández & Catalina Matheus
     * @param index
     * @param firstVertex
     * @return 
     */
    
    public int getNextVertex(int index, int firstVertex){
       
        for (int i = firstVertex+1; i < numVertices; i++) {
            if (matAd[index][i]>0) return i; 
   
        }return n; 
    }
    
    /**
     * @Descripcion: retorna el siguiente vértice requerido con la matriz de distancia y la de vertices visitados 
     * @author: Erika Hernández & Catalina Matheus
     * @param distance
     * @param visited
     * @return 
     */
    
    public int getIndex(double[] distance, boolean[] visited ){
   
        int j = 0; 
        double min = Double.POSITIVE_INFINITY; // Te devuelve el valor del infinito positivo de tipo double
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i]) {
                if (distance[i] < min) {
                    min = distance[i]; 
                    j = i; 
                }
            }
        }return j; 
    }
    
    /**
     * @Descripcion: algoritmo de Dijkstra. Devuelve si se encontró una ruta
     * @author: Erika Hernández & Catalina Matheus
     * @param source
     * @param destination
     * @return 
     */
    public boolean Dijkstra(int source, int destination) {
        // Inicializa distancias de cada vértice como infinito
        int[] dist = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
    }
    
        // Inicializa el conjunto de vertices ya visitados
        boolean[] visited = new boolean[numVertices];

        // La distancia al origen es 0
        dist[source] = 0;

        // Inicializa los predecesores de cada vértice como -1
        int[] pred = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            pred[i] = -1;
        }

        // Encuentra la ruta más corta a cada vértice
        for (int i = 0; i < numVertices - 1; i++) {
            // Encuentra el vértice no visitado con la distancia mínima
            int u = findMinimum(dist, visited);

            // Marca el vértice como visitado
            visited[u] = true;

            // Actualiza las distancias de los vecinos de u
            for (int v = 0; v < numVertices; v++) {
                if (!visited[v] && matAd[u][v] != 0 && 
                    dist[u] != Integer.MAX_VALUE && 
                    dist[u] + matAd[u][v] < dist[v]) {
                    dist[v] = dist[u] + matAd[u][v];
                    pred[v] = u;
                }
            }
        }

        // Imprime la ruta más corta desde A hasta E
        int dest = destination; // E tiene un numVertice de 4
        if (dist[dest] == Integer.MAX_VALUE) {
            String print = "no se puede llegar desde " + vertices[source].getName() + " hasta " + vertices[dest].getName()+"."; 
            JOptionPane.showMessageDialog(null, "El almacen escogido no tiene todos los productos que desea.\n"+vertices[source].getName()+ " si los tiene, sin embargo, "+print+"\nDebido a esto se canceló la compra."); 
            return false; 

        } else {
            String print = "La ruta más corta desde " + vertices[source].getName() + " hasta " + vertices[dest].getName() + " es: " + printPath(pred, dest) +"\nLa distancia es "+dist[dest]+"."; 
            JOptionPane.showMessageDialog(null, "La compra fue realizada con éxito.\nEl alamcen " + vertices[dest].getName()+ " no tiene todos los productos, sin embargo, serán suministrados por "+ vertices[source].getName()+ "\n"+print); 
            return true; 

        }
}

    /**
     * @Descripcion: Imprime la ruta desde el origen hasta el vértice dado
     * @author: Erika Hernández & Catalina Matheus
     * @param pred
     * @param vertex
     * @return 
     */

private String printPath(int[] pred, int vertex) {
    if (vertex == -1) {
        return "";
    }
    printPath(pred, pred[vertex]);
    return vertices[vertex].getName() + " ";
}

/**
 * @Descripcion: busca el indice del vertice con menor distancia 
 * @author: Erika Hernández & Catalina Matheus
 * @param dist
 * @param visited
 * @return 
 */
private int findMinimum(int[] dist, boolean[] visited) {
    int min = Integer.MAX_VALUE;
    int minIndex = -1;
    for (int i = 0; i < numVertices; i++) {
        if (!visited[i] && dist[i] < min) {
            min = dist[i];
            minIndex = i;
        }
    }
    return minIndex;
}
    

    /**
     * @Descripcion: crea un JFrame para el grafo. Cuando se cierra no se cierra todo el programa. 
     * @author: Catalina Matheus 
     * @version: 24/02/2023
     * @param graph 
     */
    public void displayGraph(Graph graph){// crea JFrame para el grafo. Cuando se cierra no se cierra todo el programa
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        JPanel panel = new JPanel(new GridLayout()){
            public Dimension getPreferredSize(){
                return new Dimension(640,480); 
            }
        }; 
        frame.setSize(panel.getWidth(), panel.getHeight()); 
         Viewer viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
         viewer.enableAutoLayout(); 
         ViewPanel viewPanel = (ViewPanel) viewer.addDefaultView(false); 
         panel.add(viewPanel); 
         frame.add(panel);
         frame.pack();
         frame.setLocationRelativeTo(null); 
         frame.setVisible(true); 
         

        
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
