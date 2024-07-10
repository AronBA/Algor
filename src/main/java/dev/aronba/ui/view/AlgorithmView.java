package dev.aronba.ui.view;


import dev.aronba.algorithm.Algorithm;

import javax.swing.*;

public abstract class AlgorithmView extends JPanel {

    private Algorithm algorithm;


    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }
}
