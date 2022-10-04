package ru.ramprox.datastructures.graph;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class GraphImpl implements Graph {

    private final List<String> vertexes = new ArrayList<>();
    private final List<List<Boolean>> adjMatrix = new ArrayList<>();

    @Override
    public boolean addVertex(String label) {
        Objects.requireNonNull(label);

        if (indexOf(label) >= 0) {
            return false;
        }

        vertexes.add(label);

        for (List<Boolean> row : adjMatrix) {
            row.add(false);
        }

        int size = vertexes.size();
        List<Boolean> newRow = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            newRow.add(false);
        }

        adjMatrix.add(newRow);

        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexes.size(); i++) {
            if (label.equals(vertexes.get(i))) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean addEdge(String from, String to) {
        Objects.requireNonNull(from);
        Objects.requireNonNull(to);

        int indexOfFrom = indexOf(from);
        int indexOfTo = indexOf(to);

        if (indexOfFrom == -1 || indexOfTo == -1) {
            return false;
        }

        if (indexOfFrom == indexOfTo) {
            return false;
        }

        List<Boolean> fromEdges = adjMatrix.get(indexOfFrom);
        fromEdges.set(indexOfTo, true);

        // Если хотим двунаправленные пути
//        List<Boolean> toEdges = adjMatrix.get(indexOfTo);
//        toEdges.set(indexOfFrom, true);

        return true;
    }

    @Override
    public void dfs(String start, Consumer<String> visitor) {
        Objects.requireNonNull(start);
        dfs(start, new HashSet<>(), visitor);
    }

    private void dfs(String current, Set<String> visited, Consumer<String> visitor) {
        if (visited.contains(current)) {
            return;
        }

        visitor.accept(current);
        visited.add(current);

        List<String> siblings = getSibling(current);
        for (String sibling : siblings) {
            dfs(sibling, visited, visitor);
        }
    }

    @Override
    public void bfs(String start, Consumer<String> visitor) {
        Objects.requireNonNull(start);

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String next = queue.poll();
            visitor.accept(next);

            List<String> siblings = getSibling(next);
            for (String sibling : siblings) {
                if (visited.add(sibling)) {
                    queue.add(sibling);
                }
            }
        }
    }

    private List<String> getSibling(String label) {
        int indexOfLabel = indexOf(label);
        List<Boolean> labelRow = adjMatrix.get(indexOfLabel);

        List<String> siblings = new ArrayList<>();
        for (int i = 0; i < labelRow.size(); i++) {
            if (labelRow.get(i)) {
                String sibling = vertexes.get(i);
                siblings.add(sibling);
            }
        }

        return siblings;
    }

    @Override
    public String toString() {
        StringBuilder adjMatrixString = new StringBuilder();

        for (List<Boolean> row : adjMatrix) {
            String routes = row.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
            adjMatrixString.append(routes).append("\n");
        }

        if (adjMatrixString.length() > 0) {
            adjMatrixString.deleteCharAt(adjMatrixString.length() - 1);
        }

        return adjMatrixString.toString();
    }

}
