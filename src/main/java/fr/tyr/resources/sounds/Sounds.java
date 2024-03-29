package fr.tyr.resources.sounds;

import fr.tyr.Main;
import org.jetbrains.annotations.NotNull;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.logging.Level;

@SuppressWarnings("unused")
public enum Sounds {
    DING("ding.wav"),
    BACKGROUND("background.wav");

    private final String path;
    private Clip clip;
    private LineListener lineListener;

    Sounds(@NotNull final String path){
        this.path = path;
    }

    /**
     * Load the sound from the path
     */
    private void loadSound(){
        try {
            URL audioUrl = getClass().getResource("/" + this.path);
            if(Objects.isNull(audioUrl))
                throw new NullPointerException("The path " + this.path + " is invalid");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioUrl);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            Main.getLogger().log(Level.SEVERE, e.getMessage(), e);
        }
    }

    /**
     * Play the sound
     */
    public void play(){
        if(Objects.isNull(clip))
            loadSound();
        clip.start();
    }

    /**
     * Play the sound in loop
     */
    public void playBackground(){
        if(Objects.isNull(clip))
            loadSound();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Stop the sound
     */
    public void stop(){
        if(Objects.nonNull(clip))
            clip.stop();
    }

    /**
     * Set the volume of the sound
     * @param volume the volume between 0 and 1
     */
    public void setVolume(float volume){
        if(Objects.isNull(clip))
            loadSound();
        if (volume < 0f || volume > 1f)
            throw new IllegalArgumentException("Volume not valid: " + volume);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(20f * (float) Math.log10(volume));
    }

    /**
     * Restart the sound
     */
    public void restart(){
        if(Objects.isNull(clip))
            loadSound();
        clip.setFramePosition(0);
    }
}
