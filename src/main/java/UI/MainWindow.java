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
        /*
        mainFrame.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        int response =
                                JOptionPane.showConfirmDialog(
                                        mainFrame,
                                        "Do you want to save your progress before exiting?",
                                        "Confirm Exit",
                                        JOptionPane.YES_NO_CANCEL_OPTION,
                                        JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            saveCurrentGame();
                            System.exit(0);
                        } else if (response == JOptionPane.NO_OPTION) {
                            System.exit(0);
                        }
                    }
                });
         */
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
