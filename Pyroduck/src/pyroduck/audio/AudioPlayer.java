package pyroduck.audio;

import javax.sound.sampled.*; 
import java.io.*;
import java.util.logging.*;

/**
 *
 * @author 
 */
public class  AudioPlayer {
   
    private Long currentFrame; 
    private Clip clip; 
    private static String status="" ; 
    private AudioInputStream audioInputStream; 
    private static String filepath;
    private static AudioPlayer audio = null;
    private static boolean musicon = true;//false=musicoff
   
    private AudioPlayer(String filepath) throws UnsupportedAudioFileException, LineUnavailableException, IOException { 
        this.filepath = filepath;
        audioInputStream =  AudioSystem.getAudioInputStream(getClass().getResource("../../resources/audio/"+filepath));  
       
        clip = AudioSystem.getClip();
        clip.open(audioInputStream); 
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
    } 
    
    public static AudioPlayer setAudioPlayer(String filepath){ 
        if (audio == null || status == null || status.equals("stop") || status.equals("paused")){
            try {
                audio = new AudioPlayer(filepath);
                if(!musicon){
                    audio.pause();
                    return audio;
                } 
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
            return audio;
        }   
        else return audio; 
    }
  
    public void play()  { 
        clip.start(); 
        status = "play"; 
    } 
       
    public void pause()  { 
        if (!status.equals("paused")){
            currentFrame = this.clip.getMicrosecondPosition(); 
            clip.stop(); 
            status = "paused";
        }
    } 
      
    public void resumeAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException{ 
         if(!musicon)
            return;
         else if (!status.equals("play"))  { 
            clip.close(); 
            resetAudioStream(); 
            clip.setMicrosecondPosition(currentFrame); 
            this.play(); 
        } 
    } 
      
    public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException{ 
        status = "stop";
        currentFrame = 0L; 
        clip.stop(); 
        clip.close(); 
    } 
      
    // Method to reset audio stream 
    private void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException{ 
        audioInputStream = AudioSystem.getAudioInputStream( 
        new File("./resources/audio/"+filepath).getAbsoluteFile()); 
        clip.open(audioInputStream); 
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
    } 
    
    public void musicOff() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
         musicon = false;
         this.pause();
    }
    
    public void musicOn() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        musicon = true;
        this.resumeAudio();        
    }

}
