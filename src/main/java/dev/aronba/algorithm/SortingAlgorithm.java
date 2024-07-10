package dev.aronba.algorithm;

import dev.aronba.util.StopWatch;


public abstract class SortingAlgorithm extends Algorithm implements Sort {

    private final StopWatch stopWatch;
    private int[] array;

    SortingAlgorithm() {
        this.stopWatch = new StopWatch();
    }

    public void run(Object object) {
        int[] input = (int[]) object;
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

