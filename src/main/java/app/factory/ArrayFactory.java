package app.factory;

public interface ArrayFactory<T> {

    T create(int... values);
}
