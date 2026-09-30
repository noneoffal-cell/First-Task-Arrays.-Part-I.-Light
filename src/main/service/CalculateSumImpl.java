package main.service;

import main.entity.IntArray;

import java.util.Optional;

public class CalculateSumImpl implements CalculateSum {

    @Override
    public Optional<Integer> calculateSum(IntArray array) {
        int[] values = array.getArray();

        if (values.length == 0) {
            return Optional.empty();
        }

        int sum = 0;

        for (int value : values) {
            sum += value;
        }

        return Optional.of(sum);
    }
}
