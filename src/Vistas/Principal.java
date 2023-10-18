/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import paneles.CambiaPanel;
import paneles.pnlCompras;
import paneles.pnlConfiguración;
import paneles.pnlConsultas;
import paneles.pnlInicio;
import paneles.pnlRegistrar;
import paneles.pnlReportes;
import paneles.pnlVentas;

/**
 *
 * @author RojeruSan
 */
public class Principal extends javax.swing.JFrame {

    int x, y;
    /**
     * Creates new form Principal
     */
    
    public Principal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(this);
        this.M_deinicio.setSelected(true);
        
        
         new CambiaPanel(pnlPrincipal, new paneles.pnlCompras());
          new CambiaPanel(pnlPrincipal, new paneles.pnlVentas());
           new CambiaPanel(pnlPrincipal, new paneles.pnlConsultas());
            new CambiaPanel(pnlPrincipal, new paneles.pnlRegistrar());
            new CambiaPanel(pnlPrincipal, new paneles.pnlReportes());
            new CambiaPanel(pnlPrincipal, new paneles.pnlConfiguración());
            new CambiaPanel(pnlPrincipal, new paneles.pnlInicio());
            
            calendario.setVisible(false);
        
        try{
            setIconImage(new ImageIcon(getClass().getResource("/img/iconoSistema64.png")).getImage());
            }catch(Exception e){
                                                                
        }
        try{
            Connection conn =conexion.ObtenerConexion();
            Statement consulta2=conn.createStatement(); // crea una variable que se encargue del código de sql            
            ResultSet r2= consulta2.executeQuery("select nombre_caja from cajas where estado='ABIERTA' order by cod_caja");
            
            int i=0;
            while(r2.next()){
                if(i==0){
                    i++;
                }
            }
            r2.close();
                                                                 
            if(i>0){
                labelCajaCerrada.setVisible(false);
                btnAbrirCaja.setVisible(false);
            }else{
                labelCajaCerrada.setVisible(true);
                btnAbrirCaja.setVisible(true);
            }
        }catch(Exception e){
                                                                
        }
        
        //PARA CAMBIARLE EL FONDO Y FUENTE A TODOS LOS JOPTIONPANE
        UIManager UI=new UIManager(); 
        
        UI.put("OptionPane.background",new ColorUIResource(255,255,255));
        UI.put("Panel.background",new ColorUIResource(255,255,255)); 
        UI.put("Button.background",new Color(93,116,163)); 
        UI.put("Button.foreground",Color.white);
        UI.put("OptionPane.font", new Font("Tahoma", Font.PLAIN, 22));
        UI.put("Button.font", new Font("Tahoma", Font.BOLD, 22));
        UI.put("OptionPane.messageFont", new FontUIResource(new Font(  
          "Tahoma", Font.PLAIN, 22)));  
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        //this.setSize(pantalla.width, pantalla.height);
        
        
         //Tomo el tamaño de la pantalla  PARA ACOMODAR EL PANEL CON LOSICONOS DEL MENU
        Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize(); 
        //Al ancho de la pantalla lo divido en 2 y le resto la mitad del ancho de mi ventana, con eso queda centrada en el eje X, para el eje Y es lo mismo pero con el alto: 
        /*panelIconosMenu.setLocation((pantallaTamano.width/2)-(panelIconosMenu.getWidth()/2), (pantallaTamano.height/2)-(panelIconosMenu.getHeight()/2)-100); //-100 ES PARA QUE ME QUEDE BIEN CENTRADO EN LA PANTALLA
        panelIconosMenu.setOpaque(false);*/ //LE PONGO EL BACKGROUND TRANSPARENTE
        
        this.setTitle("Sistema de Ventas");
        conectado.setVisible(true);
        labelFecha.setLocation(20,pantallaTamano.height-200);
        conectado.setLocation(35,pantallaTamano.height-230);
        lb_tipo.setVisible(false);
    }
    public void setearFecha() {   
        //SETEO LA FECHA ACTUAL
        Calendar c2 = new GregorianCalendar();
        calendario.setCalendar(c2);  

    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        M_deinicio = new rsbuttom.RSButtonMetro();
        jMenu2 = new rsbuttom.RSButtonMetro();
        M_acerca = new rsbuttom.RSButtonMetro();
        M_registrar = new rsbuttom.RSButtonMetro();
        jMenu1 = new rsbuttom.RSButtonMetro();
        mantenimiento = new rsbuttom.RSButtonMetro();
        M_reportes = new rsbuttom.RSButtonMetro();
        M_consultar = new rsbuttom.RSButtonMetro();
        jMenu6 = new rsbuttom.RSButtonMetro();
        jMenu7 = new rsbuttom.RSButtonMetro();
        calendario = new com.toedter.calendar.JDateChooser();
        lb_tipo = new javax.swing.JLabel();
        conectado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        pnlCentro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlPrincipal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelCajaCerrada = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnAbrirCaja = new javax.swing.JButton();
        labelFecha = new rojeru_san.RSLabelFecha();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        pnlMenu.setBackground(new java.awt.Color(239, 238, 244));
        pnlMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(239, 238, 244)));

        M_deinicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS48X48/inicio.png"))); // NOI18N
        M_deinicio.setText("Inicio");
        M_deinicio.setColorHover(new java.awt.Color(204, 204, 204));
        M_deinicio.setColorNormal(new java.awt.Color(204, 204, 204));
        M_deinicio.setColorPressed(new java.awt.Color(204, 204, 204));
        M_deinicio.setColorTextHover(new java.awt.Color(128, 128, 131));
        M_deinicio.setColorTextNormal(new java.awt.Color(128, 128, 131));
        M_deinicio.setColorTextPressed(new java.awt.Color(128, 128, 131));
        M_deinicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        M_deinicio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        M_deinicio.setIconTextGap(25);
        M_deinicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                M_deinicioMousePressed(evt);
            }
        });
        M_deinicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_deinicioActionPerformed(evt);
            }
        });

        jMenu2.setBackground(new java.awt.Color(239, 238, 244));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS48X48/ventas.png"))); // NOI18N
        jMenu2.setText("Ventas");
        jMenu2.setColorHover(new java.awt.Color(204, 204, 204));
        jMenu2.setColorNormal(new java.awt.Color(239, 238, 244));
        jMenu2.setColorPressed(new java.awt.Color(204, 204, 204));
        jMenu2.setColorTextHover(new java.awt.Color(128, 128, 131));
        jMenu2.setColorTextNormal(new java.awt.Color(128, 128, 131));
        jMenu2.setColorTextPressed(new java.awt.Color(128, 128, 131));
        jMenu2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenu2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenu2.setIconTextGap(19);
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu2MousePressed(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        M_acerca.setBackground(new java.awt.Color(239, 238, 244));
        M_acerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS48X48/compras.png"))); // NOI18N
        M_acerca.setText("Compras");
        M_acerca.setColorHover(new java.awt.Color(204, 204, 204));
        M_acerca.setColorNormal(new java.awt.Color(239, 238, 244));
        M_acerca.setColorPressed(new java.awt.Color(204, 204, 204));
        M_acerca.setColorTextHover(new java.awt.Color(128, 128, 131));
        M_acerca.setColorTextNormal(new java.awt.Color(128, 128, 131));
        M_acerca.setColorTextPressed(new java.awt.Color(128, 128, 131));
        M_acerca.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        M_acerca.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        M_acerca.setIconTextGap(25);
        M_acerca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                M_acercaMousePressed(evt);
            }
        });
        M_acerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_acercaActionPerformed(evt);
            }
        });

        M_registrar.setBackground(new java.awt.Color(239, 238, 244));
        M_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS48X48/registrar.png"))); // NOI18N
        M_registrar.setText("Registrar");
        M_registrar.setColorHover(new java.awt.Color(204, 204, 204));
        M_registrar.setColorNormal(new java.awt.Color(239, 238, 244));
        M_registrar.setColorPressed(new java.awt.Color(204, 204, 204));
        M_registrar.setColorTextHover(new java.awt.Color(128, 128, 131));
        M_registrar.setColorTextNormal(new java.awt.Color(128, 128, 131));
        M_registrar.setColorTextPressed(new java.awt.Color(128, 128, 131));
        M_registrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        M_registrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        M_registrar.setIconTextGap(19);
        M_registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                M_registrarMousePressed(evt);
            }
        });
        M_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_registrarActionPerformed(evt);
            }
        });

        jMenu1.setBackground(new java.awt.Color(239, 238, 244));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS48X48/acercade.png"))); // NOI18N
        jMenu1.setText("Acerca de");
        jMenu1.setColorHover(new java.awt.Color(204, 204, 204));
        jMenu1.setColorNormal(new java.awt.Color(239, 238, 244));
        jMenu1.setColorPressed(new java.awt.Color(204, 204, 204));
        jMenu1.setColorTextHover(new java.awt.Color(128, 128, 131));
        jMenu1.setColorTextNormal(new java.awt.Color(128, 128, 131));
        jMenu1.setColorTextPressed(new java.awt.Color(128, 128, 131));
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenu1.setIconTextGap(19);
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        mantenimiento.setBackground(new java.awt.Color(239, 238, 244));
        mantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS48X48/configuracion.png"))); // NOI18N
        mantenimiento.setText("Configuración");
        mantenimiento.setColorHover(new java.awt.Color(204, 204, 204));
        mantenimiento.setColorNormal(new java.awt.Color(239, 238, 244));
        mantenimiento.setColorPressed(new java.awt.Color(204, 204, 204));
        mantenimiento.setColorTextHover(new java.awt.Color(128, 128, 131));
        mantenimiento.setColorTextNormal(new java.awt.Color(128, 128, 131));
        mantenimiento.setColorTextPressed(new java.awt.Color(128, 128, 131));
        mantenimiento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mantenimiento.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        mantenimiento.setIconTextGap(19);
        mantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mantenimientoMousePressed(evt);
            }
        });
        mantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mantenimientoActionPerformed(evt);
            }
        });

        M_reportes.setBackground(new java.awt.Color(239, 238, 244));
        M_reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS48X48/reporte.png"))); // NOI18N
        M_reportes.setText("Reportes");
        M_reportes.setColorHover(new java.awt.Color(204, 204, 204));
        M_reportes.setColorNormal(new java.awt.Color(239, 238, 244));
        M_reportes.setColorPressed(new java.awt.Color(204, 204, 204));
        M_reportes.setColorTextHover(new java.awt.Color(128, 128, 131));
        M_reportes.setColorTextNormal(new java.awt.Color(128, 128, 131));
        M_reportes.setColorTextPressed(new java.awt.Color(128, 128, 131));
        M_reportes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        M_reportes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        M_reportes.setIconTextGap(25);
        M_reportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                M_reportesMousePressed(evt);
            }
        });
        M_reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_reportesActionPerformed(evt);
            }
        });

        M_consultar.setBackground(new java.awt.Color(239, 238, 244));
        M_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS48X48/consultas.png"))); // NOI18N
        M_consultar.setText("Consultas");
        M_consultar.setColorHover(new java.awt.Color(204, 204, 204));
        M_consultar.setColorNormal(new java.awt.Color(239, 238, 244));
        M_consultar.setColorPressed(new java.awt.Color(204, 204, 204));
        M_consultar.setColorTextHover(new java.awt.Color(128, 128, 131));
        M_consultar.setColorTextNormal(new java.awt.Color(128, 128, 131));
        M_consultar.setColorTextPressed(new java.awt.Color(128, 128, 131));
        M_consultar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        M_consultar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        M_consultar.setIconTextGap(19);
        M_consultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                M_consultarMousePressed(evt);
            }
        });
        M_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_consultarActionPerformed(evt);
            }
        });

        jMenu6.setBackground(new java.awt.Color(239, 238, 244));
        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS48X48/ayuda.png"))); // NOI18N
        jMenu6.setText("Ayuda");
        jMenu6.setColorHover(new java.awt.Color(204, 204, 204));
        jMenu6.setColorNormal(new java.awt.Color(239, 238, 244));
        jMenu6.setColorPressed(new java.awt.Color(204, 204, 204));
        jMenu6.setColorTextHover(new java.awt.Color(128, 128, 131));
        jMenu6.setColorTextNormal(new java.awt.Color(128, 128, 131));
        jMenu6.setColorTextPressed(new java.awt.Color(128, 128, 131));
        jMenu6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenu6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenu6.setIconTextGap(19);
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });

        jMenu7.setBackground(new java.awt.Color(239, 238, 244));
        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS48X48/actualizar.png"))); // NOI18N
        jMenu7.setText("Actualizacion");
        jMenu7.setColorHover(new java.awt.Color(204, 204, 204));
        jMenu7.setColorNormal(new java.awt.Color(239, 238, 244));
        jMenu7.setColorPressed(new java.awt.Color(204, 204, 204));
        jMenu7.setColorTextHover(new java.awt.Color(128, 128, 131));
        jMenu7.setColorTextNormal(new java.awt.Color(128, 128, 131));
        jMenu7.setColorTextPressed(new java.awt.Color(128, 128, 131));
        jMenu7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenu7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenu7.setIconTextGap(19);
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });

        calendario.setDateFormatString("yyy/MM/dd HH:mm:ss");
        calendario.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        lb_tipo.setFont(new java.awt.Font("Cambria", 0, 17)); // NOI18N
        lb_tipo.setText("tipo");

        conectado.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        conectado.setForeground(new java.awt.Color(128, 128, 131));
        conectado.setText("labelConectado");

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jMenu7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jMenu6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jMenu1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mantenimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(M_reportes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(M_registrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(M_deinicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(M_consultar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jMenu2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMenuLayout.createSequentialGroup()
                        .addComponent(conectado, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(M_acerca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(M_deinicio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(M_acerca, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(M_consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(M_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(M_reportes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(mantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jMenu6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jMenu7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(lb_tipo)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(conectado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 8.3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        jPanel1.add(pnlMenu, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(78, 184, 221));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(913, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.2;
        jPanel1.add(jPanel2, gridBagConstraints);

        pnlCentro.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setLayout(new javax.swing.BoxLayout(pnlPrincipal, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(pnlPrincipal);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(128, 128, 131));
        jLabel2.setText("CONTSYS");

        labelCajaCerrada.setBackground(new java.awt.Color(255, 255, 51));
        labelCajaCerrada.setFont(new java.awt.Font("Calibri", 1, 34)); // NOI18N
        labelCajaCerrada.setForeground(new java.awt.Color(128, 128, 131));
        labelCajaCerrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCajaCerrada.setText("NO HAY CAJAS ABIERTAS");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Calibri", 1, 33)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(128, 128, 131));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Apertura de Caja");

        btnAbrirCaja.setBackground(new java.awt.Color(0, 204, 204));
        btnAbrirCaja.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAbrirCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoAperturaCaja.png"))); // NOI18N
        btnAbrirCaja.setBorder(null);
        btnAbrirCaja.setBorderPainted(false);
        btnAbrirCaja.setContentAreaFilled(false);
        btnAbrirCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAbrirCaja.setFocusPainted(false);
        btnAbrirCaja.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoAperturaCajaHover.png"))); // NOI18N
        btnAbrirCaja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoAperturaCajaHover.png"))); // NOI18N
        btnAbrirCaja.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoAperturaCajaHover.png"))); // NOI18N
        btnAbrirCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirCajaActionPerformed(evt);
            }
        });

        labelFecha.setForeground(new java.awt.Color(128, 128, 131));
        labelFecha.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        labelFecha.setFormato("EEEE dd MMMM yyyy");

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCentroLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel2))
                    .addGroup(pnlCentroLayout.createSequentialGroup()
                        .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCentroLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCajaCerrada, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCentroLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCentroLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(btnAbrirCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCentroLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCajaCerrada, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrirCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(pnlCentro, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void M_deinicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_deinicioActionPerformed
        new CambiaPanel(pnlPrincipal, new paneles.pnlInicio());
        if(this.M_deinicio.isSelected()){
            this.M_deinicio.setColorNormal(new Color(204,204,204));
            this.M_deinicio.setColorHover(new Color(204,204,204));
            this.M_deinicio.setColorPressed(new Color(204,204,204));
            
            this.M_acerca.setColorNormal(new Color(239,238,244));
            this.M_acerca.setColorHover(new Color(204,204,204));
            this.M_acerca.setColorPressed(new Color(204,204,204));
            
            this.jMenu2.setColorNormal(new Color(239,238,244));
            this.jMenu2.setColorHover(new Color(204,204,204));
            this.jMenu2.setColorPressed(new Color(204,204,204));
            
            this.M_consultar.setColorNormal(new Color(239,238,244));
            this.M_consultar.setColorHover(new Color(204,204,204));
            this.M_consultar.setColorPressed(new Color(204,204,204));
            
            this.M_registrar.setColorNormal(new Color(239,238,244));
            this.M_registrar.setColorHover(new Color(204,204,204));
            this.M_registrar.setColorPressed(new Color(204,204,204));
            
            this.M_reportes.setColorNormal(new Color(239,238,244));
            this.M_reportes.setColorHover(new Color(204,204,204));
            this.M_reportes.setColorPressed(new Color(204,204,204));
            
            this.mantenimiento.setColorNormal(new Color(239,238,244));
            this.mantenimiento.setColorHover(new Color(204,204,204));
            this.mantenimiento.setColorPressed(new Color(204,204,204));
            
            this.jMenu1.setColorNormal(new Color(239,238,244));
            this.jMenu1.setColorHover(new Color(204,204,204));
            this.jMenu1.setColorPressed(new Color(204,204,204));
        }else{
            this.M_deinicio.setColorNormal(new Color(239,238,244));
            this.M_deinicio.setColorHover(new Color(204,204,204));
            this.M_deinicio.setColorPressed(new Color(204,204,204));
        }
       
    }//GEN-LAST:event_M_deinicioActionPerformed

    private void M_deinicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_M_deinicioMousePressed
        this.M_deinicio.setSelected(true);
        this.M_acerca.setSelected(false);
        this.jMenu2.setSelected(false);
        this.M_consultar.setSelected(false);
        this.M_registrar.setSelected(false);
        this.M_reportes.setSelected(false);
        this.mantenimiento.setSelected(false);
        this.jMenu1.setSelected(false);
    }//GEN-LAST:event_M_deinicioMousePressed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        new CambiaPanel(pnlPrincipal, new paneles.pnlVentas());
        if(this.jMenu2.isSelected()){
            this.jMenu2.setColorNormal(new Color(204,204,204));
            this.jMenu2.setColorHover(new Color(204,204,204));
            this.jMenu2.setColorPressed(new Color(204,204,204));
            
            this.M_deinicio.setColorNormal(new Color(239,238,244));
            this.M_deinicio.setColorHover(new Color(204,204,204));
            this.M_deinicio.setColorPressed(new Color(204,204,204));
            
            this.M_acerca.setColorNormal(new Color(239,238,244));
            this.M_acerca.setColorHover(new Color(204,204,204));
            this.M_acerca.setColorPressed(new Color(204,204,204));
            
            this.M_consultar.setColorNormal(new Color(239,238,244));
            this.M_consultar.setColorHover(new Color(204,204,204));
            this.M_consultar.setColorPressed(new Color(204,204,204));
            
            this.M_registrar.setColorNormal(new Color(239,238,244));
            this.M_registrar.setColorHover(new Color(204,204,204));
            this.M_registrar.setColorPressed(new Color(204,204,204));
            
            this.M_reportes.setColorNormal(new Color(239,238,244));
            this.M_reportes.setColorHover(new Color(204,204,204));
            this.M_reportes.setColorPressed(new Color(204,204,204));
            
            this.mantenimiento.setColorNormal(new Color(239,238,244));
            this.mantenimiento.setColorHover(new Color(204,204,204));
            this.mantenimiento.setColorPressed(new Color(204,204,204));
            
            this.jMenu1.setColorNormal(new Color(239,238,244));
            this.jMenu1.setColorHover(new Color(204,204,204));
            this.jMenu1.setColorPressed(new Color(204,204,204));
        }else{
            this.jMenu2.setColorNormal(new Color(239,238,244));
            this.jMenu2.setColorHover(new Color(204,204,204));
            this.jMenu2.setColorPressed(new Color(204,204,204));
        }
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MousePressed
        this.M_deinicio.setSelected(false);
        this.M_acerca.setSelected(false);
        this.jMenu2.setSelected(true);
        this.M_consultar.setSelected(false);
        this.M_registrar.setSelected(false);
        this.M_reportes.setSelected(false);
        this.mantenimiento.setSelected(false);
        this.jMenu1.setSelected(false);
    }//GEN-LAST:event_jMenu2MousePressed

    private void M_acercaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_M_acercaMousePressed
        this.M_deinicio.setSelected(false);
        this.M_acerca.setSelected(true);
        this.jMenu2.setSelected(false);
        this.M_consultar.setSelected(false);
        this.M_registrar.setSelected(false);
        this.M_reportes.setSelected(false);
        this.mantenimiento.setSelected(false);
        this.jMenu1.setSelected(false);
    }//GEN-LAST:event_M_acercaMousePressed

    private void M_acercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_acercaActionPerformed
        new CambiaPanel(pnlPrincipal, new paneles.pnlCompras());
        if(this.M_acerca.isSelected()){
            this.M_acerca.setColorNormal(new Color(204,204,204));
            this.M_acerca.setColorHover(new Color(204,204,204));
            this.M_acerca.setColorPressed(new Color(204,204,204));
            
            this.M_deinicio.setColorNormal(new Color(239,238,244));
            this.M_deinicio.setColorHover(new Color(204,204,204));
            this.M_deinicio.setColorPressed(new Color(204,204,204));
            
            this.jMenu2.setColorNormal(new Color(239,238,244));
            this.jMenu2.setColorHover(new Color(204,204,204));
            this.jMenu2.setColorPressed(new Color(204,204,204));
            
            this.M_consultar.setColorNormal(new Color(239,238,244));
            this.M_consultar.setColorHover(new Color(204,204,204));
            this.M_consultar.setColorPressed(new Color(204,204,204));
            
            this.M_registrar.setColorNormal(new Color(239,238,244));
            this.M_registrar.setColorHover(new Color(204,204,204));
            this.M_registrar.setColorPressed(new Color(204,204,204));
            
            this.M_reportes.setColorNormal(new Color(239,238,244));
            this.M_reportes.setColorHover(new Color(204,204,204));
            this.M_reportes.setColorPressed(new Color(204,204,204));
            
            this.mantenimiento.setColorNormal(new Color(239,238,244));
            this.mantenimiento.setColorHover(new Color(204,204,204));
            this.mantenimiento.setColorPressed(new Color(204,204,204));
            
            this.jMenu1.setColorNormal(new Color(239,238,244));
            this.jMenu1.setColorHover(new Color(204,204,204));
            this.jMenu1.setColorPressed(new Color(204,204,204));
        }else{
            this.M_acerca.setColorNormal(new Color(239,238,244));
            this.M_acerca.setColorHover(new Color(204,204,204));
            this.M_acerca.setColorPressed(new Color(204,204,204));
        }
    }//GEN-LAST:event_M_acercaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int posicion = pnlMenu.getX();
        if(posicion > -1){
            Animacion.Animacion.mover_izquierda(0, -340, 2, 2, pnlMenu);
             Animacion.Animacion.mover_izquierda(0, -264, 2, 2, pnlCompras.pnlCompras);
             Animacion.Animacion.mover_izquierda(0, -264, 2, 2, pnlConfiguración.pnlConfiguración);
             Animacion.Animacion.mover_izquierda(0, -264, 2, 2, pnlConsultas.pnlConsultas);
             Animacion.Animacion.mover_izquierda(0, -264, 2, 2, pnlInicio.pnlInicio);
             Animacion.Animacion.mover_izquierda(0, -264, 2, 2, pnlRegistrar.pnlRegistrar);
             Animacion.Animacion.mover_izquierda(0, -340, 2, 2, pnlReportes.pnlReportes);
             Animacion.Animacion.mover_izquierda(0, -264, 2, 2, pnlVentas.pnlVentas);
            
        }else{
            Animacion.Animacion.mover_derecha(-264, 0, 2, 2, pnlMenu);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        this.M_deinicio.setSelected(false);
        this.M_acerca.setSelected(false);
        this.jMenu2.setSelected(false);
        this.M_consultar.setSelected(false);
        this.M_registrar.setSelected(false);
        this.M_reportes.setSelected(false);
        this.mantenimiento.setSelected(false);
        this.jMenu1.setSelected(true);
    }//GEN-LAST:event_jMenu1MousePressed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        /*new CambiaPanel(pnlPrincipal, new paneles.pnlWeb());
        if(this.jMenu1.isSelected()){
        this.M_deinicio.setColorNormal(new Color(239,238,244));
        this.M_deinicio.setColorHover(new Color(204,204,204));
        this.M_deinicio.setColorPressed(new Color(204,204,204));
        
        this.M_acerca.setColorNormal(new Color(239,238,244));
        this.M_acerca.setColorHover(new Color(204,204,204));
        this.M_acerca.setColorPressed(new Color(204,204,204));
        
        this.jMenu2.setColorNormal(new Color(239,238,244));
        this.jMenu2.setColorHover(new Color(204,204,204));
        this.jMenu2.setColorPressed(new Color(204,204,204));
        
        this.M_consultar.setColorNormal(new Color(239,238,244));
        this.M_consultar.setColorHover(new Color(204,204,204));
        this.M_consultar.setColorPressed(new Color(204,204,204));
        
        this.M_registrar.setColorNormal(new Color(239,238,244));
        this.M_registrar.setColorHover(new Color(204,204,204));
        this.M_registrar.setColorPressed(new Color(204,204,204));
        
        this.M_reportes.setColorNormal(new Color(239,238,244));
        this.M_reportes.setColorHover(new Color(204,204,204));
        this.M_reportes.setColorPressed(new Color(204,204,204));
        
        this.mantenimiento.setColorNormal(new Color(239,238,244));
        this.mantenimiento.setColorHover(new Color(204,204,204));
        this.mantenimiento.setColorPressed(new Color(204,204,204));
        
        this.jMenu1.setColorNormal(new Color(204,204,204));
        this.jMenu1.setColorHover(new Color(204,204,204));
        this.jMenu1.setColorPressed(new Color(204,204,204));
        }else{
        this.jMenu1.setColorNormal(new Color(239,238,244));
        this.jMenu1.setColorHover(new Color(204,204,204));
        this.jMenu1.setColorPressed(new Color(204,204,204));
        }*/
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void mantenimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mantenimientoMousePressed
        this.M_deinicio.setSelected(false);
        this.M_acerca.setSelected(false);
        this.jMenu2.setSelected(false);
        this.M_consultar.setSelected(false);
        this.M_registrar.setSelected(false);
        this.M_reportes.setSelected(false);
        this.mantenimiento.setSelected(true);
        this.jMenu1.setSelected(false);
    }//GEN-LAST:event_mantenimientoMousePressed

    private void mantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mantenimientoActionPerformed
        new CambiaPanel(pnlPrincipal, new paneles.pnlConfiguración());
        if(this.mantenimiento.isSelected()){
            this.M_deinicio.setColorNormal(new Color(239,238,244));
            this.M_deinicio.setColorHover(new Color(204,204,204));
            this.M_deinicio.setColorPressed(new Color(204,204,204));
            
            this.M_acerca.setColorNormal(new Color(239,238,244));
            this.M_acerca.setColorHover(new Color(204,204,204));
            this.M_acerca.setColorPressed(new Color(204,204,204));
            
            this.jMenu2.setColorNormal(new Color(239,238,244));
            this.jMenu2.setColorHover(new Color(204,204,204));
            this.jMenu2.setColorPressed(new Color(204,204,204));
            
            this.M_consultar.setColorNormal(new Color(239,238,244));
            this.M_consultar.setColorHover(new Color(204,204,204));
            this.M_consultar.setColorPressed(new Color(204,204,204));
            
            this.M_registrar.setColorNormal(new Color(239,238,244));
            this.M_registrar.setColorHover(new Color(204,204,204));
            this.M_registrar.setColorPressed(new Color(204,204,204));
            
            this.M_reportes.setColorNormal(new Color(239,238,244));
            this.M_reportes.setColorHover(new Color(204,204,204));
            this.M_reportes.setColorPressed(new Color(204,204,204));
            
            this.mantenimiento.setColorNormal(new Color(204,204,204));
            this.mantenimiento.setColorHover(new Color(204,204,204));
            this.mantenimiento.setColorPressed(new Color(204,204,204));
            
            this.jMenu1.setColorNormal(new Color(239,238,244));
            this.jMenu1.setColorHover(new Color(204,204,204));
            this.jMenu1.setColorPressed(new Color(204,204,204));
        }else{
            this.mantenimiento.setColorNormal(new Color(239,238,244));
            this.mantenimiento.setColorHover(new Color(204,204,204));
            this.mantenimiento.setColorPressed(new Color(204,204,204));
        }
    }//GEN-LAST:event_mantenimientoActionPerformed

    private void M_reportesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_M_reportesMousePressed
        this.M_deinicio.setSelected(false);
        this.M_acerca.setSelected(false);
        this.jMenu2.setSelected(false);
        this.M_consultar.setSelected(false);
        this.M_registrar.setSelected(false);
        this.M_reportes.setSelected(true);
        this.mantenimiento.setSelected(false);
        this.jMenu1.setSelected(false);
    }//GEN-LAST:event_M_reportesMousePressed

    private void M_reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_reportesActionPerformed
        new CambiaPanel(pnlPrincipal, new paneles.pnlReportes());
        if(this.M_reportes.isSelected()){
            this.M_deinicio.setColorNormal(new Color(239,238,244));
            this.M_deinicio.setColorHover(new Color(204,204,204));
            this.M_deinicio.setColorPressed(new Color(204,204,204));
            
            this.M_acerca.setColorNormal(new Color(239,238,244));
            this.M_acerca.setColorHover(new Color(204,204,204));
            this.M_acerca.setColorPressed(new Color(204,204,204));
            
            this.jMenu2.setColorNormal(new Color(239,238,244));
            this.jMenu2.setColorHover(new Color(204,204,204));
            this.jMenu2.setColorPressed(new Color(204,204,204));
            
            this.M_consultar.setColorNormal(new Color(239,238,244));
            this.M_consultar.setColorHover(new Color(204,204,204));
            this.M_consultar.setColorPressed(new Color(204,204,204));
            
            this.M_registrar.setColorNormal(new Color(239,238,244));
            this.M_registrar.setColorHover(new Color(204,204,204));
            this.M_registrar.setColorPressed(new Color(204,204,204));
            
            this.M_reportes.setColorNormal(new Color(204,204,204));
            this.M_reportes.setColorHover(new Color(204,204,204));
            this.M_reportes.setColorPressed(new Color(204,204,204));
            
            this.mantenimiento.setColorNormal(new Color(239,238,244));
            this.mantenimiento.setColorHover(new Color(204,204,204));
            this.mantenimiento.setColorPressed(new Color(204,204,204));
            
            this.jMenu1.setColorNormal(new Color(239,238,244));
            this.jMenu1.setColorHover(new Color(204,204,204));
            this.jMenu1.setColorPressed(new Color(204,204,204));
        }else{
            this.M_reportes.setColorNormal(new Color(239,238,244));
            this.M_reportes.setColorHover(new Color(204,204,204));
            this.M_reportes.setColorPressed(new Color(204,204,204));
        }
    }//GEN-LAST:event_M_reportesActionPerformed

    private void M_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_registrarActionPerformed
        new CambiaPanel(pnlPrincipal, new paneles.pnlRegistrar());
        if(this.M_registrar.isSelected()){
            this.M_deinicio.setColorNormal(new Color(239,238,244));
            this.M_deinicio.setColorHover(new Color(204,204,204));
            this.M_deinicio.setColorPressed(new Color(204,204,204));
            
            this.M_acerca.setColorNormal(new Color(239,238,244));
            this.M_acerca.setColorHover(new Color(204,204,204));
            this.M_acerca.setColorPressed(new Color(204,204,204));
            
            this.jMenu2.setColorNormal(new Color(239,238,244));
            this.jMenu2.setColorHover(new Color(204,204,204));
            this.jMenu2.setColorPressed(new Color(204,204,204));
            
            this.M_consultar.setColorNormal(new Color(239,238,244));
            this.M_consultar.setColorHover(new Color(204,204,204));
            this.M_consultar.setColorPressed(new Color(204,204,204));
            
            this.M_registrar.setColorNormal(new Color(204,204,204));
            this.M_registrar.setColorHover(new Color(204,204,204));
            this.M_registrar.setColorPressed(new Color(204,204,204));
            
            this.M_reportes.setColorNormal(new Color(239,238,244));
            this.M_reportes.setColorHover(new Color(204,204,204));
            this.M_reportes.setColorPressed(new Color(204,204,204));
            
            this.mantenimiento.setColorNormal(new Color(239,238,244));
            this.mantenimiento.setColorHover(new Color(204,204,204));
            this.mantenimiento.setColorPressed(new Color(204,204,204));
            
            this.jMenu1.setColorNormal(new Color(239,238,244));
            this.jMenu1.setColorHover(new Color(204,204,204));
            this.jMenu1.setColorPressed(new Color(204,204,204));
        }else{
            this.M_registrar.setColorNormal(new Color(239,238,244));
            this.M_registrar.setColorHover(new Color(204,204,204));
            this.M_registrar.setColorPressed(new Color(204,204,204));
        }
    }//GEN-LAST:event_M_registrarActionPerformed

    private void M_registrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_M_registrarMousePressed
        this.M_deinicio.setSelected(false);
        this.M_acerca.setSelected(false);
        this.jMenu2.setSelected(false);
        this.M_consultar.setSelected(false);
        this.M_registrar.setSelected(true);
        this.M_reportes.setSelected(false);
        this.mantenimiento.setSelected(false);
        this.jMenu1.setSelected(false);
    }//GEN-LAST:event_M_registrarMousePressed

    private void M_consultarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_M_consultarMousePressed
        this.M_deinicio.setSelected(false);
        this.M_acerca.setSelected(false);
        this.jMenu2.setSelected(false);
        this.M_consultar.setSelected(true);
        this.M_registrar.setSelected(false);
        this.M_reportes.setSelected(false);
        this.mantenimiento.setSelected(false);
        this.jMenu1.setSelected(false);
    }//GEN-LAST:event_M_consultarMousePressed

    private void M_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_consultarActionPerformed
        new CambiaPanel(pnlPrincipal, new paneles.pnlConsultas());
        if(this.M_consultar.isSelected()){
            this.M_deinicio.setColorNormal(new Color(239,238,244));
            this.M_deinicio.setColorHover(new Color(204,204,204));
            this.M_deinicio.setColorPressed(new Color(204,204,204));
            
            this.M_acerca.setColorNormal(new Color(239,238,244));
            this.M_acerca.setColorHover(new Color(204,204,204));
            this.M_acerca.setColorPressed(new Color(204,204,204));
            
            this.jMenu2.setColorNormal(new Color(239,238,244));
            this.jMenu2.setColorHover(new Color(204,204,204));
            this.jMenu2.setColorPressed(new Color(204,204,204));
            
            this.M_consultar.setColorNormal(new Color(204,204,204));
            this.M_consultar.setColorHover(new Color(204,204,204));
            this.M_consultar.setColorPressed(new Color(204,204,204));
            
            this.M_registrar.setColorNormal(new Color(239,238,244));
            this.M_registrar.setColorHover(new Color(204,204,204));
            this.M_registrar.setColorPressed(new Color(204,204,204));
            
            this.M_reportes.setColorNormal(new Color(239,238,244));
            this.M_reportes.setColorHover(new Color(204,204,204));
            this.M_reportes.setColorPressed(new Color(204,204,204));
            
            this.mantenimiento.setColorNormal(new Color(239,238,244));
            this.mantenimiento.setColorHover(new Color(204,204,204));
            this.mantenimiento.setColorPressed(new Color(204,204,204));
            
            this.jMenu1.setColorNormal(new Color(239,238,244));
            this.jMenu1.setColorHover(new Color(204,204,204));
            this.jMenu1.setColorPressed(new Color(204,204,204));
        }else{
            this.M_consultar.setColorNormal(new Color(239,238,244));
            this.M_consultar.setColorHover(new Color(204,204,204));
            this.M_consultar.setColorPressed(new Color(204,204,204));
        }
    }//GEN-LAST:event_M_consultarActionPerformed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void btnAbrirCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirCajaActionPerformed
        Caja_Apertura form= new Caja_Apertura();
        form.setVisible(true);
        form.toFront();
    }//GEN-LAST:event_btnAbrirCajaActionPerformed

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        try {  //Mostrar pdf ayuda
            File path = new File("C:\\Manual_Usuario.pdf");
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "El archivo:\n C:\\Manual_Usuario.pdf no existe, \ntal vez se borro de la ruta", "Manual de Usuario",
            JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        /*try {  //Mostrar pdf ayuda
        File path = new File ("C:\\Manual_Usuario.pdf");
        Desktop.getDesktop().open(path);
        }catch (IOException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "El archivo: C:\\Manual_Usuario.pdf no existe, tal vez se borro de la ruta"+ex, "Manual de Usuario",
        JOptionPane.WARNING_MESSAGE);
        }*/
        
       Modulo_Informacion_Creador acerca = new Modulo_Informacion_Creador(this,true);
       acerca.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        Actualizacion Actualizar = new Actualizacion(this,true);
        Actualizar.setVisible(true);
    }//GEN-LAST:event_jMenu7MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //CIERRE DE APLICACION CON MENSAJE
Object[] opciones ={"Aceptar","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,"En Realidad desea Salir de la Aplicacion","Alerta",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if(eleccion ==JOptionPane.YES_OPTION){
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
        }else{

        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    new Principal().setVisible(true);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static rsbuttom.RSButtonMetro M_acerca;
    public static rsbuttom.RSButtonMetro M_consultar;
    public static rsbuttom.RSButtonMetro M_deinicio;
    public static rsbuttom.RSButtonMetro M_registrar;
    public static rsbuttom.RSButtonMetro M_reportes;
    public static javax.swing.JButton btnAbrirCaja;
    private com.toedter.calendar.JDateChooser calendario;
    public static javax.swing.JLabel conectado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private rsbuttom.RSButtonMetro jMenu1;
    public static rsbuttom.RSButtonMetro jMenu2;
    private rsbuttom.RSButtonMetro jMenu6;
    private rsbuttom.RSButtonMetro jMenu7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel labelCajaCerrada;
    private rojeru_san.RSLabelFecha labelFecha;
    public static javax.swing.JLabel lb_tipo;
    public static rsbuttom.RSButtonMetro mantenimiento;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
