package UI;

import Logic.Pet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class ActionPanel(pet: Pet): JPanel() {
    private val feed: JButton
    private val clean: JButton
    private val sleep: JButton
    private val play: JButton
    private val pat: JButton
    private val actionButtonsFont: Font = Font("Arial", Font.BOLD, 14)

    init {
        this.setLayout(GridLayout(5, 1, 10, 10)) // 4 строки, 1 столбец, отступы 10 пикселей
        val buttonBackgroundColor: Color = Color.decode("#472c61")
        val buttonForegroundColor: Color = Color.decode("#66dee0")

        feed = JButton("Feed me");
        feed.setPreferredSize(Dimension(150, 50));
        feed.addActionListener {event ->
            pet.restoreFullness(2);
            pet.restoreHappiness(2);
            pet.decreaseEnergy(1);
        }

        clean = JButton("Clean me");
        clean.setPreferredSize(Dimension(150, 50));
        clean.addActionListener{
            event ->
            pet.restoreCleanliness(2);
            pet.restoreHappiness(2);
        }

        sleep = JButton("Fall asleep");
        sleep.setPreferredSize(Dimension(150, 50));
        sleep.addActionListener{event->
            pet.restoreEnergy(2);
            pet.restoreHappiness(2);
            pet.decreaseFullness(1);
            pet.decreaseCleanliness(1);

        }

        play = JButton("Play with me");
        play.setPreferredSize(Dimension(150, 50));
        play.addActionListener{
            event ->
            pet.restoreHappiness(2);
            pet.decreaseEnergy(1);
            pet.decreaseCleanliness(1);
            pet.decreaseFullness(1);
        }
        pat = JButton("Pat me");
        pat.setPreferredSize(Dimension(150, 50));
        pat.addActionListener{
            event ->
            pet.restoreHappiness(5)
        }

        setButtonBackground(feed, buttonBackgroundColor);
        setButtonBackground(clean, buttonBackgroundColor);
        setButtonBackground(sleep, buttonBackgroundColor);
        setButtonBackground(play, buttonBackgroundColor);
        setButtonBackground(pat, buttonBackgroundColor);

        feed.setForeground(buttonForegroundColor);
        clean.setForeground(buttonForegroundColor);
        sleep.setForeground(buttonForegroundColor);
        play.setForeground(buttonForegroundColor);
        pat.setForeground(buttonForegroundColor);

        feed.setFont(actionButtonsFont);
        clean.setFont(actionButtonsFont);
        sleep.setFont(actionButtonsFont);
        play.setFont(actionButtonsFont);
        pat.setFont(actionButtonsFont);

        this.add(feed);
        this.add(clean);
        this.add(sleep);
        this.add(play);
        this.add(pat);

        // Устанавливаем предпочтительные размеры для панели ActionPanel
        val panelWidth: Int = 250;
        val panelHeight: Int = 400;
        this.setPreferredSize(Dimension(panelWidth, panelHeight));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        val actionPanelBackgroundColor: Color = Color.decode("#45612c");
        this.setBackground(actionPanelBackgroundColor);
    }

    private fun setButtonBackground(button:JButton, color:Color) {
        button.setBackground(color);
        button.setOpaque(true);
        button.setBorderPainted(false); // Optional: Remove border if needed
    }
}
