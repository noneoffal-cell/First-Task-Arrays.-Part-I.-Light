package app.factory;

public interface ArrayFactory<T> {

    T create(int id, int... values);
}