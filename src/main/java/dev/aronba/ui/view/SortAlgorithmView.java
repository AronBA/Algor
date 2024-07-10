package dev.aronba.ui.view;

import dev.aronba.algorithm.SortingAlgorithm;

import java.awt.*;

public class SortAlgorithmView extends AlgorithmView {

    SortingAlgorithm sortingAlgorithm;


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this. super.getAlgorithm();

        this.setBackground(Color.BLACK);
        int width = this.getWidth();
        int height = this.getHeight();
        int barWidth = width / sortingAlgorithm.getArray().length;

        for (int i = 0; i < sortingAlgorithm.getArray().length; i++) {
            if (i == sortingAlgorithm.getCurrentPos()){
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.WHITE);
            }
            int barHeigth = (int) ((double) sortingAlgorithm.getArray()[i] / getMax() * height);
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
