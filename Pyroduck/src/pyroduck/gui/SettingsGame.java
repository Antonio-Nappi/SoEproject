package pyroduck.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author 
 */
public class SettingsGame extends javax.swing.JFrame {

    private static boolean music = true;

    
    private static int lives=3;
    /**
     * Creates new form SettingsGame
     */
    public SettingsGame() {
        initComponents();
        jLabel1.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\SelectCharacter\\exit_32.png"));
         if (music == true)
                       musicCheckBox.setSelected(true);
                   else
                       musicCheckBox.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        musicCheckBox = new javax.swing.JCheckBox();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        viewScore = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel2.setText("Lives number:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 100, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel4.setText("Music:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 100, 30));

        musicCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musicCheckBoxActionPerformed(evt);
            }
        });
        jPanel1.add(musicCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 30, 30));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        jSpinner1.setRequestFocusEnabled(false);
        jSpinner1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSpinner1MouseClicked(evt);
            }
        });
        jPanel1.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 40, 30));

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, 30));

        viewScore.setText("Scores");
        jPanel1.add(viewScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 80, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSpinner1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinner1MouseClicked
    // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner1MouseClicked

    private void musicCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_musicCheckBoxActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    String var = jSpinner1.getValue().toString();   
    if (musicCheckBox.isSelected()){
        music = true;
        try {
            StartGame.audio.resumeAudio();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(SettingsGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    else{
        music = false;
        StartGame.audio.pause();
    }  
    setVisible(false);
    dispose();// TODO add your handling code here:
    lives=getLive();
    }//GEN-LAST:event_jLabel1MouseClicked

    public  int getLive(){
        return (int) jSpinner1.getValue();
    }
    
    public static int getLives(){
        return lives;
    }
    
    public static boolean isMusic() {
        return music;
    }
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
            java.util.logging.Logger.getLogger(SettingsGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SettingsGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SettingsGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SettingsGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SettingsGame().setVisible(true);
                  
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JCheckBox musicCheckBox;
    private javax.swing.JButton viewScore;
    // End of variables declaration//GEN-END:variables
}
