package UI;

import java.awt.*;
import javax.swing.*;

public class ActionPanel extends JPanel {
    private JButton feed;
    private JButton clean;
    private JButton sleep;
    private JButton play;
    private JButton pet;
    private Font actionButtonsFont = new Font("Arial", Font.BOLD, 14);

    public ActionPanel() {
        // Используем GridLayout для автоматического распределения компонентов
        this.setLayout(new GridLayout(5, 1, 10, 10)); // 4 строки, 1 столбец, отступы 10 пикселей
        Color buttonBackgroundColor = Color.decode("#472c61");
        Color buttonForegroundColor = Color.decode("#66dee0");


        feed = new JButton("Feed me");
        feed.setPreferredSize(new Dimension(150, 50));

        clean = new JButton("Clean me");
        clean.setPreferredSize(new Dimension(150, 50));

        sleep = new JButton("Fall asleep");
        sleep.setPreferredSize(new Dimension(150, 50));

        play = new JButton("Play with me");
        play.setPreferredSize(new Dimension(150, 50));

        pet = new JButton("Pet me");
        pet.setPreferredSize(new Dimension(150, 50));

        setButtonBackground(feed, buttonBackgroundColor);
        setButtonBackground(clean, buttonBackgroundColor);
        setButtonBackground(sleep, buttonBackgroundColor);
        setButtonBackground(play, buttonBackgroundColor);
        setButtonBackground(pet, buttonBackgroundColor);

        feed.setForeground(buttonForegroundColor);
        clean.setForeground(buttonForegroundColor);
        sleep.setForeground(buttonForegroundColor);
        play.setForeground(buttonForegroundColor);
        pet.setForeground(buttonForegroundColor);

        feed.setFont(actionButtonsFont);
        clean.setFont(actionButtonsFont);
        sleep.setFont(actionButtonsFont);
        play.setFont(actionButtonsFont);
        pet.setFont(actionButtonsFont);

        this.add(feed);
        this.add(clean);
        this.add(sleep);
        this.add(play);
        this.add(pet);

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
