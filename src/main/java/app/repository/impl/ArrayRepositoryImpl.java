package app.repository.impl;

import app.entity.IntArray;
import app.factory.ArrayFactory;
import app.factory.impl.IntArrayFactory;
import app.repository.ArrayRepository;
import app.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import app.observer.RepositoryObserver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayRepositoryImpl implements ArrayRepository {

    private static final Logger LOGGER =
            LogManager.getLogger(ArrayRepositoryImpl.class);

    private static ArrayRepositoryImpl instance;

    private final List<IntArray> arrays;
    private final ArrayFactory<IntArray> factory;
    private int nextId;
    private RepositoryObserver observer;

    private ArrayRepositoryImpl(ArrayFactory<IntArray> factory) {
        this.factory = factory;
        this.arrays = new ArrayList<>();
        this.nextId = 1;
    }

    public static ArrayRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ArrayRepositoryImpl(new IntArrayFactory());
        }

        return instance;
    }

    @Override
    public IntArray add(int... values) {
        IntArray array = factory.create(nextId, values);

        arrays.add(array);
        nextId++;

        if (observer != null) {
            observer.onArrayAdded(array);
        }

        LOGGER.info(
                "Added array to repository with id {}",
                array.getId()
        );

        return array;
    }

    @Override
    public List<IntArray> findBy(Specification<IntArray> specification) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray array : arrays) {
            if (specification.isSatisfiedBy(array)) {
                result.add(array);
            }
        }

        LOGGER.info(
                "Specification search completed. Found {} arrays",
                result.size()
        );

        return result;
    }

    @Override
    public List<IntArray> sort(Comparator<IntArray> comparator) {
        List<IntArray> sortedArrays = new ArrayList<>(arrays);

        sortedArrays.sort(comparator);

        return sortedArrays;
    }

    @Override
    public void updateValue(int id, int index, int value) {
        for (int i = 0; i < arrays.size(); i++) {
            IntArray array = arrays.get(i);

            if (array.getId() == id) {
                int[] values = array.getArray();

                if (index < 0 || index >= values.length) {
                    LOGGER.warn(
                            "Invalid index {} for array with id {}",
                            index,
                            id
                    );
                    return;
                }

                values[index] = value;

                IntArray updatedArray = factory.create(id, values);

                arrays.set(i, updatedArray);

                if (observer != null) {
                    observer.onArrayUpdated(updatedArray);
                }

                LOGGER.info(
                        "Updated element {} of array with id {}",
                        index,
                        id
                );

                return;
            }
        }

        LOGGER.warn("Array with id {} was not found", id);
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < arrays.size(); i++) {
            IntArray array = arrays.get(i);

            if (array.getId() == id) {
                arrays.remove(i);

                if (observer != null) {
                    observer.onArrayRemoved(id);
                }

                LOGGER.info(
                        "Array removed from repository with id {}",
                        id
                );

                return;
            }
        }

        LOGGER.warn("Array with id {} was not found", id);
    }

    public void setObserver(RepositoryObserver observer) {
        this.observer = observer;
    }

}