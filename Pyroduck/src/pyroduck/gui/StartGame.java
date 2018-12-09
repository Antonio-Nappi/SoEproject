package pyroduck.gui;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.Pyroduck;
import pyroduck.audio.AudioPlayer;
import pyroduck.exceptions.PyroduckException;

/**
 *
 * @author 
 */
public class StartGame extends javax.swing.JFrame {

    private int selected=0;
    private static AudioPlayer audio;
    String[] args;
    /**
     * Creates new form StartGame
     */
    public StartGame() {
        initComponents();
        imgLabel.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\SelectCharacter\\Psyduck.png"));
        audio= AudioPlayer.getAudioPlayer("opening.wav");
        audio.play();
        pSpeed.setValue(50);
        pSliding.setValue(50);
        pBr.setValue(50);
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
        jPanel2 = new javax.swing.JPanel();
        exitLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        imgLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        selectButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        settingsLabel = new javax.swing.JLabel();
        pSpeed = new javax.swing.JProgressBar();
        pSliding = new javax.swing.JProgressBar();
        pBr = new javax.swing.JProgressBar();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pyroduck");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setForeground(new java.awt.Color(255, 153, 0));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(null);
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 800));

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.gray));
        exitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabelMouseClicked(evt);
            }
        });
        jPanel2.add(exitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, -1, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 940, 40));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 540, 390));

        jPanel4.setBackground(new java.awt.Color(255, 102, 0));

        previousButton.setText("Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        selectButton.setText("Select");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(previousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(423, 423, 423)
                        .addComponent(selectButton)))
                .addContainerGap(224, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 940, 130));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setBackground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("Speed");

        jLabel3.setText("Sliding");

        jLabel4.setText("Bomb rate");

        settingsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        settingsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pSliding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pBr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(settingsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(pSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addComponent(pSliding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pBr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108)
                .addComponent(settingsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 400, 390));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tarzan", 0, 24)); // NOI18N
        jLabel1.setText("Choose your character");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 290, 30));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 940, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseClicked
    System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_exitLabelMouseClicked

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
    if (selected == 0){
        imgLabel.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\SelectCharacter\\Golduck.png"));
        pSpeed.setValue(100);
        pSliding.setValue(0);
        pBr.setValue(50);
        selected=1;
        }
    else{
        imgLabel.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\SelectCharacter\\Psyduck.png"));
        pSpeed.setValue(50);
        pSliding.setValue(50);
        pBr.setValue(50);
        selected=0;
        }              
    }//GEN-LAST:event_previousButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
    if (selected == 0){
        imgLabel.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\SelectCharacter\\Golduck.png"));
        pSpeed.setValue(100);
        pSliding.setValue(0);
        pBr.setValue(50);
        selected=1;
    }
    else{
        imgLabel.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\SelectCharacter\\Psyduck.png"));
        pSpeed.setValue(50);
        pSliding.setValue(50);
        pBr.setValue(50); 
        selected=0;
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        try {
            Game.getInstance().setSelected(selected);// TODO add your handling code here:
            audio.stop();
        } catch (PyroduckException ex) {
            Logger.getLogger(StartGame.class.getName()).log(Level.SEVERE, null, ex);
        }catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(StartGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StartGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(StartGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Board.getInstance().setPlayer(selected);
        Pyroduck p = new Pyroduck();
        try {
            p.main(args);
        } catch (PyroduckException ex) {
            Logger.getLogger(StartGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StartGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        
    }//GEN-LAST:event_selectButtonActionPerformed

    private void settingsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsLabelMouseClicked
    SettingsGame set = new SettingsGame();   
    set.setVisible(true);
    Point middle = new Point(200, 50);
    set.setLocation(middle);
// TODO add your handling code here:
    }//GEN-LAST:event_settingsLabelMouseClicked

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
            java.util.logging.Logger.getLogger(StartGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StartGame s = new StartGame();
                Point middle = new Point(200, 50);
                s.setBounds(new Rectangle(1000,600));   
                //new Rectangle(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height-40));
                s.setLocation(middle);
                s.setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exitLabel;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton nextButton;
    private javax.swing.JProgressBar pBr;
    private javax.swing.JProgressBar pSliding;
    private javax.swing.JProgressBar pSpeed;
    private javax.swing.JButton previousButton;
    private javax.swing.JButton selectButton;
    private javax.swing.JLabel settingsLabel;
    // End of variables declaration//GEN-END:variables
}