package factory;

import app.entity.IntArray;
import app.factory.ArrayFactory;
import app.factory.impl.IntArrayFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IntArrayFactoryTest {

    @Test
    void createShouldCreateIntArray() {
        // given
        ArrayFactory<IntArray> factory = new IntArrayFactory();
        int[] expected = {1, 2, 3};

        // when
        IntArray result = factory.create(1, 2, 3);

        // then
        assertArrayEquals(expected, result.getArray());
    }
}
