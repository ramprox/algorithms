package ru.ramprox.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Unit тесты для нахождения пропущенного числа")
public class FindMissedNumberTest {

    @DisplayName("Тест нахождения пропущенного числа")
    @ParameterizedTest
    @MethodSource("arguments")
    public void findMissedNumberTest(int[] array, int expected) {
        assertThat(FindMissedNumber.find(array)).isEqualTo(expected);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[] { 1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16 }, 11),
                Arguments.of(new int[] { 1, 2, 4, 5, 6 }, 3),
                Arguments.of(new int[] { 2, 3, 4, 5, 6, 7, 8 }, 1),
                Arguments.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 }, 15),
                Arguments.of(new int[] { }, 1)
        );
    }

}
