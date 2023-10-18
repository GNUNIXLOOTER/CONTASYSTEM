/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HerrBD;

import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.JProgressBar;

/**
 *
 * @author GNUNIXLOOTER
 */
public class cargarRestore extends Thread{

    private static final Logger LOG = getLogger(cargarRestore.class.getName());
    JProgressBar progreso;

    /**
     *
     * @param progreso
     */
    public cargarRestore(JProgressBar progreso){
        super();
        this.progreso=progreso;
    }

    /**
     *
     */
    @Override
    public void run(){
        for(int i=1;i<=100;i++){
            progreso.setValue(i);
            pausa(150);
        }
    }

    /**
     *
     * @param mlSeg
     */
    public void pausa(int mlSeg){
        try{
            sleep(mlSeg);
        }
        catch(Exception e){
            
        }
    }
}
