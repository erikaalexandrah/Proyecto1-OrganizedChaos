/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AdjListGraph;

<<<<<<< Updated upstream
import AdjListGraph.linkedList.LinkedList;
=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
       
        // LLamando a la interfaz
        Interface newScreen = new Interface();
        newScreen.setVisible(true);
        newScreen.setLocationRelativeTo(null);
        
        // PROBANDO SOLAMENTE que el BFS funcione. Se borrará eventualmente.  
        Warehouse vA = new Warehouse("A");
        Warehouse vB = new Warehouse("B");
        Warehouse vC = new Warehouse("C");
        Warehouse vD = new Warehouse("D");
        Warehouse vE = new Warehouse("E");
        
        LinkedList <Warehouse> neiA = new LinkedList();
        neiA.append(vB);
        neiA.append(vC);
        vA.setNeighbors(neiA);
        
        LinkedList <Warehouse> neiB = new LinkedList();
        neiB.append(vC);
        neiB.append(vD);
        vB.setNeighbors(neiB);
=======
        Interface newScreen = new Interface();
        newScreen.setVisible(true);
        newScreen.setLocationRelativeTo(null);
>>>>>>> Stashed changes
        
        LinkedList <Node> neiC = new LinkedList();
        neiC.append(vD);
        neiC.append(vE);
        vC.setNeighbors(neiC);
        
        LinkedList <Warehouse> neiD = new LinkedList();
        neiD.append(vE);
        vD.setNeighbors(neiD);
        
        LinkedList <Warehouse> neiE = new LinkedList();
        neiE.append(vA);
        vD.setNeighbors(neiE);
        
        BFS bfs = new BFS();
        bfs.transverse(vA);


    }
    
}

