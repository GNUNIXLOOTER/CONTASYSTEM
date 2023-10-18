package Vistas;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Actualizacion_Aplicacion {

    //Metodo para verificar la conexion a internet
    public static boolean verificarConexion() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/GNUNIXLOOTER/CONTSYS/main/Version.txt?token=GHSAT0AAAAAABUHNJCHZS7TNRLV7QE3F73WYTTE2NQ");
            URLConnection con = url.openConnection();
            con.connect();
            return true;
        } catch (MalformedURLException ex) {
            Logger.getLogger(Actualizacion_Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Actualizacion_Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Metodo para obtener el contenido del archivo
    public static String ObtenerVersion() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/GNUNIXLOOTER/CONTSYS/main/Version.txt?token=GHSAT0AAAAAABUHNJCHZS7TNRLV7QE3F73WYTTE2NQ");
            URLConnection con = url.openConnection();
            con.connect();
            return ObtenerContenidoURL(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Actualizacion_Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Actualizacion_Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    
    public static String ObtenerContenidoURL(URL url) {
        try {
            Scanner s = new Scanner(url.openStream()).useDelimiter("\\Z");
            String contenido = s.next();
            return contenido;
        } catch (IOException ex) {
            Logger.getLogger(Actualizacion_Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    
    public static void abrirEnlace(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(Actualizacion_Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
