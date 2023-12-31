/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Emmanuel
 */
public class forma1 extends javax.swing.JFrame {

    /**
     * Creates new form forma1
     */
    public forma1() {
        initComponents();
        model=(DefaultTableModel) this.jTable1.getModel();
    }
    DefaultTableModel model;
    String url="jdbc:sqlite:src\\baseDatos\\inventario.db";
    Connection connect;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_conectar = new javax.swing.JToggleButton();
        btn_seleccionar = new javax.swing.JButton();
        btn_insertar = new javax.swing.JButton();
        btn_cerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_conectar.setText("conectar");
        btn_conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_conectarActionPerformed(evt);
            }
        });

        btn_seleccionar.setText("seleccionar");
        btn_seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seleccionarActionPerformed(evt);
            }
        });

        btn_insertar.setText("insertar");
        btn_insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertarActionPerformed(evt);
            }
        });

        btn_cerrar.setText("cerrar");
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_conectar)
                .addGap(44, 44, 44)
                .addComponent(btn_seleccionar)
                .addGap(66, 66, 66)
                .addComponent(btn_insertar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cerrar)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_conectar)
                    .addComponent(btn_seleccionar)
                    .addComponent(btn_insertar)
                    .addComponent(btn_cerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_conectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_conectarActionPerformed
        // TODO add your handling code here:
        try{
            connect=DriverManager.getConnection(url);
            if(connect!=null){
            JOptionPane.showMessageDialog(null,"Conectados!!!!!!");
            }
        }catch(Exception x){
        JOptionPane.showMessageDialog(null,x.getMessage().toString());
    }
    }//GEN-LAST:event_btn_conectarActionPerformed

    private void btn_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionarActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        ResultSet resul=null;
        
        try{
            PreparedStatement st=connect.prepareStatement("select codigo,nombre from producto");
            resul=st.executeQuery();
            
            while(resul.next()){
                model.addRow(new Object[]{resul.getInt("codigo"),resul.getString("nombre")});
            }
        }catch(Exception x){
            JOptionPane.showMessageDialog(null,x.getMessage().toString());
        }
    }//GEN-LAST:event_btn_seleccionarActionPerformed

    private void btn_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertarActionPerformed
        // TODO add your handling code here:
        try{
            PreparedStatement st=connect.prepareStatement("insert into producto(nombre) values('nuevo producto')");
            st.execute();
            JOptionPane.showMessageDialog(null,"Datos guardados");
        }catch(Exception x){
            JOptionPane.showMessageDialog(null,x.getMessage().toString());
        }
    }//GEN-LAST:event_btn_insertarActionPerformed

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        // TODO add your handling code here:
        try{
            connect.close();
            JOptionPane.showMessageDialog(null,"Se ha cerrado la conexion exitosamente");
        }catch(Exception x){
            JOptionPane.showMessageDialog(null,x.getMessage().toString());
        }
    }//GEN-LAST:event_btn_cerrarActionPerformed

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
            java.util.logging.Logger.getLogger(forma1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forma1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forma1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forma1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forma1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JToggleButton btn_conectar;
    private javax.swing.JButton btn_insertar;
    private javax.swing.JButton btn_seleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
