package UI.Scene;

import Logic.Pet;
import Logic.Save;
import UI.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.*;

public class GameScene implements Scene {
    private Pet pet;
    private StatusPanel statusPanel;
    private JPanel UI;
    private final SceneManager sceneManager;
    private long lastSimulatedAt;

    public GameScene(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        Save loadingGame = Save.getTemporary();
        loadSave(loadingGame);

        generateUI();
    }

    @Override
    public JMenuBar getMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game");
        JMenuItem save = createSaveButton();
        JMenuItem load = createLoadButton();
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener((ActionEvent event) -> System.exit(0));
        menu.add(save);
        menu.add(load);
        menu.add(exit);
        menuBar.add(menu);
        return menuBar;
    }

    @Override
    public Component toComponent() {
        return UI;
    }

    @Override
    public void refresh() {
        long currentTime = new Date().getTime(); // timestamp
        int timePassedInMinutes = (int) ((currentTime - lastSimulatedAt) / 60000); // transforming to minutes
        if (timePassedInMinutes >= 1) {
            simulateTimePassed(timePassedInMinutes);
        }

        statusPanel.updateState(pet);
    }

    public void onClose() {
        int response =
                JOptionPane.showConfirmDialog(
                        null,
                        "Do you want to save your progress before exiting?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            saveCurrentGame();
        }
    }

    private void generateUI() {
        UI = new JPanel();
        Color backgroundColor = Color.decode("#2C6061");
        UI.setBackground(backgroundColor);
        BorderLayout layout = new BorderLayout();
        layout.setHgap(20);
        layout.setVgap(20);

        ImageIcon animatedIcon = new ImageIcon(getClass().getResource("/wolf_tail_animated.gif"));

        UI.setLayout(layout);
        UI.add(new JLabel(animatedIcon), BorderLayout.CENTER);

        ActionPanel actionPanel = new ActionPanel(pet);
        UI.add(actionPanel, BorderLayout.EAST);

        CharacterInfoPanel characterInfoPanel = new CharacterInfoPanel(pet);
        UI.add(characterInfoPanel, BorderLayout.WEST);

        // creating a status panel with status bars shown on top of the screen
        statusPanel = new StatusPanel(pet);
        UI.add(statusPanel, BorderLayout.NORTH);
    }

    private JMenuItem createSaveButton() {
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener((ActionEvent event) -> saveCurrentGame());

        return save;
    }

    private JMenuItem createLoadButton() {
        JMenuItem load = new JMenuItem("Load");
        load.addActionListener(
                (ActionEvent event) -> {
                    Save.load();
                    sceneManager.transitionToGame();
                });

        return load;
    }

    private void saveCurrentGame() {
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

    private void loadSave(Save save) {
        pet =
                new Pet(
                        save.name,
                        save.age,
                        save.breed,
                        save.fullness,
                        save.cleanliness,
                        save.energy,
                        save.happiness);
        lastSimulatedAt = save.savedAt * 1000L;
    }

    private void simulateTimePassed(int minutes) {
        lastSimulatedAt = lastSimulatedAt + (minutes * 60000L);
        pet.decreaseFullness(minutes);
        pet.decreaseCleanliness(minutes);
        pet.decreaseEnergy(minutes);
        pet.decreaseHappiness(minutes);
    }
}
