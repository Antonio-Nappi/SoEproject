package pyroduck.gui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
    public GamePanel gamepane;
    private final JPanel containerpane;
    public static final String TITLE = "Pyroduck";

    public Frame() throws IOException {
        containerpane = new JPanel(new BorderLayout());
        gamepane = new GamePanel(this);
        containerpane.add(gamepane, BorderLayout.PAGE_END);
        setTitle(TITLE);
        add(containerpane);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();        
        InputStream imgStream = getClass().getResourceAsStream("duck.png");
        BufferedImage myImg = ImageIO.read(imgStream);
        ImageIcon imgi = new ImageIcon(myImg);
        Image img = imgi.getImage();
        setIconImage(img);
        setLocationRelativeTo(null);
        setVisible(true);	
        gamepane.getGame().start();
    }
}