package daa;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSelect {

    public static int select(int[] a, int k, Metrics metrics) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        if (k < 0 || k >= a.length) {
            throw new IllegalArgumentException("k is out of range");
        }

        metrics.reset();
        long start = System.nanoTime();

        int left = 0;
        int right = a.length - 1;
        int depth = 1;

        while (left <= right) {
            metrics.updateDepth(depth);

            int pivotIndex =
                    ThreadLocalRandom.current().nextInt(left, right + 1);

            int pivot = a[pivotIndex];

            int[] part =
                    QuickSort.partition(a, left, right, pivot, metrics);

            if (k < part[0]) {
                right = part[0] - 1;
            } else if (k > part[1]) {
                left = part[1] + 1;
            } else {
                metrics.timeNs = System.nanoTime() - start;
                return a[k];
            }

            depth++;
        }

        metrics.timeNs = System.nanoTime() - start;
        throw new IllegalStateException("Selection failed");
    }
}