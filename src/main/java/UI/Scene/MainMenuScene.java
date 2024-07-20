package UI.Scene;

import Logic.Save;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainMenuScene implements Scene {
    private final SceneManager sceneManager;

    public MainMenuScene(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @Override
    public JMenuBar getMenu() {
        return null;
    }

    @Override
    public Component toComponent() {
        JPanel panel = new JPanel();
        Color backgroundColor = Color.decode("#2C6061");
        panel.setBackground(backgroundColor);

        JButton newGameButton = new JButton("New Game");
        newGameButton.setPreferredSize(new Dimension(150, 50));
        newGameButton.addActionListener(
                (ActionEvent event) -> {
                    Save.createTemporary();
                    sceneManager.transitionToGame();
                });
        panel.add(newGameButton);

        JButton loadButton = new JButton("Load Game");
        loadButton.setPreferredSize(new Dimension(150, 50));
        loadButton.addActionListener(
                (ActionEvent event) -> {
                    Save.load();
                    sceneManager.transitionToGame();
                });
        panel.add(loadButton);

        return panel;
    }

    @Override
    public void refresh() {}
}
