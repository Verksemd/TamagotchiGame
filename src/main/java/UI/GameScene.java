package UI;

import Logic.Pet;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class GameScene implements Scene {
    private final MainWindow mainWindow;
    private final Pet pet;
    private StatusPanel statusPanel;

    public GameScene(MainWindow mainWindow, Pet pet) {
        this.mainWindow = mainWindow;
        this.pet = pet;
    }

    @Override
    public JMenuBar getMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game");
        JMenuItem save = createSaveButton();
        JMenuItem load = createLoadButton();
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(
                (ActionEvent event) -> {
                    System.exit(0);
                });
        menu.add(save);
        menu.add(load);
        menu.add(exit);
        menuBar.add(menu);
        return menuBar;
    }

    @Override
    public Component toComponent() {
        JPanel panel = new JPanel();
        Color backgroundColor = Color.decode("#2C6061");
        panel.setBackground(backgroundColor);
        BorderLayout layout = new BorderLayout();
        layout.setHgap(20);
        layout.setVgap(20);

        ImageIcon animatedIcon = new ImageIcon(getClass().getResource("/wolf_tail_animated.gif"));

        panel.setLayout(layout);
        panel.add(new JLabel(animatedIcon), BorderLayout.CENTER);

        ActionPanel actionPanel = new ActionPanel(pet);
        panel.add(actionPanel, BorderLayout.EAST);

        CharacterInfoPanel characterInfoPanel = new CharacterInfoPanel(pet);
        panel.add(characterInfoPanel, BorderLayout.WEST);

        // creating a status panel with status bars shown on top of the screen
        statusPanel = new StatusPanel(pet);
        panel.add(statusPanel, BorderLayout.NORTH);
        return panel;
    }

    @Override
    public void refresh() {
        statusPanel.updateState(pet);
    }

    private JMenuItem createSaveButton() {
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(
                (ActionEvent event) -> {
                    mainWindow.saveCurrentGame();
                });
        return save;
    }

    private JMenuItem createLoadButton() {
        JMenuItem load = new JMenuItem("Load");
        load.addActionListener((ActionEvent event) -> mainWindow.loadLatestSave());

        return load;
    }
}
