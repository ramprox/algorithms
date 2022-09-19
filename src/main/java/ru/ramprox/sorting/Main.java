package ru.ramprox.sorting;

import ru.ramprox.sorting.model.Notebook;
import ru.ramprox.sorting.model.SortAlgorithm;
import ru.ramprox.sorting.util.NotebookComparator;
import ru.ramprox.sorting.util.NotebookGenerator;
import ru.ramprox.sorting.util.SortAlgorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static ru.ramprox.sorting.model.SortAlgorithm.create;

public class Main {
    public static void main(String[] args) {
        NotebookGenerator notebookGenerator = new NotebookGenerator();
        Comparator<Notebook> comparator = NotebookComparator.defaultComparator();

        List<SortAlgorithm<Notebook>> sortAlgorithms = List.of(
                create(SortAlgorithms::insertionSort, "Сортировка методом вставки"),
                create(SortAlgorithms::selectionSort, "Сортировка методом выбора"),
                create(Arrays::sort, "Стандартная Java сортировка")
        );

        int notebookCount = 10000;

        sortAlgorithms.forEach(sortAlgorithm ->
                sorting(sortAlgorithm, notebookGenerator.generate(notebookCount), comparator));

    }

    private static <T> void sorting(SortAlgorithm<T> sortAlgorithm, T[] array, Comparator<T> comparator) {
        System.out.printf("Вид сортировки: %s%n", sortAlgorithm.getName());
        long start = System.currentTimeMillis();
        sortAlgorithm.getSortMethod().accept(array, comparator);
        long end = System.currentTimeMillis();
        System.out.printf("Время сортировки = %d ms%n", end - start);
    }

}
