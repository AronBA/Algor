package dev.aronba.ui.controller;

import dev.aronba.algorithm.Algorithm;
import dev.aronba.dto.AlgorithmRunConfig;
import dev.aronba.ui.view.AlgorithmView;

public class AlgorithmController {

    private Algorithm algorithm;

    private final AlgorithmView view;

    public AlgorithmController(AlgorithmView view) {
        this.view = view;
    }

    public void startVisualization(AlgorithmRunConfig algorithmRunConfig) {
        this.algorithm = algorithmRunConfig.algorithm;
        this.algorithm.setPanel(view);
        this.view.repaint();
        System.out.println("start");
        Thread thread = new Thread(() -> algorithm.run(algorithmRunConfig));
        thread.start();
    }


    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public AlgorithmView getView() {
        return view;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
}
