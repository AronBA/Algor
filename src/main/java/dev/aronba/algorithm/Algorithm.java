package dev.aronba.algorithm;

import javax.swing.*;

public abstract class Algorithm {

    private int delayMs = 1;
    private int delayNs = 0;
    private JPanel panel;
    private int currentPos = 0;


    protected void update(int currentPos) {
        this.currentPos = currentPos;
        repaint();
        pause();
    }

    private void pause() {
        try {
            Thread.sleep(delayMs,delayNs);
        } catch (InterruptedException _) {
        }
    }

    private void repaint() {
        this.panel.repaint();
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
