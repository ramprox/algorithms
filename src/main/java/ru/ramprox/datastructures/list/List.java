package ru.ramprox.datastructures.list;

public interface List<T> {

    void addFirst(T item);

    void addLast(T item);

    void add(T item, int index);

    T getFirst();

    T getLast();

    T get(int index);

    void remove(int index);

}
