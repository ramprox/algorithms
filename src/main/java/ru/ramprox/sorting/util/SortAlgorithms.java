package ru.ramprox.sorting.util;

import java.util.Comparator;

public class SortAlgorithms {

    public static <T> void selectionSort(T[] array, Comparator<T> comparator) {
        for(int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < array.length; j++) {
                if(comparator.compare(array[j], array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static <T> void insertionSort(T[] array, Comparator<T> comparator) {
        for(int i = 1; i < array.length; i++) {
            int minIndex = i;
            T temp = array[minIndex];
            while (minIndex > 0 && comparator.compare(array[minIndex - 1], temp) > 0) {
                array[minIndex] = array[minIndex - 1];
                minIndex--;
            }
            array[minIndex] = temp;
        }
    }

}
