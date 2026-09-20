package daa;

public class MergeSort {

    private static final int CUTOFF = 15;

    public static void sort(int[] a, Metrics metrics) {
        metrics.reset();

        long start = System.nanoTime();

        if (a.length > 1) {
            int[] buffer = new int[a.length];
            mergeSort(a, buffer, 0, a.length - 1, metrics, 1);
        }

        metrics.timeNs = System.nanoTime() - start;
    }

    private static void mergeSort(int[] a, int[] buffer, int left, int right,
                                  Metrics metrics, int depth) {

        metrics.updateDepth(depth);

        if (right - left + 1 <= CUTOFF) {
            insertionSort(a, left, right, metrics);
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(a, buffer, left, mid, metrics, depth + 1);
        mergeSort(a, buffer, mid + 1, right, metrics, depth + 1);

        merge(a, buffer, left, mid, right, metrics);
    }

    private static void merge(int[] a, int[] buffer, int left, int mid,
                              int right, Metrics metrics) {

        for (int i = left; i <= right; i++) {
            buffer[i] = a[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            metrics.comparisons++;

            if (buffer[i] <= buffer[j]) {
                a[k] = buffer[i];
                i++;
            } else {
                a[k] = buffer[j];
                j++;
            }

            k++;
        }

        while (i <= mid) {
            a[k] = buffer[i];
            i++;
            k++;
        }

        while (j <= right) {
            a[k] = buffer[j];
            j++;
            k++;
        }
    }

    private static void insertionSort(int[] a, int left, int right,
                                      Metrics metrics) {

        for (int i = left + 1; i <= right; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= left) {
                metrics.comparisons++;

                if (a[j] <= key) {
                    break;
                }

                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = key;
        }
    }
}