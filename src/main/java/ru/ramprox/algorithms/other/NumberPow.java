package ru.ramprox.algorithms.other;

public class NumberPow {

    public static long pow(long x, long n) {
        if(n < 0) {
            String message = String.format("n = %d. n должен быть больше или равно 0", n);
            throw new IllegalArgumentException(message);
        }
        if(n == 0) {
            return 1;
        }
        return recursivePow(x, n);
    }

    private static long recursivePow(long x, long n) {
        if(n == 1) {
            return x;
        }
        long result = recursivePow(x * x, n / 2);
        if(n % 2 == 1) {
            result *= x;
        }
        return result;
    }

}
