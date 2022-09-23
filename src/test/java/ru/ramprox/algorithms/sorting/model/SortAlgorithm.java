package ru.ramprox.algorithms.sorting.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;
import java.util.function.BiConsumer;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SortAlgorithm<T> {

    private final BiConsumer<T[], Comparator<T>> sortMethod;

    private final String name;

    public static <T> SortAlgorithm<T> create(BiConsumer<T[], Comparator<T>> sortMethod, String name) {
        return new SortAlgorithm<>(sortMethod, name);
    }

}
