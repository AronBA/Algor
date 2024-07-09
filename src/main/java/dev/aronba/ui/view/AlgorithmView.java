package dev.aronba.ui.view;

import dev.aronba.algorithm.SortingAlgorithm;
import dev.aronba.dto.Config;

import javax.swing.*;
import java.awt.*;

public class AlgorithmView extends JPanel {

    SortingAlgorithm sortingAlgorithm;

    public void run(Config config) {
        int[] someData = config.data;
        this.sortingAlgorithm = (SortingAlgorithm) config.algorithm;
        this.sortingAlgorithm.setPanel(this);
        this.sortingAlgorithm.setDelayMs(config.delayMs);
        this.sortingAlgorithm.setDelayNs(config.delayNs);
        Thread thread = new Thread(() -> {
            sortingAlgorithm.run(someData);
        });
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (sortingAlgorithm == null) return;

        int[] array = this.sortingAlgorithm.getArray();
        this.setBackground(Color.BLACK);
        int width = this.getWidth();
        int height = this.getHeight();
        int barWidth = width / array.length;

        for (int i = 0; i < this.sortingAlgorithm.getArray().length; i++) {
            if (i == this.sortingAlgorithm.getCurrentPos()){
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.WHITE);
            }
            int barHeigth = (int) ((double) array[i] / getMax() * height);
            g.fillRect(i * barWidth, height - barHeigth, barWidth, barHeigth);
        }

    }

    private int getMax() {
        int max = Integer.MIN_VALUE;
        for (int value : sortingAlgorithm.getArray()) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
