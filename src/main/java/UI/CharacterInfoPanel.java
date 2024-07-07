package UI;

import Logic.Pet;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CharacterInfoPanel extends JPanel {
    private JLabel nameLabel;
    private JLabel breedLabel;
    private JLabel ageLabel;
    private JLabel moodLabel;
    private Font labelFont = new Font("Arial", Font.BOLD, 16);

    public CharacterInfoPanel(Pet pet) {
        setLayout(new BorderLayout());

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        int panelWidth = 250;
        int panelHeight = 500;
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Color infoPanelBackgroundColor = Color.decode("#45612c");
        infoPanel.setBackground(infoPanelBackgroundColor);

        nameLabel = new JLabel("Name: " + pet.getName());
        nameLabel.setFont(labelFont);
        breedLabel = new JLabel("Breed: " + pet.getBreed());
        breedLabel.setFont(labelFont);
        ageLabel = new JLabel("Age: " + pet.getAge());
        ageLabel.setFont(labelFont);
        ImageIcon moodIcon = new ImageIcon(getClass().getResource("/happyEmote.png"));
        moodLabel = new JLabel("Mood: ");
        moodLabel.setFont(labelFont);
        moodLabel.setIcon(moodIcon);
        moodLabel.setHorizontalTextPosition(JLabel.LEFT);

        int verticalSpacing = 8;
        int leftPadding = 8;
        nameLabel.setBorder(new EmptyBorder(verticalSpacing, leftPadding, verticalSpacing, 0));
        breedLabel.setBorder(new EmptyBorder(verticalSpacing, leftPadding, verticalSpacing, 0));
        ageLabel.setBorder(new EmptyBorder(verticalSpacing, leftPadding, verticalSpacing, 0));
        moodLabel.setBorder(new EmptyBorder(verticalSpacing, leftPadding, verticalSpacing, 0));

        infoPanel.add(nameLabel);
        infoPanel.add(breedLabel);
        infoPanel.add(ageLabel);
        infoPanel.add(moodLabel);
        add(infoPanel, BorderLayout.NORTH);

        // Character's messages
        JTextArea dialogueArea = new JTextArea(8, 20);
        dialogueArea.setEditable(false);
        dialogueArea.setLineWrap(true);
        dialogueArea.setWrapStyleWord(true); // Перенос слов по словам, а не по символам
        dialogueArea.setBackground(infoPanelBackgroundColor);
        dialogueArea.setMargin(new Insets(5, 5, 5, 5)); // Set top, left, bottom, and right padding
        // JScrollPane scrollPane = new JScrollPane(dialogueArea);
        // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        dialogueArea.setText(
                "Arf arf! Hey there, I'm your virtual companion here! My name's "
                        + pet.getName()
                        + ", and I'm a playful pup ready to explore and have fun with you. Woof woof! You can interact with me in various ways – feed me tasty treats when I'm hungry, take me for walks to keep me active, and don't forget to pet me for some good belly rubs! Ruff ruff! If I look sleepy, it's probably time for a nap in my cozy bed. I'm excited to be your loyal friend and companion on this virtual adventure. Let's create unforgettable memories together!");
        // this.add(scrollPane, BorderLayout.CENTER);
        this.add(dialogueArea, BorderLayout.CENTER);
    }
}
