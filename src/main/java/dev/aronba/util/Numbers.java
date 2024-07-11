package dev.aronba.util;

import java.util.Arrays;
import java.util.Random;

public final class Numbers {

    private final static Random random = new Random();

    private Numbers() {
    }


    public static int getAfterFloatingPoint(double number) {
        try {
            String numberString = String.valueOf(number);
            return Integer.parseInt(numberString.substring(0, numberString.indexOf(".")));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int getBeforeFloatingPoint(double number) {
        try {
            String numberString = String.valueOf(number);
            return Integer.parseInt(numberString.substring(numberString.indexOf(".") + 1));
        } catch (NumberFormatException e) {
            return 0;
        }
    }


    public static int[] getShuffledArray(ShuffleType shuffleType, int min, int max, int amount) {
        switch (shuffleType) {
            case RANDOM:
                return generateRandomNumbers(min, max, amount);
            case SORTED:
                return generateRandomSortedArray(min, max, amount);
            case REVERSED:
                return  generateRandomReversedArray(min, max, amount);
            default:
                return new int[amount];
        }
    }

    private static int[] generateRandomReversedArray(int min, int max, int amount){
        int[] array = generateRandomSortedArray(min, max, amount);
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return array;
    }


    private static int[] generateRandomSortedArray(int min, int max, int amount) {
        int[] array = generateRandomNumbers(min, max, amount);
        Arrays.sort(array);
        return array;
    }

    private static int[] generateRandomNumbers(int min, int max, int amount) {
        int[] numbers = new int[amount];
        for (int i = 0; i <= amount - 1; i++) {
            numbers[i] = random.nextInt(max - min) + min;
        }
        return numbers;
    }

}
