/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph;

import AdjListGraph.linkedList.ListNode;

/**
 *
 * @author Catalina Matheus
 */
public class Dijkstra {
    
//    // INTENTO 1: 
//    private int mCosts[][]; 
//    private int last[]; // se guarda desde el origen al destino el utlimo vertice que se visito antes del destino
//    private int D[]; //aqui se guardan los costos minimos del origen a cada vertice 
//    private boolean F[]; // vertices visitados
//    private int s; // s es el origen, n el num de vertices
//    private int n; // s es el origen, n el num de vertices que tiene el grafo
//    
//    App app = App.getInstance(); 
//    public static GraphMA graph; 
//
//    public Dijkstra(int s, GraphMA graph) {
//        n = graph.getNumVertices(); 
//        this.s = s; 
//        mCosts = insMatrix(graph);
//        last = new int[n]; 
//        D = new int[n]; 
//        F = new boolean[n]; 
//        this.graph = app.getGraph(); 
//    }
//    
//    
//    private int[][] insMatrix (){
//        int t = this.graph.getNumVertices(); 
//        mCosts = new int[t][t]; 
//        for (int i = 0; i < t; i++) {
//            for (int j = 0; j < t; j++) {
//                mCosts[i][j] = graph.getIntMatAd(i,j); 
//                
//            }
//            
//        }return mCosts; 
//    }
//    
//    public void minPaths(){
//        // valores iniciales
//        for (int i = 0; i < n; i++) {
//            F[i] = false; // inicializa los vertices como no visitados
//            D[i] = mCosts[s][i]; // pesos directos desde el origen hasta todos los posibles destinos 
//            last[i] = s;    
//        }
//        F[s] = true; 
//        D[s] = 0; // es el origen (la distancia es 0)
//        // Pasos para marcar los n-1 vértices
//        for (int i = 0; i < n; i++) {
//            int v = min(); // HAY QUE REVISAR ESTE METODO!!!!
//            F[v] = true; 
//            
//            for (int j = 0; j < n; j++) {
//                if (!F[j]) {
//                    if ((D[v] + mCosts[v][j]) < D[j]) {
//                        D[j] = D[v] + mCosts[v][j]; 
//                        last[j] = v; 
//                    }
//                    
//                }
//                
//            }
//           
//            
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.println("Costo mínimo a " + i+ ":" + D[i]);
//            
//        }
//    }
//    
//    public int min(){ // REVISAR METODO!!!
//        int mx = graph.getNumVertices(); 
//        int v = 1; 
//        for (int i = 0; i < n; i++) {
//            if (!F[i] && D[i] <= mx) {
//                mx = D[i];
//                v = i; 
//                
//            }
//            
//        }return v;
//    }
//
//    /**
//     * @return the mCostos
//     */
//    public int[][] getmCosts() {
//        return mCosts;
//    }
//
//    /**
//     * @param mCostos the mCostos to set
//     */
//    public void setmCosts(int[][] mCosts) {
//        this.mCosts = mCosts;
//    }
//
//    /**
//     * @return the last
//     */
//    public int[] getLast() {
//        return last;
//    }
//
//    /**
//     * @param last the last to set
//     */
//    public void setLast(int[] last) {
//        this.last = last;
//    }
//
//    /**
//     * @return the D
//     */
//    public int[] getD() {
//        return D;
//    }
//
//    /**
//     * @param D the D to set
//     */
//    public void setD(int[] D) {
//        this.D = D;
//    }
//
//    /**
//     * @return the F
//     */
//    public boolean[] getF() {
//        return F;
//    }
//
//    /**
//     * @param F the F to set
//     */
//    public void setF(boolean[] F) {
//        this.F = F;
//    }
//
//    /**
//     * @return the s
//     */
//    public int getS() {
//        return s;
//    }
//
//    /**
//     * @param s the s to set
//     */
//    public void setS(int s) {
//        this.s = s;
//    }
//
//    /**
//     * @return the n
//     */
//    public int getN() {
//        return n;
//    }
//
//    /**
//     * @param n the n to set
//     */
//    public void setN(int n) {
//        this.n = n;
//    }
    
    
    
    
    
}
