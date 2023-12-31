
package Vistas;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class Consultar_Pagos_Ventas extends javax.swing.JFrame {
    int Select;
    String codigo,nombre,apellido,fecha,empleado;
    boolean banderaFacturado=false;
    String NOMBRE,signo_moneda;

    public Consultar_Pagos_Ventas() {
        initComponents();
        this.setResizable(false);
        //icono del sistema
        try{
            setIconImage(new ImageIcon(getClass().getResource("/img/iconoSistema64.png")).getImage());
        }catch(Exception e){
            
        }
        try{
            Connection conn= conexion.ObtenerConexion(); // esta es la verificación de la conexión con mysql
            Statement consulta=conn.createStatement();
            ResultSet r2= consulta.executeQuery("select signo_moneda from  monedas where seleccion_moneda like 'SELECCIONADA'");
            while(r2.next()){
                signo_moneda=r2.getString(1);
            }
        }catch(Exception e){
            
        }
        
        setLocationRelativeTo(null);
        txtRecibe.setVisible(false);
        txtCodigoCliente1.setVisible(false);
        txtBanderaRemito.setVisible(false);
        cargarRemitoNoFacturado();   
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        iniciar();
        JTableHeader th; 
        th = tabla.getTableHeader(); 
        Font fuente = new Font("Calibri", Font.BOLD, 20); 
        th.setFont(fuente); 
        th.setBackground(new Color(93,116,163));
        th.setForeground(new Color(255,255,255));
        

    }    
    
    
    public void cargarRemitoNoFacturado(){
        TableColumn  column = null;    
        try{
            Connection conn= conexion.ObtenerConexion(); // esta es la verificación de la conexión con mysql
            Statement consulta=conn.createStatement(); // crea una variable que se encargue del código de sql

            ResultSet r= consulta.executeQuery("select * from factura where condicion='ACTIVA' order by cod_factura");
            int i,j;
            i=0;
            j=0;
            DefaultTableModel modelo=(DefaultTableModel)tabla.getModel();
            tabla.setRowSorter(new TableRowSorter(modelo));
            
            tabla.getColumnModel().getColumn(0).setMaxWidth(120);
            tabla.getColumnModel().getColumn(0).setMinWidth(120);
            tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(120);
            tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(120);
            
            tabla.getColumnModel().getColumn(1).setMaxWidth(150);
            tabla.getColumnModel().getColumn(1).setMinWidth(150);
            tabla.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(150);
            tabla.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(150);
            
            tabla.getColumnModel().getColumn(2).setMaxWidth(120);
            tabla.getColumnModel().getColumn(2).setMinWidth(120);
            tabla.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(120);
            tabla.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(120);
            
            tabla.getColumnModel().getColumn(5).setMaxWidth(0);
            tabla.getColumnModel().getColumn(5).setMinWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
                           
            tabla.getColumnModel().getColumn(6).setMaxWidth(0);
            tabla.getColumnModel().getColumn(6).setMinWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
            
            tabla.getColumnModel().getColumn(7).setMaxWidth(0);
            tabla.getColumnModel().getColumn(7).setMinWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
            
            tabla.getColumnModel().getColumn(8).setMaxWidth(140);
            tabla.getColumnModel().getColumn(8).setMinWidth(140);
            tabla.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(140);
            tabla.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(140);
            
            modelo.setNumRows(0);
            while(r.next()){
                String codigoCliente=r.getString(3),
                codigoEmpleado=r.getString(4);
                                
                modelo.addRow( new Object [] {null,null,null,null,null,null,null,null});
                tabla.setValueAt(r.getString(1),i,0);

                Statement consulta2=conn.createStatement();
                ResultSet r2= consulta2.executeQuery("select * from cliente order by cod_cliente");
                String nombreCliente="N° "+codigoCliente,apellidoCliente="", cuitCliente="";
                while(r2.next()){
                    if((r2.getString("cod_cliente")).equals(r.getString("cod_cliente"))){
                        nombreCliente=r2.getString(2);
                        apellidoCliente=r2.getString(3);     
                        cuitCliente=r2.getString(8);
                    }
                }
                tabla.setValueAt(r.getString(5),i,1);
                tabla.setValueAt(r.getString(2),i,2);
                tabla.setValueAt(nombreCliente,i,3);
                

                Statement consulta3=conn.createStatement();
                ResultSet r3= consulta3.executeQuery("select * from empleado order by cod_empleado");
                String nombreEmpleado="N° "+codigoEmpleado,apellidoEmpleado="";
                while(r3.next()){
                    if(r3.getString(1).equals(codigoEmpleado)){
                        nombreEmpleado=r3.getString(2);
                        apellidoEmpleado=r3.getString(3);         
                    }
                }
                tabla.setValueAt(nombreEmpleado+" "+apellidoEmpleado,i,4);
                tabla.setValueAt(codigoCliente,i,5);
                tabla.setValueAt(codigoEmpleado,i,6);
                tabla.setValueAt(cuitCliente,i,7);
                
                String pattern3 = "###,###,###.00";
                double value3 = Double.parseDouble(r.getString(9));
                DecimalFormat myFormatter3 = new DecimalFormat(pattern3);
                String str3 = myFormatter3.format(value3);
                if(str3.equals(",00")){
                    str3="0,00";
                } 
                tabla.setValueAt(str3,i,8);
                i++;
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Este articulo Ya Existe") ;
            System.out.println(e);
        }
    }
    
    public void reiniciarPago(){
        txtSubtotalEfectivo.setText("");
        txtDescuentoEfectivo.setText("");
        txtTotalEfectivo.setText("");
        txtTotalCredito.setText("");
        txtACuentaCredito.setText("");
        txtSaldoRestanteCredito.setText("");
        txtNroDeposito.setText("");
        txtNroCuentaDeposito.setText("");
        txtFechaDeposito.setText("");
        txtMontoDeposito.setText("");
        txtNroCheque.setText("");
        txtFechaEmisionCheque.setText("");
        txtMontoCheque.setText("");
        
        panelEfectivo.setVisible(false);
        panelCheque.setVisible(false);
        panelCredito.setVisible(false);
        panelDeposito.setVisible(false); 
        panelTarjetaEfectivo.setVisible(false); 
    }
    
    
    public void iniciar(){

        panelRemito.setVisible(false);
        checkNombreCliente.setSelected(true);
        txtBuscar.setText("Ingrese su búsqueda");
        txtBuscar.setForeground(Color.gray);

        txtCodigoEmpleado1.setVisible(false);
        labelCodigoCliente.setVisible(false);
        labelCodigoEmpleado.setVisible(false);
        txtNombreApellidoEmpleado.setVisible(false);
        txtNombreApellidoCliente.setVisible(true);
        txtTotalFactura.setVisible(false);
        
        txtNumeroRemito.setEditable(false);
        txtFechaRemito.setEditable(false);
        txtTotalFactura2.setEditable(false);
        txtSubtotal.setEditable(false);
        txtIva.setEditable(false);
        
        txtPago.setBackground(Color.WHITE);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        checkRemito = new javax.swing.JRadioButton();
        checkNombreCliente = new javax.swing.JRadioButton();
        checkFecha = new javax.swing.JRadioButton();
        panelRemito = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTotalFactura2 = new javax.swing.JTextField();
        btnFacturarRemito = new javax.swing.JButton();
        txtSubtotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        panelTarjetaEfectivo = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtEfectivoTarjeta = new javax.swing.JTextField();
        txtTarjetaEfectivo = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtSaldoRestanteTarjetaEfectivo = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtVueltoTarjetaEfectivo = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        panelCheque = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtMontoCheque = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNroCheque = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtFechaEmisionCheque = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtFechaVencimientoCheque = new javax.swing.JTextField();
        panelEfectivo = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTotalEfectivo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtSubtotalEfectivo = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtDescuentoEfectivo = new javax.swing.JTextField();
        panelDeposito = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtMontoDeposito = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtNroDeposito = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtFechaDeposito = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtNroCuentaDeposito = new javax.swing.JTextField();
        panelCredito = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtSaldoRestanteCredito = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtTotalCredito = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtACuentaCredito = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumeroRemito = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtFechaRemito = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNombreApellidoCliente = new javax.swing.JTextField();
        txtIva = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtFacturaNumero1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRecibe = new javax.swing.JTextField();
        checkPago = new javax.swing.JRadioButton();
        txtTotalFactura = new javax.swing.JTextField();
        txtBanderaRemito = new javax.swing.JTextField();
        txtCodigoEmpleado1 = new javax.swing.JTextField();
        txtCodigoCliente1 = new javax.swing.JTextField();
        labelCodigoCliente = new javax.swing.JLabel();
        labelCodigoEmpleado = new javax.swing.JLabel();
        txtNombreApellidoEmpleado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(78, 184, 221));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N° FACTURA", "PAGO", "FECHA", "CLIENTE", "VENDEDOR", "cod cliente", "cod empleado", "cuit cliente", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setRowHeight(25);
        tabla.setRowMargin(4);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1200, 380));

        txtBuscar.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txtBuscar.setBorder(null);
        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarFocusLost(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, 300, 40));

        buttonGroup1.add(checkRemito);
        checkRemito.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        checkRemito.setForeground(new java.awt.Color(255, 255, 255));
        checkRemito.setText("N° Fact");
        checkRemito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkRemito.setOpaque(false);
        checkRemito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkRemitoActionPerformed(evt);
            }
        });
        jPanel1.add(checkRemito, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, -1, 30));

        buttonGroup1.add(checkNombreCliente);
        checkNombreCliente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        checkNombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        checkNombreCliente.setText("Cliente");
        checkNombreCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkNombreCliente.setOpaque(false);
        checkNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNombreClienteActionPerformed(evt);
            }
        });
        jPanel1.add(checkNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, -1, -1));

        buttonGroup1.add(checkFecha);
        checkFecha.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        checkFecha.setForeground(new java.awt.Color(255, 255, 255));
        checkFecha.setText("Fecha");
        checkFecha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkFecha.setOpaque(false);
        checkFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkFechaActionPerformed(evt);
            }
        });
        jPanel1.add(checkFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, -1, -1));

        panelRemito.setBackground(new java.awt.Color(255, 255, 255));
        panelRemito.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel2.setText("SUBTOTAL");
        panelRemito.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 42));

        txtTotalFactura2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txtTotalFactura2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelRemito.add(txtTotalFactura2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 200, 42));

        btnFacturarRemito.setBackground(new java.awt.Color(47, 172, 148));
        btnFacturarRemito.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnFacturarRemito.setForeground(new java.awt.Color(255, 255, 255));
        btnFacturarRemito.setText("MOSTRAR FACTURA");
        btnFacturarRemito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFacturarRemito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarRemitoActionPerformed(evt);
            }
        });
        panelRemito.add(btnFacturarRemito, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 130, 240, 40));

        txtSubtotal.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txtSubtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelRemito.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 160, 42));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel5.setText("TOTAL");
        panelRemito.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 80, 42));

        panelTarjetaEfectivo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel19.setText("Efectivo:");
        panelTarjetaEfectivo.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 30));

        txtEfectivoTarjeta.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtEfectivoTarjeta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEfectivoTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEfectivoTarjetaActionPerformed(evt);
            }
        });
        panelTarjetaEfectivo.add(txtEfectivoTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 150, 30));

        txtTarjetaEfectivo.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtTarjetaEfectivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTarjetaEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTarjetaEfectivoActionPerformed(evt);
            }
        });
        panelTarjetaEfectivo.add(txtTarjetaEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 170, 30));

        jLabel30.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel30.setText("Tarjeta:");
        panelTarjetaEfectivo.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 100, 30));

        txtSaldoRestanteTarjetaEfectivo.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtSaldoRestanteTarjetaEfectivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSaldoRestanteTarjetaEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoRestanteTarjetaEfectivoActionPerformed(evt);
            }
        });
        panelTarjetaEfectivo.add(txtSaldoRestanteTarjetaEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 160, 30));

        jLabel31.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel31.setText("Saldo restante:");
        panelTarjetaEfectivo.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 160, 30));

        txtVueltoTarjetaEfectivo.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtVueltoTarjetaEfectivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVueltoTarjetaEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVueltoTarjetaEfectivoActionPerformed(evt);
            }
        });
        panelTarjetaEfectivo.add(txtVueltoTarjetaEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 180, 30));

        jLabel32.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel32.setText("Vuelto:");
        panelTarjetaEfectivo.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 80, 30));

        panelRemito.add(panelTarjetaEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1160, 50));

        panelCheque.setBackground(new java.awt.Color(255, 255, 153));
        panelCheque.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel6.setText("Monto:");
        panelCheque.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, 90, 30));

        txtMontoCheque.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtMontoCheque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMontoCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoChequeActionPerformed(evt);
            }
        });
        panelCheque.add(txtMontoCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, 140, 30));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel9.setText("N°Cheque:");
        panelCheque.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));

        txtNroCheque.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtNroCheque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNroCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNroChequeActionPerformed(evt);
            }
        });
        panelCheque.add(txtNroCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 180, 30));

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel14.setText("Fecha vencimiento:");
        panelCheque.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 180, 30));

        txtFechaEmisionCheque.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtFechaEmisionCheque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaEmisionCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaEmisionChequeActionPerformed(evt);
            }
        });
        panelCheque.add(txtFechaEmisionCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 140, 30));

        jLabel33.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel33.setText("Fecha emision:");
        panelCheque.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 140, 30));

        txtFechaVencimientoCheque.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtFechaVencimientoCheque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaVencimientoCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaVencimientoChequeActionPerformed(evt);
            }
        });
        panelCheque.add(txtFechaVencimientoCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 140, 30));

        panelRemito.add(panelCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1160, 50));

        panelEfectivo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel15.setText("Total:");
        panelEfectivo.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 70, 30));

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel16.setText("Fecha");
        panelEfectivo.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 70, 40));

        txtTotalEfectivo.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtTotalEfectivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalEfectivoActionPerformed(evt);
            }
        });
        panelEfectivo.add(txtTotalEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 180, 30));

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel18.setText("Subtotal:");
        panelEfectivo.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 30));

        txtSubtotalEfectivo.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtSubtotalEfectivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSubtotalEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubtotalEfectivoActionPerformed(evt);
            }
        });
        panelEfectivo.add(txtSubtotalEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 190, 30));

        jLabel21.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel21.setText("IVA Disc:");
        panelEfectivo.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 110, 30));

        txtDescuentoEfectivo.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtDescuentoEfectivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescuentoEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescuentoEfectivoActionPerformed(evt);
            }
        });
        panelEfectivo.add(txtDescuentoEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 190, 30));

        panelRemito.add(panelEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1160, 50));

        panelDeposito.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel17.setText("Monto:");
        panelDeposito.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 90, 30));

        jLabel22.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel22.setText("Fecha");
        panelDeposito.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 70, 40));

        txtMontoDeposito.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtMontoDeposito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMontoDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoDepositoActionPerformed(evt);
            }
        });
        panelDeposito.add(txtMontoDeposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 150, 30));

        jLabel23.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel23.setText("N°Deposito:");
        panelDeposito.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        txtNroDeposito.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtNroDeposito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNroDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNroDepositoActionPerformed(evt);
            }
        });
        panelDeposito.add(txtNroDeposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 190, 30));

        jLabel24.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel24.setText("Fecha");
        panelDeposito.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 80, 30));

        txtFechaDeposito.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtFechaDeposito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaDepositoActionPerformed(evt);
            }
        });
        panelDeposito.add(txtFechaDeposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 140, 30));

        jLabel25.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel25.setText("N° Cuenta:");
        panelDeposito.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 120, 30));

        txtNroCuentaDeposito.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtNroCuentaDeposito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNroCuentaDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNroCuentaDepositoActionPerformed(evt);
            }
        });
        panelDeposito.add(txtNroCuentaDeposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 190, 30));

        panelRemito.add(panelDeposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1160, 50));

        panelCredito.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel26.setText("Saldo restante:");
        panelCredito.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 160, 30));

        jLabel27.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel27.setText("Fecha");
        panelCredito.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 70, 40));

        txtSaldoRestanteCredito.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtSaldoRestanteCredito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSaldoRestanteCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoRestanteCreditoActionPerformed(evt);
            }
        });
        panelCredito.add(txtSaldoRestanteCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 180, 30));

        jLabel28.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel28.setText("Total:");
        panelCredito.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 70, 30));

        txtTotalCredito.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtTotalCredito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalCreditoActionPerformed(evt);
            }
        });
        panelCredito.add(txtTotalCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 190, 30));

        jLabel29.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel29.setText("A cuenta:");
        panelCredito.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 120, 30));

        txtACuentaCredito.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtACuentaCredito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtACuentaCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtACuentaCreditoActionPerformed(evt);
            }
        });
        panelCredito.add(txtACuentaCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 190, 30));

        panelRemito.add(panelCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1160, 50));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel10.setText("PAGO");
        panelRemito.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 80, 40));

        txtPago.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtPago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagoActionPerformed(evt);
            }
        });
        panelRemito.add(txtPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 200, 40));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel3.setText("N° Fact");
        panelRemito.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 90, 40));

        txtNumeroRemito.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txtNumeroRemito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroRemito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroRemitoActionPerformed(evt);
            }
        });
        panelRemito.add(txtNumeroRemito, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 170, 42));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel11.setText("Fecha");
        panelRemito.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 70, 40));

        txtFechaRemito.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txtFechaRemito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaRemito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaRemitoActionPerformed(evt);
            }
        });
        panelRemito.add(txtFechaRemito, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 130, 42));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel12.setText("Cliente");
        panelRemito.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, -1, 40));

        txtNombreApellidoCliente.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        txtNombreApellidoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreApellidoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreApellidoClienteActionPerformed(evt);
            }
        });
        panelRemito.add(txtNombreApellidoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 280, 40));

        txtIva.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txtIva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelRemito.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 170, 42));

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel13.setText("IVA DISC");
        panelRemito.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 100, 42));

        jPanel1.add(panelRemito, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, 190));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoRemitosXs-01.png"))); // NOI18N
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 70));

        txtFacturaNumero1.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        txtFacturaNumero1.setForeground(new java.awt.Color(255, 255, 255));
        txtFacturaNumero1.setText("PAGOS DE CLIENTES");
        jPanel1.add(txtFacturaNumero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 270, 50));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 310, 10));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonBuscar.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, -1, 80));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 26)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Buscar por");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, -1));
        jPanel1.add(txtRecibe, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 50, 20));

        buttonGroup1.add(checkPago);
        checkPago.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        checkPago.setForeground(new java.awt.Color(255, 255, 255));
        checkPago.setText("Pago");
        checkPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkPago.setOpaque(false);
        checkPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPagoActionPerformed(evt);
            }
        });
        jPanel1.add(checkPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, -1, -1));

        txtTotalFactura.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jPanel1.add(txtTotalFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 20, -1));
        jPanel1.add(txtBanderaRemito, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 30, 50));

        txtCodigoEmpleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoEmpleado1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigoEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 80, 20));

        txtCodigoCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoCliente1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigoCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 70, 20));

        labelCodigoCliente.setText("COD_CLIENTE");
        jPanel1.add(labelCodigoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        labelCodigoEmpleado.setText("COD_EMPLEADO");
        jPanel1.add(labelCodigoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));
        jPanel1.add(txtNombreApellidoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    DefaultTableModel dm;
    /* Método filtro*/
    private void filtro2(String consulta, JTable jtableBuscar){
        dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(dm);
        jtableBuscar.setRowSorter(tr);

        int columna=0;
        // Identificamos cual es el JRadioButton seleccionado para filtrar el
        // resultado de acuerdo a los datos de la columna elegida
        if (checkRemito.isSelected()) {
            columna = 0;
        }else if (checkNombreCliente.isSelected()) {
                    columna = 3;
              }else if (checkFecha.isSelected()) {
                        columna = 2;
                    }else if (checkPago.isSelected()){
                        columna = 1;
                    }
        tr.setRowFilter(RowFilter.regexFilter(consulta, columna));
    }
    
    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if (buttonGroup1.getSelection()==null) {
            // Si ninguno de los JRadioButtons está seleccionado, evitamos que se
            // escriba algo dentro del JTextField y mostramos un mensaje de error
            evt.consume();
            JOptionPane.showMessageDialog(this, "Debe seleccionar una opción para filtrar los resultados", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
            txtBuscar.setText("");
            txtBuscar.transferFocus();
        }else{
            filtro2(txtBuscar.getText().toUpperCase(), tabla);
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void checkRemitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkRemitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkRemitoActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        txtBanderaRemito.setText("0");
        panelRemito.setVisible(true);
        int fila= tabla.getSelectedRow();

        if(fila>=0){
            Select=tabla.getSelectedRow();
            txtNumeroRemito.setText(tabla.getValueAt(Select,0).toString());
            txtFechaRemito.setText(tabla.getValueAt(Select,2).toString());
            txtCodigoCliente1.setText(tabla.getValueAt(Select,5).toString());
            txtCodigoEmpleado1.setText(tabla.getValueAt(Select,6).toString());
            txtNombreApellidoEmpleado.setText(tabla.getValueAt(Select,4).toString());
            txtNombreApellidoCliente.setText(tabla.getValueAt(Select,3).toString());
            txtPago.setText(tabla.getValueAt(Select,1).toString());
            
            
            String pago=txtPago.getText();
            String numFact=txtNumeroRemito.getText();
            reiniciarPago();
            try{
                Connection conn= conexion.ObtenerConexion(); // esta es la verificación de la conexión con mysql
                Statement consulta=conn.createStatement(); // crea una variable que se encargue del código de sql
                Statement consulta2=conn.createStatement(); // crea una variable que se encargue del código de sql
                ResultSet res2= consulta2.executeQuery("select total_con_iva,total_sin_iva,ivaDiscriminado from factura where cod_factura='"+numFact+"'");    
                while(res2.next()){
                    String pattern = "###,###,###.00";
                    double value = Double.parseDouble(res2.getString(1));
                    DecimalFormat myFormatter = new DecimalFormat(pattern);
                    String str = myFormatter.format(value);
                    if(str.equals(",00")){
                        str="0,00";
                    }
                    txtTotalFactura2.setText(str);
                    

                    double value2 = Double.parseDouble(res2.getString(2));
                    String str2 = myFormatter.format(value2);
                    if(str2.equals(",00")){
                        str2="0,00";
                    }
                    txtSubtotal.setText(str2);
                    
                    double value3 = Double.parseDouble(res2.getString(3));
                    String str3 = myFormatter.format(value3);
                    if(str3.equals(",00")){
                        str3="0,00";
                    }
                    txtIva.setText(str3);
                }
                ResultSet res=null;
                if(pago.equals("EFECTIVO")){
                    Color verde = new Color(67,202,7);
                    panelEfectivo.setBackground(verde);
                    txtPago.setBackground(verde);
                    panelEfectivo.setVisible(true);
                    
                    res= consulta.executeQuery("select * from venta_efectivo where cod_venta='"+numFact+"'");               
                    while(res.next()){
                        String pattern = "###,###,###.00";
                        double value = Double.parseDouble(res.getString(3));
                        DecimalFormat myFormatter = new DecimalFormat(pattern);
                        String str = myFormatter.format(value);
                        if(str.equals(",00")){
                                str="0,00";
                        }
                        txtSubtotalEfectivo.setText(str); //subtotal
                       
                        String pattern2 = "###,###,###.00";
                        double value2 = Double.parseDouble(res.getString(4));
                        DecimalFormat myFormatter2 = new DecimalFormat(pattern2);
                        String str2 = myFormatter2.format(value2);
                        if(str2.equals(",00")){
                                str2="0,00";
                        }                    
                        txtDescuentoEfectivo.setText(str2); //descuento 
                        
                        String pattern3 = "###,###,###.00";
                        double value3 = Double.parseDouble(res.getString(5));
                        DecimalFormat myFormatter3 = new DecimalFormat(pattern3);
                        String str3 = myFormatter3.format(value3);
                        if(str3.equals(",00")){
                                str3="0,00";
                        } 
                        txtTotalEfectivo.setText(str3); //total
                    }

                    res.close(); 
                }else if(pago.equals("CREDITO")){
                            panelCredito.setBackground(Color.ORANGE);
                            txtPago.setBackground(Color.ORANGE);
                            panelCredito.setVisible(true);

                            res= consulta.executeQuery("select * from venta_credito where cod_venta='"+numFact+"'");               
                            while(res.next()){
                                String pattern = "###,###,###.00";
                                double value = Double.parseDouble(res.getString(3));
                                DecimalFormat myFormatter = new DecimalFormat(pattern);
                                String str = myFormatter.format(value);
                                if(str.equals(",00")){
                                        str="0,00";
                                }
                               txtTotalCredito.setText(str); //total
                               
                               String pattern2 = "###,###,###.00";
                                double value2 = Double.parseDouble(res.getString(4));
                                DecimalFormat myFormatter2 = new DecimalFormat(pattern2);
                                String str2 = myFormatter2.format(value2);
                                if(str2.equals(",00")){
                                        str2="0,00";
                                }
                               txtACuentaCredito.setText(str2); //acuenta
                               
                               String pattern3 = "###,###,###.00";
                                double value3 = Double.parseDouble(res.getString(5));
                                DecimalFormat myFormatter3 = new DecimalFormat(pattern3);
                                String str3 = myFormatter3.format(value3);
                                if(str3.equals(",00")){
                                        str3="0,00";
                                }
                               txtSaldoRestanteCredito.setText(str3); //restante
                            }

                            res.close();
                        }else if(pago.equals("DEPOSITO")){
                                    panelDeposito.setBackground(Color.ORANGE);
                                    txtPago.setBackground(Color.ORANGE);
                                    panelDeposito.setVisible(true);

                                    res= consulta.executeQuery("select * from venta_deposito where cod_venta='"+numFact+"'");               
                                    while(res.next()){
                                       txtNroDeposito.setText(res.getString(4)); //nro deposito
                                       txtNroCuentaDeposito.setText(res.getString(3)); //nro cuenta
                                       txtFechaDeposito.setText(res.getString(6)); //fecha deposito
                                       
                                        String pattern = "###,###,###.00";
                                        double value = Double.parseDouble(res.getString(5).replace(',','.'));
                                        DecimalFormat myFormatter = new DecimalFormat(pattern);
                                        String str = myFormatter.format(value);
                                        if(str.equals(",00")){
                                                str="0,00";
                                        }
                                       txtMontoDeposito.setText(str); //monto deposito
                                    }

                                    res.close();
                                }else if(pago.equals("CHEQUE")){
                                        panelCheque.setBackground(Color.ORANGE);
                                        txtPago.setBackground(Color.ORANGE);
                                        panelCheque.setVisible(true);

                                        res= consulta.executeQuery("select * from venta_cheque where cod_venta='"+numFact+"'");               
                                        while(res.next()){
                                           txtNroCheque.setText(res.getString(3)); //nro cheque
                                           txtFechaEmisionCheque.setText(res.getString(4)); //fecha emision
                                           txtFechaVencimientoCheque.setText(res.getString(5)); //fecha vencimiento
                                           
                                            String pattern = "###,###,###.00";
                                            double value = Double.parseDouble(res.getString(6));
                                            DecimalFormat myFormatter = new DecimalFormat(pattern);
                                            String str = myFormatter.format(value);
                                            if(str.equals(",00")){
                                                    str="0,00";
                                            }
                                           txtMontoCheque.setText(str); //monto

                                        }

                                        res.close();
                                    }else if (pago.equals("EFECTIVO Y TARJETA")){
                                        panelTarjetaEfectivo.setBackground(Color.YELLOW);
                                        txtPago.setBackground(Color.YELLOW);
                                        panelTarjetaEfectivo.setVisible(true);

                                        res= consulta.executeQuery("select * from venta_mixta where cod_venta='"+numFact+"'");               
                                        while(res.next()){
                                            String pattern = "###,###,###.00";
                                            double value = Double.parseDouble(res.getString(4));//efectivo
                                            DecimalFormat myFormatter = new DecimalFormat(pattern);
                                            String str = myFormatter.format(value);
                                            if(str.equals(",00")){
                                                    str="0,00";
                                            }
                                           txtEfectivoTarjeta.setText(str); //efectivo

                                           String pattern2 = "###,###,###.00";
                                            double value2 = Double.parseDouble(res.getString(5));//tarjeta
                                            DecimalFormat myFormatter2 = new DecimalFormat(pattern2);
                                            String str2 = myFormatter2.format(value2);
                                            if(str2.equals(",00")){
                                                    str2="0,00";
                                            }
                                           txtTarjetaEfectivo.setText(str2); //tarjeta

                                           String pattern3 = "###,###,###.00";
                                            double value3 = Double.parseDouble(res.getString(6));//saldo restante
                                            DecimalFormat myFormatter3 = new DecimalFormat(pattern3);
                                            String str3 = myFormatter3.format(value3);
                                            if(str3.equals(",00")){
                                                    str3="0,00";
                                            }
                                           txtSaldoRestanteTarjetaEfectivo.setText(str3); //saldo restante
                                           
                                           String pattern4 = "###,###,###.00";
                                            double value4 = Double.parseDouble(res.getString(7));//saldo restante
                                            DecimalFormat myFormatter4 = new DecimalFormat(pattern4);
                                            String str4 = myFormatter4.format(value4);
                                            if(str4.equals(",00")){
                                                    str4="0,00";
                                            }
                                           txtVueltoTarjetaEfectivo.setText(str4); //saldo restante
                                        }

                                        res.close();
                                    }else if (pago.equals("")){
                                       reiniciarPago(); 
                                    }
            }catch(SQLException e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Error en el SQL") ;
            }
    
            
     
        }else{
            JOptionPane.showMessageDialog(null,"No selecciono ninguna fila");
        }
    }//GEN-LAST:event_tablaMouseClicked
    
    private void txtNumeroRemitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroRemitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroRemitoActionPerformed

    private void txtCodigoCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoCliente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoCliente1ActionPerformed

    private void txtFechaRemitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaRemitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaRemitoActionPerformed

    private void txtCodigoEmpleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoEmpleado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoEmpleado1ActionPerformed

    private void txtNombreApellidoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreApellidoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreApellidoClienteActionPerformed

    private void checkFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkFechaActionPerformed

    private void checkNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkNombreClienteActionPerformed

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        if(txtBuscar.getText().equals("Ingrese su búsqueda")){
            txtBuscar.setText("");
        }
        txtBuscar.setForeground(Color.black);
    }//GEN-LAST:event_txtBuscarFocusGained

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        if(txtBuscar.getText().equals("")){
            txtBuscar.setText("Ingrese su búsqueda");
        }
        txtBuscar.setForeground(Color.gray);
    }//GEN-LAST:event_txtBuscarFocusLost

    private void btnFacturarRemitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarRemitoActionPerformed

        Connection miconexion = conexion.ObtenerConexion();
        Map parametros = new HashMap();
        Select=tabla.getSelectedRow();
        String codigoFactura= txtNumeroRemito.getText(); 
        parametros.put("codf",codigoFactura);
        try{     
            String reporte="factura.jasper";
            JasperPrint informe =JasperFillManager.fillReport(reporte, parametros,miconexion);
            JasperViewer ventanavisor=new JasperViewer(informe,false);
            ventanavisor.setTitle("Reporte de Factura");
            ventanavisor.setVisible(true); 
            //this.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
         
    }//GEN-LAST:event_btnFacturarRemitoActionPerformed

    private void txtPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagoActionPerformed

    private void txtMontoChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoChequeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoChequeActionPerformed

    private void txtNroChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroChequeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNroChequeActionPerformed

    private void txtFechaEmisionChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaEmisionChequeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaEmisionChequeActionPerformed

    private void txtTotalEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalEfectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalEfectivoActionPerformed

    private void txtSubtotalEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalEfectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtotalEfectivoActionPerformed

    private void txtDescuentoEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentoEfectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoEfectivoActionPerformed

    private void txtMontoDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoDepositoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoDepositoActionPerformed

    private void txtNroDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroDepositoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNroDepositoActionPerformed

    private void txtFechaDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaDepositoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaDepositoActionPerformed

    private void txtNroCuentaDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroCuentaDepositoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNroCuentaDepositoActionPerformed

    private void txtSaldoRestanteCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoRestanteCreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoRestanteCreditoActionPerformed

    private void txtTotalCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalCreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalCreditoActionPerformed

    private void txtACuentaCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtACuentaCreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtACuentaCreditoActionPerformed

    private void checkPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkPagoActionPerformed

    private void txtEfectivoTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEfectivoTarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEfectivoTarjetaActionPerformed

    private void txtTarjetaEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTarjetaEfectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTarjetaEfectivoActionPerformed

    private void txtSaldoRestanteTarjetaEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoRestanteTarjetaEfectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoRestanteTarjetaEfectivoActionPerformed

    private void txtVueltoTarjetaEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVueltoTarjetaEfectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVueltoTarjetaEfectivoActionPerformed

    private void txtFechaVencimientoChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaVencimientoChequeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaVencimientoChequeActionPerformed

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
            java.util.logging.Logger.getLogger(Consultar_Pagos_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultar_Pagos_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultar_Pagos_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultar_Pagos_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultar_Pagos_Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFacturarRemito;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton checkFecha;
    private javax.swing.JRadioButton checkNombreCliente;
    private javax.swing.JRadioButton checkPago;
    private javax.swing.JRadioButton checkRemito;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCodigoCliente;
    private javax.swing.JLabel labelCodigoEmpleado;
    private javax.swing.JPanel panelCheque;
    private javax.swing.JPanel panelCredito;
    private javax.swing.JPanel panelDeposito;
    private javax.swing.JPanel panelEfectivo;
    private javax.swing.JPanel panelRemito;
    private javax.swing.JPanel panelTarjetaEfectivo;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtACuentaCredito;
    private javax.swing.JTextField txtBanderaRemito;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigoCliente1;
    private javax.swing.JTextField txtCodigoEmpleado1;
    private javax.swing.JTextField txtDescuentoEfectivo;
    private javax.swing.JTextField txtEfectivoTarjeta;
    private javax.swing.JLabel txtFacturaNumero1;
    private javax.swing.JTextField txtFechaDeposito;
    private javax.swing.JTextField txtFechaEmisionCheque;
    private javax.swing.JTextField txtFechaRemito;
    private javax.swing.JTextField txtFechaVencimientoCheque;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtMontoCheque;
    private javax.swing.JTextField txtMontoDeposito;
    private javax.swing.JTextField txtNombreApellidoCliente;
    private javax.swing.JTextField txtNombreApellidoEmpleado;
    private javax.swing.JTextField txtNroCheque;
    private javax.swing.JTextField txtNroCuentaDeposito;
    private javax.swing.JTextField txtNroDeposito;
    private javax.swing.JTextField txtNumeroRemito;
    private javax.swing.JTextField txtPago;
    public static javax.swing.JTextField txtRecibe;
    private javax.swing.JTextField txtSaldoRestanteCredito;
    private javax.swing.JTextField txtSaldoRestanteTarjetaEfectivo;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtSubtotalEfectivo;
    private javax.swing.JTextField txtTarjetaEfectivo;
    private javax.swing.JTextField txtTotalCredito;
    private javax.swing.JTextField txtTotalEfectivo;
    private javax.swing.JTextField txtTotalFactura;
    private javax.swing.JTextField txtTotalFactura2;
    private javax.swing.JTextField txtVueltoTarjetaEfectivo;
    // End of variables declaration//GEN-END:variables
}
