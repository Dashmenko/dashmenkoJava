package task4;

import task4.sorts.BubbleSort;
import task4.sorts.GnomeSort;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void bubbleSortTest(int arraySize) {
        Integer[] arr = new Integer[arraySize];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = new Random().nextInt(arr.length);
        }

        System.out.println(Arrays.toString(arr));
        BubbleSort<Integer> bubbleSort = new BubbleSort<>(arr);
        bubbleSort.sort(new IntegerComparator());
        System.out.println(Arrays.toString(arr));
        System.out.println("Compare times: " + bubbleSort.getCompareCounter());
        System.out.println("Swap times: " + bubbleSort.getSwapCounter());
    }

    public static void gnomeSortTest(int arraySize) {
        Integer[] arr = new Integer[arraySize];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = new Random().nextInt(arr.length);
        }

        System.out.println(Arrays.toString(arr));
        GnomeSort<Integer> gnomeSort = new GnomeSort<>(arr);
        gnomeSort.sort(new IntegerComparator());
        System.out.println(Arrays.toString(arr));
        System.out.println("Compare times: " + gnomeSort.getCompareCounter());
        System.out.println("Swap times: " + gnomeSort.getSwapCounter());
    }

    public static void standardSortTest(int arraySize) {
        Integer[] arr = new Integer[arraySize];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = new Random().nextInt(arr.length);
        }
        IntegerComparator integerComparator = new IntegerComparator();
        Arrays.sort(arr, integerComparator);
        System.out.println("Compare times: "
                + integerComparator.getCompareCounter());
    }

    public static void main(String[] args) {
        System.out.println("Bubble sort:");
        bubbleSortTest(1000);
        System.out.println();

        System.out.println("Gnome sort:");
        gnomeSortTest(1000);
        System.out.println();

        System.out.println("Standard sort:");
        standardSortTest(1000);
    }
}
