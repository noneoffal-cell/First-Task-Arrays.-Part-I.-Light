package main.service;

import main.entity.IntArray;

import java.util.Optional;

public class CalculateAverageImpl implements CalculateAverage {

    @Override
    public Optional<Double> calculateAverage(IntArray array) {
        int[] values = array.getArray();

        if (values.length == 0) {
            return Optional.empty();
        }

        long sum = 0;

        for (int value : values) {
            sum += value;
        }

        double average = (double) sum / values.length;

        return Optional.of(average);
    }
}
