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
        Color backgroundColor = Color.decode("#E8C794");
        // Color backgroundColor = Color.decode("#81B0A4");
        panel.setBackground(backgroundColor);

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/main_menu_pic.jpg"));
        // ImageIcon logoIcon = new ImageIcon(getClass().getResource("/mainMenu3.jpg"));
        JLabel logoLabel = new JLabel(logoIcon);
        panel.add(logoLabel);

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

    @Override
    public void onClose() {}
}
