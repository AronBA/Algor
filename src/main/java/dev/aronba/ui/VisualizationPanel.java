package dev.aronba.ui;

import dev.aronba.algorithm.Algorithm;
import dev.aronba.util.RunConfig;

import javax.swing.*;
import java.awt.*;

public class VisualizationPanel extends JPanel {

    Algorithm algorithm;

    VisualizationPanel(Algorithm algorithm, RunConfig runConfig) {
        this.algorithm = algorithm;
        this.algorithm.setPanelReference(this);
        this.algorithm.setArray(runConfig.array());
        this.algorithm.setPauseMs(runConfig.delayInMs());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.setBackground(Color.BLACK);
        int width = this.getWidth();
        int height = this.getHeight();
        int barWidth = width / algorithm.getArray().length;

        for (int i = 0; i < algorithm.getArray().length; i++) {
            if (i == algorithm.getCurrentPosInArray()){
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.WHITE);
            }
            int barHeigth = (int) ((double) algorithm.getArray()[i] / getMax() * height);
            g.fillRect(i * barWidth, height - barHeigth, barWidth, barHeigth);
        }


    }
    private int getMax() {
        int max = Integer.MIN_VALUE;
        for (int value : algorithm.getArray()) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public void start() {
        this.algorithm.start();
    }
}
