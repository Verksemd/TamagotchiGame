package UI;

import Logic.Pet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class CharacterInfoPanel(pet: Pet) : JPanel() {
    private val nameLabel: JLabel
    private val breedLabel: JLabel
    private val ageLabel: JLabel
    private val moodLabel: JLabel
    private val labelFont = Font ("Arial", Font.PLAIN, 14)

    init {
        layout = BorderLayout()

        val infoPanel = JPanel()
        infoPanel.setLayout(BoxLayout(infoPanel, BoxLayout.Y_AXIS))
        val panelWidth: Int = 250
        val panelHeight: Int = 500;
        this.setPreferredSize(Dimension(panelWidth, panelHeight));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        val infoPanelBackgroundColor:Color  = Color.decode("#45612c");
        infoPanel.setBackground(infoPanelBackgroundColor);

        nameLabel = JLabel("Name: " + pet.name);
        nameLabel.setFont(labelFont);
        breedLabel = JLabel("Breed: " + pet.breed);
        breedLabel.setFont(labelFont);
        ageLabel = JLabel("Age: " + pet.age);
        ageLabel.setFont(labelFont);
        val moodIcon: ImageIcon = ImageIcon(javaClass.getResource("/happyEmote.png"));
        moodLabel = JLabel("Mood: ");
        moodLabel.setFont(labelFont);
        moodLabel.setIcon(moodIcon);
        moodLabel.setHorizontalTextPosition(JLabel.LEFT);

        val verticalSpacing: Int = 8;
        val leftPadding: Int = 8;
        nameLabel.setBorder(EmptyBorder(verticalSpacing, leftPadding, verticalSpacing, 0));
        breedLabel.setBorder(EmptyBorder(verticalSpacing, leftPadding, verticalSpacing, 0));
        ageLabel.setBorder(EmptyBorder(verticalSpacing, leftPadding, verticalSpacing, 0));
        moodLabel.setBorder(EmptyBorder(verticalSpacing, leftPadding, verticalSpacing, 0));

        infoPanel.add(nameLabel);
        infoPanel.add(breedLabel);
        infoPanel.add(ageLabel);
        infoPanel.add(moodLabel);
        add(infoPanel, BorderLayout.NORTH);

        // Character's messages
        val dialogueArea: JTextArea = JTextArea(8, 20);
        dialogueArea.setEditable(false);
        dialogueArea.setLineWrap(true);
        dialogueArea.setWrapStyleWord(true); // Перенос слов по словам, а не по символам
        dialogueArea.setBackground(infoPanelBackgroundColor);
        dialogueArea.setMargin(Insets(5, 5, 5, 5)); // Set top, left, bottom, and right padding
        dialogueArea.setText(
                "Arf arf! Hey there, I'm your virtual companion here! My name's "
                        + pet.name
                        + ", and I'm a playful pup ready to explore and have fun with you. Woof woof! You can interact with me in various ways – feed me tasty treats when I'm hungry, take me for walks to keep me active, and don't forget to pet me for some good belly rubs! Ruff ruff! If I look sleepy, it's probably time for a nap in my cozy bed. I'm excited to be your loyal friend and companion on this virtual adventure. Let's create unforgettable memories together!");
        this.add(dialogueArea, BorderLayout.CENTER);
    }
}
