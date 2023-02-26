/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph.linkedList;

/**
 *@Descripcion: clase nodo para las listas simples
 * @author Erika Hernández & Catalina Matheus
 *  @version: 24/01/2023
 * @param <T>
 */
public class ListNode <T> {
    public T element;
    public ListNode pNext; 
    
    /**
     * @Descripcion: constructor
     * @author Erika Hernández & Catalina Matheus
     *  @version: 24/01/2023
     * @param element 
     */
    public ListNode(T element) {
        this.element = element;
    }

   /**
    * @Descripcion: constructor
    *  @author Erika Hernández & Catalina Matheus
    *  @version: 24/01/2023
    * @param element
    * @param pNext 
    */
    public ListNode(T element, ListNode pNext) {
        this.element = element;
        this.pNext = pNext;
    }

    /**
     * @Descripcion: constructor
     * @author Erika Hernández & Catalina Matheus
     *  @version: 24/01/2023
     */
    public ListNode() {
    }

 
    /**
     * @return the element
     */
    public T getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * @return the pNext
     */
    public ListNode getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(ListNode pNext) {
        this.pNext = pNext;
    }    
}
