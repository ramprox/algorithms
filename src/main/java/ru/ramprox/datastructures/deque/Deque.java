package ru.ramprox.datastructures.deque;

import ru.ramprox.datastructures.queue.Queue;

public interface Deque<T> extends Queue<T> {

    boolean addFirst(T item);

    boolean addLast(T item);

    T pollFirst();

    T pollLast();

    T peekFirst();

    T peekLast();

    @Override
    default boolean add(T item) {
        return addFirst(item);
    }

    @Override
    default T poll() {
        return pollFirst();
    }

    @Override
    default T peek() {
        return peekFirst();
    }
}
