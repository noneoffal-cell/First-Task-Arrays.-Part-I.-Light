package main.factory;

public interface ArrayFactory<T> {

    T create(int... values);
}
