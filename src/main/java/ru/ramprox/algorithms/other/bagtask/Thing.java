package ru.ramprox.algorithms.other.bagtask;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Thing implements Comparable<Thing> {

    private int q;

    private int p;

    @Override
    public int compareTo(Thing o) {
        return q - o.q;
    }

    @Override
    public String toString() {
        return String.format("[q = %d, p = %d]", q, p);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thing thing = (Thing) o;
        return q == thing.q && p == thing.p;
    }

    @Override
    public int hashCode() {
        return Objects.hash(q, p);
    }
}
