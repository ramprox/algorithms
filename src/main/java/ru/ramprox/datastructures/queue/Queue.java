package ru.ramprox.datastructures.queue;

public interface Queue<T> {

    boolean add(T item);

    T poll();

    T peek();

    boolean isEmpty();

    boolean isFull();

    int size();

}
