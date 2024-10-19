package UI.Scene;

import Logic.Save;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class MainMenuScene(val sceneManager: SceneManager) : Scene {

    override fun getMenu(): JMenuBar? {
        return null
    }

    override fun toComponent(): Component {
        val panel: JPanel  = JPanel()
        val backgroundColor: Color = Color.decode("#E8C794");
        // Color backgroundColor = Color.decode("#81B0A4");
        panel.setBackground(backgroundColor);

        val logoIcon: ImageIcon  = ImageIcon(javaClass.getResource("/main_menu_pic.jpg"));
        // ImageIcon logoIcon = new ImageIcon(getClass().getResource("/mainMenu3.jpg"));
        val logoLabel: JLabel = JLabel(logoIcon);
        panel.add(logoLabel);

        val newGameButton: JButton = JButton("New Game");
        newGameButton.setPreferredSize(Dimension(150, 50));
        newGameButton.addActionListener {event ->
            Save.createTemporary()
            sceneManager.transitionToGame()
        }
        panel.add(newGameButton);

        val loadButton: JButton = JButton("Load Game");
        loadButton.setPreferredSize(Dimension(150, 50));
        loadButton.addActionListener{event->
            Save.load()
            sceneManager.transitionToGame()
        }
        panel.add(loadButton);

        return panel;
    }

   override fun refresh() {}

    override fun onClose() {}
}
