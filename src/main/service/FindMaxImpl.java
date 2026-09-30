package main.service;

import main.entity.IntArray;

import java.util.Optional;

public class FindMaxImpl implements FindMaxService {

    @Override
    public Optional<Integer> findMax(IntArray array) {
        int[] values = array.getArray();

        if (values.length == 0) {
            return Optional.empty();
        }

        int max = values[0];

        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }

        return Optional.of(max);
    }
}
