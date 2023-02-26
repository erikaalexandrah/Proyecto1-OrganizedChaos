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
   
   // PARA EL ALGORITMO DE DIJKSTRA: 
   private double[] distance; 
   private String[] path; 
   private boolean[] visited; 

   
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
    public int getFirstVertex(int index){
        // retorna el primer vértice adyacente del vértice especificado
        for (int i = 0; i < numVertices; i++) {
            if(matAd[index][i]>0) return i;  
        }return n; 
        
    }
    
    public int getNextVertex(int index, int firstVertex){
        // devuelve los vertices adyacentes secuenciales del vértice pasado como parámetro
        for (int i = firstVertex+1; i < numVertices; i++) {
            if (matAd[index][i]>0) return i; 
   
        }return n; 
    }
    
    
    public int getIndex(double[] distance, boolean[] visited ){
        // retorna el siguiente vértice requerido con la matriz de distancia y la de vertices visitados 
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

    // ALGORITMO DE DIJKSTRA: 
//    public LinkedList dijkstra(int index){
//        int CO; // vertices necesarios para la iteración
//        int startIndex = index; // vertice inicial 
//        distance[index] = 0; // se establece la distancia desde el punto inicial al punto inicial como cero
//        
//        
//        // PARA CADA VÉRTICE: 
//        //1. Establece este vértice en conocido, no te preocupes por la distancia y la ruta de este punto, porque ha sido diseñado antes
//        //2. Encuentra cada vértice adyacente de este vértice. Para un vértice desconocido, compare la distancia alcanzada a lo largo de este vértice con su distancia original, si es menor que la distancia original, actualice la distancia y actualice la ruta
//        //3. Después de establecer este vértice, use la función indexGet para encontrar el vértice con la distancia más pequeña entre los vértices desconocidos actuales, y utilícelo como el siguiente vértice para realizar el paso 2
//        
//        while(!visited[startIndex]){
//            CO = getFirstVertex(startIndex); // CO es la primera coordenada que no ha sido visitada
//            while(visited[CO]){
//                CO= getNextVertex(startIndex, CO);  
//            }if (CO == n) {// si el vértice inicial no tiene vértices adyacentes que no hayan sido visitados la coordenada que se retorna del método es n
//                // es el último vértice desconocido
//                visited[startIndex] = true; // se marca como conocido     
//            } // Ahora se ejecuta el paso 2 para todos los vértices adyacentes al inicial
//            
//            else{
//                while(!visited[CO] && CO <n){
//                    visited[startIndex] = true; 
//                    double currentDistance = distance[startIndex] + matAd[startIndex][CO]; // Le sumas lo que ya tenías mas lo actual
//                    if (currentDistance < distance[CO]) {// si es menor se agarra ese camino
//                        distance[CO] = currentDistance; 
//                        path[CO] = path[startIndex] + " " + vertices[startIndex];
//                    }
//                    
//                    CO = getNextVertex(startIndex, CO); 
//              
//                }
//            } startIndex = getIndex(distance, visited); 
//     
//        }
//        
//        for (int i = 0; i < numVertices; i++) {
//            path[i] = path[i] + " " + vertices[i].getName(); 
//            
//        }System.out.println("Iniciar nodo: " + vertices[index].getName());
//        
//        LinkedList listOfDijskstra = new LinkedList(); 
//        for (int i = 0; i < numVertices; i++) {
//            String[] result = new String[3]; 
//            result[0] = vertices[i].getName(); 
//            result[1] = String.valueOf(distance[i]); 
//            result[2] = path[i]; 
//    
//           listOfDijskstra.insertInOrder(result);
//        }
//        listOfDijskstra.setpFirst(listOfDijskstra.getpFirst().getpNext()); 
//        return listOfDijskstra;
//    }
    
    
 // intento 2 algoritmo de Dijkstra: 
    // TE DEVUELVE LAS DISTANCIAS MAS CORTAS PARA CUALQUIER VERTICE DESDE EL QUE TU PIDAS COMO INICIAL: 
//    public int[] dijkstraAlgorithm(int start){
//        // start es el indice desde donde quieres que comience. 
//        boolean[] visited = new boolean[numVertices]; // aqui marcaremos si el vertice fue marcado o no 
//        visited[start] = true; // marcamos como visitado el vertice donde inicia el recorrido
//        int[] shortestDistances = new int[numVertices];  
//        String pathIndices = ""; // donde vamos a guardar el índice de cada vertice visitado
//        pathIndices += Integer.toString(start) + "->"; // se separa cada indice por ->
//        
//        for (int i = 0; i < numVertices; i++) {
//            if(i != start){
//                shortestDistances[i] = Integer.MAX_VALUE;
//            }else{
//                shortestDistances[i] = 0; 
//            }
//            
//        }
//
//        for (int i = 0; i < numVertices; i++) {
//            if (i != start) {// para que no cuente el vértice donde empieza el recorrido
//                int minVertex = findMinVertex(shortestDistances,visited); // para encontrar el vértice con el menor peso 
//                visited[minVertex] = true; // se marca que ya fue visitado
//                // exploramos vertices vecinos: 
//                for (int j = 0; j < numVertices; j++) {
//                    if (matAd[minVertex][j] != 0 && !visited[j] && shortestDistances[minVertex] != Integer.MAX_VALUE) {
//                        int newDistance = shortestDistances[minVertex] + matAd[minVertex][j]; 
//                        if(newDistance < shortestDistances[j]){
//                            shortestDistances[j] = newDistance; 
//                            pathIndices += Integer.toString(j) + "->"; 
//              
//                    }else pathIndices += Integer.toString(minVertex) + "->"; 
//                }
//            }
//            
//        }
//    }
//        System.out.println( "PATH: " +pathIndices);
//        return shortestDistances; 
//    }
    
    
        
//    public int findMinVertex(int[] shortesDistances, boolean[] visited){// te retorna el indice del vertice con menor peso
//        int minVertex = -1; // lo inicializamos 
//        
//        for (int i = 0; i < shortesDistances.length; i++) {
//            if(!visited[i] && minVertex == -1 || shortesDistances[i] < shortesDistances[minVertex]){
//                minVertex = i; 
//            }
//        }
//        return minVertex; 
//    }

    //INTENTO 3: algoritmo de dijkstra: 
    public int dijkstraAlgorithm(int start, int end){// start es el índice del  vértice desde donde se inicia el recorrido 
        //y end es el indice del vertice donde se quiere terminar el recorrido 
        // vamos a retornar la distancia mínima: 
        int shortesDistance = 0; // donde guardaremos la distancia mínima total. 
        boolean[] visited = new boolean[numVertices]; // arreglo que dice si un vértice ya fue visitado o no
        visited[start] = true; // el inicio ya está visitado
        String path = "->" + Integer.toString(start); // donde guardamos el indice de cada camino. Metemos el índice del primero 
        
        // se empieza el recorrido: 
        int[] result = findMinVertex(start, shortesDistance, visited); 
        
        shortesDistance = result[1]; 
        path += "->" + Integer.toString(result[0]); 
        int index = result[0]; 
        visited[index] = true; 
        
        while(!visited[end]){
            int[] result2 = findMinVertex(index, shortesDistance, visited); 
            index = result2[0]; 
            shortesDistance = result2[1]; 
            visited[index] = true; 
            path +="->" + Integer.toString(index); 
        }
    
        
        System.out.println("PATH: " + path);
        
        return shortesDistance; 
        
        
    }
    
    public int[] findMinVertex(int v, int currentDistance, boolean[] visited){
        // retorna el indice del vertice adyacente que hace menor la distancia
        // si no existe se devuelve -1 como idnice 
        // le pasamos como parámetro el  índice del vértice al cual le queremos evaluar cual de sus vértices adyacentes tiene la menor distancia
        int[] resultados = new int[2]; 
        int index =-1; 
        int totalDistance = currentDistance; 
        int shortesDistance = Integer.MAX_VALUE; //establecemos el menor como el primero
        for (int i = 0; i < numVertices; i++) {
            if ((matAd[v][i] + currentDistance)< shortesDistance+currentDistance && !visited[i]) {
                shortesDistance = matAd[v][i]; 
                index = i; 
                
            }
            
            
        }
        
        // sacamos la distancia total: 
        totalDistance += shortesDistance; 
        resultados[0] = index; 
        resultados[1] = totalDistance; 
        return resultados; // estoy devolviendo el indice del vertice y la distancia total hasta el momento. 
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
