/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import Vistas.Login_ingreso;
import Vistas.Menu_Caja;
import Vistas.Principal;
import Vistas.SPLASH;
import Vistas.conexion;
import Vistas.ventana_carga_articulos;
import Vistas.ventana_carga_clientes;
import Vistas.ventana_carga_proveedores;
import Vistas.ventana_carga_vendedores;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author RojeruSan
 */
public class pnlRegistrar extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
     */
    public pnlRegistrar() {
        initComponents();
        ingresar();
    }
    

     public void ingresar(){
            Connection conn = conexion.ObtenerConexion();
            Statement consulta = null;
        try {
            consulta = conn.createStatement(); // crea una variable que se encargue del código de sql
        } catch (SQLException ex) {
            Logger.getLogger(pnlRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement consulta2 = conn.createStatement(); // crea una variable que se encargue del código de sql
        } catch (SQLException ex) {
            Logger.getLogger(pnlRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
            String usuario = Login_ingreso.nombre.getText();
            String clave = Login_ingreso.txt_clave.getText();
            ResultSet res = null;
        try {
            res = consulta.executeQuery("select * from usuarios where clave='" + clave + "' and usuario='" + usuario + "' and estado='ACTIVO'");
        } catch (SQLException ex) {
            Logger.getLogger(pnlRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }

            String tipoUsuario = "";
        try {
            if (res.next()) {
                tipoUsuario = res.getString(8); //acceso de usuario
                try {

                    System.out.println("Por abrir menu");
                   
                } catch (Exception e) {

                }

                //Principal.conectado.setText(usuario);
                Principal.lb_tipo.setText(tipoUsuario);
                if (!tipoUsuario.equals("Administrador")) {
                    Clientes.setEnabled(false);
                    btnArt.setEnabled(false);
                    menu_empleados.setEnabled(false);
                    Proveedores.setEnabled(false);
                    Principal.M_acerca.setEnabled(false);
                    Principal.M_reportes.setEnabled(false);

                    /*Menu_Principal.botonArticulos.setEnabled(false);
                    Menu_Principal.botonClientes.setEnabled(false);
                    Menu_Principal.botonProveedores.setEnabled(false);*/
                    Principal.mantenimiento.setEnabled(false);
                    //itemAgregarArticulo.setEnabled(false);

                }
                if (tipoUsuario.equals("Comprador")) {
                    Principal.mantenimiento.setEnabled(false);
                    Principal.M_reportes.setEnabled(false);
                    Proveedores.setEnabled(true);
                    Principal.M_acerca.setEnabled(true);
                    Principal.M_registrar.setEnabled(true);
                    Principal.jMenu2.setEnabled(false);
                    btnArt.setEnabled(true);
                }
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(pnlRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRegistrar = new javax.swing.JPanel();
        btnArt = new rojerusan.RSButtonIconI();
        Clientes = new rojerusan.RSButtonIconI();
        menu_empleados = new rojerusan.RSButtonIconI();
        Proveedores = new rojerusan.RSButtonIconI();
        jMenuItem25 = new rojerusan.RSButtonIconI();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlRegistrar.setBackground(new java.awt.Color(255, 255, 255));

        btnArt.setBackground(new java.awt.Color(78, 184, 221));
        btnArt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_principal/articulos.png"))); // NOI18N
        btnArt.setText("Articulos");
        btnArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArtActionPerformed(evt);
            }
        });

        Clientes.setBackground(new java.awt.Color(78, 184, 221));
        Clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_principal/clientes.png"))); // NOI18N
        Clientes.setText("Clientes");
        Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesActionPerformed(evt);
            }
        });

        menu_empleados.setBackground(new java.awt.Color(78, 184, 221));
        menu_empleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_principal/vendedores.png"))); // NOI18N
        menu_empleados.setText("Vendedores");
        menu_empleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_empleadosActionPerformed(evt);
            }
        });

        Proveedores.setBackground(new java.awt.Color(78, 184, 221));
        Proveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_principal/proveedor.png"))); // NOI18N
        Proveedores.setText("Proveedores");
        Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProveedoresActionPerformed(evt);
            }
        });

        jMenuItem25.setBackground(new java.awt.Color(78, 184, 221));
        jMenuItem25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_principal/cajaRegistradora.png"))); // NOI18N
        jMenuItem25.setText("Caja");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRegistrarLayout = new javax.swing.GroupLayout(pnlRegistrar);
        pnlRegistrar.setLayout(pnlRegistrarLayout);
        pnlRegistrarLayout.setHorizontalGroup(
            pnlRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(menu_empleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jMenuItem25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlRegistrarLayout.setVerticalGroup(
            pnlRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarLayout.createSequentialGroup()
                .addComponent(btnArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu_empleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jMenuItem25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menu_empleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_empleadosActionPerformed
        new ventana_carga_vendedores().setVisible(true);
    }//GEN-LAST:event_menu_empleadosActionPerformed

    private void btnArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArtActionPerformed
       new ventana_carga_articulos().setVisible(true);
    }//GEN-LAST:event_btnArtActionPerformed

    private void ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesActionPerformed
        new ventana_carga_clientes().setVisible(true); 
    }//GEN-LAST:event_ClientesActionPerformed

    private void ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProveedoresActionPerformed
        new ventana_carga_proveedores().setVisible(true); 
    }//GEN-LAST:event_ProveedoresActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
       Menu_Caja caja = new Menu_Caja();
        caja.setVisible(true); 
    }//GEN-LAST:event_jMenuItem25ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static rojerusan.RSButtonIconI Clientes;
    public static rojerusan.RSButtonIconI Proveedores;
    public static rojerusan.RSButtonIconI btnArt;
    public static rojerusan.RSButtonIconI jMenuItem25;
    public static rojerusan.RSButtonIconI menu_empleados;
    public static javax.swing.JPanel pnlRegistrar;
    // End of variables declaration//GEN-END:variables
}
