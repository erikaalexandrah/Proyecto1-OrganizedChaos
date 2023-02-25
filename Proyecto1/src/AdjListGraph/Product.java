/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdjListGraph;

/**
 *@Descripcion: clase producto
 * @author Erika Hernández
 */
public class Product {
    private String name; 
    private int quantity;

    /**
     * @Descipcion: constructor de la clase cuando se le pasa el nombre del producto
     * @auhtor: Erika Hernández
     * @param name 
     */
    public Product(String name) {
        this.name = name;
        this.quantity = 0;
    }

    /**
     * @Descripcion: Constructor de la clase cuando se le pasa el nombre y la cantidad del producto
     * @author: Erika Hernández
     * @param name
     * @param quantity 
     */
    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Product() {
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
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    
}
