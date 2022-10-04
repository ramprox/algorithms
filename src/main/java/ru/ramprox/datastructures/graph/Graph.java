package ru.ramprox.datastructures.graph;

import java.util.function.Consumer;

public interface Graph {

    boolean addVertex(String label);

    boolean addEdge(String from, String to, int weight);

    /**
     * depth-first search
     */
    void dfs(String start, Consumer<String> visitor);

    /**
     * breadth-first search
     */
    void bfs(String start, Consumer<String> visitor);

}
