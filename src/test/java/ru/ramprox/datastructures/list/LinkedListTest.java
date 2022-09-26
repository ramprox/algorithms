package ru.ramprox.datastructures.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Unit тесты для LinkedList")
public class LinkedListTest {

    @DisplayName("Проверка состояния пустого списка")
    @Test
    public void checkEmptyLinkedList() {
        List<Integer> list = emptyLinkedList();
        assertThat(list.toString()).isEqualTo("[]");
    }

    @DisplayName("Проверка добавления в начало списка")
    @Test
    public void addFirstTest() {
        List<Integer> list = emptyLinkedList();
        list.addFirst(1);
        assertThat(list.toString()).isEqualTo("[1]");
        list.addFirst(2);
        assertThat(list.toString()).isEqualTo("[2, 1]");
        list.addFirst(3);
        assertThat(list.toString()).isEqualTo("[3, 2, 1]");
    }

    @DisplayName("Проверка добавления в конец списка")
    @Test
    public void addLastTest() {
        List<Integer> list = emptyLinkedList();
        list.addLast(1);
        assertThat(list.toString()).isEqualTo("[1]");
        list.addLast(2);
        assertThat(list.toString()).isEqualTo("[1, 2]");
        list.addLast(3);
        assertThat(list.toString()).isEqualTo("[1, 2, 3]");
    }

    @DisplayName("Проверка добавления элемента по индексу")
    @Test
    public void addByIndexTest() {
        List<Integer> list = emptyLinkedList();
        assertThrows(IllegalArgumentException.class, () -> list.add(1, -1));
        list.add(1, 0);
        assertThat(list.toString()).isEqualTo("[1]");
        list.add(2, 1);
        assertThat(list.toString()).isEqualTo("[1, 2]");
        list.add(3, 1);
        assertThat(list.toString()).isEqualTo("[1, 3, 2]");
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(4, 4));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(4, 5));
    }

    @DisplayName("Проверка извлечения первого элемента")
    @Test
    public void getFirstTest() {
        List<Integer> list = emptyLinkedList();
        assertThrows(NoSuchElementException.class, list::getFirst);
        list.addLast(1);
        Integer item = list.getFirst();
        assertThat(item).isEqualTo(1);
        list.addLast(2);
        item = list.getFirst();
        assertThat(item).isEqualTo(1);
        list.addFirst(3);
        item = list.getFirst();
        assertThat(item).isEqualTo(3);
    }

    @DisplayName("Извлечение последнего элемента")
    @Test
    public void getLastTest() {
        List<Integer> list = emptyLinkedList();
        assertThrows(NoSuchElementException.class, list::getFirst);
        list.addLast(1);
        Integer item = list.getLast();
        assertThat(item).isEqualTo(1);
        list.addLast(2);
        item = list.getLast();
        assertThat(item).isEqualTo(2);
        list.addFirst(3);
        item = list.getLast();
        assertThat(item).isEqualTo(2);
    }

    @DisplayName("Извлечение элемента по индексу")
    @Test
    public void getByIndexTest() {
        List<Integer> list = emptyLinkedList();
        assertThrows(IllegalArgumentException.class, () -> list.get(-1));
        assertThrows(NoSuchElementException.class, () -> list.get(0));
        assertThrows(NoSuchElementException.class, () -> list.get(1));
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(2);
        assertThat(list.get(2)).isEqualTo(3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(4));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
    }

    @DisplayName("Удаление по индексу")
    @Test
    public void removeByIndexTest() {
        List<Integer> list = emptyLinkedList();
        assertThrows(IllegalArgumentException.class, () -> list.remove(-1));
        assertThrows(NoSuchElementException.class, () -> list.remove(0));
        assertThrows(NoSuchElementException.class, () -> list.remove(1));
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.remove(0);
        assertThat(list.toString()).isEqualTo("[2, 3, 4, 5]");
        list.remove(3);
        assertThat(list.toString()).isEqualTo("[2, 3, 4]");
        list.remove(1);
        assertThat(list.toString()).isEqualTo("[2, 4]");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
    }

    @DisplayName("Проверка итератора для пустого списка")
    @Test
    public void emptyListIteratorTest() {
        List<Integer> list = emptyLinkedList();
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.hasNext()).isEqualTo(false);
        assertThrows(NoSuchElementException.class, iterator::next);
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @DisplayName("Проверка итератора для списка, имеющего элементы")
    @Test
    public void iteratorTest() {
        Integer[] expectedItems = new Integer[] { 1, 2, 3, 4, 5, 6 };
        List<Integer> list = createFilledList(expectedItems);
        Iterator<Integer> iterator = list.iterator();
        int counter = 0;
        while(iterator.hasNext()) {
            Integer item = iterator.next();
            assertThat(item).isEqualTo(expectedItems[counter]);
            counter++;
        }
        assertThat(counter).isEqualTo(expectedItems.length);
        assertThrows(NoSuchElementException.class, iterator::next);
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @DisplayName("Проверка цикла в стиле foreach")
    @Test
    public void foreachTest() {
        Integer[] expectedItems = new Integer[] { 1, 2, 3, 4, 5, 6 };
        List<Integer> list = createFilledList(expectedItems);
        int counter = 0;
        for(Integer item : list) {
            assertThat(item).isEqualTo(expectedItems[counter++]);
        }
        assertThat(counter).isEqualTo(expectedItems.length);
    }

    private List<Integer> emptyLinkedList() {
        return new LinkedList<>();
    }

    private List<Integer> createFilledList(Integer... items) {
        List<Integer> list = emptyLinkedList();
        for(Integer item : items) {
            list.addLast(item);
        }
        return list;
    }

}
