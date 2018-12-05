/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.audio;
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 
import java.io.File; 
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
/**
 *
 * @author Acer 5744 i5
 */
public class  AudioPlayer {
    
    static {
                   JFXPanel fxPanel = new JFXPanel();

    }
    
    // to store current position 
    private Long currentFrame; 
    private Clip clip; 
      
    // current status of clip 
    private static String status ; 
    private AudioInputStream audioInputStream; 
    private static String filepath;
    private static AudioPlayer audio=null;
  
    // constructor to initialize streams and clip 
    private AudioPlayer(String filepath) throws UnsupportedAudioFileException, LineUnavailableException, IOException { 
        // create AudioInputStream object 
        this.filepath=filepath;
        audioInputStream =  AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile()); 
          
        // create clip reference 
        clip = AudioSystem.getClip(); 
          
        // open audioInputStream to the clip 
        clip.open(audioInputStream); 
          
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
    } 
      
    
      
    // Method to play the audio 
    
    public static AudioPlayer getAudioPlayer(String filepath){
        if (audio==null || status==null || status.equals("stop")){
            try {
                audio= new AudioPlayer(filepath);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
            return audio;
        }
        
        else return audio;
        
    }
  
    public void play()  
    { 
        //start the clip 
        clip.start(); 
          
        status = "play"; 
    } 
      
    // Method to pause the audio 
    public void pause()  
    { 
        if (status.equals("paused"))  
        { 
            //System.out.println("audio is already paused"); 
            return; 
        } 
        this.currentFrame = this.clip.getMicrosecondPosition(); 
        clip.stop(); 
        status = "paused"; 
    } 
      
    // Method to resume the audio 
    public void resumeAudio() throws UnsupportedAudioFileException, 
                                IOException, LineUnavailableException  
    { 
        if (status.equals("play"))  
        { 
            return; 
        } 
        clip.close(); 
        resetAudioStream(); 
        clip.setMicrosecondPosition(currentFrame); 
        this.play(); 
    } 
      
    // Method to restart the audio 
    public void restart() throws IOException, LineUnavailableException, 
                                            UnsupportedAudioFileException  
    { 
        clip.stop(); 
        clip.close(); 
        resetAudioStream(); 
        currentFrame = 0L; 
        clip.setMicrosecondPosition(0); 
        this.play(); 
    } 
      
    // Method to stop the audio 
    public void stop() throws UnsupportedAudioFileException, 
    IOException, LineUnavailableException  
    { 
        status="stop";
        currentFrame = 0L; 
        clip.stop(); 
        clip.close(); 
    } 
      
    // Method to jump over a specific part 
    public void jump(long c) throws UnsupportedAudioFileException, IOException, 
                                                        LineUnavailableException  
    { 
        if (c > 0 && c < clip.getMicrosecondLength())  
        { 
            clip.stop(); 
            clip.close(); 
            resetAudioStream(); 
            currentFrame = c; 
            clip.setMicrosecondPosition(c); 
            this.play(); 
        } 
    } 
      
    // Method to reset audio stream 
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, 
                                            LineUnavailableException  
    { 
        audioInputStream = AudioSystem.getAudioInputStream( 
        new File(filepath).getAbsoluteFile()); 
        clip.open(audioInputStream); 
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
    } 

    public Long getCurrentFrame() {
        return currentFrame;
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }

    public String getStatus() {
        return status;
    }

   
    
}
