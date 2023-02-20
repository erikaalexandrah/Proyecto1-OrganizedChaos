/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph;

import AdjListGraph.linkedList.LinkedList;
import AdjListGraph.linkedList.ListNode;
import Interface.Interface;
//import Interface.NewWarehouse2;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
// IMPORTAR PARA MANEJO DE TXT
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// IMPORTAR GRAPHSTREAM PARA GRAFICAR GRAFO
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.DefaultView;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;


/**
 *
 * @author David
 */
public class App {
    
    private LinkedList clients;
    private LinkedList products;
    private GraphMA graphMA;
    private LinkedList orders;
    private static App app; 

    /**
    *@Descripcion: constructor privado de la clase App
    * @author: Catalina Matheus
    * @version: 19/02/2023
    **/
    private App() {
        this.clients = new LinkedList(); 
        this.products = new LinkedList(); 
        this.graphMA =  new GraphMA(10); 
        this.orders = new LinkedList(); 
           
    }
    
    /**
     * @Descripcion: método que retorna la única instancia de la clase App (crea el objeto si no existe)
     * @author: Catalina Matheus
     * @version: 19/02/2023
     * @return 
     */
    public static synchronized App getInstance(){
        if (app == null){
            app = new App();
        }
        return app; 
    }
    
  
    public void restartProgram() throws FileNotFoundException{
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
      
        
        //// SE UTILIZA LIBRERIA PARA DESGLOSAR EL STRING Y PODER CREAR LOS OBJETOS DE CLASE ALMACEN Y PRODUCTOS 
        Pattern p = Pattern.compile("([A-Z]):(.*?);", Pattern.DOTALL);
        Matcher m = p.matcher(txtWarehouse);
        while (m.find()) {
            String names = m.group(1);
            String productsStr = m.group(2);
            LinkedList products =  new LinkedList();
            Pattern p2 = Pattern.compile("(\\w+),(\\d+)");
            Matcher m2 = p2.matcher(productsStr);
            while (m2.find()) {
             String productName = m2.group(1);
                int productQuantity = Integer.parseInt(m2.group(2));
                products.append(new Product(productName, productQuantity));
            }
            this.getGraph().addVertice(new Warehouse(names,products));
         }
        
        
         // guardamos lo que está en "txtEdge" el string "txtEdge" esta cuadrado asi: A,B,10 -> donde A es el 'originNode', B es el 'nextNode'y 10 es el 'weight'cada salto de linea es un 'edge' nuevo
         if (!"".equals(txtEdge)){
             String[] edgesSplit = txtEdge.split("\n"); // separa cada ruta
             for (int i = 1; i < edgesSplit.length; i++) {
                 String[] e= edgesSplit[i].split(","); // separa cada componente de la ruta
                 Edge edge = new Edge(e[0], e[1], Integer.parseInt(e[2])); // se crea instancia 
                 try {
                     this.getGraph().addEdge(edge);
                 } catch (Exception ex) {
                     //// FLAGGGGGGGG VER QUE ES ESTO QUE ME OBLIGA A PONERLO
                     Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }  
            }
//    JOptionPane.showMessageDialog(null, "Los archivos se cargaron con éxito."); 
         
    }
    
    
    
    public void showGraph(){
        // Se crea un objeto de la clase graphstream
        Graph graph2 = new SingleGraph("Amazon");
        // Se recorre nuestro grafo para agregar cada ALMACEN(WAREHOUSE) como NODO de la clase graphstream.
       for (int k=0;k<this.graphMA.getNumVertices();k++){
           graph2.addNode(this.graphMA.getVertices()[k].getName());
       }
       // Se recorre nuestro grafo para agregar cada ARISTA(EDGE) como NODO de la clase graphstream.
       for (int i=0; i<this.graphMA.getNumVertices(); i++){
           for (int j=0; j<this.graphMA.getNumVertices(); j++){
            if (this.graphMA.getMatAd()[i][j]>0){
                graph2.addEdge(this.graphMA.getVertices()[i].getName() + "-" + this.graphMA.getVertices()[j].getName(),this.graphMA.getVertices()[i].getName(),this.graphMA.getVertices()[j].getName(),true);
            }
        }
    }
        graph2.display();
    }
    
    
    public boolean itExists(LinkedList list, Product product){
        // revisa si ese producto está en la lista
        boolean exists = false; 
        
        if(list.getSize() == 0){
            return exists; 
        }else{
            ListNode aux = list.getpFirst(); 
            for (int i = 0; i < list.getSize(); i++) {
                if (((Product)aux.getElement()).getName().equals(product.getName())) {
                    exists = true; 
                    return exists;
                }aux.getpNext(); 
 
        }return exists; 
      
    }
    }
     
    public void start () {
        try {
            this.restartProgram();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void addClient(Client client){
        this.clients.append(client); 
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

    /**
     * @return the graph
     */
    public GraphMA getGraph() {
        return graphMA;
    }

    /**
     * @param graph the graph to set
     */
    public void setGraph(GraphMA graph) {
        this.graphMA = graphMA;
    }
    
    
    
}
