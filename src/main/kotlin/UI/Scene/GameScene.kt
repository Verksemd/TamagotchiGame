package UI.Scene;

import Logic.Pet;
import Logic.Save;
import UI.ActionPanel;
import UI.CharacterInfoPanel;
import UI.StatusPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import kotlin.system.exitProcess

class GameScene(sceneManager: SceneManager) : Scene {
    private lateinit var pet: Pet
    private lateinit var statusPanel: StatusPanel
    private lateinit var ui: JPanel
    private val sceneManager : SceneManager
    private var lastSimulatedAt: Long = Date().getTime()

    init {
        this.sceneManager = sceneManager;
        var loadingGame: Save = Save.getTemporary()!!;
        loadSave(loadingGame);

        generateUI();
    }

    @Override
    override fun getMenu(): JMenuBar{
        val menuBar: JMenuBar = JMenuBar()
        val menu: JMenu = JMenu("Game")
        val save: JMenuItem = createSaveButton();
        val load: JMenuItem = createLoadButton();
        val exit: JMenuItem = JMenuItem("Exit");
        exit.addActionListener {event ->
            exitProcess(0)
        }
        menu.add(save);
        menu.add(load);
        menu.add(exit);
        menuBar.add(menu);
        return menuBar;
    }

    @Override
    override fun toComponent(): Component {
        return ui
    }

    override fun refresh(): Unit {
        val currentTime: Long = Date().getTime();
        val timePassedInMinutes: Int = ((currentTime - lastSimulatedAt) / 60000).toInt()
        if (timePassedInMinutes >= 1) {
            simulateTimePassed(timePassedInMinutes);
        }

        statusPanel.updateState(pet);
    }

   override fun onClose(): Unit {
        val response: Int =
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

    private fun generateUI(): Unit {
        ui = JPanel()
        var backgroundColor: Color = Color.decode("#2C6061")
        ui.setBackground(backgroundColor)
        val layout: BorderLayout = BorderLayout()
        layout.setHgap(20)
        layout.setVgap(20)

        val animatedIcon: ImageIcon = ImageIcon(javaClass.getResource("/wolf_tail_animated.gif"))

        ui.setLayout(layout);
        ui.add(JLabel(animatedIcon), BorderLayout.CENTER);

        val actionPanel: ActionPanel = ActionPanel(pet);
        ui.add(actionPanel, BorderLayout.EAST);

        val characterInfoPanel: CharacterInfoPanel = CharacterInfoPanel(pet);
        ui.add(characterInfoPanel, BorderLayout.WEST);

        // creating a status panel with status bars shown on top of the screen
        statusPanel = StatusPanel(pet);
        ui.add(statusPanel, BorderLayout.NORTH);
    }

    private fun createSaveButton() : JMenuItem  {
        val save: JMenuItem  = JMenuItem("Save");
        save.addActionListener {event ->
            saveCurrentGame()
        }
        return save;
    }

    private fun createLoadButton(): JMenuItem  {
        val load: JMenuItem  = JMenuItem("Load");
        load.addActionListener {event->
            Save.load()
            sceneManager.transitionToGame()
        }
        return load;
    }

    private fun saveCurrentGame() {
        val newSave: Save = Save()
        newSave.name = pet.name
        newSave.age = pet.age
        newSave.breed = pet.breed
        newSave.fullness = pet.getFullness()
        newSave.cleanliness = pet.getCleanliness()
        newSave.energy = pet.getEnergy()
        newSave.happiness = pet.getHappiness()
        newSave.savedAt = (Date().getTime() / 1000).toInt()
        newSave.conserve();
    }

    private fun loadSave(save: Save) {
        pet =
                Pet(
                        save.name,
                        save.age,
                        save.breed,
                        save.fullness,
                        save.cleanliness,
                        save.energy,
                        save.happiness);

        var currentTime: Int = (Date().getTime() / 1000).toInt();
        var passedTime: Int = (currentTime - save.savedAt) / 60;
        simulateTimePassed(passedTime);
    }

    private fun simulateTimePassed(minutes: Int) {
        lastSimulatedAt = lastSimulatedAt.plus((minutes * 60000L));
        pet.decreaseFullness(minutes);
        pet.decreaseCleanliness(minutes);
        pet.decreaseEnergy(minutes);
        pet.decreaseHappiness(minutes);
    }
}
