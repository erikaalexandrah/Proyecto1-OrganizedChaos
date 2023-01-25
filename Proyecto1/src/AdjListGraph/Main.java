/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AdjListGraph;
import LinkedList;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList myList = new LinkedList(); 
        
        myList.append(5);
        myList.append(4);
        myList.insertAtHead(3);
        myList.insertAtPosition("caca", 1);
        myList.printList();
        

    }
    
}

