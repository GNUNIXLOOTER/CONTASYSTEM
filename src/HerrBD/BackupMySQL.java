package HerrBD;


import Vistas.Principal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Runtime.getRuntime;
import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.GregorianCalendar;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.ImageIcon;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;


/**
 *
 * @author GNUNIXLOOTER
 */
public class BackupMySQL {
    private static final Logger LOG = getLogger(BackupMySQL.class.getName());


    int BUFFER = 10485760;
    private String obtenerFecha() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(YEAR);
        int mes = fecha.get(MONTH);
        int dia = fecha.get(DAY_OF_MONTH);
        String Fehca = dia + "-" + (mes + 1) + "-" + año;
        return Fehca;
    }

    /**
     *
     * @param nombreDB
     */
    public void exportDB(String nombreDB) {
       
        //nombre de usuario de la base de datos
        String mysqluser = "root";
        //password del usuario
        String mysqlpassword = "";
        //nombre de la base de datos
        String mysqldb = "ventas3";
        //ruta donde se guardará el backup
        String path = "C:\\Respaldos/" + nombreDB + "_" + obtenerFecha() + ".sql";
        File existe = new File(path);
        if (existe.exists()) {
            if (showConfirmDialog(new Principal(), "Ya existe un respaldo con ese nombre\n¿Desea reemplazarlo?", "Restaurar respaldo!!!", YES_NO_OPTION, 0,
                    new ImageIcon(getClass().getResource("/img/pregunta.png"))) == YES_OPTION) {
                RealizaBackup(path, mysqluser, mysqlpassword, mysqldb);
            }
        } else {
            RealizaBackup(path, mysqluser, mysqlpassword, mysqldb);
        }
    }

    /**
     *
     * @param path
     * @param mysqluser
     * @param mysqlpassword
     * @param mysqldb
     */
    public void RealizaBackup(String path, String mysqluser, String mysqlpassword, String mysqldb) {
        new CargandoBackup(null, true).setVisible(true);
        //String dumpCommand = "mysqldump.exe --hex-blob -u" + mysqluser + " -p" + mysqlpassword + " --skip-comments --skip-triggers " + mysqldb;
        String dumpCommand = "C://xampp//mysql//bin//mysqldump -u"+mysqluser+" "+mysqlpassword+" --skip-comments --skip-triggers "+mysqldb;
        FileWriter fw = null;
        try {
            Runtime runtime = getRuntime();
            File backupFile = new File(path);
            fw = new FileWriter(backupFile);
            Process child = runtime.exec(dumpCommand);
            BufferedReader br;
            try (InputStreamReader irs = new InputStreamReader(child.getInputStream())) {
                br = new BufferedReader(irs);
                String line;
                while ((line = br.readLine()) != null) {
                    fw.write(line + "\n");
                }   fw.close();
            }
            br.close();
        } catch (IOException ex) {
            getLogger(BackupMySQL.class.getName()).log(SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                getLogger(BackupMySQL.class.getName()).log(SEVERE, null, ex);
            }
        }
    }
}
