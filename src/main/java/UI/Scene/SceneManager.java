package UI.Scene;

import UI.AudioPlayer;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class SceneManager {
    private final JFrame mainFrame;
    private Scene currentScene;

    public SceneManager(JFrame mainFrame) {
        this.mainFrame = mainFrame;

        int fps = 30;
        int frequency = (int) (1000.0 / fps);
        ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
        timer.scheduleAtFixedRate(this::sync, 0, frequency, TimeUnit.MILLISECONDS);

        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play(getClass().getResource("/theme_song.wav"));

        onGameExit();
    }

    public void transitionToMainMenu() {
        setCurrentScene(new MainMenuScene(this));
    }

    public void transitionToGame() {
        setCurrentScene(new GameScene(this));
    }

    private void setCurrentScene(Scene scene) {
        currentScene = scene;

        mainFrame.getContentPane().removeAll();
        mainFrame.setJMenuBar(currentScene.getMenu());
        mainFrame.add(currentScene.toComponent());
        mainFrame.revalidate();
        mainFrame.setVisible(true);
    }

    private void sync() {
        try {
            if (currentScene != null) {
                currentScene.refresh();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void onGameExit() {
        mainFrame.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        currentScene.onClose();
                        System.exit(0);
                    }
                });
    }
}
