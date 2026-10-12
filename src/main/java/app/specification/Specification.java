package app.specification;

public interface Specification<T> {

    boolean isSatisfiedBy(T item);
}
