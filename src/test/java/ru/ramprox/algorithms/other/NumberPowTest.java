package ru.ramprox.algorithms.other;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Unit тесты NumberPow")
public class NumberPowTest {

    @DisplayName("Возведение числа в степень")
    @ParameterizedTest
    @MethodSource("args")
    public void powTest(long x, long n, long expected) {
        assertThat(NumberPow.pow(x, n)).isEqualTo(expected);
    }

    @DisplayName("Генерирование исключения при n < 0")
    @Test
    public void powThrowExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> NumberPow.pow(2, -1));
    }

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(0, 0, 1),
                Arguments.of(2, 0, 1),
                Arguments.of(2, 4, 16),
                Arguments.of(2, 9, 512),
                Arguments.of(-2, 9, -512),
                Arguments.of(3, 12, 531441),
                Arguments.of(-3, 12, 531441),
                Arguments.of(2, 15, 32768),
                Arguments.of(2, 18, 262144),
                Arguments.of(2, 27, 134217728),
                Arguments.of(2, 31, 2147483648L)
        );
    }

}
