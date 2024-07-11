package dev.aronba.algorithm;

public class BubbleSort extends Algorithm {


    public void sort(int[] data) {
        int n = data.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swapped = true;

                    this.increment(j + 1); // <- important
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "BubbleSort";
    }
}