package app.repository;

import app.entity.IntArray;
import app.specification.Specification;
import app.observer.RepositoryObserver;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {

    IntArray add(int... values);

    List<IntArray> findBy(Specification<IntArray> specification);

    List<IntArray> sort(Comparator<IntArray> comparator);

    void updateValue(int id, int index, int value);

    void deleteById(int id);

    void setObserver(RepositoryObserver observer);
}