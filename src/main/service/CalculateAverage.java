package main.service;

import main.entity.IntArray;

import java.util.Optional;

public interface CalculateAverage {

    Optional<Double> calculateAverage(IntArray array);

}
