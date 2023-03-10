/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph;

import javax.swing.JOptionPane;
import AdjListGraph.linkedList.LinkedList;
import AdjListGraph.linkedList.ListNode;


/**
 *Descripcion: clase Cliente
 * @author Catalina Matheus
 * @version: 24/01/2023
 */
public class Client {

    // atributos de la clase
    private String name; // nombre del cliente
    private String lastName; // apellido del cliente
    private int id; // cédula de identidad del cliente
    private String location; // la dirección del cliente
    private Warehouse warehouse; // PREGUNTAR: almacen que el cliente desea 
    private LinkedList products; // una lista con los productos que el cliente desea
    
 
    
    /**
     * @Descripcion: construtor de la clase
     * @author: Catalina Matheus
     * @version: 24/01/2023
     * @param name
     * @param lastName
     * @param id
     * @param location
     * @param warehouse
     * @param products 
     */

    public Client(String name, String lastName, int id, String location, Warehouse warehouse, LinkedList products) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.location = location;
        this.warehouse = warehouse;
        this.products = products; 
    }


    /**
     * Muestra un mensaje al cliente que su pedido fue procesado con éxito. 
     * @author: Catalina Matheus
     * @version: 24/01/2023
     */
    
    public void show(){
        
        if(!this.products.isEmpty()){
            JOptionPane.showMessageDialog(null, "Cliente: " +getName() + " \nSu pedido fue procesado con éxito.\n Para ver los productos comprados de a siguiente. ");
        
        // para desplegar producto: 
        String productString = ""; 
        Product product = new Product();
        for (int i = 0; i < getProducts().getSize(); i++) {
            ListNode aux = getProducts().getpFirst(); 
            product = (Product) aux.getElement();
            productString += product.getName() + "\n"; 
            aux = aux.getpNext(); 
  
       }JOptionPane.showMessageDialog(null, "PRODUCTOS:\n " + productString);// falta que se vean los productos comprados
        }
        else{
            JOptionPane.showMessageDialog( null, "No se pudo procesar su compra ya que no hay productos. ");
        }
         
        
        }

    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the warehouse
     */
    public Warehouse getWarehouse() {
        return warehouse;
    }

    /**
     * @param warehouse the warehouse to set
     */
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
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

        
    

    
}

