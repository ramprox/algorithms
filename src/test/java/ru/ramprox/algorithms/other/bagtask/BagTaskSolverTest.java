package ru.ramprox.algorithms.other.bagtask;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Unit тесты BagProblemResolver")
public class BagTaskSolverTest {

    @DisplayName("Решение задачи о рюкзаке")
    @ParameterizedTest
    @MethodSource("args")
    public void resolveTest(List<Thing> things, Bag bag, List<Thing> expected) {
        assertThat(BagTaskSolver.solve(things, bag))
                .containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(List.of(), bag(10), List.of()),

                Arguments.of(
                        List.of(thing(9, 11),
                                thing(9, 11),
                                thing(7, 11)),
                        bag(10),
                        List.of()),

                Arguments.of(
                        List.of(thing(9, 11),
                                thing(9, 9),
                                thing(7, 11)),
                        bag(10),
                        List.of(thing(9, 9))),

                Arguments.of(
                        List.of(thing(6, 4),
                                thing(4, 3),
                                thing(9, 10)),
                        bag(10),
                        List.of(thing(6, 4),
                                thing(4, 3))),

                Arguments.of(
                        List.of(
                                thing(9, 7),
                                thing(9, 4),
                                thing(7, 7),
                                thing(7, 5),
                                thing(5, 2),
                                thing(5, 1)
                        ),
                        bag(10),
                        List.of(
                                thing(9, 4),
                                thing(7, 5),
                                thing(5, 1)))
        );
    }

    private static Bag bag(int maxP) {
        return new Bag(maxP);
    }

    private static Thing thing(int q, int p) {
        return new Thing(q, p);
    }

}
