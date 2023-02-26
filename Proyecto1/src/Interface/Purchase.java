/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import AdjListGraph.App;
import AdjListGraph.Client;
import AdjListGraph.Product;
import AdjListGraph.Warehouse;
import AdjListGraph.linkedList.LinkedList;
import AdjListGraph.linkedList.ListNode;
import javax.swing.JOptionPane;

/**
 *@Descripcion: interfaz gráfica para registrar compras
 * @version : 24/02/2023
 * @author Catalina Matheus 
 */
public class Purchase extends javax.swing.JFrame {

    /**
     * Creates new form Purchase
     */
    
    private App app = App.getInstance(); 
    private LinkedList products = new LinkedList(); // para ir guardando los productos del cliente 
    
    /**
     * @Descripcion: crea ventana Purchase y coloca la información en los combo box
     * @author: Catalina Matheus 
     * @version : 24/02/2023
     */
    public Purchase() {
        initComponents();
        this.setVisible(true); 
        this.setLocationRelativeTo(null);
        
        
        // PARA AGREGAR EN LA LISTA DE ALMACENES: 
        for (int i = 0; i < app.getGraph().getNumVertices(); i++) {
            warehousesDisplay.addItem(app.getGraph().getVertices()[i].getName());
        }
       
        // PARA AGREGAR EN LA LISTA DE PRODUCTOS:  
         LinkedList allProducts = new LinkedList(); // lista que va a tener todos los productos (repetidos)
            for (int j = 0; j < app.getGraph().getNumVertices(); j++) {
                ListNode aux = app.getGraph().getVertices()[j].getProducts().getpFirst(); 
                for (int k = 0; k < app.getGraph().getVertices()[j].getProducts().getSize(); k++) {
                    allProducts.append(aux.getElement());
                    aux = aux.getpNext();
                }
                
            }
         LinkedList allProductsSet = new LinkedList(); // lista con todos los productos sin repetir
         
         ListNode aux2 = allProducts.getpFirst(); 
         for (int j = 0; j < allProducts.getSize(); j++) {
             if(allProductsSet.getSize() == 0){
                 allProductsSet.append(aux2.getElement());
            
        } else{
                 if (!app.itExists(allProductsSet, (Product)aux2.getElement())) {// si no existe se agrega
                     allProductsSet.append(aux2.getElement());
                 }else{// si existe hay que sumarle el resto de los elementos
                    ListNode aux3 = allProductsSet.getpFirst(); 
                     for (int i = 0; i < allProductsSet.getSize(); i++) {
                         if (((Product)aux2.getElement()).getName().equals(((Product)aux3.getElement()).getName())) {
                             ((Product)aux3.getElement()).setQuantity(((Product)aux3.getElement()).getQuantity() + ((Product)aux2.getElement()).getQuantity());
                         } aux3= aux3.getpNext(); 
                     }
                 }
             }
             aux2 = aux2.getpNext();
      
        }
         
         ListNode aux4 = allProductsSet.getpFirst(); 
         for (int i = 0; i < allProductsSet.getSize(); i++) {
            productsDisplay.addItem(((Product)aux4.getElement()).getName()+". Cantidad: " + ((Product)aux4.getElement()).getQuantity());
             aux4 = aux4.getpNext(); 
        }
           
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputLastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputName = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        warehousesDisplay = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        inputLocation = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        productsDisplay = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        inputQuantity = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REALIZAR COMPRA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 120, 30));

        jLabel2.setText("Por favor, suministre los siguientes datos: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 250, 30));

        jLabel3.setText("APELLIDO: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));
        getContentPane().add(inputLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 150, -1));

        jLabel4.setText("ÁLMACEN: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        inputId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIdActionPerformed(evt);
            }
        });
        getContentPane().add(inputId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 170, -1));

        jLabel5.setText("NOMBRE: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));
        getContentPane().add(inputName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 140, -1));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 140, -1));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 140, -1));

        jLabel6.setText("CANTIDAD: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        warehousesDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warehousesDisplayActionPerformed(evt);
            }
        });
        getContentPane().add(warehousesDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 120, -1));

        jLabel7.setText("CÉDULA: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));
        getContentPane().add(inputLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 270, -1));

        jLabel8.setText("DIRECCIÓN PARA EL ENVÍO: ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        productsDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsDisplayActionPerformed(evt);
            }
        });
        getContentPane().add(productsDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 160, -1));

        jLabel9.setText("PRODUCTOS : ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));
        getContentPane().add(inputQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 100, -1));

        jToggleButton1.setText("REGISTRAR PRODUCTO");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        jToggleButton2.setText("ATRÁS");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jToggleButton3.setText("REGISTRAR COMPRA");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, -1));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIdActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    
    /**
     * @Descripcion: procedimiento que guarda toda la información colocada en la ventana en la lista cliente de app
     * @version: 24/02/2023
     * @author: Catalina Matheus
     * @param evt 
     */
    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
       if(app.getGraph().getNumVertices() == 0){
            JOptionPane.showMessageDialog(null, "No es posible realizar una compra ya que los almacenes y productos no se encuentran en la base de datos.\nCargue un txt o cargue el repositorio. ");
        }else{
             try{
                 String name = inputName.getText();
                 if (name. equals("")) throw new Exception("Debe colocar su nombre.");
                 String lastName = inputLastName.getText(); 
                 if (lastName. equals("")) throw new Exception("Debe colocar su apellido.");
                 int id = Integer.parseInt(inputId.getText()); 
                 
                 String location = inputLocation.getText(); 
                 if (location. equals("")) throw new Exception("Debe colocar la ubicación.");
                 String warehouseStr = (String) warehousesDisplay.getSelectedItem(); 
                
                 
                 Warehouse wa = app.getGraph().findWarehouse(warehouseStr);
               
                 
                 if(products.getSize() == 0) throw new Exception(" No hay productos en el carrito."); 
                 
                 Client client = new Client(name, lastName,id, location, wa, products); 
                  boolean productsAvailable = app.productsAvailableInWarehouse(client.getProducts(), client.getWarehouse()); 

           if (productsAvailable){
               app.addClient(client);
               JOptionPane.showMessageDialog(null, "Registro exitoso. El almacén escogido tiene todos los productos que desea."); 
    
           }else{
                  boolean algorithDijkstra = app.Dijkstra(wa, client.getProducts()); // esto nos retorna si existe un path o no 
                   if (algorithDijkstra) {
                   app.addClient(client);  
                   JOptionPane.showMessageDialog(null, "Registro exitoso. El almacén escogido tiene todos los productos que desea."); 
                   this.setVisible(false);
                   Interface mainInterface = new Interface();
                   mainInterface.setVisible(true);
                   } else {
                   JOptionPane.showMessageDialog(null, "No se logró procesar el pedido.\nActualmente ningún almacen tiene todos los productos que desea."); 
               }

         }
             inputName.setText(""); 
              inputLastName.setText(""); 
              inputId.setText(""); 
               inputLocation.setText("");
                
             }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error. No se logró registar la compra");
                inputName.setText(""); 
                inputLastName.setText(""); 
                inputId.setText(""); 
                inputLocation.setText("");
            }} 
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void warehousesDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warehousesDisplayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_warehousesDisplayActionPerformed

    /**
     * @Descripcion: procedimiento que guarda los productos colocas por el usuario en la lista products
     * @version: 24/02/2023
     * @author: Catalina Matheus
     * @param evt 
     */
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // se van a agregar los productos que la persona escoja: 
        String product = (String) productsDisplay.getSelectedItem(); 
        
        String[] productArray = new String[2]; 
        productArray = product.split(". "); 
        int quantity = Integer.parseInt(inputQuantity.getText()); 
        
        
        Product productObj = new Product(productArray[0], quantity); 
        products.append(productObj);
        System.out.println(products);
        
        
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void productsDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsDisplayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productsDisplayActionPerformed

    /**
     * @Descripcion: abre ventana principal
     * @author: Catalina Matheus
     * @version : 24/02/2023
     * @param evt 
     */
    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false); 
        Interface window1 = new Interface(); 
        window1.setVisible(true); 
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Purchase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputId;
    private javax.swing.JTextField inputLastName;
    private javax.swing.JTextField inputLocation;
    private javax.swing.JTextField inputName;
    private javax.swing.JTextField inputQuantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JComboBox<String> productsDisplay;
    private javax.swing.JComboBox<String> warehousesDisplay;
    // End of variables declaration//GEN-END:variables
}
