package main.service;

import main.entity.IntArray;

import java.util.Optional;

public interface FindMaxService {

    Optional<Integer> findMax(IntArray array);
}
