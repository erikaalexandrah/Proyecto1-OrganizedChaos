/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AdjListGraph;



import AdjListGraph.linkedList.LinkedList;
import Interface.Interface;

/**
 * @Descripcion: clase main que tiene el método main para correr el programaß
 * @author David Dávila
 * @version: 11/02/2023
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   
        App app =  App.getInstance();
        Interface newScreen = new Interface();
        newScreen.setVisible(true);
        newScreen.setLocationRelativeTo(null);
        newScreen.getApp(app);
  
    }
    
}
