package UI;

import Logic.Pet;
import Logic.PetStat;

import javax.swing.*;
import java.awt.*;

class StatusPanel(pet: Pet):JPanel() {
    private var fullness: JProgressBar
    private var cleanliness: JProgressBar
    private var energy: JProgressBar
    private var happiness: JProgressBar

    private val statusFont: Font = Font("Arial", Font.BOLD, 18);

    init {
        this.setLayout(BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(Style.statusPanelBackgroundColor);

        fullness = JProgressBar();
        fullness.setMinimum(PetStat.MIN_VALUE);
        fullness.setMaximum(PetStat.MAX_VALUE);

        cleanliness = JProgressBar();
        cleanliness.setMinimum(PetStat.MIN_VALUE);
        cleanliness.setMaximum(PetStat.MAX_VALUE);

        happiness = JProgressBar();
        happiness.setMinimum(PetStat.MIN_VALUE);
        happiness.setMaximum(PetStat.MAX_VALUE);

        energy = JProgressBar();
        energy.setMinimum(PetStat.MIN_VALUE);
        energy.setMaximum(PetStat.MAX_VALUE);

        val hungerPanel: JPanel = JPanel();
        hungerPanel.setLayout(BoxLayout(hungerPanel, BoxLayout.Y_AXIS));
        val hungerLabel: JLabel  = JLabel("Fullness");
        hungerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        hungerLabel.setFont(statusFont);
        hungerLabel.setForeground(Style.statusPanelForegroundColor);
        fullness.setAlignmentX(Component.CENTER_ALIGNMENT);
        hungerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        hungerPanel.setBackground(Style.statusPanelBackgroundColor);
        hungerPanel.add(hungerLabel);
        hungerPanel.add(fullness);

        val thirstPanel: JPanel = JPanel();
        thirstPanel.setLayout(BoxLayout(thirstPanel, BoxLayout.Y_AXIS));
        val thirstLabel: JLabel  = JLabel("Cleanliness");
        thirstLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        thirstLabel.setFont(statusFont);
        thirstLabel.setForeground(Style.statusPanelForegroundColor);
        cleanliness.setAlignmentX(Component.CENTER_ALIGNMENT);
        thirstPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        thirstPanel.setBackground(Style.statusPanelBackgroundColor);
        thirstPanel.add(thirstLabel);
        thirstPanel.add(cleanliness);

        val happinessPanel: JPanel  = JPanel();
        happinessPanel.setLayout(BoxLayout(happinessPanel, BoxLayout.Y_AXIS));
        val happinessLabel: JLabel = JLabel("Happiness");
        happinessLabel.setFont(statusFont);
        happinessLabel.setForeground(Style.statusPanelForegroundColor);
        happinessLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        happiness.setAlignmentX(Component.CENTER_ALIGNMENT);
        happinessPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        happinessPanel.setBackground(Style.statusPanelBackgroundColor);
        happinessPanel.add(happinessLabel);
        happinessPanel.add(happiness);

        val energyPanel: JPanel = JPanel();
        energyPanel.setLayout(BoxLayout(energyPanel, BoxLayout.Y_AXIS));
        val energyLabel: JLabel  = JLabel("Energy");
        energyLabel.setFont(statusFont);
        energyLabel.setForeground(Style.statusPanelForegroundColor);
        energyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        energy.setAlignmentX(Component.CENTER_ALIGNMENT);
        energyPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        energyPanel.setBackground(Style.statusPanelBackgroundColor);
        energyPanel.add(energyLabel);
        energyPanel.add(energy);

        this.add(hungerPanel);
        this.add(Box.createHorizontalStrut(10));
        this.add(thirstPanel);
        this.add(Box.createHorizontalStrut(10));
        this.add(happinessPanel);
        this.add(Box.createHorizontalStrut(10));
        this.add(energyPanel);
    }

    fun updateState(pet: Pet) {
        fullness.setValue(pet.getFullness());
        cleanliness.setValue(pet.getCleanliness());
        energy.setValue(pet.getEnergy());
        happiness.setValue(pet.getHappiness());
    }
}
