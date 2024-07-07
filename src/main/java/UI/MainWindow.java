package UI;

import Logic.Pet;
import Logic.Save;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class MainWindow {
    private JFrame mainFrame;
    private StatusPanel statusPanel;
    private ActionPanel actionPanel;
    private CharacterInfoPanel characterInfoPanel;
    private Pet pet;

    public MainWindow() {
        Gson gson = new GsonBuilder().create();
        Save mySave = null;
        try (FileReader reader = new FileReader(Save.SAVE_FILE)) {
            mySave = gson.fromJson(reader, Save.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        pet =
                new Pet(
                        mySave.name,
                        mySave.age,
                        mySave.breed,
                        mySave.fullness,
                        mySave.cleanliness,
                        mySave.energy,
                        mySave.happiness);

        prepareGUI(pet);

        ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
        timer.scheduleAtFixedRate(
                () -> {
                    pet.decreaseFullness(1);
                    pet.decreaseCleanliness(1);
                    pet.decreaseEnergy(1);
                    pet.decreaseHappiness(1);
                },
                1,
                1,
                TimeUnit.MINUTES);

        timer.scheduleAtFixedRate(() -> statusPanel.refresh(pet), 0, 250, TimeUnit.MILLISECONDS);
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
        mainFrame.setJMenuBar(menuBar);
        createPetPanels(pet);
    }

    private JMenuItem createSaveButton() {
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(
                (ActionEvent event) -> {
                    saveCurrentGame();
                });
        return save;
    }

    private JMenuItem createLoadButton() {
        JMenuItem load = new JMenuItem("Load");
        load.addActionListener(
                (ActionEvent event) -> {
                    Gson gson = new GsonBuilder().create();
                    Save mySave = null;
                    try (FileReader reader = new FileReader(Save.SAVE_FILE)) {
                        mySave = gson.fromJson(reader, Save.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(0);
                    }

                    pet =
                            new Pet(
                                    mySave.name,
                                    mySave.age,
                                    mySave.breed,
                                    mySave.fullness,
                                    mySave.cleanliness,
                                    mySave.energy,
                                    mySave.happiness);

                    prepareGUI(pet);
                    render();
                });
        return load;
    }

    public void render() {
        mainFrame.revalidate();
        mainFrame.setVisible(true);
    }

    private void createPetPanels(Pet pet) {
        JPanel panel = new JPanel();
        Color backgroundColor = Color.decode("#2C6061");
        panel.setBackground(backgroundColor);
        BorderLayout layout = new BorderLayout();
        layout.setHgap(20);
        layout.setVgap(20);

        ImageIcon animatedIcon = new ImageIcon(getClass().getResource("/wolf_tail_animated.gif"));

        panel.setLayout(layout);
        panel.add(new JLabel(animatedIcon), BorderLayout.CENTER);

        actionPanel = new ActionPanel(pet);
        panel.add(actionPanel, BorderLayout.EAST);

        characterInfoPanel = new CharacterInfoPanel(pet);
        panel.add(characterInfoPanel, BorderLayout.WEST);

        // creating a status panel with status bars shown on top of the screen
        statusPanel = new StatusPanel(pet);
        panel.add(statusPanel, BorderLayout.NORTH);

        // panel.add(new JButton("Woof-woof Inc."),BorderLayout.SOUTH);

        mainFrame.add(panel);
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

    private void saveCurrentGame() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(Save.SAVE_FILE)) {
            Save newSave = new Save();
            newSave.name = pet.getName();
            newSave.age = pet.getAge();
            newSave.breed = pet.getBreed();
            newSave.fullness = pet.getFullness();
            newSave.cleanliness = pet.getCleanliness();
            newSave.energy = pet.getEnergy();
            newSave.happiness = pet.getHappiness();
            gson.toJson(newSave, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
