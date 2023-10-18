
package HerrBD;

import static java.lang.Class.forName;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;


public class CONEXION {
   
    private final String nombreBD="ventas3";
    private final String usuarioBD="root";
    private final String contrasenaBD="";
    private final String urlBD="jdbc:mysql://localhost:3306/"+ nombreBD;
    public Connection con=null;
    
     public Connection getConnection(){
        out.println(nombreBD+" "+usuarioBD+" "+contrasenaBD+" "+urlBD);
       
       try{
           
            forName("com.mysql.jdbc.Driver");
         con= (Connection) DriverManager.getConnection(this.urlBD,this.usuarioBD,this.contrasenaBD);
          
       }
       catch(SQLException se){  
            out.println("No se pudo realizar la conexion"+se.getMessage());
       
       }
       catch(ClassNotFoundException cnfe){
       
            getLogger(CONEXION.class.getName()).log(SEVERE, null, cnfe);
       }
       return con;
       
       
       }

    

}
