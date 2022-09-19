package ru.ramprox.sorting.model;

import java.util.Comparator;
import java.util.function.BiConsumer;

public class SortAlgorithm<T> {

    private final BiConsumer<T[], Comparator<T>> sortMethod;

    private final String name;

    private SortAlgorithm(BiConsumer<T[], Comparator<T>> sortMethod, String name) {
        this.sortMethod = sortMethod;
        this.name = name;
    }

    public static <T> SortAlgorithm<T> create(BiConsumer<T[], Comparator<T>> sortMethod, String name) {
        return new SortAlgorithm<>(sortMethod, name);
    }

    public BiConsumer<T[], Comparator<T>> getSortMethod() {
        return sortMethod;
    }

    public String getName() {
        return name;
    }

}
