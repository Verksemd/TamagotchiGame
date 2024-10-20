package UI;

import Logic.Pet;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ActionPanel extends JPanel {
    private JButton feed;
    private JButton clean;
    private JButton sleep;
    private JButton play;
    private JButton pat;
    private Font actionButtonsFont = new Font("Arial", Font.BOLD, 14);

    public ActionPanel(Pet pet) {
        this.setLayout(new GridLayout(5, 1, 10, 10)); // 4 строки, 1 столбец, отступы 10 пикселей
        Color buttonBackgroundColor = Color.decode("#472c61");
        Color buttonForegroundColor = Color.decode("#66dee0");

        feed = new JButton("Feed me");
        feed.setPreferredSize(new Dimension(150, 50));
        feed.addActionListener(
                (ActionEvent event) -> {
                    pet.restoreFullness(3);
                    pet.restoreHappiness(2);
                    pet.decreaseCleanliness(1);
                });

        clean = new JButton("Clean me");
        clean.setPreferredSize(new Dimension(150, 50));
        clean.addActionListener(
                (ActionEvent event) -> {
                    pet.restoreCleanliness(2);
                    pet.restoreHappiness(2);
                });

        sleep = new JButton("Fall asleep");
        sleep.setPreferredSize(new Dimension(150, 50));
        sleep.addActionListener(
                (ActionEvent event) -> {
                    pet.restoreEnergy(3);
                    pet.restoreHappiness(2);
                    pet.decreaseFullness(1);
                    pet.decreaseCleanliness(1);
                });

        play = new JButton("Play with me");
        play.setPreferredSize(new Dimension(150, 50));
        play.addActionListener(
                (ActionEvent event) -> {
                    pet.restoreHappiness(3);
                    pet.decreaseEnergy(1);
                    pet.decreaseCleanliness(1);
                    pet.decreaseFullness(1);
                });

        pat = new JButton("Pat me");
        pat.setPreferredSize(new Dimension(150, 50));
        pat.addActionListener(
                (ActionEvent event) -> {
                    pet.restoreHappiness(5);
                });

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
        int panelWidth = 250;
        int panelHeight = 400;
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Color actionPanelBackgroundColor = Color.decode("#45612c");
        this.setBackground(actionPanelBackgroundColor);
    }

    private void setButtonBackground(JButton button, Color color) {
        button.setBackground(color);
        button.setOpaque(true);
        button.setBorderPainted(false); // Optional: Remove border if needed
    }
}
