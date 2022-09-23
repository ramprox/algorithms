package ru.ramprox.algorithms.sorting.util;

import ru.ramprox.algorithms.sorting.model.Notebook;

import java.util.Comparator;

public class NotebookComparator implements Comparator<Notebook> {

    @Override
    public int compare(Notebook notebook1, Notebook notebook2) {
        return Double.compare(notebook1.getPrice(), notebook2.getPrice());
    }

    public static Comparator<Notebook> defaultComparator() {
        return new NotebookComparator()
                .thenComparing(Notebook::getRam)
                .thenComparing(Notebook::getBrand);
    }

}
