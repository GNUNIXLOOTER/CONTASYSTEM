
package HerrBD;

import static Notificaciones.DesktopNotify.INFORMATION;
import static Notificaciones.DesktopNotify.showDesktopMessage;
import alertas.SuccessAlerts;
import java.awt.Dimension;
import static java.awt.EventQueue.invokeLater;
import static java.awt.Toolkit.getDefaultToolkit;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;
import static necesario.RSAWTUtilities.setOpaque;

/**
 *
 * @author GNUNIXLOOTER
 */
public final class CargandoBackup extends javax.swing.JDialog {

    /**
     * Creates new form CargandoBackup
     * @param parent
     * @param modal
     */
    public CargandoBackup(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setOpaque(this, false);
        this.setLocationRelativeTo(null);
        this.progreso.setVisible(false);
        startThread();
        Dimension screenSize = getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progreso = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        progreso.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                progresoStateChanged(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HerrBD/carga.gif"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(128, 128, 131));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Creando respaldo de la base de datos.");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(128, 128, 131));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Espere un momento...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void progresoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_progresoStateChanged
        if (progreso.getValue() == 100) {
            this.dispose();
            SuccessAlerts success = new SuccessAlerts(new javax.swing.JFrame(), true);
            success.setVisible(true);
            //showDesktopMessage("Crear Respaldo...", "Se ha generado un nuevo respaldo de la base de datos.", INFORMATION, 8000);
        }
        
    }//GEN-LAST:event_progresoStateChanged

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
            for (javax.swing.UIManager.LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            getLogger(CargandoBackup.class.getName()).log(SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        invokeLater(() -> {
            CargandoBackup dialog = new CargandoBackup(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    exit(0);
                }

                private void exit(int i) {
                    exit(i); //To change body of generated methods, choose Tools | Templates.
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar progreso;
    // End of variables declaration//GEN-END:variables

    cargarBackup hilo;

    /**
     *
     * @return
     */
    public javax.swing.JProgressBar getProgreso() {
        return progreso;
    }

    /**
     * @param progreso
     */
    public void setProgreso(JProgressBar progreso) {
        this.progreso = progreso;
    }

    void startThread() {
        progreso.setVisible(false);
        hilo = new cargarBackup(getProgreso());
        hilo.start();
        hilo = null;
    }
    private static final Logger LOG = getLogger(CargandoBackup.class.getName());
}