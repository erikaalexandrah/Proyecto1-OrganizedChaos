/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph;

/**
 *@Descripcion: clase Edge(vértice del grafo)
 * @author Erika Hernández
 * 
 */
public class Edge {
    private String originNode;
    private String nextNode; 
    private int weight; 

    
    /**
     * @Descripcion: constructor de la clase Edge 
     * @author: Erika Hernández
     * @param originNode
     * @param nextNode
     * @param weight 
     */
    public Edge(String originNode, String nextNode, int weight) {
        this.originNode = originNode;
        this.nextNode = nextNode;
        this.weight = weight;
    }

    /**
     * @return the originNode
     */
    public String getOriginNode() {
        return originNode;
    }

    /**
     * @param originNode the originNode to set
     */
    public void setOriginNode(String originNode) {
        this.originNode = originNode;
    }

    /**
     * @return the nextNode
     */
    public String getNextNode() {
        return nextNode;
    }

    /**
     * @param nextNode the nextNode to set
     */
    public void setNextNode(String nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
 
}
