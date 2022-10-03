package ru.ramprox.datastructures.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

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

}
