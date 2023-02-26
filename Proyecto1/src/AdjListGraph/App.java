/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph;

import AdjListGraph.linkedList.LinkedList;
import AdjListGraph.linkedList.ListNode;
//import Interface.NewWarehouse2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
// IMPORTAR PARA MANEJO DE TXT
import java.util.regex.Matcher;
import java.util.regex.Pattern;



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
     * @return: App 
     */
    public static synchronized App getInstance(){
        if (app == null){
            app = new App();
        }
        return app; 
    }
    
    /**
     * @Descripcion: procedimiento para guardar la información que se encuentra en un txt.
     * @author: Erika Hernandez & Catalina Matheus
     * @version: 10/02/2023
     * @param path 
     */
    
    public void saveFile( String path){
        String line;
        String txt = "";
        String txtWarehouse = "";
        String txtEdge = "";
      
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
        
    }

     /**
     * @Descripcion: procedimiento que guarda los almacenes y rutas de la base de datos en un txt. 
     * @author: Catalina Matheus
     * @version: 22/02/2023
     */
    public void updateRepository(){
        // para escribir en el txt
        String fileStr = ""; 
        if (0 != graphMA.getVertices().length) {// getVertices() me retorna un arreglo de warehouses 
            // no necesarimanete esta llena 
         
            Warehouse[] warehouses = graphMA.getVertices(); 
            // se colocan primero en el String los almacenes
            fileStr += "Almacenes;\n";
            for (int i = 0; i < warehouses.length && warehouses[i] != null; i++) {
                fileStr += "Almacen "+ warehouses[i].getName()+":\n"; // coloca  el nombre del almacen
                ListNode aux = warehouses[i].getProducts().getpFirst(); 
                for (int j = 0; j < warehouses[i].getProducts().getSize(); j++) {
                    if (aux.getpNext() != null) {
                        fileStr += ((Product)aux.getElement()).getName()+","+ ((Product)aux.getElement()).getQuantity()+"\n"; // coloca el nombre
                    }else{// es el ultimo producto de la lista de productos
                        fileStr += ((Product)aux.getElement()).getName()+","+((Product)aux.getElement()).getQuantity()+";\n";
                        
                    } aux = aux.getpNext(); 
                    
                }
            }
            
            // Ahora se colocan las rutas: 
            fileStr +="Rutas;\n";
            for (int i = 0; i < graphMA.getNumVertices(); i++) {
                String start = graphMA.getVertices()[i].getName();
                for (int j = 0; j < graphMA.getMatAd()[i].length; j++) {
                    if (graphMA.getMatAd()[i][j] != 0) {
                        
                        fileStr += start +","+ graphMA.getVertices()[j].getName()+","+graphMA.getMatAd()[i][j]+"\n";
                    }
                }
            }
            
            
            // Se guarda todo en el txt: 
            
            try{
                PrintWriter pw = new PrintWriter("src//Files//FileRestarter.txt");
                pw.print(fileStr); 
                pw.close(); 
                JOptionPane.showMessageDialog(null, "La actualización del repositorio fue realizada con éxito. "); 
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se logró actualizar el repositorio"); 
            }
            
        }
      
    }
    
    /**
     * @Descripcion: método que revisa si un producto se encuentra en una lista
     * @author: Catalina Matheus
     * @version: 19/02/2023
     * @param list
     * @param product
     * @return 
     */
    
    // método que revisa si un producto se encuentra en la lista pasada como parámetro
    public boolean itExists(LinkedList list, Product product){
        // revisa si ese producto está en la lista
        boolean exists = false; 
        
        if(list.getSize() == 0){
            return exists; 
        }else{
            ListNode aux = list.getpFirst(); 
            for (int i = 0; i < list.getSize(); i++) {
                if (((Product)aux.getElement()).getName().compareToIgnoreCase(product.getName()) == 0) {
                    exists = true; 
                    return exists;
                }aux.getpNext(); 
 
            }return exists; 
      
        }
    }
    
    /**
     * @Descripcion: método que devuelve un producto en una lista
     * @author: Catalina Matheus
     * @version: 19/02/2023
     * @param list
     * @param product
     * @return 
     */
    
    // método que retorna el producto de la lista: 
    public Product getProduct(LinkedList list, Product product){
        Product productFound = null; 
        if (app.itExists(list, product)) {
            ListNode aux = list.getpFirst(); 
            for (int i = 0; i < list.getSize(); i++) {
                if (((Product)aux.getElement()).getName().equals(product.getName())) {
                    productFound = (Product)aux.getElement(); 
                    return productFound; 

                }
                aux = aux.getpNext(); 
                
            }
            
        }
    return productFound; 
    }
    
    
    /**
     * @Descripcion: método que revisa si todos los productos de una lista estan en un almacen
     * @author: Catalina Matheus
     * @version: 19/02/2023
     * @param productsClient
     * @param warehouse
     * @return 
     */
    
//    public boolean productsAvailableInWarehouse(LinkedList productsClient, Warehouse warehouse){
//        boolean productsAvailable = true;
//        
//        ListNode aux = productsClient.getpFirst(); 
//       
//        for (int i = 0; i < productsClient.getSize(); i++) {
//            if(!this.itExists(warehouse.getProducts(), (Product)aux.getElement())){
//                productsAvailable = false; 
//                return productsAvailable; 
//            } else if (((Product)aux.getElement()).getQuantity() > app.getProduct(warehouse.getProducts(), ((Product)aux.getElement())).getQuantity()) {
//                productsAvailable = false; 
//                return productsAvailable; 
//            }
//            aux = aux.getpNext(); 
//        }
//        
//        // si al final del for loop productsAvailable es true es porque si estan todos los productos y hay la cantidad que el cliente pide
//        // ahora se descuentan las cantidades pedidas: 
//        
//        ListNode aux2 = productsClient.getpFirst(); 
//        if (productsAvailable) {
//            for (int i = 0; i < productsClient.getSize(); i++) {
//                Product pro = app.getProduct(warehouse.getProducts(), (Product)aux2.getElement()); 
//                pro.setQuantity(pro.getQuantity() -((Product) aux2.getElement()).getQuantity()); 
//                aux2 = aux2.getpNext(); 
//            } 
//        }
//        
//        return productsAvailable; 
//    }
//    
    /**
     * @Descripcion: método que busca el almacen que tenga todos los productos de una lista pasada como parametro
     * @author: Catalina Matheus
     * @version: 20/02/2023
     * @param productsClient
     * @return 
     */
    // revisa que almacen tiene todos los productos pedidos por el cliente y te devuelve el almacen y descuenta la cantidad al almacen
    public Warehouse findWarehouse(LinkedList productsClient){
        Warehouse[] vertices = app.getGraph().getVertices(); // arreglo de almancenes
        Warehouse foundWarehouse = null; 
       
        for (int i = 0; i < vertices.length; i++) {
            if (productsAvailableInWarehouse(productsClient, vertices[i])) {// si se encuentran todos los productos 
                foundWarehouse = vertices[i]; 
                break; 
            }
            
        }return foundWarehouse; 
        // si se encuentra el almacen se retorna el mismo, si no se encuentra se retorna null
    }
    
    /**
     * @Descripcion: método que busca el índice de un vértice en la lista de vertices del grafo. Si no encuentra el almacen retorna -1
     * @author: Catalina Matheus 
     * @version: 24/02/2023
     * @param warehouse
     * @return 
     */
    
       public int getIndexVertex(Warehouse warehouse){
           int index = -1; 
           
           for (int i = 0; i < graphMA.getVertices().length; i++) {
               
               if(graphMA.getVertices()[i] == null) break; 
               else{
                   if (graphMA.getVertices()[i].getName().equals(warehouse.getName())) {
                       index = i; 
                       
                   }
               }
               
           } return index; 
        
    }
  
        public boolean productsAvailableInWarehouse(LinkedList productsClient, Warehouse warehouse){
    boolean productsAvailable = true;
    
    ListNode aux = productsClient.getpFirst(); 
   
    for (int i = 0; i < productsClient.getSize(); i++) {
        boolean foundProduct = false;
        ListNode aux2 = warehouse.getProducts().getpFirst();
        for (int j = 0; j < warehouse.getProducts().getSize(); j++) {
            if (((Product)aux.getElement()).getName().equals(((Product)aux2.getElement()).getName())) {
                foundProduct = true;
                if (((Product)aux.getElement()).getQuantity() > ((Product)aux2.getElement()).getQuantity()) {
                    productsAvailable = false; 
                    return productsAvailable;
                }
                break;
            }
            aux2 = aux2.getpNext();
        }
        if (!foundProduct) {
            productsAvailable = false;
            return productsAvailable;
        }
        aux = aux.getpNext(); 
    }
    
    // si al final del for loop productsAvailable es true es porque si estan todos los productos y hay la cantidad que el cliente pide
    // ahora se descuentan las cantidades pedidas: 
    
    ListNode aux3 = productsClient.getpFirst(); 
    if (productsAvailable) {
        for (int i = 0; i < productsClient.getSize(); i++) {
            ListNode aux4 = warehouse.getProducts().getpFirst();
            while (aux4 != null) {
                if (((Product)aux3.getElement()).getName().equals(((Product)aux4.getElement()).getName())) {
                    ((Product)aux4.getElement()).setQuantity(((Product)aux4.getElement()).getQuantity() - ((Product)aux3.getElement()).getQuantity());
                    break;
                }
                aux4 = aux4.getpNext();
            }
            aux3 = aux3.getpNext(); 
        } 
    }
    return productsAvailable; 
}
  
  public boolean Dijkstra(Warehouse warehouse, LinkedList productsClient) {
        
        int source = warehouse.getNumVertice();
        // Inicializa distancias de cada vértice como infinito
        int[] dist = new int[graphMA.getNumVertices()];
        for (int i = 0; i < graphMA.getNumVertices(); i++) {
            dist[i] = Integer.MAX_VALUE;
    }
    
        // Inicializa el conjunto de vertices ya visitados
        boolean[] visited = new boolean[graphMA.getNumVertices()];

        // La distancia al origen es 0
        dist[source] = 0;

        // Inicializa los predecesores de cada vértice como -1
        int[] pred = new int[graphMA.getNumVertices()];
        for (int i = 0; i < graphMA.getNumVertices(); i++) {
            pred[i] = -1;
        }

        // Encuentra la ruta más corta a cada vértice
        for (int i = 0; i < graphMA.getNumVertices() - 1; i++) {
            // Encuentra el vértice no visitado con la distancia mínima
            int u = findMinimum(dist, visited);

            // Marca el vértice como visitado
            visited[u] = true;

            // Actualiza las distancias de los vecinos de u
            for (int v = 0; v < graphMA.getNumVertices(); v++) {
                if (!visited[v] && graphMA.getMatAd()[u][v] != 0 && 
                    dist[u] != Integer.MAX_VALUE && 
                    dist[u] + graphMA.getMatAd()[u][v] < dist[v]) {
                    dist[v] = dist[u] + graphMA.getMatAd()[u][v];
                    pred[v] = u;
                }
            }
        }

        // Imprime la ruta más corta desde A hasta E
        Warehouse destWarehouse = this.findWarehouse(productsClient); 
        System.out.println(destWarehouse);
        int dest = destWarehouse.getNumVertice();
        if (dist[dest] == Integer.MAX_VALUE) {
            String print = "no se puede llegar desde " + source + " hasta " + dest+"."; 
            JOptionPane.showMessageDialog(null, "El almacen escogido no tiene todos los productos que desea.\n"+source+ " si los tiene, sin embargo, "+print+"\nDebido a esto se canceló la compra."); 
            return false; 
//            System.out.println("No se puede llegar desde " + source + " hasta " + dest);
        } else {
            JOptionPane.showMessageDialog( null, "La ruta más corta desde " + warehouse.getName() + " hasta " + destWarehouse.getName() + " es: " + printPath(pred, dest) +"\nLa distancia es "+dist[dest]); 
            return true; 
        }
}

    // Imprime la ruta desde el origen hasta el vértice dado
    private String printPath(int[] pred, int vertex) {
        if (vertex == -1) {
            return "";
        }
        printPath(pred, pred[vertex]);
        return vertex + " ";
    }

    private int findMinimum(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < graphMA.getNumVertices(); i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
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
