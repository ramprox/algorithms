package ru.ramprox.algorithms.sorting.util;

import ru.ramprox.algorithms.sorting.model.Brand;
import ru.ramprox.algorithms.sorting.model.Notebook;

import java.util.Random;

public class NotebookGenerator {

    private static final double[] prices = new double[] {100, 200, 300, 400, 500, 600, 700};

    private static final int[] rams = new int[] {4, 8, 16, 20, 24};

    private static final Brand[] brands = Brand.values();

    private final Random random = new Random();

    public Notebook[] generate(int count) {
        Notebook[] notebooks = new Notebook[count];
        for(int i = 0; i < notebooks.length; i++) {
            notebooks[i] = create();
        }
        return notebooks;
    }

    public Notebook create() {
        double price = prices[random.nextInt(prices.length)];
        int ram = rams[random.nextInt(rams.length)];
        Brand brand = brands[random.nextInt(brands.length)];
        return new Notebook(price, ram, brand);
    }

}
