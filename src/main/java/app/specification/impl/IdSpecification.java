package app.specification.impl;

import app.entity.IntArray;
import app.specification.Specification;

public class IdSpecification implements Specification<IntArray> {

    private final int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean isSatisfiedBy(IntArray item) {
        return item.getId() == id;
    }
}