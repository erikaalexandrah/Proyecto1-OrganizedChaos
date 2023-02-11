/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph.linkedList;

/**
 *
 * @author user
 */
public class LinkedList <T> {
    private ListNode pFirst;  
    private int size; 

    public LinkedList() {
        this.pFirst = null; 
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return (getpFirst() == null);
    }
    
    public ListNode first(){
        return getpFirst();
    }
    public ListNode last(){
        return null;
    }
    
    public void insertAtHead(T element){
        ListNode newNode= new ListNode(element); 
        newNode.pNext = getpFirst();
        setpFirst(newNode);
        setSize(getSize() + 1);
    }
    
    public void deleteAtHead(){
        if (getpFirst() != null){
            setpFirst(getpFirst().pNext); 
            setSize(getSize() - 1);
        }
    } 
    
     public T poll(){
        if (getpFirst() != null){
            ListNode pAux = getpFirst();
            setpFirst(getpFirst().pNext); 
            setSize(getSize() - 1);
            return (T) pAux.element;
        }
        return null;
     } 
    
    public int len(){
        return getSize();
    }
    
    public void printList(){
        ListNode pAux = this.getpFirst();
        while (pAux != null){
            System.out.println("->" + pAux.element);
            pAux = pAux.pNext;
        }
        System.out.println("null");
    }
    
    public void inserAtPosition (T element, int position){
        if (position <0 || position > getSize()){
            System.out.println("Posición no válida");
        } else {
            ListNode newNode = new ListNode(element);
            if (position == 0){
                newNode.pNext = getpFirst(); 
                setpFirst(newNode); 
            } else {
                ListNode pAux = getpFirst(); 
                for (int i = 0; i < (position -1); i++) {
                    pAux = pAux.pNext; 
                }
                newNode.pNext = pAux.pNext;
                pAux.pNext = newNode;
            }
            setSize(getSize() + 1);
        }
    }
    
    public void append (T element){
        ListNode newNode = new ListNode(element);
        if (getpFirst() == null){
            setpFirst(newNode);
        } else {
            ListNode pAux = getpFirst(); 
            while (pAux.pNext != null){
                pAux = pAux.pNext;
            }
            pAux.pNext = newNode;
        }
        setSize(getSize() + 1);
    }
    
    public T getByPosition(int position){
       if (position <0 || position > getSize()){
            System.out.println("Posición no válida");
            return null;
        } else {
            if (position == 0){
                return null;
            } else {
                ListNode pAux = getpFirst(); 
                for (int i = 0; i < (position -1); i++) {
                    pAux = pAux.pNext; 
                }
                return (T) pAux.element;
            }
        }
    }

    /**
     * @return the pFirst
     */
    public ListNode getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(ListNode pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }
    
}
