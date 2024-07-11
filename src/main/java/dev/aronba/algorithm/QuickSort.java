package dev.aronba.algorithm;
public class QuickSort extends Algorithm {

    public void sort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);

            quickSort(data, low, pi - 1);
            quickSort(data, pi + 1, high);
        }
    }

    private int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (data[j] < pivot) {
                i++;

                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;

                this.increment(j); // <- important
            }
        }

        int temp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = temp;

        this.increment(high); // <- important
        return i + 1;
    }

    @Override
    public String toString() {
        return "QuickSort";
    }
}
