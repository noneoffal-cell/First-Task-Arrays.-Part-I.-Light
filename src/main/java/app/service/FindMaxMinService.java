package app.service;

import app.entity.IntArray;

import java.util.OptionalInt;

public interface FindMaxMinService {

    OptionalInt findMax(IntArray array);

    OptionalInt findMin(IntArray array);

}
