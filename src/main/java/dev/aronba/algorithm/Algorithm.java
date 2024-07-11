package dev.aronba.algorithm;

import dev.aronba.util.Numbers;
import dev.aronba.util.StopWatch;

import javax.swing.*;

public abstract class Algorithm {

    private int[] array;
    private int currentPosInArray;
    private double pauseMs = 1.000;
    private JPanel panelReference;
    private StopWatch stopWatch;

    public void start() {
        this.stopWatch = new StopWatch();
        stopWatch.start();
        sort(this.array);
        stopWatch.stop();
    }

    public abstract void sort(int[] array);

    protected void increment(int currentPosInArray) {
        this.currentPosInArray = currentPosInArray;
        panelReference.repaint();
        pauseExecution();
    }

    private void pauseExecution() {
        int ms = Numbers.getBeforeFloatingPoint(this.pauseMs);
        int ns = Numbers.getAfterFloatingPoint(this.pauseMs);
        try {
            Thread.sleep(ms, ns);
        } catch (InterruptedException _) {
        }
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getCurrentPosInArray() {
        return currentPosInArray;
    }


    public void setPauseMs(double pauseMs) {
        this.pauseMs = pauseMs;
    }


    public void setPanelReference(JPanel panelReference) {
        this.panelReference = panelReference;
    }


    public StopWatch getStopWatch() {
        return this.stopWatch;
    }
}
