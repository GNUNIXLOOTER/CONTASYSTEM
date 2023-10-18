/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import HerrBD.BackupMySQL;
import HerrBD.CONEXION;
import HerrBD.CargandoRestore;
import Vistas.Principal;
import Vistas.Registrar_Empresa;
import Vistas.Registrar_Localidades;
import Vistas.Registrar_Monedas;
import Vistas.Registrar_Usuarios;
import alertas.ErrorAlerts;
import alertas.WarningBackups;
import static alertas.WarningBackups.txtNombre;
import alertas.WarningRestores;
import static alertas.WarningRestores.continuar;
import static alertas.WarningRestores.lblTipo;
import static alertas.WarningRestores.msj1;
import static alertas.WarningRestores.msj2;
import static alertas.WarningRestores.msj3;
import static alertas.WarningRestores.msj4;
import java.io.File;
import java.sql.SQLException;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.filechooser.FileNameExtensionFilter;
import necesario.RSFileChooser;

/**
 *
 * @author RojeruSan
 */
public class pnlConfiguración extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
     */
    public pnlConfiguración() {
        initComponents();
    }

    public static File existe = null;
    private void RestoreBackup() throws SQLException {
        RSFileChooser fileChooser = new RSFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("Respaldos/"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos SQL (*.sql)", "sql");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Seleccionar respaldo");
        if (fileChooser.showOpenDialog(this) == APPROVE_OPTION) {
            existe = fileChooser.getSelectedFile();
            if (existe.exists()) {

                WarningRestores a = new WarningRestores(null, true);
                msj1.setText("Ha seleccionado un respaldo y la aplicación");
                msj2.setText("se reiniciara al terminar de restaurar la");
                msj3.setText("Base de Datos. Se recomienda que haga");
                msj4.setText("un respaldo antes de continuar.");
                lblTipo.setText("Restaurar");
                lblTipo.setVisible(false);
                a.setVisible(true);
                
                if (continuar) {
                    new CargandoRestore(null, true).setVisible(true);
                    //this.dispose();

                }

            } else {
                ErrorAlerts a = new ErrorAlerts(null, true);
                msj1.setText("Archivo no encontrado.");
                msj2.setVisible(false);
                msj3.setVisible(false);
                a.setVisible(true);
            }
            
        }
        new CONEXION().getConnection();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlConfiguración = new javax.swing.JPanel();
        rSButtonIconI11 = new rojerusan.RSButtonIconI();
        rSButtonIconI12 = new rojerusan.RSButtonIconI();
        rSButtonIconI13 = new rojerusan.RSButtonIconI();
        rSButtonIconI14 = new rojerusan.RSButtonIconI();
        rSButtonIconI15 = new rojerusan.RSButtonIconI();
        rSButtonIconI16 = new rojerusan.RSButtonIconI();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlConfiguración.setBackground(new java.awt.Color(255, 255, 255));

        rSButtonIconI11.setBackground(new java.awt.Color(78, 184, 221));
        rSButtonIconI11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_principal/acceso.png"))); // NOI18N
        rSButtonIconI11.setText("Usuario y Acceso");
        rSButtonIconI11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconI11ActionPerformed(evt);
            }
        });

        rSButtonIconI12.setBackground(new java.awt.Color(78, 184, 221));
        rSButtonIconI12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_principal/empresa.png"))); // NOI18N
        rSButtonIconI12.setText("Empresa");
        rSButtonIconI12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconI12ActionPerformed(evt);
            }
        });

        rSButtonIconI13.setBackground(new java.awt.Color(78, 184, 221));
        rSButtonIconI13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_principal/localidades.png"))); // NOI18N
        rSButtonIconI13.setText("Localidades");
        rSButtonIconI13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconI13ActionPerformed(evt);
            }
        });

        rSButtonIconI14.setBackground(new java.awt.Color(78, 184, 221));
        rSButtonIconI14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_principal/moneda.png"))); // NOI18N
        rSButtonIconI14.setText("Monedas");
        rSButtonIconI14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconI14ActionPerformed(evt);
            }
        });

        rSButtonIconI15.setBackground(new java.awt.Color(78, 184, 221));
        rSButtonIconI15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_principal/restore.png"))); // NOI18N
        rSButtonIconI15.setText("Restore");
        rSButtonIconI15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconI15ActionPerformed(evt);
            }
        });

        rSButtonIconI16.setBackground(new java.awt.Color(78, 184, 221));
        rSButtonIconI16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_principal/backup.png"))); // NOI18N
        rSButtonIconI16.setText("Backup");
        rSButtonIconI16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconI16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConfiguraciónLayout = new javax.swing.GroupLayout(pnlConfiguración);
        pnlConfiguración.setLayout(pnlConfiguraciónLayout);
        pnlConfiguraciónLayout.setHorizontalGroup(
            pnlConfiguraciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSButtonIconI11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rSButtonIconI12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rSButtonIconI13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rSButtonIconI14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rSButtonIconI15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rSButtonIconI16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlConfiguraciónLayout.setVerticalGroup(
            pnlConfiguraciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfiguraciónLayout.createSequentialGroup()
                .addComponent(rSButtonIconI11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButtonIconI12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButtonIconI13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButtonIconI14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButtonIconI15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButtonIconI16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlConfiguración, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlConfiguración, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonIconI11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconI11ActionPerformed
        Registrar_Usuarios r = new Registrar_Usuarios();
        r.setVisible(true);
    }//GEN-LAST:event_rSButtonIconI11ActionPerformed

    private void rSButtonIconI12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconI12ActionPerformed
        Registrar_Empresa emp = new Registrar_Empresa(null,true);
      emp.setVisible(true);
    }//GEN-LAST:event_rSButtonIconI12ActionPerformed

    private void rSButtonIconI13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconI13ActionPerformed
        Registrar_Localidades localidad = new Registrar_Localidades(null, true);
         localidad.setVisible(true);
    }//GEN-LAST:event_rSButtonIconI13ActionPerformed

    private void rSButtonIconI14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconI14ActionPerformed
        Registrar_Monedas monedas = new Registrar_Monedas(null, true);  
        monedas.setVisible(true);
    }//GEN-LAST:event_rSButtonIconI14ActionPerformed

    private void rSButtonIconI15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconI15ActionPerformed
        try {
            RestoreBackup();
        } catch (SQLException ex) {
            getLogger(Principal.class.getName()).log(SEVERE, null, ex);
        }
    }//GEN-LAST:event_rSButtonIconI15ActionPerformed

    private void rSButtonIconI16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconI16ActionPerformed
        WarningBackups a = new WarningBackups(null, true);
        a.setVisible(true);

        if (txtNombre.getText().length() != 0) {
            new BackupMySQL().exportDB(txtNombre.getText());
        }
    }//GEN-LAST:event_rSButtonIconI16ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel pnlConfiguración;
    private rojerusan.RSButtonIconI rSButtonIconI11;
    private rojerusan.RSButtonIconI rSButtonIconI12;
    private rojerusan.RSButtonIconI rSButtonIconI13;
    private rojerusan.RSButtonIconI rSButtonIconI14;
    private rojerusan.RSButtonIconI rSButtonIconI15;
    private rojerusan.RSButtonIconI rSButtonIconI16;
    // End of variables declaration//GEN-END:variables
}
