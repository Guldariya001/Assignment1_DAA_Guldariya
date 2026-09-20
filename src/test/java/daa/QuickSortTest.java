package daa;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuickSortTest {

    @Test
    void randomArrays() {
        Random random = new Random(2);

        for (int test = 0; test < 100; test++) {
            int size = random.nextInt(200);
            int[] a = new int[size];

            for (int i = 0; i < size; i++) {
                a[i] = random.nextInt(1000);
            }

            int[] expected = a.clone();
            Arrays.sort(expected);

            Metrics metrics = new Metrics();
            QuickSort.sort(a, metrics);

            assertArrayEquals(expected, a);
        }
    }

    @Test
    void emptyArray() {
        int[] a = {};

        QuickSort.sort(a, new Metrics());

        assertArrayEquals(new int[]{}, a);
    }

    @Test
    void oneElement() {
        int[] a = {7};

        QuickSort.sort(a, new Metrics());

        assertArrayEquals(new int[]{7}, a);
    }

    @Test
    void allEqual() {
        int[] a = {5, 5, 5, 5, 5, 5};

        QuickSort.sort(a, new Metrics());

        assertArrayEquals(new int[]{5, 5, 5, 5, 5, 5}, a);
    }

    @Test
    void sortedArray() {
        int[] a = {1, 2, 3, 4, 5, 6};

        QuickSort.sort(a, new Metrics());

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, a);
    }

    @Test
    void depthTest() {
        int n = 100000;
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = i;
        }

        Metrics metrics = new Metrics();
        QuickSort.sort(a, metrics);

        double limit = 2 * (Math.log(n) / Math.log(2));

        assertTrue(metrics.maxDepth <= limit);
    }
}
