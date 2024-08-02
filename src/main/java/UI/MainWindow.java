package UI;

import UI.Scene.SceneManager;
import java.awt.*;
import javax.swing.*;

public class MainWindow {
    private JFrame mainFrame;

    public MainWindow() {
        render();

        SceneManager sceneManager = new SceneManager(mainFrame);
        sceneManager.transitionToMainMenu();

        // timer.scheduleAtFixedRate(() -> timePassed(1), 1, 1, TimeUnit.MINUTES);

        // TODO this has to happen in game scene only

    }

    private void render() {
        mainFrame = new JFrame("Tamagotchi game");
        mainFrame.setSize(900, 600);
        mainFrame.setLayout(new GridLayout());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);

        mainFrame.setVisible(false);
    }
}
