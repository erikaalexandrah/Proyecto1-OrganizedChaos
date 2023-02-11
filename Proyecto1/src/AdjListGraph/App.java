/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph;

import AdjListGraph.linkedList.LinkedList;
import Interface.Interface;

/**
 *
 * @author david
 */
public class App {
    
    private LinkedList clients = new LinkedList ();
    private LinkedList products = new LinkedList ();
    private LinkedList grafo = new LinkedList ();
    private LinkedList orders = new LinkedList ();

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
