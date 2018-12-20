package pyroduck.gui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.audio.AudioPlayer;

/**
 *
 * @author 
 */
public class StartGame extends javax.swing.JFrame {

    private int selected = 0;
    public static AudioPlayer audio;
    String[] args;
    private boolean restart=false;
   
    /**
     * Creates new form StartGame
     */
    public StartGame() {
        initComponents();
        imgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("../../resources/textures/SelectCharacter/Psyduck.png")));
        exitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("../../resources/textures/SelectCharacter/exit_32.png")));     
        audio = AudioPlayer.setAudioPlayer("opening.wav");
        audio.play();
        pSpeed.setValue(100);
        pSliding.setValue(100);
        pBr.setValue(50);
        demomodeButton.setToolTipText("Start the demo with selected player and make your first play!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        powerupButton = new javax.swing.JButton();
        demomodeButton = new javax.swing.JButton();
        howtoplayButton = new javax.swing.JButton();
        infoButton = new javax.swing.JButton();
        settingButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        exitLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        imgLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        playButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pSpeed = new javax.swing.JProgressBar();
        pSliding = new javax.swing.JProgressBar();
        pBr = new javax.swing.JProgressBar();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        namecharacterLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pyroduck");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1125, 600));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1125, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 153, 0));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(null);

        jPanel8.setBackground(new java.awt.Color(255, 204, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 3), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2)));

        powerupButton.setBackground(new java.awt.Color(255, 255, 255));
        powerupButton.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        powerupButton.setText("Powerup");
        powerupButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        powerupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powerupButtonActionPerformed(evt);
            }
        });

        demomodeButton.setBackground(new java.awt.Color(255, 255, 255));
        demomodeButton.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        demomodeButton.setText("Demo Mode");
        demomodeButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        demomodeButton.setMaximumSize(new java.awt.Dimension(60, 150));
        demomodeButton.setMinimumSize(new java.awt.Dimension(60, 150));
        demomodeButton.setPreferredSize(new java.awt.Dimension(60, 150));
        demomodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demomodeButtonActionPerformed(evt);
            }
        });

        howtoplayButton.setBackground(new java.awt.Color(255, 255, 255));
        howtoplayButton.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        howtoplayButton.setText("How to play");
        howtoplayButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        howtoplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                howtoplayButtonActionPerformed(evt);
            }
        });

        infoButton.setBackground(new java.awt.Color(255, 255, 255));
        infoButton.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        infoButton.setText("?");
        infoButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoButtonActionPerformed(evt);
            }
        });

        settingButton.setBackground(new java.awt.Color(255, 255, 255));
        settingButton.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        settingButton.setText("Settings");
        settingButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        settingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingButtonhowtoplayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(powerupButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(demomodeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(infoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(settingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(howtoplayButton, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(demomodeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(powerupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(howtoplayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8);
        jPanel8.setBounds(20, 110, 150, 360);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 800));

        jPanel2.setBackground(new java.awt.Color(102, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabelMouseClicked(evt);
            }
        });
        jPanel2.add(exitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 50, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 960, 40));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 470, 390));

        jPanel4.setBackground(new java.awt.Color(102, 0, 0));

        playButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        playButton.setText("Play");
        playButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));
        playButton.setMaximumSize(new java.awt.Dimension(40, 90));
        playButton.setMinimumSize(new java.awt.Dimension(40, 90));
        playButton.setPreferredSize(new java.awt.Dimension(40, 90));
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(413, Short.MAX_VALUE)
                .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(407, 407, 407))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 910, 100));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setBackground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("Speed");

        jLabel3.setText("Sliding");

        jLabel4.setText("Bomb rate");

        previousButton.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        previousButton.setText("Previous");
        previousButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 2, true), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102))));
        previousButton.setMaximumSize(new java.awt.Dimension(124, 40));
        previousButton.setMinimumSize(new java.awt.Dimension(124, 40));
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        nextButton.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        nextButton.setText("Next");
        nextButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 2, true), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102))));
        nextButton.setMaximumSize(new java.awt.Dimension(124, 40));
        nextButton.setMinimumSize(new java.awt.Dimension(124, 40));
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        namecharacterLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        namecharacterLabel.setText("PSYDUCK");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namecharacterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pSliding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pBr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(previousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(namecharacterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(pSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pSliding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pBr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 360, 390));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tarzan", 0, 24)); // NOI18N
        jLabel1.setText("Choose your character");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 290, 30));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 830, 40));

        jPanel7.setBackground(new java.awt.Color(102, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 40, 60, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseClicked
        System.exit(0); 
    }//GEN-LAST:event_exitLabelMouseClicked

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        if (selected == 0){
            imgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("resources/textures/SelectCharacter/Golduck.png")));
            pSpeed.setValue(50);
            pSliding.setValue(0);
            pBr.setValue(50);
            namecharacterLabel.setText("GOLDUCK");
            selected = 1;
        }
        else{
            imgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("resources/textures/SelectCharacter/Psyduck.png")));
            pSpeed.setValue(100);
            pSliding.setValue(100);
            pBr.setValue(50);
            namecharacterLabel.setText("PSYDUCK");
            selected = 0;
        }              
    }//GEN-LAST:event_previousButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if (selected == 0){
            imgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("../../resources/textures/SelectCharacter/Golduck.png")));
            pSpeed.setValue(50);
            pSliding.setValue(0);
            pBr.setValue(50);
            namecharacterLabel.setText("GOLDUCK");
            selected = 1;
        }
        else{
            imgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("../../resources/textures/SelectCharacter/Psyduck.png")));
            pSpeed.setValue(100);
            pSliding.setValue(100);
            pBr.setValue(50); 
            namecharacterLabel.setText("PSYDUCK");
            selected = 0;
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        
        Game.getInstance().setDemo(false);
        try {
            Game.getInstance().setSelected(selected);
            audio.stop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(StartGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Board.getInstance().setPlayer(selected);  
        try {
            if(!restart){
            Frame mainwindow = new Frame();
            restart=true;
            }

        } catch (IOException ex) {
            Logger.getLogger(StartGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Board.getInstance().setLives(SettingsGame.getLives());
         setVisible(false);    
    }//GEN-LAST:event_playButtonActionPerformed

    private void powerupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powerupButtonActionPerformed
        PowerupWindow pwindow = new PowerupWindow(this);
        setEnabled(false);
    }//GEN-LAST:event_powerupButtonActionPerformed

    private void howtoplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_howtoplayButtonActionPerformed
        HowToPlay howtoplay = new HowToPlay(this);
        setEnabled(false);
    }//GEN-LAST:event_howtoplayButtonActionPerformed

    private void infoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoButtonActionPerformed
        InfoWindow info = new InfoWindow(this);
        setEnabled(false);
    }//GEN-LAST:event_infoButtonActionPerformed
                              
    private void settingButtonhowtoplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingButtonhowtoplayButtonActionPerformed
        SettingsGame setting = new SettingsGame(this);
        setEnabled(false);
    }//GEN-LAST:event_settingButtonhowtoplayButtonActionPerformed

    private void demomodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demomodeButtonActionPerformed
        Game.getInstance().setSelected(selected);
        Board.getInstance().setPlayer(selected);
        Board.getInstance().changeLevel(0);
        Game.getInstance().setDemo(true);
        try {
            audio.stop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(StartGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
             if(!restart){
            Frame mainwindow = new Frame();
            restart=true;
            }
        } catch (IOException ex) {
            Logger.getLogger(StartGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);  
    }//GEN-LAST:event_demomodeButtonActionPerformed

   
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
                s.setBounds(new Rectangle(1000,600));  
                s.setLocationRelativeTo(null);
                s.setVisible(true);              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton demomodeButton;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JButton howtoplayButton;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JButton infoButton;
    private javax.swing.JFrame jFrame1;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel namecharacterLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JProgressBar pBr;
    private javax.swing.JProgressBar pSliding;
    private javax.swing.JProgressBar pSpeed;
    private javax.swing.JButton playButton;
    private javax.swing.JButton powerupButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JButton settingButton;
    // End of variables declaration//GEN-END:variables
}
