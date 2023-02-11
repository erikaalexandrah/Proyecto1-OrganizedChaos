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
        String txtAlmacenes = "";
        String txtRutas = "";
        String path = "src//Files//FileRestarter.txt";
       
        File file = new File(path);
        try {
            FileReader fr = new FileReader (file);
            BufferedReader br = new BufferedReader (fr);
//            System.out.println("FLAG 1");
            while ((line = br.readLine()) != null) {
//                System.out.println("FLAG 2");
                if (!line.isEmpty()) {
//                    System.out.println("FLAG 3");
                    while (!line.equals("Rutas;")){
//                        System.out.println("FLAG 4");
                        if (line.contains("Almacen") && !line.contains(";")){
//                            System.out.println("FLAG 5");
//                            System.out.println(line);
                            String[] arregloAux = line.split(" ");
                          
                            txtAlmacenes +=arregloAux[1] + "\n";
                            
//                            System.out.println("FLAG 6");
                 
                    }else if(line.contains(",")){
//                            System.out.println("FLAG 7");
                          txtAlmacenes += line + "\n";  
                        }
                      
                    }
//                    System.out.println("FLAG 8");
                    txtRutas += line +"\n";
                    
                    
                }
                br.close();
            }
           br.close();
            System.out.println(txtAlmacenes);
            System.out.println(txtRutas);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se logró cargar el archivo. Intente nuevamente.");
        }
      
        
        
//        Interface newScreen = new Interface();
//        newScreen.setVisible(true);
//        newScreen.setLocationRelativeTo(null);
//        
    }
    
}
