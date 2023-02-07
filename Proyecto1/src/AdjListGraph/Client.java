/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph;

import javax.swing.JOptionPane;
import AdjListGraph.linkedList.LinkedList;

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
     * Muestra un mensaje al cliente que su pedido fue procesado con éxito. 
     * @author: Catalina Matheus
     * @version: 24/01/2023
     */
    public void show(){
        
        JOptionPane.showMessageDialog(null, "Cliente: " +name + " \nSu pedido fue procesado con éxito.\n Para ver los productos comprados de a siguiente. ");
        JOptionPane.showMessageDialog(null, "PRODUCTOS:\n ");// falta que se vean los productos comprados
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

