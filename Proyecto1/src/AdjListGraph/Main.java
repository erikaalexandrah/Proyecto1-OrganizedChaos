/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AdjListGraph;

import Interface.Interface;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String line;
        String txt = "";
        String txtWarehouse = "";
        String txtEdge = "";
        String path = "src//Files//FileRestarter.txt";
       
        
        //// LEER EL TXT Y ALMACENARLO EN UNA VARIABLE 
        File file = new File(path);
        try {
            FileReader fr = new FileReader (file);
            BufferedReader br = new BufferedReader (fr);
            while ((line = br.readLine()) != null) {
                if (!line.equals("Almacenes;")){
                    if (line.contains("Almacen")){
                      String[] arrayAux1 = line.split(" ");
                        txt += arrayAux1[1] + "\n";
                    } else {
                        txt += line + "\n";
                }
            }
            }

            br.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se logró cargar el archivo. Intente nuevamente.");
        }
        
        String[] arrayAux = txt.split("Rutas;");
        txtWarehouse = arrayAux[0];
        txtEdge = arrayAux[1];
         
        System.out.println(txtWarehouse);
        System.out.println(txtEdge);
        
        
        

//        Interface newScreen = new Interface();
//        newScreen.setVisible(true);
//        newScreen.setLocationRelativeTo(null);
//        
    }
    
}
