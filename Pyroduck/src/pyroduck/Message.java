package pyroduck;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import pyroduck.gui.GamePanel;

/**
 *
 * @author Montefusco
 */
public class Message {
    
    private static JLabel tutorial;
    private final GamePanel panel;
    private final Timer timer;
    
    public Message(GamePanel panel){
        this.panel = panel;
        tutorial = panel.getTutorial();
        timer = new Timer();
        timer.schedule(new ScheduleTask(), 4000);
    }

    public static void setMessage(String message){
         tutorial.setText(message);
    }
    
    private class ScheduleTask extends TimerTask {
        @Override
        public void run() {
            if(Game.getInstance().getDemo())
                setMessage("");
            else
                timer.cancel();
        }
    }
}
