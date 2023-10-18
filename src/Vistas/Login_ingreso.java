package Vistas;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.EnumVariant;
import com.jacob.com.Variant;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Properties;
import javax.swing.*;
import paneles.pnlRegistrar;

public class Login_ingreso extends javax.swing.JFrame {

    String idPlacaBase = "";

    public Login_ingreso() {
        initComponents();
        nombre.requestFocus();
        calendario.setVisible(false);
        setLocationRelativeTo(null);
        try {
            setIconImage(new ImageIcon(getClass().getResource("../img/iconoSistema64.png")).getImage());
        } catch (Exception e) {

        }
        /*        try {
        
        //PRUEBA PARA VALIDAR LA LICENCIA (EVITAR QUE SE COPIE EL SOFTWARE DE MAQUINA EN MAQUINA)
        ActiveXComponent a = new ActiveXComponent("winmgmts:\\\\.");
        Variant b = a.invoke("InstancesOf", "Win32_BaseBoard"); // para la placa base
        Enumeration<Variant> baseBoard = new EnumVariant(b.getDispatch());
        
        while (baseBoard.hasMoreElements()) {
        ActiveXComponent cc = new ActiveXComponent(baseBoard.nextElement().getDispatch());
        
        //System.out.println("Id de la placa base " + cc.getPropertyAsString("SerialNumber"));
        idPlacaBase = cc.getPropertyAsString("SerialNumber");
        break;
        }
        
        Connection conn = conexion.ObtenerConexion(); // esta es la verificación de la conexión con mysql
        Statement consulta = conn.createStatement(); // crea una variable que se encargue del código de sql
        
        Statement consulta2 = conn.createStatement();
        ResultSet res2 = consulta2.executeQuery("select afip from facturable where id=1");
        String codigoSerialBase = "", codigoSerialDefault = "NKN250BU0007I00313";
        
        if (res2.next()) {
        codigoSerialBase = res2.getString(1);
        }
        if (codigoSerialBase.equals(codigoSerialDefault)) {
        consulta.executeUpdate("UPDATE facturable SET afip='" + idPlacaBase + "' where id=1");
        }
        
        ResultSet res3 = consulta2.executeQuery("select afip from facturable where id=1");
        String codigoBaseActual = "";
        if (res3.next()) {
        codigoBaseActual = res3.getString(1);
        }
        if (!codigoBaseActual.equals(idPlacaBase) && !codigoBaseActual.equals(codigoSerialDefault)) {
        
        JOptionPane.showMessageDialog(null, "ERROR DE LICENCIA, COMUNIQUESE CON EL NUMER0 +573015752105", "Licencia",
        JOptionPane.WARNING_MESSAGE);
        ingresarLicencia lic = new ingresarLicencia(this, true);
        lic.setVisible(true);
        System.exit(0);
        }
        
        } catch (Exception e) {
        
        }*/

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nombre = new javax.swing.JTextField();
        txt_clave = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        calendario = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingreso al Sistema");
        setMinimumSize(new java.awt.Dimension(100, 100));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(78, 184, 221));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel1KeyReleased(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre.setFont(new java.awt.Font("Calibri Light", 1, 19)); // NOI18N
        nombre.setBorder(null);
        nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreFocusLost(evt);
            }
        });
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 260, 40));

        txt_clave.setFont(new java.awt.Font("Calibri Light", 0, 19)); // NOI18N
        txt_clave.setBorder(null);
        txt_clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_claveActionPerformed(evt);
            }
        });
        txt_clave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_claveKeyPressed(evt);
            }
        });
        jPanel1.add(txt_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 260, 40));

        jLabel5.setFont(new java.awt.Font("Calibri Light", 1, 23)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("USUARIO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 240, 20));

        jLabel4.setFont(new java.awt.Font("Calibri Light", 1, 23)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CONTRASEÑA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 290, 40));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuarioGrande2.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 140, 130));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoLogin.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 40, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoUsuario.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 70, 50));

        jSeparator1.setAlignmentY(2.0F);
        jSeparator1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 290, 10));

        jSeparator3.setAlignmentY(2.0F);
        jSeparator3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 290, 10));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Enter_OFF.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Enter_ON.png"))); // NOI18N
        jButton1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Enter_ON.png"))); // NOI18N
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Enter_ON.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 140, 50));

        calendario.setDateFormatString("yyy/MM/dd HH:mm:ss");
        calendario.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel1.add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 170, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 450));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/saler.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 620, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setearFecha() {
        //SETEO LA FECHA ACTUAL
        Calendar c2 = new GregorianCalendar();
        calendario.setCalendar(c2);
    }

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        if (evt.getKeyChar() == evt.VK_ENTER) {
            if (nombre.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese el Dato");
            } else {
                txt_clave.requestFocus();
            }
        }
    }//GEN-LAST:event_nombreKeyTyped

    private void nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyReleased

    }//GEN-LAST:event_nombreKeyReleased

    private void jPanel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyReleased

    }//GEN-LAST:event_jPanel1KeyReleased

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed

    }//GEN-LAST:event_nombreActionPerformed

    public void ingresar() {
        if (nombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "INGRESE SU USUARIO", "Advertencia", JOptionPane.WARNING_MESSAGE);
            nombre.requestFocus();
        } else if (txt_clave.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "INGRESE SU CONTRASEÑA", "Advertencia", JOptionPane.WARNING_MESSAGE);
            txt_clave.requestFocus();
        } else /*if(tipoPago.equals("1") || fechaActual>=fechaTope ){
                        JOptionPane.showMessageDialog(this, "SE VENCIO LA FECHA TOPE PARA REALIZAR EL PAGO, COMUNIQUESE CON EL NUMERO +549 2302 532220 PARA DESBLOQUEAR EL SISTEMA","Advertencia",JOptionPane.WARNING_MESSAGE );
                    }else*/
                     try {
            int num = 0;
            String usuario = nombre.getText();
            String clave = txt_clave.getText();

            Connection conn = conexion.ObtenerConexion();
            Statement consulta = conn.createStatement(); // crea una variable que se encargue del código de sql
            Statement consulta2 = conn.createStatement(); // crea una variable que se encargue del código de sql

            ResultSet res = consulta.executeQuery("select * from usuarios where clave='" + clave + "' and usuario='" + usuario + "' and estado='ACTIVO'");

            String tipoUsuario = "";
            if (res.next()) {
                tipoUsuario = res.getString(8); //acceso de usuario
                try {

                    System.out.println("Por abrir menu");
                    SPLASH splash = new SPLASH(this, true);
                    splash.setVisible(true);
                    Principal form = new Principal();
                    form.setVisible(true);
                    form.toFront();
                } catch (Exception e) {

                }

                Principal.conectado.setText(usuario);
                Principal.lb_tipo.setText(tipoUsuario);
                if (!tipoUsuario.equals("Administrador")) {
                    pnlRegistrar.Clientes.setEnabled(false);
                    pnlRegistrar.btnArt.setEnabled(false);
                    pnlRegistrar.menu_empleados.setEnabled(false);
                    pnlRegistrar.Proveedores.setEnabled(false);
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
                    pnlRegistrar.Proveedores.setEnabled(true);
                    Principal.M_acerca.setEnabled(true);
                    Principal.M_registrar.setEnabled(true);
                    Principal.jMenu2.setEnabled(false);
                    pnlRegistrar.btnArt.setEnabled(true);
                }

                {

                }
                setearFecha();
                String fecha = ((JTextField) calendario.getDateEditor().getUiComponent()).getText();
                int i = consulta2.executeUpdate("insert into ingreso_usuarios(nombre_usuario,fecha_ingreso,fecha_salida,estado,tipo_usuario) VALUES('" + res.getString(3) + " " + res.getString(4) + "','" + fecha + "','" + fecha + "','ACTIVO','" + tipoUsuario + "')");
                Principal.conectado.setText("Usuario " + tipoUsuario + " " + usuario);

                Principal.conectado.setText("Usuario " + tipoUsuario + " " + usuario);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, " El usuario" + " " + nombre.getText() + " o la contraseña son incorrectos", "INFORMACION", JOptionPane.ERROR_MESSAGE);
                nombre.setText("");
                txt_clave.setText("");
                nombre.requestFocus();
            }
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en el SQL");
        }
    }
    private void txt_claveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_claveKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ingresar();
        }
    }//GEN-LAST:event_txt_claveKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ingresar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreFocusLost
        if (nombre.getText().equals("")) {
            nombre.setText("Ingrese el nombre");
        }
        nombre.setForeground(Color.gray);
    }//GEN-LAST:event_nombreFocusLost

    private void nombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreFocusGained
        if (nombre.getText().equals("Ingrese el nombre")) {
            nombre.setText("");
        }
        nombre.setForeground(Color.black);
    }//GEN-LAST:event_nombreFocusGained

    private void txt_claveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_claveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_claveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    /*Properties props = new Properties();
                    props.put("logoString", "Contsys");
                    props.put("windowBorderColor", "0 0 0");
                    
                    AeroLookAndFeel.setCurrentTheme(props);*/
                    //UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                    //UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
                    
                    //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                    //UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
                    //UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
                    //UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
                    //UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                    //UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
                    //UIManager.setLookAndFeel(new AeroLookAndFeel());
                    //UIManager.setLookAndFeel(new HiFiLookAndFeel());
                    //UIManager.setLookAndFeel(new FastLookAndFeel());
                    //UIManager.setLookAndFeel(new McWinLookAndFeel());
                    //UIManager.setLookAndFeel(new SmartLookAndFeel());
                    //UIManager.setLookAndFeel(new AluminiumLookAndFeel());
                    //UIManager.setLookAndFeel(new NoireLookAndFeel());
                    //UIManager.setLookAndFeel(new GraphiteLookAndFeel());
                    
                    

                } catch (Exception ex) {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                new Login_ingreso().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    public static javax.swing.JTextField nombre;
    public static javax.swing.JPasswordField txt_clave;
    // End of variables declaration//GEN-END:variables

}
