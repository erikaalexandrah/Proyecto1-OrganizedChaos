/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph;

import AdjListGraph.linkedList.LinkedList;
import Interface.Interface;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class App {
    
    private LinkedList clients = new LinkedList ();
    private LinkedList products = new LinkedList ();
    private LinkedList grafo = new LinkedList ();
    private LinkedList orders = new LinkedList ();

    public void restartProgram() throws FileNotFoundException{
        String line;
        String txtAlmacenes = "";
        String txtRutas = "";
        String path = "test//FileRestarter.txt";
       
        File file = new File(path);
        try {
            FileReader fr = new FileReader (file);
            BufferedReader br = new BufferedReader (fr);
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    while (!line.equals("Rutas;")){
                        if (line.contains("Almacen")){
                            String[] arregloAux = line.split(" ");
                            txtAlmacenes +=arregloAux[1] + "\n";
                 
                    }else{
                          txtAlmacenes += line + "\n";  
                        }
                      
                    }
                    txtRutas += line +"\n";
                    
                    
                }
            }
            System.out.println(txtAlmacenes);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se logró cargar el archivo. Intente nuevamente.");
        }
        
    }
    
    public void start (){
      
        
    }
    
    
    /**
     * @return the clients
     */
    public LinkedList getClients() {
        return clients;
    }

    /**
     * @param clients the clients to set
     */
    public void setClients(LinkedList clients) {
        this.clients = clients;
    }

    /**
     * @return the products
     */
    public LinkedList getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(LinkedList products) {
        this.products = products;
    }

    /**
     * @return the grafo
     */
    public LinkedList getGrafo() {
        return grafo;
    }

    /**
     * @param grafo the grafo to set
     */
    public void setGrafo(LinkedList grafo) {
        this.grafo = grafo;
    }

    /**
     * @return the orders
     */
    public LinkedList getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(LinkedList orders) {
        this.orders = orders;
    }
    
    
    
}
