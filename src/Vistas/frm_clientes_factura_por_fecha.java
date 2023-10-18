/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Hugo
 */
public class frm_clientes_factura_por_fecha extends javax.swing.JFrame {

    /**
     * Creates new form frm_facturasPorFecha
     */
    public frm_clientes_factura_por_fecha() {
        initComponents();
        
        //icono del sistema
        try{
            setIconImage(new ImageIcon(getClass().getResource("/img/iconoSistema64.png")).getImage());
        }catch(Exception e){
            
        }
        
        recibeCliente.setVisible(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setearFecha();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JButton();
        fechaDesde = new com.toedter.calendar.JDateChooser();
        fechaHasta = new com.toedter.calendar.JDateChooser();
        recibeCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nombreCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(78, 184, 221));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hasta:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 120, 50));

        btnMostrar.setBackground(new java.awt.Color(47, 172, 148));
        btnMostrar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrar.setText("MOSTRAR");
        btnMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 190, 40));

        fechaDesde.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jPanel1.add(fechaDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 190, 50));

        fechaHasta.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jPanel1.add(fechaHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 190, 50));

        recibeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recibeClienteActionPerformed(evt);
            }
        });
        jPanel1.add(recibeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 100, 40));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Reporte de facturación");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 710, 50));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Desde:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 120, 50));

        nombreCliente.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        nombreCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(nombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 660, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void setearFecha() {      
        Calendar c2 = new GregorianCalendar();
        fechaDesde.setCalendar(c2); 
        fechaHasta.setCalendar(c2); 
    }
    public void obtenerFecha(){
        
        String fechaDesde1="", fechaDesde2="";
        int añoDesde = fechaDesde.getCalendar().get(Calendar.YEAR);
        int mesDesde = fechaDesde.getCalendar().get(Calendar.MONTH);
        int diaDesde = fechaDesde.getCalendar().get(Calendar.DAY_OF_MONTH);

        if((mesDesde+1)<10 && (diaDesde>=10)){
            fechaDesde1 = (añoDesde+"/0"+(mesDesde+1)+"/"+diaDesde);
            fechaDesde2 = (diaDesde+"/0"+(mesDesde+1)+"/"+añoDesde);
        }else{
            if(((mesDesde+1)<10 && (diaDesde<10))){
                fechaDesde1 = (añoDesde+"/0"+(mesDesde+1)+"/0"+diaDesde);
                fechaDesde2 = ("0"+diaDesde+"/0"+(mesDesde+1)+"/"+añoDesde);
            }else{
                fechaDesde1 = (añoDesde+"/"+(mesDesde+1)+"/"+diaDesde);
                fechaDesde2 = (diaDesde+"/"+(mesDesde+1)+"/"+añoDesde);
            }
        }
        
        String fechaHasta1="",fechaHasta2="";
        int añoHasta = fechaHasta.getCalendar().get(Calendar.YEAR);
        int mesHasta = fechaHasta.getCalendar().get(Calendar.MONTH);
        int diaHasta = fechaHasta.getCalendar().get(Calendar.DAY_OF_MONTH);

        if((mesHasta+1)<10 && (diaHasta>=10)){
            fechaHasta1 = (añoHasta+"/0"+(mesHasta+1)+"/"+diaHasta);
            fechaHasta2 = (diaHasta+"/0"+(mesHasta+1)+"/"+añoHasta);
        }else{
            if(((mesHasta+1)<10 && (diaHasta<10))){
                fechaHasta1 = (añoHasta+"/0"+(mesHasta+1)+"/0"+diaHasta);
                fechaHasta2 = ("0"+diaHasta+"/0"+(mesHasta+1)+"/"+añoHasta);
            }else{
                fechaHasta1 = (añoHasta+"/"+(mesHasta+1)+"/"+diaHasta);
                fechaHasta2 = (diaHasta+"/"+(mesHasta+1)+"/"+añoHasta);
            }
        }
            //JOptionPane.showMessageDialog(this, fechaDesde1);
            //JOptionPane.showMessageDialog(this, fechaHasta1);
            
            Connection miconexion = conexion.ObtenerConexion();
            int bandera=0;
            String totalConIva="";
            String codigoCliente=recibeCliente.getText();
            try{
                Statement consulta1=miconexion.createStatement(); // crea una variable que se encargue del código de sql
                ResultSet r= consulta1.executeQuery("select SUM(total_con_iva) from factura where fecha BETWEEN '"+fechaDesde1+"' AND '"+fechaHasta1+"' AND cod_cliente='"+codigoCliente+"'");
                while(r.next()){
                   totalConIva=r.getString(1);
                   bandera=1;
                }
            }catch(Exception e){
                System.out.println("1"+e);
            }
            
            Map parametros = new HashMap();
            
            parametros.put("codCliente",codigoCliente);
            parametros.put("fechaDesde",fechaDesde1);
            parametros.put("fechaHasta",fechaHasta1);
            parametros.put("fechaDesde2",fechaDesde2);
            parametros.put("fechaHasta2",fechaHasta2);
            parametros.put("totalFactura",totalConIva);
            try{
                String reporte="fnombres.jasper";
                JasperPrint informe =JasperFillManager.fillReport(reporte, parametros,miconexion);
                JasperViewer ventanavisor=new JasperViewer(informe,false);
                ventanavisor.setTitle("Reporte Factura por Codigo Cliente");
                ventanavisor.setVisible(true); 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        
    }
    
    
    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        obtenerFecha();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void recibeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recibeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recibeClienteActionPerformed

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
            java.util.logging.Logger.getLogger(frm_clientes_factura_por_fecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_clientes_factura_por_fecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_clientes_factura_por_fecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_clientes_factura_por_fecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_clientes_factura_por_fecha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrar;
    private com.toedter.calendar.JDateChooser fechaDesde;
    private com.toedter.calendar.JDateChooser fechaHasta;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel nombreCliente;
    public static javax.swing.JTextField recibeCliente;
    // End of variables declaration//GEN-END:variables
}