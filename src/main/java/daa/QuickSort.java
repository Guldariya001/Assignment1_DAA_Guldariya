package daa;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

    public static void sort(int[] a, Metrics metrics) {
        metrics.reset();

        long start = System.nanoTime();

        if (a.length > 1) {
            quickSort(a, 0, a.length - 1, metrics, 1);
        }

        metrics.timeNs = System.nanoTime() - start;
    }

    private static void quickSort(int[] a, int left, int right,
                                  Metrics metrics, int depth) {

        while (left < right) {
            metrics.updateDepth(depth);

            int pivotIndex = ThreadLocalRandom.current().nextInt(left, right + 1);
            int pivot = a[pivotIndex];

            int[] part = partition(a, left, right, pivot, metrics);

            int leftSize = part[0] - left;
            int rightSize = right - part[1];

            if (leftSize < rightSize) {
                if (left < part[0] - 1) {
                    quickSort(a, left, part[0] - 1, metrics, depth + 1);
                }

                left = part[1] + 1;
            } else {
                if (part[1] + 1 < right) {
                    quickSort(a, part[1] + 1, right, metrics, depth + 1);
                }

                right = part[0] - 1;
            }
        }
    }

    static int[] partition(int[] a, int left, int right,
                           int pivot, Metrics metrics) {

        int lt = left;
        int i = left;
        int gt = right;

        while (i <= gt) {
            metrics.comparisons++;

            if (a[i] < pivot) {
                swap(a, lt, i);
                lt++;
                i++;
            } else {
                metrics.comparisons++;

                if (a[i] > pivot) {
                    swap(a, i, gt);
                    gt--;
                } else {
                    i++;
                }
            }
        }

        return new int[]{lt, gt};
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}