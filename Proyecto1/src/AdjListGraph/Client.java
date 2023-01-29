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
    private String name; 
    private int id; 
    private String location; 
    private Warehouse warehouse; 
    private LinkedList products; 
    
    /**
     * Descripcion: Muestra un mensaje al cliente que su pedido fue procesado con éxito. 
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
    
    
    
    
    
}

