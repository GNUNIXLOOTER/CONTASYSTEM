/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import static Vistas.Principal.M_acerca;
import static Vistas.Principal.M_consultar;
import static Vistas.Principal.M_registrar;
import static Vistas.Principal.M_reportes;
import static Vistas.Principal.mantenimiento;
import Vistas.conexion;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author RojeruSan
 */
public class pnlInicio extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
     */
    public pnlInicio() {
        initComponents();
        calendario.setVisible(false);
    }

    public void setearFecha() {   
        //SETEO LA FECHA ACTUAL
        Calendar c2 = new GregorianCalendar();
        calendario.setCalendar(c2);  

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInicio = new javax.swing.JPanel();
        M_desconectar = new rojerusan.RSButtonIconI();
        jMenuItem13 = new rojerusan.RSButtonIconI();
        calendario = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlInicio.setBackground(new java.awt.Color(255, 255, 255));

        M_desconectar.setBackground(new java.awt.Color(78, 184, 221));
        M_desconectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_principal/desconectar.png"))); // NOI18N
        M_desconectar.setText("Desconectar");
        M_desconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_desconectarActionPerformed(evt);
            }
        });

        jMenuItem13.setBackground(new java.awt.Color(78, 184, 221));
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_principal/salir.png"))); // NOI18N
        jMenuItem13.setText("Salir");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInicioLayout = new javax.swing.GroupLayout(pnlInicio);
        pnlInicio.setLayout(pnlInicioLayout);
        pnlInicioLayout.setHorizontalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(M_desconectar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jMenuItem13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlInicioLayout.setVerticalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addComponent(M_desconectar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jMenuItem13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        calendario.setDateFormatString("yyy/MM/dd HH:mm:ss");
        calendario.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(278, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void M_desconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_desconectarActionPerformed
       M_desconectar.setEnabled(false);
        M_registrar.setEnabled(false);
        M_consultar.setEnabled(false);
        M_reportes.setEnabled(false);
        mantenimiento.setEnabled(false);
        M_acerca.setEnabled(false);
        
    }//GEN-LAST:event_M_desconectarActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
      Object[]opciones={"Aceptar","Cancelar"};
        int mensa= JOptionPane.showOptionDialog(null,"DESEA SALIR DEL SISTEMA??", "ADVERTENCIA",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, opciones,"Aceptar");
        if (mensa ==JOptionPane.YES_OPTION )
        {
            try{
                Connection conn= conexion.ObtenerConexion(); // esta es la verificación de la conexión con mysql
                Statement consulta=conn.createStatement(); // crea una variable que se encargue del código de sql  
                setearFecha();
                String fecha=((JTextField)calendario.getDateEditor().getUiComponent()).getText();
                consulta.executeUpdate("UPDATE ingreso_usuarios SET estado='INACTIVO', fecha_salida='"+fecha+"' WHERE estado='ACTIVO' ");
                System.exit(0);
            }catch(Exception e){
                System.out.println(e);
            }
            System.exit(0);
        }
        else 
        { }
    }//GEN-LAST:event_jMenuItem13ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconI M_desconectar;
    private com.toedter.calendar.JDateChooser calendario;
    private rojerusan.RSButtonIconI jMenuItem13;
    public static javax.swing.JPanel pnlInicio;
    // End of variables declaration//GEN-END:variables
}
