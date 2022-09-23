package ru.ramprox.algorithms.other;

public class FindMissedNumber {

    // Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1).
    // Но в массиве гарантированно 1 число пропущено. Необходимо вывести на экран пропущенное число.
    // Постарайтесь придумать более оптимальный (асимптотически) алгоритм. Примеры:
    //1. [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16] => 11
    //2. [1, 2, 4, 5, 6] => 3
    //3. [2, 3, 4, 5, 6, 7, 8] => 1
    //4. [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14] => 15
    //5. [] => 1

    public static int find(int[] array) {
        int lowerBound = 0;
        int upperBound = array.length - 1;
        while (lowerBound <= upperBound) {
            int middle = (upperBound + lowerBound) / 2;
            if(array[middle] != middle + 1) {
                upperBound = middle - 1;
            } else {
                lowerBound = middle + 1;
            }
        }
        return lowerBound + 1;
    }

}
