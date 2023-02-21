/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph.linkedList;

/**
 *
 * @author user
 */
public class Stack<T> {
    private StackNode pCima; 
    private int size; 

    public Stack() {
        this.pCima = null;
        size= 0;
    }
    
    public boolean isEmpty(){
        return pCima == null;
        
    }

    public void push(T data){
        StackNode pAux = new StackNode(data);
        if (this.isEmpty()){
            this.pCima = pAux;
        } else {
            pAux.setpNext(pCima);
            pCima = pAux;
        }
        size ++;  
    }
    
       public void pop(){
        if (!this.isEmpty()){
            pCima = pCima.getpNext();
            size --;
        } 
       }
        
       public StackNode getPop(){
          if (!this.isEmpty()){
              StackNode pAux;
              pAux = pCima;
              size --;
              pCima = pCima.getpNext();
              return pAux;
          }
          return null;
       }
    /**
     * @return the pTop
     */
    public StackNode getpCima() {
        return pCima;
    }

    /**
     * @param pTop the pTop to set
     */
    public void setpCima(StackNode pCima) {
        this.pCima = pCima;
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
