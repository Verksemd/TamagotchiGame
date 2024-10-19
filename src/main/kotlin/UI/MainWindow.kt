package UI

import UI.Scene.SceneManager
import java.awt.GridLayout
import javax.swing.JFrame
import javax.swing.WindowConstants

class MainWindow {
    private var mainFrame: JFrame = JFrame("Tamagotchi game")

    init {
        render()

        val sceneManager = SceneManager(mainFrame)
        sceneManager.transitionToMainMenu()

        // timer.scheduleAtFixedRate({ timePassed(1) }, 1, 1, TimeUnit.MINUTES);

        // TODO this has to happen in game scene only
    }

    private fun render() {
        mainFrame.setSize(900, 600)
        mainFrame.layout = GridLayout()
        mainFrame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        mainFrame.setLocationRelativeTo(null)
        mainFrame.isVisible = false
    }
}