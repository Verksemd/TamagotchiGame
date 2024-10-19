package UI.Scene;

import UI.AudioPlayer;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import kotlin.system.exitProcess

class SceneManager {
    private val mainFrame: JFrame
    private var currentScene: Scene? = null

    constructor (mainFrame: JFrame) {
        this.mainFrame = mainFrame;

        val fps: Int = 30
        val frequency: Long = (1000.0 / fps).toLong();
        val timer: ScheduledExecutorService  = Executors.newScheduledThreadPool(1);
        timer.scheduleAtFixedRate(this::sync, 0, frequency, TimeUnit.MILLISECONDS);

        val audioPlayer: AudioPlayer = AudioPlayer()
        audioPlayer.play(javaClass.getResource("/theme_song.wav"));

        onGameExit();
    }

    fun transitionToMainMenu() {
        setCurrentScene(MainMenuScene(this));
    }

    fun transitionToGame() {
        setCurrentScene(GameScene(this));
    }

    private fun setCurrentScene(scene: Scene) {
        currentScene = scene;

        mainFrame.getContentPane().removeAll();
        mainFrame.setJMenuBar(currentScene?.getMenu());
        mainFrame.add(currentScene?.toComponent());
        mainFrame.revalidate();
        mainFrame.setVisible(true);
    }

    private fun sync()  {
        try {
            currentScene?.refresh()
        } catch (e: Throwable ) {
            e.printStackTrace();
        }
    }

    private fun onGameExit() {
        mainFrame.addWindowListener(
            object: WindowAdapter() {
                override fun windowClosing(e: WindowEvent) {
                    currentScene?.onClose();
                    exitProcess(0);
                }
            });
    }
}
