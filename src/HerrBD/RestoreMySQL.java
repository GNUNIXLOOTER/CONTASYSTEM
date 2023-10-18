package HerrBD;

import java.io.IOException;
import static java.lang.Runtime.getRuntime;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class RestoreMySQL {

    public static boolean restoreDB(String dbName, String dbUserName, String dbPassword, String source) {
        
        String[] comando = new String[]{"C:\\xampp\\mysql\\bin\\mysql.exe", "--user=" + dbUserName, "--password=" + dbPassword, dbName, "-e", " source " + source};
        Process runtimeProcess;
        try {
            runtimeProcess = getRuntime().exec(comando);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                out.println("Backup restored successfully");
                return true;
            } else {
                out.println("Could not restore the backup");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
