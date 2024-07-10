package dev.aronba.algorithm;

import dev.aronba.dto.AlgorithmRunConfig;

import javax.swing.*;

public abstract class Algorithm {


    private int delayMs = 1;
    private int delayNs = 0;
    private JPanel panel;
    private int currentPos = 0;

    public void run(AlgorithmRunConfig algorithmRunConfig){
        this.delayMs = algorithmRunConfig.delayMs;
        this.delayNs = algorithmRunConfig.delayNs;
        this.run(algorithmRunConfig.data);
    };
    protected abstract void run(Object object);

    protected void updateAlgorithmView(int currentPos) {
        this.currentPos = currentPos;
        this.panel.repaint();
        pauseAlgorithm();
    }

    private void pauseAlgorithm() {
        try {
            Thread.sleep(delayMs,delayNs);
        } catch (InterruptedException _) {
        }
    }

    public void setDelayMs(int delay) {
        this.delayMs = delay;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void setDelayNs(int delayNs) {
        this.delayNs = delayNs;
    }
}
