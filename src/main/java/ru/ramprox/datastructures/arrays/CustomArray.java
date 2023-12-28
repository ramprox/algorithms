package ru.ramprox.datastructures.arrays;

/**
 * В массиве могут быть дубликаты
 */
public class CustomArray {

    private final long[] a;
    private int size;

    public CustomArray(int max) {
        a = new long[max];
    }

    // Вставка (добавление)
    // Сложность - O(1)
    public void add(long value) {
        if (size == a.length) {
            return;
        }
        a[size++] = value;
    }

    // Поиск
    // Сложность
    //      O(N / 2) - средняя
    //      O(N) - общая
    public boolean contains(long searchKey) {
        for(int i = 0; i < size; i++) {
            if (a[i] == searchKey) {
                return true;
            }
        }
        return false;
    }

    // Удаление
    // В среднем поиск занимает O(N / 2) и смещение O(N / 2). Поэтому в сумме O(N).
    public boolean delete(long value) {
        int oldSize = size;
        for (int i = 0; i < size; i++) {
            if (a[i] == value) {
                for (int j = i; j < size - 1; j++) {
                    a[j] = a[j + 1];
                }
                size--;
            }
        }
        return size != oldSize;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size - 1; i++) {
            builder.append(a[i]);
            builder.append(", ");
        }
        builder.append(a[size - 1]);
        return "[%s]".formatted(builder.toString());
    }
}
