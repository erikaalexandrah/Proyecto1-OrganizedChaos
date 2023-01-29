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
        return (pFirst == null);
    }
    
    public ListNode first(){
        return pFirst;
    }
    public ListNode last(){
        return null;
    }
    
    public void insertAtHead(T element){
        ListNode newNode= new ListNode(element); 
        newNode.pNext = pFirst;
        pFirst = newNode;
        size++;
    }
    
    public void deleteAtHead(){
        if (pFirst != null){
            pFirst = pFirst.pNext; 
            size --;
        }
    } 
    
     public T poll(){
        if (pFirst != null){
            ListNode pAux = pFirst;
            pFirst = pFirst.pNext; 
            size --;
            return (T) pAux.element;
        }
        return null;
     } 
    
    public int len(){
        return size;
    }
    
    public void printList(){
        ListNode pAux = pFirst;
        while (pAux != null){
            System.out.println("->" + pAux.element);
            pAux = pAux.pNext;
        }
        System.out.println("null");
    }
    
    public void inserAtPosition (T element, int position){
        if (position <0 || position > size){
            System.out.println("Posición no válida");
        } else {
            ListNode newNode = new ListNode(element);
            if (position == 0){
                newNode.pNext = pFirst; 
                pFirst = newNode; 
            } else {
                ListNode pAux = pFirst; 
                for (int i = 0; i < (position -1); i++) {
                    pAux = pAux.pNext; 
                }
                newNode.pNext = pAux.pNext;
                pAux.pNext = newNode;
            }
            size ++;
        }
    }
    
    public void append (T element){
        ListNode newNode = new ListNode(element);
        if (pFirst == null){
            pFirst = newNode;
        } else {
            ListNode pAux = pFirst; 
            while (pAux.pNext != null){
                pAux = pAux.pNext;
            }
            pAux.pNext = newNode;
        }
        size ++;
    }
    
    public T getByPosition(int position){
       if (position <0 || position > size){
            System.out.println("Posición no válida");
            return null;
        } else {
            if (position == 0){
                return null;
            } else {
                ListNode pAux = pFirst; 
                for (int i = 0; i < (position -1); i++) {
                    pAux = pAux.pNext; 
                }
                return (T) pAux.element;
            }
        }
    }
    
}
