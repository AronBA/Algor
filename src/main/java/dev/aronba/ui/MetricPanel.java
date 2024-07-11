package dev.aronba.ui;

import dev.aronba.algorithm.Algorithm;
import dev.aronba.util.StopWatch;

import javax.swing.*;

public class MetricPanel extends JPanel {

    MetricPanel(Algorithm algorithm){

        this.add(new JLabel(algorithm.toString()));
        StopWatch stopWatch = new StopWatch();
        this.add(new JLabel(STR."Time:\{stopWatch.getElapsedTimeInMsAsString()}"));
    }
}
