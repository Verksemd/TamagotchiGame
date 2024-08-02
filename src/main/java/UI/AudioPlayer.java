package UI;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;

public class AudioPlayer {

    private Clip clip;

    /**
     * Plays the audio file located at the specified URL in a loop.
     *
     * @param audioFileURL the URL of the audio file to be played
     */
    public void play(URL audioFileURL) {
        try {
            // Get an audio input stream from the audio file URL
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFileURL);

            // Obtain a Clip instance
            clip = AudioSystem.getClip();

            // Open the audio clip and load the audio stream
            clip.open(audioStream);

            // Start playing the clip
            clip.start();

            // Loop continuously
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /** Stops the audio playback and releases resources. */
    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }
}
