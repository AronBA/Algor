package dev.aronba.ui.view;

import dev.aronba.algorithm.Algorithm;
import dev.aronba.algorithm.BubbleSort;
import dev.aronba.algorithm.InsertSort;
import dev.aronba.dto.Config;

import javax.swing.*;
import java.util.*;

public class ConfigView extends JPanel {

    private final JSpinner spinnerDelay;
    private final JSpinner spinnerDataSize;
    private final JSpinner spinnerDuplicateChance;
    private final JComboBox<Algorithm> algorithmDropdown;
    private final ButtonGroup buttonGroup;
    public JButton buttonRun;
    private JRadioButton randomData;
    private JRadioButton bestCase;
    private JRadioButton worstCase;

    ConfigView() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.buttonRun = new JButton("Run");
        this.spinnerDelay = new JSpinner();
        this.spinnerDelay.setModel(new SpinnerNumberModel(0, 0, 10000, 0.1));
        this.algorithmDropdown = new JComboBox<>();
        this.algorithmDropdown.setModel(new DefaultComboBoxModel<>(new Algorithm[]{new BubbleSort(), new InsertSort()}));

        this.spinnerDuplicateChance = new JSpinner();
        this.spinnerDuplicateChance.setModel(new SpinnerNumberModel(100, 1, 100, 10));

        this.spinnerDataSize = new JSpinner();
        this.spinnerDataSize.setModel(new SpinnerNumberModel(100, 1, 10000, 100));

        this.bestCase = new JRadioButton("sorted");
        this.worstCase = new JRadioButton("unsorted");
        this.randomData = new JRadioButton("random");
        randomData.setSelected(true);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(bestCase);
        buttonGroup.add(randomData);
        buttonGroup.add(worstCase);

        this.add(spinnerDuplicateChance);
        this.add(spinnerDataSize);
        this.add(bestCase);
        this.add(worstCase);
        this.add(randomData);
        this.add(algorithmDropdown);
        this.add(spinnerDelay);
        this.add(buttonRun);
    }

    private int[] generateNumbers(int length, int upperBound) {
        int[] numbers = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int number = random.nextInt(upperBound);
            numbers[i] = number;
        }
        return numbers;
    }

    private int[] generateSorted(int length, int upperBound) {
        int[] numbers = generateNumbers(length, upperBound);
        Arrays.sort(numbers);
        return numbers;
    }

    private int[] generateUnsorted(int length, int upperBound) {
        //todo -> make less ugly is possible
        int[] numbers = generateNumbers(length, upperBound);
        Arrays.sort(numbers);
        List<Integer> numbersList = new ArrayList<>(Arrays.stream(numbers).boxed().toList());
        Collections.reverse(numbersList);
        return numbersList.stream().mapToInt(i -> i).toArray();
    }


    public Config getConfig() {
        Config config = new Config();
        String number = String.valueOf(spinnerDelay.getValue());
        String numberString = String.valueOf(number);
        config.delayMs = Integer.parseInt(numberString.substring(0, numberString.indexOf(".")));
        config.delayNs = Integer.parseInt(numberString.substring(numberString.indexOf(".") + 1));
        config.algorithm = (Algorithm) algorithmDropdown.getSelectedItem();


        int p1 = (int) this.spinnerDataSize.getValue();
        int chancePercentage = (int) spinnerDuplicateChance.getValue();
        double chanceDecimal =  (double) chancePercentage / 100;
        int p2 = (int) (p1 * chanceDecimal);

        if (bestCase.isSelected()) {
            config.data = generateSorted(p1, p2);
        } else if (worstCase.isSelected()) {
            config.data = generateUnsorted(p1, p2);
        } else {
            config.data = generateNumbers(p1, p2);
        }

        return config;
    }

    public JButton getButtonRun() {
        return buttonRun;
    }
}
