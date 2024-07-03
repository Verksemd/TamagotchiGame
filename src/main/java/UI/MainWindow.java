package UI;

import Logic.Pet;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class MainWindow {
    private JFrame mainFrame;
    private StatusPanel statusPanel;
    private ActionPanel actionPanel;
    private CharacterInfoPanel characterInfoPanel;

    public MainWindow() {
        prepareGUI();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Tamagotchi game");
        mainFrame.setSize(900, 600);
        mainFrame.setLayout(new GridLayout());

        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem load = new JMenuItem("Load");
        JMenuItem exit = new JMenuItem("Exit");
        menu.add(save);
        menu.add(load);
        menu.add(exit);
        menuBar.add(menu);
        mainFrame.setJMenuBar(menuBar);
    }

    public void renderUI() {
        JPanel panel = new JPanel();
        Color backgroundColor = Color.decode("#2C6061");
        panel.setBackground(backgroundColor);
        BorderLayout layout = new BorderLayout();
        layout.setHgap(20);
        layout.setVgap(20);

        ImageIcon animatedIcon = new ImageIcon(getClass().getResource("/wolf_tail_animated.gif"));

        panel.setLayout(layout);
        panel.add(new JLabel(animatedIcon), BorderLayout.CENTER);
        Pet dog = new Pet("Goburu", 24, "Husky", 10, 10, 10, 2);
        actionPanel = new ActionPanel(dog);
        panel.add(actionPanel, BorderLayout.EAST);

        characterInfoPanel = new CharacterInfoPanel(dog);
        panel.add(characterInfoPanel, BorderLayout.WEST);

        // creating a status panel with status bars shown on top of the screen
        statusPanel = new StatusPanel(dog);
        panel.add(statusPanel, BorderLayout.NORTH);

        // panel.add(new JButton("Woof-woof Inc."),BorderLayout.SOUTH);

        mainFrame.add(panel);
        mainFrame.setVisible(true);

        ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
        timer.scheduleAtFixedRate(
                () -> {
                    dog.decreaseFullness(1);
                    dog.decreaseCleanliness(1);
                    dog.decreaseEnergy(1);
                    dog.decreaseHappiness(1);
                },
                1,
                1,
                TimeUnit.MINUTES);
    }
}
