
package Vistas;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Estadistica_Vendedores extends javax.swing.JDialog {
    int Select,bandera,totalArticulos;
    Double montoTotal;
    String fecha1,fecha2,diaG,mesG,añoG,fechaG,añoDesde,añoHasta, signo_moneda;
    Double total;

    public Estadistica_Vendedores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        //icono del sistema
        try{
            setIconImage(new ImageIcon(getClass().getResource("../img/iconoSistema64.png")).getImage());
         }catch(Exception e){
            
        }
        try{   
            Connection conn= conexion.ObtenerConexion(); // esta es la verificación de la conexión con mysql
            Statement consulta=conn.createStatement();
            ResultSet r2= consulta.executeQuery("SELECT signo_moneda FROM  monedas WHERE seleccion_moneda LIKE 'SELECCIONADA'");
            signo_moneda="$";
            while(r2.next()){
                signo_moneda=r2.getString(1);
            }
        }catch(Exception e){
            
        }
        
        setLocationRelativeTo(null);
        panelEsta.setVisible(false);
        panelDia.setVisible(false);
        panelMes.setVisible(false);
        botonAtras.setVisible(false);
        setearFecha();
    
        JTableHeader th2;
        th2 = tabla2.getTableHeader(); 
        Font fuente2 = new Font("Calibri", Font.BOLD, 20); 
        th2.setFont(fuente2); 
        th2.setBackground(new Color(93,116,163));
        th2.setForeground(new Color(255,255,255));
        
        tabla2.getColumnModel().getColumn(0).setMaxWidth(100);
        tabla2.getColumnModel().getColumn(0).setMinWidth(100);
        tabla2.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
        tabla2.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100); 
        
        tabla2.getColumnModel().getColumn(1).setMaxWidth(300);
        tabla2.getColumnModel().getColumn(1).setMinWidth(300);
        tabla2.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(300);
        tabla2.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(300);       
    }
    
    public void setearFecha() {      
        Calendar c2 = new GregorianCalendar();
        calendario1.setCalendar(c2);    
        calendario2.setCalendar(c2); 
    }
    
    public void cargarTablaRemitosYFacturas22(){
       try{
            Connection conn= conexion.ObtenerConexion(); // esta es la verificación de la conexión con mysql
            Statement consulta=conn.createStatement();

            totalArticulos=0;
            montoTotal=0.0;
            int i,j;
            i=0;
            j=0;
            DefaultTableModel modelo=(DefaultTableModel)tabla2.getModel();
            tabla2.setRowSorter(new TableRowSorter(modelo));
            modelo.setNumRows(0);
            ResultSet r2= consulta.executeQuery("SELECT empleado.nombres, empleado.apellidos, referencia_remito.Total FROM empleado, referencia_remito, remito where remito.fecha BETWEEN '"+fecha1+"' AND '"+fecha2+"' AND empleado.cod_empleado=remito.cod_empleado AND remito.cod_remito=referencia_remito.cod_remito AND remito.condicion='NO FACTURADO' GROUP by remito.cod_remito");
            while(r2.next()){          
                bandera=0;       
                for (int x=0;x<j;x++){ 
                    String Empleado=r2.getString(1)+" "+r2.getString(2);
                    if(Empleado.equals(tabla2.getValueAt(x,1).toString())){
                        Double contador= Double.parseDouble(tabla2.getValueAt(x,2).toString());    
                        String cad= r2.getString(3);
                        String numeroNuevo = cad.replace(",", "."); //----REMPLAZO LA COMA QUE VIENE DE LA BD POR UN PUNTO XQ SINO ME TIRA ERROR DE FORMATO   
                        contador=contador+ Double.parseDouble(numeroNuevo);
                        tabla2.setValueAt(contador,x,2);
                        bandera=1;
                    }
                }
                if(bandera==0){
                    modelo.addRow( new Object [] {null,null,null}); 
                
                    tabla2.setValueAt(r2.getString(1)+" "+r2.getString(2),i,1);
                    String cad= r2.getString(3);
                    String numeroNuevo = cad.replace(",", "."); //----REMPLAZO LA COMA QUE VIENE DE LA BD POR UN PUNTO XQ SINO ME TIRA ERROR DE FORMATO
                    Double numero=Double.parseDouble(numeroNuevo);
                    tabla2.setValueAt(numero,i,2);     
                    i++;
                    j++;
                }
            }
            r2.close();
            
            ResultSet r= consulta.executeQuery("SELECT empleado.nombres, empleado.apellidos, factura.total_con_iva FROM empleado, factura where factura.fecha BETWEEN '"+fecha1+"' AND '"+fecha2+"' AND empleado.cod_empleado=factura.cod_empleado GROUP by factura.cod_factura");
            while(r.next()){
                bandera=0; 
                for (int x=0;x<j;x++){ 
                    String Empleado=r.getString(1)+" "+r.getString(2);
                    if(Empleado.equals(tabla2.getValueAt(x,1).toString())){
                        Double contador= Double.parseDouble(tabla2.getValueAt(x,2).toString());  
                        String cad= r.getString(3);
                        String numeroNuevo = cad.replace(",", "."); //----REMPLAZO LA COMA QUE VIENE DE LA BD POR UN PUNTO XQ SINO ME TIRA ERROR DE FORMATO   
                        contador=contador+ Double.parseDouble(numeroNuevo);
                        tabla2.setValueAt(contador,x,2);
                        bandera=1;
                    }
                }
                if(bandera==0){
                    modelo.addRow( new Object [] {null,null,null}); 
                
                    tabla2.setValueAt(r.getString(1)+" "+r.getString(2),i,1);
                    String cad= r.getString(3);
                    String numeroNuevo = cad.replace(",", "."); //----REMPLAZO LA COMA QUE VIENE DE LA BD POR UN PUNTO XQ SINO ME TIRA ERROR DE FORMATO
                    Double numero=Double.parseDouble(numeroNuevo);
                    tabla2.setValueAt(numero,i,2);     
                    i++;
                    j++;
                }
            }
            r.close(); 
               
            tabla2.getRowSorter().toggleSortOrder(2);
            tabla2.getRowSorter().toggleSortOrder(2);
            for(int k=0; k<tabla2.getRowCount();k++){
                tabla2.setValueAt(k+1,k,0);
                montoTotal=montoTotal+Double.parseDouble(tabla2.getValueAt(k,2).toString());
            }
            txtTotal.setText(signo_moneda+" "+String.format("%.2f",montoTotal));
 
        } catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Esta carnet ya existe") ;
        }
    }
      
    public void cargarTablaRemitosYFacturasMes22(){
        try{
            Connection conn= conexion.ObtenerConexion(); // esta es la verificación de la conexión con mysql
            Statement consulta=conn.createStatement();
            totalArticulos=0;
            montoTotal=0.0;
            int i,j;
            i=0;
            j=0;
            DefaultTableModel modelo=(DefaultTableModel)tabla2.getModel();
            tabla2.setRowSorter(new TableRowSorter(modelo));
            modelo.setNumRows(0);
            ResultSet r2= consulta.executeQuery("SELECT empleado.nombres, empleado.apellidos, referencia_remito.Total FROM empleado, referencia_remito, remito where MONTH(remito.fecha) >='"+fecha1+"' and YEAR(remito.fecha) >='"+añoDesde+"' and MONTH(remito.fecha) <='"+fecha2+"' and YEAR(remito.fecha) <='"+añoHasta+"' AND empleado.cod_empleado=remito.cod_empleado AND remito.cod_remito=referencia_remito.cod_remito AND remito.condicion='NO FACTURADO' GROUP by remito.cod_remito");
            while(r2.next()){    
                bandera=0;         
                for (int x=0;x<j;x++){ 
                    String Empleado=r2.getString(1)+" "+r2.getString(2);
                    if(Empleado.equals(tabla2.getValueAt(x,1).toString())){
                        Double contador= Double.parseDouble(tabla2.getValueAt(x,2).toString());      
                        String cad= r2.getString(3);
                        String numeroNuevo = cad.replace(",", "."); //----REMPLAZO LA COMA QUE VIENE DE LA BD POR UN PUNTO XQ SINO ME TIRA ERROR DE FORMATO  
                        contador=contador+ Double.parseDouble(numeroNuevo);
                        tabla2.setValueAt(contador,x,2);
                        bandera=1;
                    }
                }
                if(bandera==0){
                    modelo.addRow( new Object [] {null,null,null}); 
                
                    tabla2.setValueAt(r2.getString(1)+" "+r2.getString(2),i,1);
                    String cad= r2.getString(3);
                    String numeroNuevo = cad.replace(",", "."); //----REMPLAZO LA COMA QUE VIENE DE LA BD POR UN PUNTO XQ SINO ME TIRA ERROR DE FORMATO
                    Double numero=Double.parseDouble(numeroNuevo);
                    tabla2.setValueAt(numero,i,2);     
                    i++;
                    j++;
                }
            }
            r2.close();
            
            ResultSet r= consulta.executeQuery("SELECT empleado.nombres, empleado.apellidos, factura.total_con_iva FROM empleado, referencia_factura, factura where MONTH(factura.fecha) >='"+fecha1+"'  and YEAR(factura.fecha) >='"+añoDesde+"' AND MONTH(factura.fecha) <='"+fecha2+"'  and YEAR(factura.fecha) <='"+añoHasta+"' AND empleado.cod_empleado=factura.cod_empleado GROUP by factura.cod_factura");
            while(r.next()){   
                bandera=0;
                for (int x=0;x<j;x++){ 
                    String Empleado=r.getString(1)+" "+r.getString(2);
                    if(Empleado.equals(tabla2.getValueAt(x,1).toString())){
                        Double contador= Double.parseDouble(tabla2.getValueAt(x,2).toString());  
                        String cad= r.getString(3);
                        String numeroNuevo = cad.replace(",", "."); //----REMPLAZO LA COMA QUE VIENE DE LA BD POR UN PUNTO XQ SINO ME TIRA ERROR DE FORMATO  
                        contador=contador+ Double.parseDouble(numeroNuevo);
                        tabla2.setValueAt(contador,x,2);
                        bandera=1;
                    }
                }
                if(bandera==0){
                    modelo.addRow( new Object [] {null,null,null});                
                    tabla2.setValueAt(r.getString(1)+" "+r.getString(2),i,1);
                    String cad= r.getString(3);
                    String numeroNuevo = cad.replace(",", "."); //----REMPLAZO LA COMA QUE VIENE DE LA BD POR UN PUNTO XQ SINO ME TIRA ERROR DE FORMATO
                    Double numero=Double.parseDouble(numeroNuevo);
                    tabla2.setValueAt(numero,i,2);     
                    i++;
                    j++;
                }
            }
            r.close(); 
               
            tabla2.getRowSorter().toggleSortOrder(2);
            tabla2.getRowSorter().toggleSortOrder(2);
            for(int k=0; k<tabla2.getRowCount();k++){
                tabla2.setValueAt(k+1,k,0);
                montoTotal=montoTotal+Double.parseDouble(tabla2.getValueAt(k,2).toString());
            }
            txtTotal.setText(signo_moneda+" "+String.format("%.2f",montoTotal));         
        } catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Esta carnet ya existe") ;
        }
    }
     
    public void cargarTablaRemitos22(){
        try{
            Connection conn= conexion.ObtenerConexion(); // esta es la verificación de la conexión con mysql
            Statement consulta=conn.createStatement();
            totalArticulos=0;
            montoTotal=0.0;
            int i,j;
            i=0;
            j=0;
            DefaultTableModel modelo=(DefaultTableModel)tabla2.getModel();
            tabla2.setRowSorter(new TableRowSorter(modelo));
            modelo.setNumRows(0);
            ResultSet r2= consulta.executeQuery("SELECT empleado.nombres, empleado.apellidos, referencia_remito.Total FROM empleado, referencia_remito, remito where remito.fecha BETWEEN '"+fecha1+"' AND '"+fecha2+"' AND empleado.cod_empleado=remito.cod_empleado AND remito.cod_remito=referencia_remito.cod_remito AND remito.condicion='NO FACTURADO' GROUP by remito.cod_remito");
            while(r2.next()){    
                bandera=0;   
                for (int x=0;x<j;x++){ 
                    String Empleado=r2.getString(1)+" "+r2.getString(2);
                    if(Empleado.equals(tabla2.getValueAt(x,1).toString())){
                        Double contador= Double.parseDouble(tabla2.getValueAt(x,2).toString());     
                        String cad= r2.getString(3);
                        String numeroNuevo = cad.replace(",", "."); //----REMPLAZO LA COMA QUE VIENE DE LA BD POR UN PUNTO XQ SINO ME TIRA ERROR DE FORMATO     
                        contador=contador+ Double.parseDouble(numeroNuevo);
                        tabla2.setValueAt(contador,x,2);
                        bandera=1;
                    }
                }
                if(bandera==0){
                    modelo.addRow( new Object [] {null,null,null});               
                    tabla2.setValueAt(r2.getString(1)+" "+r2.getString(2),i,1);
                    String cad= r2.getString(3);
                    String numeroNuevo = cad.replace(",", "."); //----REMPLAZO LA COMA QUE VIENE DE LA BD POR UN PUNTO XQ SINO ME TIRA ERROR DE FORMATO
                    Double numero=Double.parseDouble(numeroNuevo);
                    tabla2.setValueAt(numero,i,2);     
                    i++;
                    j++;
                }
            }
            r2.close();
            
            tabla2.getRowSorter().toggleSortOrder(2);
            tabla2.getRowSorter().toggleSortOrder(2);
            for(int k=0; k<tabla2.getRowCount();k++){
                tabla2.setValueAt(k+1,k,0);
                montoTotal=montoTotal+Double.parseDouble(tabla2.getValueAt(k,2).toString());
            }
            txtTotal.setText(signo_moneda+" "+String.format("%.2f",montoTotal));
        } catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Esta carnet ya existe") ;
        }
    }
     
    public void cargarTablaRemitosMes22(){
         try{
            Connection conn= conexion.ObtenerConexion(); // esta es la verificación de la conexión con mysql
            Statement consulta=conn.createStatement();
            totalArticulos=0;
            montoTotal=0.0;
            int i,j;
            i=0;
            j=0;
            DefaultTableModel modelo=(DefaultTableModel)tabla2.getModel();
            tabla2.setRowSorter(new TableRowSorter(modelo));
            modelo.setNumRows(0);
            ResultSet r2= consulta.executeQuery("SELECT empleado.nombres, empleado.apellidos, referencia_remito.Total FROM empleado, referencia_remito, remito where MONTH(remito.fecha) >='"+fecha1+"' and YEAR(remito.fecha) >='"+añoDesde+"' and MONTH(remito.fecha) <='"+fecha2+"' and YEAR(remito.fecha) <='"+añoHasta+"' AND empleado.cod_empleado=remito.cod_empleado AND remito.cod_remito=referencia_remito.cod_remito AND remito.condicion='NO FACTURADO' GROUP by remito.cod_remito");
            while(r2.next()){      
                bandera=0; 
                for (int x=0;x<j;x++){ 
                    String Empleado=r2.getString(1)+" "+r2.getString(2);
                    if(Empleado.equals(tabla2.getValueAt(x,1).toString())){
                        Double contador= Double.parseDouble(tabla2.getValueAt(x,2).toString());   
                        String cad= r2.getString(3);
                        String numeroNuevo = cad.replace(",", "."); //----REMPLAZO LA COMA QUE VIENE DE LA BD POR UN PUNTO XQ SINO ME TIRA ERROR DE FORMATO 
                        contador=contador+ Double.parseDouble(numeroNuevo);
                        tabla2.setValueAt(contador,x,2);
                        bandera=1;
                    }
                }
                if(bandera==0){
                    modelo.addRow( new Object [] {null,null,null}); 
                    tabla2.setValueAt(r2.getString(1)+" "+r2.getString(2),i,1);
                    String cad= r2.getString(3);
                    String numeroNuevo = cad.replace(",", "."); //----REMPLAZO LA COMA QUE VIENE DE LA BD POR UN PUNTO XQ SINO ME TIRA ERROR DE FORMATO
                    Double numero=Double.parseDouble(numeroNuevo);
                    tabla2.setValueAt(numero,i,2);     
                    i++;
                    j++;
                }
            }
            r2.close();
            
            tabla2.getRowSorter().toggleSortOrder(2);
            tabla2.getRowSorter().toggleSortOrder(2);
            for(int k=0; k<tabla2.getRowCount();k++){
                tabla2.setValueAt(k+1,k,0);
                montoTotal=montoTotal+Double.parseDouble(tabla2.getValueAt(k,2).toString());
            }
            txtTotal.setText(signo_moneda+" "+String.format("%.2f",montoTotal));
       
        } catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Esta carnet ya existe") ;
        }
    }
      
    public void cargarTablaFacturas22(){
         try{
            Connection conn= conexion.ObtenerConexion(); // esta es la verificación de la conexión con mysql
            Statement consulta=conn.createStatement();
            totalArticulos=0;
            montoTotal=0.0;
            int i,j;
            i=0;
            j=0;
            DefaultTableModel modelo=(DefaultTableModel)tabla2.getModel();
            tabla2.setRowSorter(new TableRowSorter(modelo));
            modelo.setNumRows(0);
            ResultSet r2= consulta.executeQuery("SELECT empleado.nombres, empleado.apellidos, factura.total_con_iva FROM empleado, factura where factura.fecha BETWEEN '"+fecha1+"' AND '"+fecha2+"' AND empleado.cod_empleado=factura.cod_empleado GROUP by factura.cod_factura");
            while(r2.next()){             
                bandera=0;  
                for (int x=0;x<j;x++){ 
                    String Empleado=r2.getString(1)+" "+r2.getString(2);
                    if(Empleado.equals(tabla2.getValueAt(x,1).toString())){
                        Double contador= Double.parseDouble(tabla2.getValueAt(x,2).toString());  
                        String cad= r2.getString(3);
                        String numeroNuevo = cad.replace(",", "."); //----REMPLAZO LA COMA QUE VIENE DE LA BD POR UN PUNTO XQ SINO ME TIRA ERROR DE FORMATO 
                        contador=contador+ Double.parseDouble(numeroNuevo);
                        tabla2.setValueAt(contador,x,2);
                        bandera=1;
                    }
                }
                if(bandera==0){
                    modelo.addRow( new Object [] {null,null,null});               
                    tabla2.setValueAt(r2.getString(1)+" "+r2.getString(2),i,1);
                    String cad= r2.getString(3);
                    String numeroNuevo = cad.replace(",", "."); //----REMPLAZO LA COMA QUE VIENE DE LA BD POR UN PUNTO XQ SINO ME TIRA ERROR DE FORMATO
                    Double numero=Double.parseDouble(numeroNuevo);
                    tabla2.setValueAt(numero,i,2);     
                    i++;
                    j++;
                }
            }
            r2.close();
            
            tabla2.getRowSorter().toggleSortOrder(2);
            tabla2.getRowSorter().toggleSortOrder(2);
            for(int k=0; k<tabla2.getRowCount();k++){
                tabla2.setValueAt(k+1,k,0);
                montoTotal=montoTotal+Double.parseDouble(tabla2.getValueAt(k,2).toString());
            }
            txtTotal.setText(signo_moneda+" "+String.format("%.2f",montoTotal));
        
        } catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Esta carnet ya existe") ;
        }
    }
    
    
    public void cargarTablaFacturasMes22(){
        try{
            Connection conn= conexion.ObtenerConexion(); // esta es la verificación de la conexión con mysql
            Statement consulta=conn.createStatement();
            totalArticulos=0;
            montoTotal=0.0;
            int i,j;
            i=0;
            j=0;
            DefaultTableModel modelo=(DefaultTableModel)tabla2.getModel();
            tabla2.setRowSorter(new TableRowSorter(modelo));
            modelo.setNumRows(0);
            ResultSet r2= consulta.executeQuery("SELECT empleado.nombres, empleado.apellidos, factura.total_con_iva FROM empleado, factura where MONTH(factura.fecha) >='"+fecha1+"'  and YEAR(factura.fecha) >='"+añoDesde+"' AND MONTH(factura.fecha) <='"+fecha2+"'  and YEAR(factura.fecha) <='"+añoHasta+"' AND empleado.cod_empleado=factura.cod_empleado GROUP by factura.cod_factura");
            while(r2.next()){         
                bandera=0;   
                for (int x=0;x<j;x++){ 
                    String Empleado=r2.getString(1)+" "+r2.getString(2);
                    if(Empleado.equals(tabla2.getValueAt(x,1).toString())){
                        Double contador= Double.parseDouble(tabla2.getValueAt(x,2).toString());       
                        String cad= r2.getString(3);
                        String numeroNuevo = cad.replace(",", "."); //----REMPLAZO LA COMA QUE VIENE DE LA BD POR UN PUNTO XQ SINO ME TIRA ERROR DE FORMATO   
                        contador=contador+ Double.parseDouble(numeroNuevo);
                        tabla2.setValueAt(contador,x,2);
                        bandera=1;
                    }
                }
                if(bandera==0){
                    modelo.addRow( new Object [] {null,null,null}); 
                    tabla2.setValueAt(r2.getString(1)+" "+r2.getString(2),i,1);
                    String cad= r2.getString(3);
                    String numeroNuevo = cad.replace(",", "."); //----REMPLAZO LA COMA QUE VIENE DE LA BD POR UN PUNTO XQ SINO ME TIRA ERROR DE FORMATO
                    Double numero=Double.parseDouble(numeroNuevo);
                    tabla2.setValueAt(numero,i,2);     
                    i++;
                    j++;
                }
            }
            r2.close();
            
            tabla2.getRowSorter().toggleSortOrder(2);
            tabla2.getRowSorter().toggleSortOrder(2);
            for(int k=0; k<tabla2.getRowCount();k++){
                tabla2.setValueAt(k+1,k,0);
                montoTotal=montoTotal+Double.parseDouble(tabla2.getValueAt(k,2).toString());
            }
            txtTotal.setText(signo_moneda+" "+String.format("%.2f",montoTotal));    
        } catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Esta carnet ya existe") ;
        }
    }

    public void obtenerFechas(){
        int año = calendario1.getCalendar().get(Calendar.YEAR);
        int mes = calendario1.getCalendar().get(Calendar.MONTH);
        int dia = calendario1.getCalendar().get(Calendar.DAY_OF_MONTH);

        if((mes+1)<10 && (dia>=10)){
            fecha1 = (año+"/0"+(mes+1)+"/"+dia);
        }else{
            if(((mes+1)<10 && (dia<10))){
                fecha1 = (año+"/0"+(mes+1)+"/0"+dia);
            }else{
                fecha1= (año+"/"+(mes+1)+"/"+dia);
            }
        }
        
        int año2 = calendario2.getCalendar().get(Calendar.YEAR);
        int mes2 = calendario2.getCalendar().get(Calendar.MONTH);
        int dia2 = calendario2.getCalendar().get(Calendar.DAY_OF_MONTH);

        if((mes2+1)<10 && (dia2>=10)){
            fecha2 = (año2+"/0"+(mes2+1)+"/"+dia2);
        }else{
            if(((mes2+1)<10 && (dia2<10))){
                fecha2 = (año2+"/0"+(mes2+1)+"/0"+dia2);
            }else{
                fecha2= (año2+"/"+(mes2+1)+"/"+dia2);
            }
        }
    }
    
    public void obtenerFechaMes(){      
        int mes = calendarioMes.getMonth()+1;
        int añoDesde1= calendarioAñoDesde.getYear();
        añoDesde=String.valueOf(añoDesde1);
        
        if(mes<10){
            fecha1=("0"+mes);
        }else{
           fecha1=(""+mes);
        }
        int mes2 = calendarioMes1.getMonth()+1;
        int añoHasta1= calendarioAñoDesde.getYear();
        añoHasta=String.valueOf(añoHasta1);
        if(mes2<10){
            fecha2=("0"+mes2);
        }else{
           fecha2=(""+mes2);
        }     
     }
    
    public void graficarDias(){
        DefaultCategoryDataset dtsc=new DefaultCategoryDataset();
        int i=0;
        while (i<tabla2.getRowCount()){
            dtsc.setValue(Integer.parseInt(tabla2.getValueAt(i,2).toString()),tabla2.getValueAt(i,0).toString(),tabla2.getValueAt(i,1).toString() );
            i++;
        }
        JFreeChart ch =ChartFactory.createBarChart("GRÁFICA DE VENTAS POR DÍA", "DÍAS", "MONTO", dtsc, PlotOrientation.HORIZONTAL, true, true, false);
        ChartPanel cp= new ChartPanel(ch);
        panelEstadistica.add(cp);
        cp.setBounds(0,0,550,400);
    }
    
    public void graficarArticulos(){
        DefaultPieDataset dtsc=new DefaultPieDataset();  
        int i=0;
        while (i<tabla2.getRowCount() && i<5){
            dtsc.setValue(tabla2.getValueAt(i,1).toString(),Double.parseDouble(tabla2.getValueAt(i,2).toString()));
            i++;
        }
        JFreeChart ch =ChartFactory.createPieChart("MEJORES VENDEDORES", dtsc,true, true, false);
        ChartPanel cp= new ChartPanel(ch);
        panelEstadistica.add(cp);
        cp.setBounds(0,0,550,400);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FiltrarResultados = new javax.swing.ButtonGroup();
        grupoEstadisticas = new javax.swing.ButtonGroup();
        dialogoMenu = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelEstadistica = new javax.swing.JPanel();
        panelTope = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        botonAtras1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        panelEsta = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelMes = new javax.swing.JPanel();
        remitosPorMes = new javax.swing.JRadioButton();
        facturasPorMes = new javax.swing.JRadioButton();
        remitosYFacturasPorMes = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        calendarioMes = new com.toedter.calendar.JMonthChooser();
        jLabel1 = new javax.swing.JLabel();
        calendarioMes1 = new com.toedter.calendar.JMonthChooser();
        btnConsulta1 = new javax.swing.JButton();
        calendarioAñoDesde = new com.toedter.calendar.JYearChooser();
        calendarioAñoHasta = new com.toedter.calendar.JYearChooser();
        panelDia = new javax.swing.JPanel();
        soloRemitos = new javax.swing.JRadioButton();
        soloFacturas = new javax.swing.JRadioButton();
        remitosYFacturas = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        calendario2 = new com.toedter.calendar.JDateChooser();
        calendario1 = new com.toedter.calendar.JDateChooser();
        btnConsulta2 = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        dialogoMenu.setBackground(new java.awt.Color(255, 255, 255));
        dialogoMenu.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 35)); // NOI18N
        jLabel8.setText("Ventas Por Dia");
        dialogoMenu.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 420, 240, 30));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonEstadisticaXLHover.png"))); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusPainted(false);
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonEstadisticaXL.png"))); // NOI18N
        jButton7.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonEstadisticaXL.png"))); // NOI18N
        jButton7.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonEstadisticaXL.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        dialogoMenu.getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, -1, -1));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonEstadisticaXLHover.png"))); // NOI18N
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setFocusPainted(false);
        jButton9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonEstadisticaXL.png"))); // NOI18N
        jButton9.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonEstadisticaXL.png"))); // NOI18N
        jButton9.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonEstadisticaXL.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        dialogoMenu.getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, -1, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 35)); // NOI18N
        jLabel9.setText("Ventas Por Mes");
        dialogoMenu.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 240, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoBlanco-01.png"))); // NOI18N
        dialogoMenu.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, 3235, 1880));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ESTADÍSTICAS");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelEstadistica.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelEstadisticaLayout = new javax.swing.GroupLayout(panelEstadistica);
        panelEstadistica.setLayout(panelEstadisticaLayout);
        panelEstadisticaLayout.setHorizontalGroup(
            panelEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        panelEstadisticaLayout.setVerticalGroup(
            panelEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        jPanel1.add(panelEstadistica, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 570, 420));

        panelTope.setBackground(new java.awt.Color(78, 184, 221));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoRanking.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ranking por Día");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonRankChico.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonRankChicoHover.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonRankChicoHover.png"))); // NOI18N
        jButton2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonRankChicoHover.png"))); // NOI18N
        jButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonRankChicoHover.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 33)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("RANKING DE VENDEDORES");

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ranking por Mes");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonRankChico.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonRankChicoHover.png"))); // NOI18N
        jButton3.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonRankChicoHover.png"))); // NOI18N
        jButton3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonRankChicoHover.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        botonAtras1.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        botonAtras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonAtras.png"))); // NOI18N
        botonAtras1.setBorder(null);
        botonAtras1.setBorderPainted(false);
        botonAtras1.setContentAreaFilled(false);
        botonAtras1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAtras1.setFocusPainted(false);
        botonAtras1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonAtrasHover.png"))); // NOI18N
        botonAtras1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonAtrasHover.png"))); // NOI18N
        botonAtras1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonAtrasHover.png"))); // NOI18N
        botonAtras1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonAtrasHover.png"))); // NOI18N
        botonAtras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtras1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ir al Menú");

        javax.swing.GroupLayout panelTopeLayout = new javax.swing.GroupLayout(panelTope);
        panelTope.setLayout(panelTopeLayout);
        panelTopeLayout.setHorizontalGroup(
            panelTopeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopeLayout.createSequentialGroup()
                .addGroup(panelTopeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTopeLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(panelTopeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelTopeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelTopeLayout.createSequentialGroup()
                                .addComponent(botonAtras1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelTopeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelTopeLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel11))
                    .addGroup(panelTopeLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel3)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        panelTopeLayout.setVerticalGroup(
            panelTopeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTopeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(panelTopeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTopeLayout.createSequentialGroup()
                        .addComponent(botonAtras1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTopeLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(58, 58, 58))))
        );

        jPanel1.add(panelTope, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 740));

        panelEsta.setBackground(new java.awt.Color(255, 255, 255));
        panelEsta.setLayout(null);

        tabla2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "POSICION", "VENDEDOR", "MONTO VENDIDO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla2.setRowHeight(25);
        tabla2.setRowMargin(4);
        jScrollPane2.setViewportView(tabla2);
        if (tabla2.getColumnModel().getColumnCount() > 0) {
            tabla2.getColumnModel().getColumn(1).setResizable(false);
        }

        panelEsta.add(jScrollPane2);
        jScrollPane2.setBounds(10, 10, 570, 160);

        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelEsta.add(txtTotal);
        txtTotal.setBounds(320, 180, 250, 50);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel7.setText("Total Vendido");
        panelEsta.add(jLabel7);
        jLabel7.setBounds(160, 190, 150, 30);

        jPanel1.add(panelEsta, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, 590, 260));

        jPanel2.setBackground(new java.awt.Color(78, 184, 221));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMes.setBackground(new java.awt.Color(255, 255, 255));
        panelMes.setOpaque(false);
        panelMes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grupoEstadisticas.add(remitosPorMes);
        remitosPorMes.setFont(new java.awt.Font("Calibri", 1, 21)); // NOI18N
        remitosPorMes.setText("Solo Remitos");
        remitosPorMes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        remitosPorMes.setOpaque(false);
        panelMes.add(remitosPorMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        grupoEstadisticas.add(facturasPorMes);
        facturasPorMes.setFont(new java.awt.Font("Calibri", 1, 21)); // NOI18N
        facturasPorMes.setText("Solo Facturas");
        facturasPorMes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        facturasPorMes.setOpaque(false);
        panelMes.add(facturasPorMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        grupoEstadisticas.add(remitosYFacturasPorMes);
        remitosYFacturasPorMes.setFont(new java.awt.Font("Calibri", 1, 21)); // NOI18N
        remitosYFacturasPorMes.setText("Remitos y Facturas ");
        remitosYFacturasPorMes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        remitosYFacturasPorMes.setOpaque(false);
        panelMes.add(remitosYFacturasPorMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel4.setText("Desde");
        panelMes.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 70, 40));

        calendarioMes.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        panelMes.add(calendarioMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, 40));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel1.setText("Hasta");
        panelMes.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 67, 60, 40));

        calendarioMes1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        panelMes.add(calendarioMes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 195, 40));

        btnConsulta1.setBackground(new java.awt.Color(5, 52, 99));
        btnConsulta1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btnConsulta1.setForeground(new java.awt.Color(255, 255, 255));
        btnConsulta1.setText("Mostrar Gráfica");
        btnConsulta1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsulta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsulta1ActionPerformed(evt);
            }
        });
        panelMes.add(btnConsulta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 278, 61));
        panelMes.add(calendarioAñoDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 130, 34));
        panelMes.add(calendarioAñoHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 130, 36));

        jPanel2.add(panelMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 401, 480, -1));

        panelDia.setBackground(new java.awt.Color(255, 255, 255));
        panelDia.setOpaque(false);
        panelDia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grupoEstadisticas.add(soloRemitos);
        soloRemitos.setFont(new java.awt.Font("Calibri", 1, 21)); // NOI18N
        soloRemitos.setText("Solo Remitos");
        soloRemitos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        soloRemitos.setOpaque(false);
        soloRemitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soloRemitosActionPerformed(evt);
            }
        });
        panelDia.add(soloRemitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        grupoEstadisticas.add(soloFacturas);
        soloFacturas.setFont(new java.awt.Font("Calibri", 1, 21)); // NOI18N
        soloFacturas.setText("Solo Facturas");
        soloFacturas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        soloFacturas.setOpaque(false);
        panelDia.add(soloFacturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        grupoEstadisticas.add(remitosYFacturas);
        remitosYFacturas.setFont(new java.awt.Font("Calibri", 1, 21)); // NOI18N
        remitosYFacturas.setText("Remitos y Facturas");
        remitosYFacturas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        remitosYFacturas.setOpaque(false);
        panelDia.add(remitosYFacturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel6.setText("Hasta");
        panelDia.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 70, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel5.setText("Desde");
        panelDia.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, -1));

        calendario2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        panelDia.add(calendario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 150, 44));

        calendario1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        panelDia.add(calendario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 150, 44));

        btnConsulta2.setBackground(new java.awt.Color(5, 52, 99));
        btnConsulta2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btnConsulta2.setForeground(new java.awt.Color(255, 255, 255));
        btnConsulta2.setText("Mostrar Gráfica");
        btnConsulta2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsulta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsulta2ActionPerformed(evt);
            }
        });
        panelDia.add(btnConsulta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 278, 61));

        jPanel2.add(panelDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 188, 490, -1));

        botonAtras.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        botonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonAtras.png"))); // NOI18N
        botonAtras.setBorder(null);
        botonAtras.setBorderPainted(false);
        botonAtras.setContentAreaFilled(false);
        botonAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAtras.setFocusPainted(false);
        botonAtras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonAtrasHover.png"))); // NOI18N
        botonAtras.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonAtrasHover.png"))); // NOI18N
        botonAtras.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonAtrasHover.png"))); // NOI18N
        botonAtras.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonAtrasHover.png"))); // NOI18N
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });
        jPanel2.add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 90, 90));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel12.setText("Ir hacia atrás");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 520, 750));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    private void soloRemitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soloRemitosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soloRemitosActionPerformed

    private void btnConsulta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsulta1ActionPerformed
        panelEsta.setVisible(true); 
        obtenerFechaMes();
        if(remitosPorMes.isSelected()){
            cargarTablaRemitosMes22();
        }else{
            if(facturasPorMes.isSelected()){
                cargarTablaFacturasMes22();
            }else{
                if(remitosYFacturasPorMes.isSelected()){
                    cargarTablaRemitosYFacturasMes22();
          
                }
            }
        }
        graficarArticulos();
    }//GEN-LAST:event_btnConsulta1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        dialogoMenu.setVisible(false);
        panelMes.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        dialogoMenu.setVisible(false);
        panelMes.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnConsulta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsulta2ActionPerformed
        panelEsta.setVisible(true);        
        if(soloRemitos.isSelected()){
            obtenerFechas();
            cargarTablaRemitos22();
            graficarArticulos();
        }else{
            if(soloFacturas.isSelected()){
                obtenerFechas();
                cargarTablaFacturas22();
                graficarArticulos();
            }else{
                if(remitosYFacturas.isSelected()){
                    obtenerFechas();
                    cargarTablaRemitosYFacturas22();
                    graficarArticulos();
                }
            }
        }
    }//GEN-LAST:event_btnConsulta2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       panelTope.setVisible(false);
       panelDia.setVisible(true);
       soloFacturas.setSelected(true);
       botonAtras.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       panelTope.setVisible(false);
       panelMes.setVisible(true);
       facturasPorMes.setSelected(true);
       botonAtras.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        panelTope.setVisible(true);
        panelDia.setVisible(false);
        panelMes.setVisible(false);
        botonAtras.setVisible(false);
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonAtras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtras1ActionPerformed
     this.dispose();
    }//GEN-LAST:event_botonAtras1ActionPerformed

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
            java.util.logging.Logger.getLogger(Estadistica_Vendedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estadistica_Vendedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estadistica_Vendedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estadistica_Vendedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Estadistica_Vendedores dialog = new Estadistica_Vendedores(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup FiltrarResultados;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonAtras1;
    private javax.swing.JButton btnConsulta1;
    private javax.swing.JButton btnConsulta2;
    private com.toedter.calendar.JDateChooser calendario1;
    private com.toedter.calendar.JDateChooser calendario2;
    private com.toedter.calendar.JYearChooser calendarioAñoDesde;
    private com.toedter.calendar.JYearChooser calendarioAñoHasta;
    private com.toedter.calendar.JMonthChooser calendarioMes;
    private com.toedter.calendar.JMonthChooser calendarioMes1;
    private javax.swing.JDialog dialogoMenu;
    private javax.swing.JRadioButton facturasPorMes;
    private javax.swing.ButtonGroup grupoEstadisticas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelDia;
    private javax.swing.JPanel panelEsta;
    private javax.swing.JPanel panelEstadistica;
    private javax.swing.JPanel panelMes;
    private javax.swing.JPanel panelTope;
    private javax.swing.JRadioButton remitosPorMes;
    private javax.swing.JRadioButton remitosYFacturas;
    private javax.swing.JRadioButton remitosYFacturasPorMes;
    private javax.swing.JRadioButton soloFacturas;
    private javax.swing.JRadioButton soloRemitos;
    private javax.swing.JTable tabla2;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
