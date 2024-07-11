package dev.aronba.util;

public enum ShuffleType {
    RANDOM,
    SORTED,
    REVERSED;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
