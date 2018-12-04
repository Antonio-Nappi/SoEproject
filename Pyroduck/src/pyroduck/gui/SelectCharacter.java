package pyroduck.gui;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.ImageIcon;
import pyroduck.Game;
import pyroduck.Pyroduck;
import pyroduck.exceptions.PyroduckException;


/**
 *
 * @author 
 */
public class SelectCharacter extends javax.swing.JFrame {

    private int selected=0;
    String[] args;
    public static final String TITLE = "Choose your player";
    private static Media clip;
    private static MediaPlayer media;
    static {
                   JFXPanel fxPanel = new JFXPanel();

    }
    
    /**
     * Creates new form SelectCharacter
     */
    public SelectCharacter() {
        initComponents();
        this.setTitle(TITLE);
        ImageIcon imgi = new ImageIcon("resources\\textures\\duck.png");
        Image img = imgi.getImage();
        this.setIconImage(img);
        imageLabel.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\Psyduck.png"));
        imgSpeed.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\50.png"));
        imgSliding.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\0.png"));
        imgBomb.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\50.png"));
        imgSpeed.setText("");
        imgSliding.setText("");
        imgBomb.setText("");
         URL file = getClass().getResource("opening.mp3");
    final Media media = new Media(file.toString());
    final MediaPlayer mediaPlayer = new MediaPlayer(media);
    mediaPlayer.play();

      
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
        Next = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        select = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        speedLabel = new javax.swing.JLabel();
        slidingLabel = new javax.swing.JLabel();
        bombLabel = new javax.swing.JLabel();
        imgSpeed = new javax.swing.JLabel();
        imgSliding = new javax.swing.JLabel();
        imgBomb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Next.setText("Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        previous.setText("Previous");
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });

        select.setText("Select");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });

        speedLabel.setText("Speed");

        slidingLabel.setText("Sliding");

        bombLabel.setText("Bomb rate");

        imgSpeed.setText("jLabel1");

        imgSliding.setText("jLabel1");

        imgBomb.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(previous, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addGap(19, 19, 19)
                        .addComponent(Next, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imageLabel)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bombLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(slidingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(speedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgSpeed)
                            .addComponent(imgSliding)
                            .addComponent(imgBomb))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(select)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(speedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imgSpeed))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(slidingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imgSliding))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bombLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imgBomb))
                        .addGap(18, 18, 18))
                    .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Next)
                    .addComponent(previous))
                .addGap(18, 18, 18)
                .addComponent(select)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        try {
            Game.getInstance().setSelected(selected);
            Game.getInstance().getBoard().setPlayer(selected);
            Pyroduck p = new Pyroduck();
            p.main(args);
            this.setVisible(false);
        } catch (PyroduckException ex) {
            Logger.getLogger(SelectCharacter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SelectCharacter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_selectActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
        if( selected == 0){
            imageLabel.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\Golduck.png"));
            imgSpeed.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\501.png"));
            imgSliding.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\01.png"));
            imgBomb.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\501.png"));
            selected=1;
        }
        else{
            imageLabel.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\Psyduck.png"));
            imgSpeed.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\0.png"));
            imgSliding.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\50.png"));
            imgBomb.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\50.png"));
            selected=0;
        }
    }//GEN-LAST:event_previousActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        if( selected == 0){
            imageLabel.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\Golduck.png"));
            selected=1;
            imgSpeed.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\501.png"));
            imgSliding.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\01.png"));
            imgBomb.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\501.png"));
        }
        else{
            imageLabel.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\Psyduck.png"));
            selected=0;
            imgSpeed.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\0.png"));
            imgSliding.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\50.png"));
            imgBomb.setIcon(new javax.swing.ImageIcon(".\\resources\\textures\\50.png"));
        }
    }//GEN-LAST:event_NextActionPerformed

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
            java.util.logging.Logger.getLogger(SelectCharacter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectCharacter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectCharacter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectCharacter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
// Open an input stream  to the audio file.

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                

            SelectCharacter s;
            Point middle = new Point(0, 0);
            s = new SelectCharacter();
            s.setVisible(true);
            s.setLocation(middle);
            s.setBounds(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height-40));
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Next;
    private javax.swing.JLabel bombLabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel imgBomb;
    private javax.swing.JLabel imgSliding;
    private javax.swing.JLabel imgSpeed;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton previous;
    private javax.swing.JButton select;
    private javax.swing.JLabel slidingLabel;
    private javax.swing.JLabel speedLabel;
    // End of variables declaration//GEN-END:variables
}
