package pyroduck.gui;

import java.awt.Point;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.table.DefaultTableModel;
import pyroduck.ListPointsSerialize;
import pyroduck.PointsSerialize;

/**
 *
 * @author 
 */
public class SettingsGame extends javax.swing.JFrame {

    private static boolean music = true;
    private static int lives = 3;
    private ListPointsSerialize scores = new ListPointsSerialize();
    private List<PointsSerialize> list;

    /**
     * Creates new form SettingsGame
     */
    public SettingsGame() {
        initComponents(); 
        setLocation(new Point(600,200));
        DefaultTableModel model= new DefaultTableModel();
        jTable1.setModel(model);
        Object[] row = new Object[3];
        Object[] column = {"Names","Points","Lives"};
        model.setColumnIdentifiers(column);       
        list = scores.charge();
        for(PointsSerialize p : list){
            row[0] = p.getName();
            row[1]= p.getPoints();
            row[2]= p.getLives();           
            model.addRow(row);
        }
        if (music == true)
            musicCheckBox.setSelected(true);
        else
            musicCheckBox.setSelected(false);
        setVisible(true);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel2.setText("Lives number:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 100, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel4.setText("Music:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 100, 30));
        jPanel1.add(musicCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 30, 30));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        jSpinner1.setRequestFocusEnabled(false);
        jPanel1.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 40, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Names", "Points", "Lives"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 270, 150));

        saveButton.setBackground(new java.awt.Color(0, 102, 102));
        saveButton.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        saveButton.setText("Save and Exit");
        saveButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 140, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String var = jSpinner1.getValue().toString();
        if (musicCheckBox.isSelected()) {
            music = true;
            try {
                StartGame.audio.resumeAudio();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(SettingsGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            music = false;
            StartGame.audio.pause();
        }
        lives = (int) jSpinner1.getValue();
        setVisible(false);
        dispose();
    }//GEN-LAST:event_saveButtonActionPerformed

    public static int getLives(){
        return lives;
    }
    
    public static boolean isMusic() {
        return music;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JCheckBox musicCheckBox;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}