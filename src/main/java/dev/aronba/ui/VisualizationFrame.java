package dev.aronba.ui;

import dev.aronba.algorithm.Algorithm;
import dev.aronba.util.RunConfig;

import javax.swing.*;
import java.awt.*;

public class VisualizationFrame extends JFrame {

    VisualizationPanel visualizationPanel;
     Algorithm algorithm;
    RunConfig config;
    VisualizationFrame(Algorithm algorithm, RunConfig runConfig){

        this.setLayout(new BorderLayout());
        this.config = runConfig;
        this.algorithm = algorithm;
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);
        this.visualizationPanel = new VisualizationPanel(algorithm,config);
        this.add(visualizationPanel,BorderLayout.CENTER);

        Thread t = new Thread(this::visualize);
        t.start();


    }

    private void visualize(){
        this.visualizationPanel.start();
    }

}
