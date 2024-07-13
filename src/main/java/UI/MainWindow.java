package UI;

import Logic.Pet;
import Logic.Save;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class MainWindow {
    private JFrame mainFrame;
    private Scene currentScene;
    private Pet pet;

    public MainWindow() {
        loadLatestSave();
        ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
        timer.scheduleAtFixedRate(() -> timePassed(1), 1, 1, TimeUnit.MINUTES);

        int fps = 30;
        int frequency = (int) (1000.0 / fps);
        timer.scheduleAtFixedRate(
                () -> currentScene.refresh(), 0, frequency, TimeUnit.MILLISECONDS);

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
    }

    private void prepareGUI(Pet pet) {
        if (mainFrame == null) {
            mainFrame = new JFrame("Tamagotchi game");
            mainFrame.setSize(900, 600);
            mainFrame.setLayout(new GridLayout());
            mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            mainFrame.setLocationRelativeTo(null);
        } else {
            mainFrame.getContentPane().removeAll();
        }

        mainFrame.setVisible(false);
        currentScene = new GameScene(this, pet);
        JMenuBar menuBar = currentScene.getMenu();
        mainFrame.setJMenuBar(menuBar);
        mainFrame.add(currentScene.toComponent());
    }

    public void render() {
        mainFrame.revalidate();
        mainFrame.setVisible(true);
    }

    public void saveCurrentGame() {
        Save newSave = new Save();
        newSave.name = pet.getName();
        newSave.age = pet.getAge();
        newSave.breed = pet.getBreed();
        newSave.fullness = pet.getFullness();
        newSave.cleanliness = pet.getCleanliness();
        newSave.energy = pet.getEnergy();
        newSave.happiness = pet.getHappiness();
        newSave.savedAt = (int) (new Date().getTime() / 1000);
        newSave.conserve();
    }

    public void loadLatestSave() {
        Save mySave = Save.load();
        pet =
                new Pet(
                        mySave.name,
                        mySave.age,
                        mySave.breed,
                        mySave.fullness,
                        mySave.cleanliness,
                        mySave.energy,
                        mySave.happiness);

        int currentTime = (int) (new Date().getTime() / 1000);
        int passedTime = (currentTime - mySave.savedAt) / 60;
        timePassed(passedTime);
        prepareGUI(pet);
        render();
    }

    private void timePassed(int minutes) {
        pet.decreaseFullness(minutes);
        pet.decreaseCleanliness(minutes);
        pet.decreaseEnergy(minutes);
        pet.decreaseHappiness(minutes);
    }
}
