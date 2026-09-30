package main.service;

import main.entity.IntArray;

import java.util.Optional;

public class FindMinImpl implements FindMinService {

    @Override
    public Optional<Integer> findMin(IntArray array) {
        int[] values = array.getArray();

        if (values.length == 0) {
            return Optional.empty();
        }

        int min = values[0];

        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }

        return Optional.of(min);
    }
}
