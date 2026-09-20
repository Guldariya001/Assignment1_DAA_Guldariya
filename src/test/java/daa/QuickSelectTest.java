package daa;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuickSelectTest {

    @Test
    void randomArrays() {
        Random random = new Random(3);

        for (int test = 0; test < 100; test++) {
            int size = random.nextInt(199) + 1;
            int[] a = new int[size];

            for (int i = 0; i < size; i++) {
                a[i] = random.nextInt(1000);
            }

            int k = random.nextInt(size);

            int[] sorted = a.clone();
            Arrays.sort(sorted);

            Metrics metrics = new Metrics();
            int result = QuickSelect.select(a, k, metrics);

            assertEquals(sorted[k], result);
        }
    }

    @Test
    void oneElement() {
        int[] a = {10};

        int result = QuickSelect.select(a, 0, new Metrics());

        assertEquals(10, result);
    }

    @Test
    void allEqual() {
        int[] a = {7, 7, 7, 7, 7};

        int result = QuickSelect.select(a, 3, new Metrics());

        assertEquals(7, result);
    }

    @Test
    void invalidNegativeK() {
        int[] a = {1, 2, 3};

        assertThrows(
                IllegalArgumentException.class,
                () -> QuickSelect.select(a, -1, new Metrics())
        );
    }

    @Test
    void invalidLargeK() {
        int[] a = {1, 2, 3};

        assertThrows(
                IllegalArgumentException.class,
                () -> QuickSelect.select(a, 3, new Metrics())
        );
    }

    @Test
    void emptyArray() {
        int[] a = {};

        assertThrows(
                IllegalArgumentException.class,
                () -> QuickSelect.select(a, 0, new Metrics())
        );
    }
}