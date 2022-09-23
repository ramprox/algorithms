package ru.ramprox.datastructures.deque;

// Реализовать двунаправленную очередь (чтобы элементы можно было добавлять и удалять не только
// в начало (из начала), но и в конец (с конца))

public class ArrayDeque<T> implements Deque<T> {

    private final Object[] items;

    private int head = 0;

    private int tail = -1;

    private int size;

    public ArrayDeque(int size) {
        this.items = new Object[size];
    }

    @Override
    public boolean addFirst(T item) {
        if(isFull()) {
           return false;
        }
        if(head == 0) {
            head = items.length;
        }
        items[--head] = item;
        size++;
        return true;
    }

    @Override
    public boolean addLast(T item) {
        if(isFull()) {
            return false;
        }
        if(tail == items.length - 1) {
            tail = -1;
        }
        items[++tail] = item;
        size++;
        return true;
    }

    @Override
    public T pollFirst() {
        if(isEmpty()) {
            return null;
        }
        T item = (T)items[head];
        items[head] = null;
        if(++head == items.length) {
            head = 0;
        }
        size--;
        return item;
    }

    @Override
    public T pollLast() {
        if(isEmpty()) {
            return null;
        }
        if(tail == -1) {
            tail = items.length - 1;
        }
        T item = (T)items[tail];
        items[tail--] = null;
        size--;
        return item;
    }

    @Override
    public T peekFirst() {
        if(isEmpty()) {
            return null;
        }
        return (T)items[head];
    }

    @Override
    public T peekLast() {
        if(isEmpty()) {
            return null;
        }
        return (T)items[tail];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == items.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String format = "[%s]";
        StringBuilder content = new StringBuilder();
        for(int i = 0, index = head; i < size; i++, index++) {
            if(index == items.length) {
                index = 0;
            }
            content.append(items[index]);
            if(i != size - 1) {
                content.append(", ");
            }
        }
        return String.format(format, content);
    }
}
