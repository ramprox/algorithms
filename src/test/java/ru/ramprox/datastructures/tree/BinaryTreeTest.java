package ru.ramprox.datastructures.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    private BinaryTree<Integer> createTree() {
        return new BinaryTree<>();
    }

    @Test
    void testAddAndContains() {
        BinaryTree<Integer> tree = createTree();
        assertFalse(tree.contains(5));
        tree.add(5);
        assertTrue(tree.contains(5));

        tree.add(3);
        tree.add(4);
        tree.add(9);
        tree.add(8);

        assertTrue(tree.contains(3));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(9));
        assertTrue(tree.contains(8));
    }

    @Test
    void remove() {
        BinaryTree<Integer> tree = createTree();
        tree.add(5);
        assertTrue(tree.contains(5));

        tree.remove(5);
        assertFalse(tree.contains(5));

        tree = createTree();
        tree.add(8);
        tree.add(4);
        tree.add(6);
        tree.add(3);
        tree.add(1);
        tree.add(2);
        tree.add(1);
        tree.add(1);
        tree.add(1);

        tree.remove(8);

        assertFalse(tree.contains(8));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(1));
    }

    @Test
    void testDfs() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(8);
        tree.add(3);
        tree.add(1);
        tree.add(6);
        tree.add(4);
        tree.add(7);
        tree.add(10);
        tree.add(14);
        tree.add(13);

        Queue<Integer> queue = new ArrayDeque<>();
        tree.dfs(queue::add);

        assertEquals(9, queue.size());

        assertEquals(1, queue.poll());
        assertEquals(3, queue.poll());
        assertEquals(4, queue.poll());
        assertEquals(6, queue.poll());
        assertEquals(7, queue.poll());
        assertEquals(8, queue.poll());
        assertEquals(10, queue.poll());
        assertEquals(13, queue.poll());
        assertEquals(14, queue.poll());
        assertNull(queue.poll());
    }

    @Test
    void testBfs() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(8);
        tree.add(3);
        tree.add(1);
        tree.add(6);
        tree.add(4);
        tree.add(7);
        tree.add(10);
        tree.add(14);
        tree.add(13);

        Queue<Integer> queue = new ArrayDeque<>();
        tree.bfs(queue::add);

        assertEquals(9, queue.size());

        assertEquals(8, queue.poll());
        assertEquals(3, queue.poll());
        assertEquals(10, queue.poll());
        assertEquals(1, queue.poll());
        assertEquals(6, queue.poll());
        assertEquals(14, queue.poll());
        assertEquals(4, queue.poll());
        assertEquals(7, queue.poll());
        assertEquals(13, queue.poll());
        assertNull(queue.poll());
    }

    @DisplayName("Проверка сбалансировано ли дерево")
    @ParameterizedTest
    @MethodSource("isBalancedArgs")
    public void isBalancedTest(List<Integer> items, boolean expectedResult) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        items.forEach(tree::add);
        assertThat(tree.isBalanced()).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> isBalancedArgs() {
        return Stream.of(
                Arguments.of(List.of(8, 3, 1, 6, 4, 7, 10, 14, 13), false),
                Arguments.of(List.of(8, 3, 1, 6, 4, 7, 10, 14, 13, 9), true),
                Arguments.of(List.of(8, 3, 1, 6, 4, 7, 10, 14, 13, 9, 15, 16), false),
                Arguments.of(List.of(8, 3, 1, 6, 4, 7, 10, 14, 13), false),
                Arguments.of(List.of(8, 3, 1, 6, 4, 7, 10, 11, 9), true)
        );
    }

}
