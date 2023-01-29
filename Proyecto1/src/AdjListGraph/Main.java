/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AdjListGraph;

import AdjListGraph.linkedList.LinkedList;
import Interface.Interface;


/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // LLamando a la interfaz
        Interface newScreen = new Interface();
        newScreen.setVisible(true);
        newScreen.setLocationRelativeTo(null);
        
        // PROBANDO SOLAMENTE que el BFS funcione. Se borrará eventualmente.  
        Node vA = new Node("A");
        Node vB = new Node("B");
        Node vC = new Node("C");
        Node vD = new Node("D");
        Node vE = new Node("E");
        
        LinkedList <Node> neiA = new LinkedList();
        neiA.append(vB);
        neiA.append(vC);
        vA.setNeighbors(neiA);
        
        LinkedList <Node> neiB = new LinkedList();
        neiB.append(vC);
        neiB.append(vD);
        vB.setNeighbors(neiB);
        
        LinkedList <Node> neiC = new LinkedList();
        neiC.append(vD);
        neiC.append(vE);
        vC.setNeighbors(neiC);
        
        LinkedList <Node> neiD = new LinkedList();
        neiD.append(vE);
        vD.setNeighbors(neiD);
        
        LinkedList <Node> neiE = new LinkedList();
        neiE.append(vA);
        vD.setNeighbors(neiE);
        
        BFS bfs = new BFS();
        bfs.transverse(vA);


    }
    
}

