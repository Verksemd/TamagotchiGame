package UI;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

class AudioPlayer {

    private var clip: Clip? = null

    /**
     * Plays the audio file located at the specified URL in a loop.
     *
     * @param audioFileURL the URL of the audio file to be played
     */
    fun play(audioFileURL: URL) {
        try {
            // Get an audio input stream from the audio file URL
            val audioStream: AudioInputStream = AudioSystem.getAudioInputStream(audioFileURL);

            // Obtain a Clip instance
            clip = AudioSystem.getClip();

            // Open the audio clip and load the audio stream
            clip?.open(audioStream);

            // Start playing the clip
            clip?.start();

            // Loop continuously
            clip?.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (e: UnsupportedAudioFileException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: LineUnavailableException) {
            e.printStackTrace()
        }

        /** Stops the audio playback and releases resources. */
        fun stop() {
            clip?.stop()
            clip?.close()
        }
    }
}
