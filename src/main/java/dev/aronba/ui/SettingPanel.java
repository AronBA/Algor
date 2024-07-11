package dev.aronba.ui;

import dev.aronba.algorithm.Algorithm;
import dev.aronba.algorithm.BubbleSort;
import dev.aronba.algorithm.InsertSort;
import dev.aronba.algorithm.QuickSort;
import dev.aronba.util.Numbers;
import dev.aronba.util.RunConfig;
import dev.aronba.util.ShuffleType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SettingPanel extends JPanel {
    private final JComboBox<Algorithm> algorithmSelect;
    private final JSlider arraySize;
    private final JComboBox<ShuffleType> shuffleSelect;
    private final JButton visualize;
    private final JSpinner delay;

    SettingPanel(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        Font boldFont = new Font("Default", Font.BOLD, 12);
        Font tileFont= new Font("Default", Font.BOLD, 18);

        JLabel title = new JLabel("Settings");

        gbc.gridx = 0;
        gbc.gridy = 0;
        title.setFont(tileFont);
        this.add(title, gbc);

        JLabel algorithmLabel = new JLabel("Algorithm:");
        algorithmLabel.setFont(boldFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(algorithmLabel, gbc);

        this.algorithmSelect = new JComboBox<>(new Algorithm[]{new QuickSort(),new BubbleSort(), new InsertSort()});
        algorithmSelect.setSelectedIndex(0);
        gbc.gridx = 1;
        this.add(algorithmSelect, gbc);

        JLabel arraySizeLabel = new JLabel("Array size:");
        arraySizeLabel.setFont(boldFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(arraySizeLabel, gbc);

        this.arraySize = new JSlider(JSlider.HORIZONTAL, 0, 1000, 100);
        arraySize.setMajorTickSpacing(250);
        arraySize.setMinorTickSpacing(100);
        arraySize.setPaintTicks(true);
        arraySize.setPaintLabels(true);
        gbc.gridx = 1;
        this.add(arraySize, gbc);

        JLabel shuffleLabel = new JLabel("Shuffle type:");
        shuffleLabel.setFont(boldFont);
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(shuffleLabel, gbc);

        this.shuffleSelect = new JComboBox<>(ShuffleType.values());
        shuffleSelect.setSelectedIndex(0);
        gbc.gridx = 1;
        this.add(shuffleSelect, gbc);


        JLabel delayLabel = new JLabel("Delay in ms:");
        delayLabel.setFont(boldFont);
        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(delayLabel, gbc);

        this.delay = new JSpinner(new SpinnerNumberModel(0, 0, 10, 0.1));
        gbc.gridx = 1;
        this.add(delay, gbc);


        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        this.visualize = new JButton("Visualize");
        visualize.addActionListener(this::startVisualization);
        this.add(visualize, gbc);

    }

    private void startVisualization(ActionEvent actionEvent) {
        new VisualizationFrame((Algorithm) this.algorithmSelect.getSelectedItem(),getRunConfig());
    }

    private RunConfig getRunConfig() {
        return new RunConfig((double)delay.getValue(), Numbers.getShuffledArray((ShuffleType) shuffleSelect.getSelectedItem(),0,arraySize.getValue(),arraySize.getValue()));
    }

}
