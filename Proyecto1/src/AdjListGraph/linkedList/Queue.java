/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph.linkedList;

/**
 * Descripción: Clase cola.
 * @author Erika Hernández
 * @version 20/02/2023
 */
public class Queue <T> {
    private QueueNode pFirst;
    private QueueNode pLast;
    private int size;

    // Constructor vacío.
    public Queue() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
        
    }
    
    public boolean isEmpty(){
        return pFirst==null;
    }
    
    public void enqueue(T data){
        QueueNode node = new QueueNode(data);
        if (this.isEmpty()){
            pFirst=node;
            pLast=node;
        } else {
            pLast.setpNext(node);
            pLast = node;
            
        }
        size++;
    }
     
    public void dequeue(){
        if (pFirst!=null){
            pFirst = pFirst.getpNext();
            size --;
        } else {
            pLast = null;
        }
    }
    
    public QueueNode poll(){
        if (pFirst!=null){
            QueueNode pAux;
            pAux = pFirst;
            pFirst = pFirst.getpNext();
            size --;
            return pAux;
        } else {
            pLast = null;
            return null;
        }
    }
    
    //////////////////////
    // GETTERS & SETTERS

    /**
     * @return the pFirst
     */
    public QueueNode getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(QueueNode pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public QueueNode getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(QueueNode pLast) {
        this.pLast = pLast;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
    
}

