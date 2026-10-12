package app.repository;

import app.entity.IntArray;
import app.specification.Specification;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface ArrayRepository {

    IntArray add(int... values);

    Optional<IntArray> findById(int id);

    List<IntArray> findByElements(int... values);

    List<IntArray> query(Specification<IntArray> specification);

    List<IntArray> sort(Comparator<IntArray> comparator);

    void updateValue(int id, int index, int value);

    void deleteById(int id);
}