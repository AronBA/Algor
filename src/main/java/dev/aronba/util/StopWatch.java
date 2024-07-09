package dev.aronba.util;

public class StopWatch {
    private long startTime;
    private long stopTime;
    private long elapsedTime;

    public void start() {
        this.reset();
        this.startTime = System.nanoTime();
    }
    public void stop() {
        this.stopTime = System.nanoTime();
        this.elapsedTime = this.stopTime - this.startTime;
    }
    public long getElapsedTimeInNs() {
        return this.elapsedTime;
    }
    public long getElapsedTimeInMs() {
        return getElapsedTimeInNs() / 1000000;
    }
    public long getElapsedTimeInS() {
        return getElapsedTimeInMs() / 1000;
    }
    public String getElapsedTimeInMsAsString(){
        return STR."\{getElapsedTimeInMs()} ms";
    }
    public void reset() {
        this.startTime = 0;
        this.stopTime = 0;
        this.elapsedTime = 0;
    }
}
