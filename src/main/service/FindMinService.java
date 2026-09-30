package main.service;

import main.entity.IntArray;

import java.util.Optional;

public interface FindMinService {

    Optional<Integer> findMin(IntArray array);

}
