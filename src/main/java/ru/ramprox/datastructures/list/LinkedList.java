package ru.ramprox.datastructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {

    private Node<T> head;

    @Override
    public void addFirst(T item) {
        head = new Node<>(item, head);
    }

    @Override
    public void addLast(T item) {
        if(head == null) {
            addFirst(item);
            return;
        }
        Node<T> lastNode = getLastNode();
        lastNode.next = new Node<>(item);;
    }

    @Override
    public void add(T item, int index) {
        checkIndex(index);
        if(index == 0) {
            head = new Node<>(item);
            return;
        }
        Node<T> prevNode = getNode(index - 1);
        prevNode.next = new Node<>(item, prevNode.next);
    }

    @Override
    public T getFirst() {
        checkIsEmpty();
        return head.data;
    }

    @Override
    public T getLast() {
        checkIsEmpty();
        return getLastNode().data;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        checkIsEmpty();
        return getNode(index).data;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        checkIsEmpty();
        if(index == 0) {
            head = head.next;
            return;
        }
        Node<T> prevNode = getNode(index - 1);
        checkIsNextNull(prevNode, index);
        prevNode.next = prevNode.next.next;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(head);
    }

    @Override
    public String toString() {
        String format = "[%s]";
        StringBuilder content = new StringBuilder();
        if(head != null) {
            content.append(head.data);
            Node<T> current = head.next;
            while(current != null) {
                content.append(", ").append(current.data);
                current = current.next;
            }
        }
        return String.format(format, content);
    }

    private Node<T> getNode(int index) {
        int counter = 0;
        Node<T> current = head;
        while(counter != index) {
            checkIsNextNull(current, index);
            current = current.next;
            counter++;
        }
        return current;
    }

    private void checkIndex(int index) {
        if(index < 0) {
            throw new IllegalArgumentException(String.format("Index %d must not be less 0", index));
        }
    }

    private void checkIsEmpty() {
        if(head == null) {
            throw new NoSuchElementException("List is empty");
        }
    }

    private void checkIsNextNull(Node<T> node, int index) {
        if(node.next == null) {
            throw new IndexOutOfBoundsException(String.format("Item with index %d not exist", index));
        }
    }

    private Node<T> getLastNode() {
        Node<T> current = head;
        while(current.next != null) {
            current = current.next;
        }
        return current;
    }

    private static class Node<T> {

        private Node<T> next;

        private T data;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this(data);
            this.next = next;
        }

    }

    private static class LinkedListIterator<T> implements Iterator<T> {

        private Node<T> current;

        public LinkedListIterator(Node<T> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if(current == null) {
                throw new NoSuchElementException("");
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }

}
