/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph;

import AdjListGraph.linkedList.LinkedList;
import AdjListGraph.linkedList.ListNode;
import Interface.Interface;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        
        LinkedList  almacenes = new LinkedList();
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
            almacenes.append(new Warehouse(names, products));
         }
        
        
        ///  MÉTODO PARA IMPRIMIR LOS ALMACENES CON SU INVENTARIO 
        
         
        // Se crea un nodo auxiliar que devuelva el primer elemento de la lista almacenes.
        // Se itera sobre la lista almacenes
        ListNode pAux = almacenes.getpFirst();
        for (int i = 0; i<almacenes.getSize(); i++){
            // Se obtiene al objeto (de tipo WAREHOUSE) guardado en ese nodo.
            Warehouse pAlmacen = (Warehouse) pAux.getElement();
            // Imprimimos al nombre del almacen. 
            System.out.println(pAlmacen.getName());
           // Creamos una copia de la lista de productos que guarda ese almacen para poderna iterar. 
            LinkedList pProducts = pAlmacen.getProducts();
            // Se crea un nodo auxiliar de la lista para obtener el pFirst
            ListNode pAux1 = pProducts.getpFirst(); 
            // Se itera la lista de productos de ese almacen
            for (int y=0; y<pProducts.getSize(); y++){
                // Se crea un objeto de tipo Producto para poder obtener sus atributos. 
                Product pProduct = (Product) pAux1.getElement();
                System.out.println("El articulo es --> " + pProduct.getName() + " La cantidad disponible es: "+ pProduct.getQuantity());
                pAux1=pAux1.pNext;
            }
            pAux= pAux.pNext;  
        
    }
        
        
         // guardamos lo que está en "txtEdge" el string "txtEdge" esta cuadrado asi: A,B,10 -> donde A es el 'originNode', B es el 'nextNode'y 10 es el 'weight'cada salto de linea es un 'edge' nuevo
        
        LinkedList importedEdges = new LinkedList(); // lista donde estan todas las instancias de la clase edge
        
  
         if (!"".equals(txtEdge)){
             String[] edgesSplit = txtEdge.split("\n"); // separa cada ruta
             for (int i = 1; i < edgesSplit.length; i++) {
                 String[] e= edgesSplit[i].split(","); // separa cada componente de la ruta
                 Edge edge = new Edge(e[0], e[1], Integer.parseInt(e[2])); // se crea instancia 
                 importedEdges.append(edge); // se guarda en la lista
             }
            
           
                
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
