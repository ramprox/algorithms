package ru.ramprox.algorithms.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ramprox.algorithms.sorting.model.Notebook;
import ru.ramprox.algorithms.sorting.model.SortAlgorithm;
import ru.ramprox.algorithms.sorting.util.NotebookComparator;
import ru.ramprox.algorithms.sorting.util.NotebookGenerator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static ru.ramprox.algorithms.sorting.model.SortAlgorithm.create;

@DisplayName("Unit тесты алгоритмов сортировок")
public class GenericAlgorithmsTest {

    @Test
    public void checkAlgorithms() {
        NotebookGenerator notebookGenerator = new NotebookGenerator();
        Comparator<Notebook> comparator = NotebookComparator.defaultComparator();

        List<SortAlgorithm<Notebook>> sortAlgorithms = List.of(
                create(GenericAlgorithms::bubbleSort, "Пузырьковая сортировка"),
                create(GenericAlgorithms::insertionSort, "Сортировка методом вставки"),
                create(GenericAlgorithms::selectionSort, "Сортировка методом выбора"),
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
