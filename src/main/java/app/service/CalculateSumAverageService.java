package app.service;

import app.entity.IntArray;

import java.util.OptionalDouble;
import java.util.OptionalLong;

public interface CalculateSumAverageService {

    OptionalLong calculateSum(IntArray array);

    OptionalDouble calculateAverage(IntArray array);

}
