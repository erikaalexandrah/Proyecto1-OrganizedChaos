/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph.linkedList;

/**
 *@Descripcion: clase Nodo para las pilas
 * @author: Erika Hernández
 */
public class StackNode <T> {
    private T data;
    private StackNode pNext;

    /**
     * @Descripcion: constructor
     * @author: Erika Hernández
     * @param data 
     */
    public StackNode(T data) {
        this.data = data;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the pNext
     */
    public StackNode getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(StackNode pNext) {
        this.pNext = pNext;
    }
    
    
    
}
