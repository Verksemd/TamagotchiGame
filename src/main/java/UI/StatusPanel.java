package UI;

import Logic.Pet;
import Logic.PetStat;
import java.awt.*;
import javax.swing.*;

public class StatusPanel extends JPanel {
    private JProgressBar fullness;

    private JProgressBar cleanliness;
    private JProgressBar energy;
    private JProgressBar happiness;

    private Font statusFont = new Font("Arial", Font.BOLD, 18);

    public StatusPanel(Pet pet) {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(Style.statusPanelBackgroundColor);

        fullness = new JProgressBar();
        fullness.setMinimum(PetStat.MIN_VALUE);
        fullness.setMaximum(PetStat.MAX_VALUE);

        cleanliness = new JProgressBar();
        cleanliness.setMinimum(PetStat.MIN_VALUE);
        cleanliness.setMaximum(PetStat.MAX_VALUE);

        happiness = new JProgressBar();
        happiness.setMinimum(PetStat.MIN_VALUE);
        happiness.setMaximum(PetStat.MAX_VALUE);

        energy = new JProgressBar();
        energy.setMinimum(PetStat.MIN_VALUE);
        energy.setMaximum(PetStat.MAX_VALUE);

        JPanel hungerPanel = new JPanel();
        hungerPanel.setLayout(new BoxLayout(hungerPanel, BoxLayout.Y_AXIS));
        JLabel hungerLabel = new JLabel("Fullness");
        hungerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        hungerLabel.setFont(statusFont);
        hungerLabel.setForeground(Style.statusPanelForegroundColor);
        fullness.setAlignmentX(Component.CENTER_ALIGNMENT);
        hungerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        hungerPanel.setBackground(Style.statusPanelBackgroundColor);
        hungerPanel.add(hungerLabel);
        hungerPanel.add(fullness);

        JPanel thirstPanel = new JPanel();
        thirstPanel.setLayout(new BoxLayout(thirstPanel, BoxLayout.Y_AXIS));
        JLabel thirstLabel = new JLabel("Cleanliness");
        thirstLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        thirstLabel.setFont(statusFont);
        thirstLabel.setForeground(Style.statusPanelForegroundColor);
        cleanliness.setAlignmentX(Component.CENTER_ALIGNMENT);
        thirstPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        thirstPanel.setBackground(Style.statusPanelBackgroundColor);
        thirstPanel.add(thirstLabel);
        thirstPanel.add(cleanliness);

        JPanel happinessPanel = new JPanel();
        happinessPanel.setLayout(new BoxLayout(happinessPanel, BoxLayout.Y_AXIS));
        JLabel happinessLabel = new JLabel("Happiness");
        happinessLabel.setFont(statusFont);
        happinessLabel.setForeground(Style.statusPanelForegroundColor);
        happinessLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        happiness.setAlignmentX(Component.CENTER_ALIGNMENT);
        happinessPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        happinessPanel.setBackground(Style.statusPanelBackgroundColor);
        happinessPanel.add(happinessLabel);
        happinessPanel.add(happiness);

        JPanel energyPanel = new JPanel();
        energyPanel.setLayout(new BoxLayout(energyPanel, BoxLayout.Y_AXIS));
        JLabel energyLabel = new JLabel("Energy");
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

    public void updateState(Pet pet) {
        fullness.setValue(pet.getFullness());
        cleanliness.setValue(pet.getCleanliness());
        energy.setValue(pet.getEnergy());
        happiness.setValue(pet.getHappiness());
    }
}
