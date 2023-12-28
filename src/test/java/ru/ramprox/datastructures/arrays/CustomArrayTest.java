package ru.ramprox.datastructures.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomArrayTest {

    @Test
    public void add() {
        CustomArray customArray = new CustomArray(1);
        assertThat(customArray.toString()).isEqualTo("[]");
        customArray.add(1);
        assertThat(customArray.toString()).isEqualTo("[1]");
        customArray.add(2);
        assertThat(customArray.toString()).isEqualTo("[1]");

        customArray = new CustomArray(2);
        customArray.add(1);
        assertThat(customArray.toString()).isEqualTo("[1]");
        customArray.add(2);
        assertThat(customArray.toString()).isEqualTo("[1, 2]");
    }

    @Test
    public void contains() {
        CustomArray customArray = new CustomArray(2);
        customArray.add(1);
        customArray.add(2);

        assertThat(customArray.contains(1)).isTrue();
        assertThat(customArray.contains(2)).isTrue();
        assertThat(customArray.contains(3)).isFalse();
    }

    @Test
    public void delete() {
        CustomArray customArray = new CustomArray(3);
        customArray.add(1);
        customArray.add(1);
        customArray.add(2);

        assertThat(customArray.delete(1)).isTrue();
        assertThat(customArray.toString()).isEqualTo("[2]");
        assertThat(customArray.delete(3)).isFalse();
        assertThat(customArray.toString()).isEqualTo("[2]");
    }
}
