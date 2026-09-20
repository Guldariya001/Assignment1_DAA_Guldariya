package daa;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {

    @Test
    void randomArrays() {
        Random random = new Random(1);

        for (int test = 0; test < 100; test++) {
            int size = random.nextInt(200);
            int[] a = new int[size];

            for (int i = 0; i < size; i++) {
                a[i] = random.nextInt(1000);
            }

            int[] expected = a.clone();
            Arrays.sort(expected);

            Metrics metrics = new Metrics();
            MergeSort.sort(a, metrics);

            assertArrayEquals(expected, a);
        }
    }

    @Test
    void emptyArray() {
        int[] a = {};

        MergeSort.sort(a, new Metrics());

        assertArrayEquals(new int[]{}, a);
    }

    @Test
    void oneElement() {
        int[] a = {5};

        MergeSort.sort(a, new Metrics());

        assertArrayEquals(new int[]{5}, a);
    }

    @Test
    void allEqual() {
        int[] a = {4, 4, 4, 4, 4};

        MergeSort.sort(a, new Metrics());

        assertArrayEquals(new int[]{4, 4, 4, 4, 4}, a);
    }

    @Test
    void sortedArray() {
        int[] a = {1, 2, 3, 4, 5};

        MergeSort.sort(a, new Metrics());

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, a);
    }
}