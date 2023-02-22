/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import AdjListGraph.App;
import AdjListGraph.Warehouse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.view.Viewer;

/**
 * Descripción: Interfaz principal de todas.
 * @author Catalina Matheus & Erika Hernández 
 * @version 19/02/2023
 */
public class Interface extends javax.swing.JFrame {

    public static Interface Instancia;
    private App app = App.getInstance(); 
    
/**
     * Creates new form Interface
     */
        public Interface() {
        initComponents();
        this.setLocationRelativeTo(null);
        Instancia = this;
    }
        
        public void getApp(App app1){
            this.app = app1;
        }
        
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainWindow = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        uploadTxt = new javax.swing.JButton();
        saveFile = new javax.swing.JButton();
        warehouseReport = new javax.swing.JButton();
        placeOrder = new javax.swing.JButton();
        newWarehouse = new javax.swing.JButton();
        showGraph = new javax.swing.JButton();
        newEdge = new javax.swing.JButton();
        stockManagement = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainWindow.setBackground(new java.awt.Color(102, 102, 102));

        Title.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("  ORGANIZED CHAOS  ");

        uploadTxt.setText("Cargar archivo");
        uploadTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadTxtActionPerformed(evt);
            }
        });

        saveFile.setText("Actualizar repositorio");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });

        warehouseReport.setText("Reporte de almacenes");
        warehouseReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warehouseReportActionPerformed(evt);
            }
        });

        placeOrder.setText("Realizar un pedido");
        placeOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeOrderActionPerformed(evt);
            }
        });

        newWarehouse.setText("Agregar un nuevo almacen");
        newWarehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newWarehouseActionPerformed(evt);
            }
        });

        showGraph.setText("Mostrar grafo");
        showGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGraphActionPerformed(evt);
            }
        });

        newEdge.setText("Agregar nueva ruta");
        newEdge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEdgeActionPerformed(evt);
            }
        });

        stockManagement.setText("Gestionar Stock");
        stockManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockManagementActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainWindowLayout = new javax.swing.GroupLayout(mainWindow);
        mainWindow.setLayout(mainWindowLayout);
        mainWindowLayout.setHorizontalGroup(
            mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainWindowLayout.createSequentialGroup()
                .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainWindowLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saveFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(uploadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(warehouseReport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(placeOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newWarehouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(showGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newEdge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stockManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(mainWindowLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(Title)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        mainWindowLayout.setVerticalGroup(
            mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainWindowLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(Title)
                .addGap(29, 29, 29)
                .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uploadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newWarehouse, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveFile, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(newEdge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(warehouseReport, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(stockManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Descripcion: llena las estructuras de datos de app con la información de un txt.
     * @author: Catalina Matheus
     * @version: 19/02/2023
     * @param evt 
     */
    private void uploadTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadTxtActionPerformed

        this.setVisible(false); 
        SelectFile selectFile = new SelectFile(); 
        selectFile.setVisible(true); 
//        try{
//            app.restartProgram(); 
//            JOptionPane.showMessageDialog(null, "Se cargaron los archivos con éxito!"); 
//        }catch(Exception e){
//            
//        }
             
    }//GEN-LAST:event_uploadTxtActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        try{
            app.updateRepository(); 
            JOptionPane.showMessageDialog(null, "Se actualizó el repositorio exitosamente.");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "¡Error!\nNo se logró actualizar el repositorio. ");
        }
    }//GEN-LAST:event_saveFileActionPerformed

    private void placeOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeOrderActionPerformed
        this.setVisible(false); 
        RegisterClient registerCliente = new RegisterClient(); 
        registerCliente.setVisible(true); 
    }//GEN-LAST:event_placeOrderActionPerformed

    private void newWarehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newWarehouseActionPerformed
        // TODO add your handling code here:
        NewWarehouse newWarehouse = new NewWarehouse();
        newWarehouse.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_newWarehouseActionPerformed

    private void showGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGraphActionPerformed
        // TODO add your handling code here:
        // Se modifica para que la ventana aparezca ya que sin esto el .display() no funciona.
        System.setProperty("org.graphstream.ui", "swing");
        // Se crea el objeto grafo de tipo grafoGraphStream.
        Graph graph = new MultiGraph("Amazon");
        graph.setAttribute("ui.stylesheet", "edge{ text-size: 30; }");
        // Se recorre nuestro arreglo de almacenes del grafo para ahora meterlos en el objeto grafo de GraphStream.
        for (int i=0;i<app.getGraph().getNumVertices();i++){
            graph.addNode(app.getGraph().getVertices()[i].getName()).setAttribute("ui.label", app.getGraph().getVertices()[i].getName());
            graph.getNode(app.getGraph().getVertices()[i].getName()).setAttribute("ui.style", "text-size: 100; text-color: blue;");
        }
        // Se recorre la matriz de adyacencia para añadir los arcos al objeto grafoGraphStream.
        for (int i=0; i<app.getGraph().getNumVertices(); i++){
            String node1 = app.getGraph().getVertices()[i].getName();
            for (int j=0; j<app.getGraph().getNumVertices(); j++){
                String node2 = app.getGraph().getVertices()[j].getName();
                if (app.getGraph().getMatAd()[i][j]>0){
                    String nodeAux = node1 + node2;
                    graph.addEdge(nodeAux, node1, node2, true).setAttribute("ui.label",app.getGraph().getMatAd()[i][j]);
                }
            }
        }
        
        // Se crea el visor del grafo
        Viewer viewer = graph.display();
        viewer.enableAutoLayout();
   
    }//GEN-LAST:event_showGraphActionPerformed

    private void newEdgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEdgeActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        NewEdge newEdge = new NewEdge();
        newEdge.setVisible(true);
    }//GEN-LAST:event_newEdgeActionPerformed

    private void stockManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockManagementActionPerformed
        // TODO add your handling code here:
        StockManagement newstock = new StockManagement();
        newstock.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_stockManagementActionPerformed

    private void warehouseReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warehouseReportActionPerformed
        // TODO add your handling code here:
        DisponibilityReport newReport = new DisponibilityReport();
        newReport.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_warehouseReportActionPerformed

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JPanel mainWindow;
    private javax.swing.JButton newEdge;
    private javax.swing.JButton newWarehouse;
    private javax.swing.JButton placeOrder;
    private javax.swing.JButton saveFile;
    private javax.swing.JButton showGraph;
    private javax.swing.JButton stockManagement;
    private javax.swing.JButton uploadTxt;
    private javax.swing.JButton warehouseReport;
    // End of variables declaration//GEN-END:variables
}
