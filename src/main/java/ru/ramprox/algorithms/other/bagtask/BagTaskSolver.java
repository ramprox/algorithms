package ru.ramprox.algorithms.other.bagtask;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BagTaskSolver {

    public static List<Thing> solve(List<Thing> things, Bag bag) {
        List<Thing> sortedThings = new ArrayList<>(things);
        sortedThings.sort(Comparator.comparing(Thing::getQ)
                .thenComparing(Thing::getP).reversed());
        return recursiveSolve(sortedThings, bag.getMaxP());
    }

    private static List<Thing> recursiveSolve(List<Thing> things, int maxP) {
        if(things.size() == 0) {
            return things;
        }
        List<Thing> subList = things.subList(1, things.size());
        List<Thing> subListResult = recursiveSolve(subList, maxP);
        Thing firstThing = things.get(0);
        int curMaxP = maxP - firstThing.getP();
        if(curMaxP < 0) {
            return subListResult;
        }
        List<Thing> resultWithFirstThing = new ArrayList<>();
        resultWithFirstThing.add(firstThing);
        resultWithFirstThing.addAll(recursiveSolve(subList, curMaxP));
        return sumQ(resultWithFirstThing) > sumQ(subListResult) ? resultWithFirstThing : subListResult;
    }

    private static int sumQ(List<Thing> things) {
        return things.stream()
                .mapToInt(Thing::getQ)
                .sum();
    }

}
