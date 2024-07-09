package dev.aronba.algorithm;

import dev.aronba.util.StopWatch;

public abstract class SortingAlgorithm extends Algorithm implements Sort {

    private int[] array;
    private final StopWatch stopWatch;

    SortingAlgorithm() {
        this.stopWatch = new StopWatch();
    }

    public void run(int[] input) {
        this.array = input;
        stopWatch.start();
        this.sort(input);
        stopWatch.stop();
    }
    public StopWatch getStopWatch() {
        return stopWatch;
    }
    public int[] getArray() {
        return array;
    }

}

