package pyroduck;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import pyroduck.gui.GamePanel;

/**
 *
 * @author Montefusco
 */
public class Message {

    private final JLabel tutorial;
    private final GamePanel panel;
    private final LinkedList<String> list;
    private final Timer timer;
    
    public Message(GamePanel panel) {
        this.panel = panel;
        tutorial = panel.getTutorial();
        list = new LinkedList<>();
        timer = new Timer();
        setList();
        timer.scheduleAtFixedRate(new ScheduleTask(), 5000, 4600);   
    }

    private void setMessage(String message) {
        tutorial.setText(message);
    }

    private void setList(){
        list.add("Destroy all the bricks to find powerups and go through the arena.");
        list.add("Press SPACE or X to place a bomb.");
        list.add("This is a powerup. Pick up them to become much stronger. But pay attention to malus!");
        list.add("    ");
        list.add("You have just killed an enemy. Kill all the enemies to finish the level.");
        list.add("Wow! Another powerup. You can find a powerup description in the main menù.");
        list.add("To cross a level you must kill all the enemies before.");
        list.add("     ");
        list.add("Congratulations! The level is now complete. It's your turn.");
        list.add("     ");    
    }    

    private class ScheduleTask extends TimerTask {
        @Override
        public void run() {
            if(list.isEmpty())
                setMessage("     ");
            setMessage(list.poll());
        }
    } 
}