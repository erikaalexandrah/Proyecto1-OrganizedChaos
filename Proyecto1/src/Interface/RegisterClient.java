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
 * @Descripción: interfaz gráfica para que el cliente realice su compra
 * @author Catalina Matheus
 * @version: 19/02/2023
 */
public class RegisterClient extends javax.swing.JFrame {
    
    private App app = App.getInstance(); 
    
    /**
     * @Descripción: constructor 
     * @author Catalina Matheus
     * @version: 19/02/2023
     */
    public RegisterClient() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null); 
          
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
        inputName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputLastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        inputLocation = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        warehousesAvailable = new javax.swing.JTextArea();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        inputWarehouse = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        availableProducts = new javax.swing.JTextArea();
        jToggleButton3 = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        inputProducts = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jToggleButton4 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel1.setText("REALIZAR PEDIDO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 120, 40));

        jLabel2.setText("Por favor, ingrese los siguientes datos personales: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 330, 30));

        jLabel3.setText("Nombre: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
        getContentPane().add(inputName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 120, -1));

        jLabel4.setText("Apellido: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, 20));
        getContentPane().add(inputLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 130, -1));

        jLabel5.setText("Cédula: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, -1));
        getContentPane().add(inputId, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 210, -1));

        jLabel6.setText("Dirección para el envío: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        getContentPane().add(inputLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 510, -1));

        jToggleButton1.setText("REGISTRAR DATOS");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 710, -1, -1));

        jLabel7.setText("Almacenes disponibles:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 160, 20));

        warehousesAvailable.setColumns(20);
        warehousesAvailable.setRows(5);
        jScrollPane1.setViewportView(warehousesAvailable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 640, 70));

        jToggleButton2.setText("VER ALMACENES");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, -1, -1));

        jLabel8.setText("Coloque el nombre de el almacen a donde quiere hacer el pedido: ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        inputWarehouse.setText("Ejemplo: A");
        getContentPane().add(inputWarehouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 660, -1));

        jLabel9.setText("Productos disponibles:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 180, 20));

        availableProducts.setColumns(20);
        availableProducts.setRows(5);
        jScrollPane2.setViewportView(availableProducts);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 660, 60));

        jToggleButton3.setText("VER PRODUCTOS");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, -1, -1));

        jLabel10.setText("Coloque los productos y la cantidad que desea: ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 380, -1));

        inputProducts.setColumns(20);
        inputProducts.setRows(5);
        jScrollPane3.setViewportView(inputProducts);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 680, 100));

        jTextField1.setText("Coloca: el nombre del producto// cantidad. Separa cada producto con una coma \",\".");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 670, 30));

        jTextField2.setText("Ejemplo: Teclado//2,Pantalla//1");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 670, -1));

        jToggleButton4.setText("ATRÁS");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 710, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        String clientName; 
        String clientLastName; 
        int clientId; 
        String clientLocation; 
        String nameWarehouse; 
        
        if(!app.getProducts().isEmpty()){

        try{
            
            clientName = inputName.getText(); 
            if (clientName. equals("")) throw new Exception("Debe colocar su nombre.");
            inputName.setText(""); 
            
        
            clientLastName = inputLastName.getText(); 
            if (clientLastName.equals("")) throw new Exception("Debe colocar su apellido."); 
            inputLastName.setText(""); 
            
            clientId = Integer.parseInt(inputId.getText()); 
            inputId.setText(""); 
            
            clientLocation = inputLocation.getText(); 
            if (clientLocation.equals("")) throw new Exception("Debe colocar una dirección donde se mandarán los productos seleccionados."); 
            inputLocation.setText(""); 
            
            nameWarehouse = inputWarehouse.getText(); 
            if(nameWarehouse.equals("")) throw new Exception("Debe colocar el nombre del almacen.");
            
            if(app.getGraph().searchVertice(nameWarehouse)<0) throw new Exception("El almacen colocado no existe"); // revisa si ese almacen existe
            inputWarehouse.setText("");
            Warehouse wa = app.getGraph().findWarehouse(nameWarehouse); 
            
            String strProducts = inputProducts.getText();
            if(strProducts.equals("")) throw new Exception("Debe colocar los productos que desea.");
            inputProducts.setText("");
            
        
            
            Client client = new Client(clientName, clientLastName, clientId, clientLocation, wa,strProducts); // se crea al cliente
            
            
            // revisa si en el mismo almacen estan todos los productos
            // si estan los descuenta
            
           
           boolean productsAvailable = app.productsAvailableInWarehouse(client.getProducts(), client.getWarehouse()); 
           
           if (productsAvailable){
               app.addClient(client);
               JOptionPane.showMessageDialog(null, "Registro exitoso. El almacén escogido tiene todos los productos que desea."); 
    
           }else{
               Warehouse warehouseFound = app.findWarehouse(client.getProducts()); 
               if(warehouseFound == null){
                   JOptionPane.showMessageDialog(null, "No se logró procesar el pedido.\nActualmente ningún almacen tiene todos los productos que desea."); 
               }else{
                   app.addClient(client);
                   JOptionPane.showMessageDialog(null, "Compra exitosa.\nEl almacen seleccionado no tiene todos los productos que desea, sin embargo, el Alamacen "+warehouseFound.getName() + " mandará al almacen seleccionado todos los productos");
                   // se muestra la ruta mas corta: 
                   int indexWarehouse = app.getIndexVertex(warehouseFound);// buscamos el indice del almacen que tiene todos los productos que es el inicio del recorrido.
               }
           }
        
       
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se logró registrar al cliente. Debe suministrar toda la información que se pide. "); 
            inputName.setText(""); 
            inputLastName.setText(""); 
            inputId.setText(""); 
            inputLocation.setText(""); 
           
        }}
        else{
            JOptionPane.showMessageDialog(null, "Actualmente no hay productos ni almacenes disponibles. Debe cargar un archivo en el sistema primero");
        }
 
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
       // para desplegar los almacenes que hay: 
       
       
       String warehouses = ""; 
       
        for (int i = 0; i < app.getGraph().getNumVertices(); i++) {
            warehouses += "-" + app.getGraph().getVertices()[i].getName()+"\n";  
        }
        warehousesAvailable.setText(warehouses); 
       
       if(warehouses.length() == 0){
        warehousesAvailable.setText("Actualmente no hay almacenes en el sistema"); 
    }
       
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // PARA VISUALIZAR TODOS LOS PRODUCTOS QUE HAY

    
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
        
        
        
        String products = ""; 
        
        ListNode aux4 = allProductsSet.getpFirst(); 
        for (int i = 0; i < allProductsSet.getSize(); i++) {
            products += "-PRODUCTO: "+ ((Product)aux4.getElement()).getName()+", CANTIDAD: " + ((Product)aux4.getElement()).getQuantity()+"\n";
            aux4 = aux4.getpNext();
        }
        
        

        availableProducts.setText(products); 
        
        if(products.length() == 0){
            availableProducts.setText("No hay productos en la base de datos actualmente. "); 
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        this.setVisible(false); 
        Interface inter = new Interface(); 
        inter.setVisible(true); 
        
    }//GEN-LAST:event_jToggleButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea availableProducts;
    private javax.swing.JTextField inputId;
    private javax.swing.JTextField inputLastName;
    private javax.swing.JTextField inputLocation;
    private javax.swing.JTextField inputName;
    private javax.swing.JTextArea inputProducts;
    private javax.swing.JTextField inputWarehouse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JTextArea warehousesAvailable;
    // End of variables declaration//GEN-END:variables
}
