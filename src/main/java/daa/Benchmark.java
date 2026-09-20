package daa;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class Benchmark {

    private static final int[] SIZES = {
            1000, 10000, 100000, 1000000
    };

    private static final String[] INPUTS = {
            "random", "sorted", "duplicates"
    };

    private static final int RUNS = 5;

    public static void main(String[] args) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("results.csv"))) {

            writer.println("algorithm,input,n,time_ms,comparisons,max_depth");

            for (String input : INPUTS) {
                for (int n : SIZES) {
                    int[] original = createArray(n, input);

                    runMergeSort(original, input, writer);
                    runQuickSort(original, input, writer);
                    runQuickSelect(original, input, writer);

                    System.out.println("Finished: " + input + ", n = " + n);
                }
            }
        }

        System.out.println("Benchmark finished.");
    }

    private static int[] createArray(int n, String input) {
        int[] a = new int[n];
        Random random = new Random(42);

        if (input.equals("random")) {
            for (int i = 0; i < n; i++) {
                a[i] = random.nextInt();
            }
        } else if (input.equals("sorted")) {
            for (int i = 0; i < n; i++) {
                a[i] = i;
            }
        } else {
            for (int i = 0; i < n; i++) {
                a[i] = random.nextInt(10);
            }
        }

        return a;
    }

    private static void runMergeSort(int[] original, String input,
                                     PrintWriter writer) {

        double[] times = new double[RUNS];
        long[] comparisons = new long[RUNS];
        int[] depths = new int[RUNS];

        for (int run = 0; run < RUNS; run++) {
            int[] a = original.clone();
            Metrics metrics = new Metrics();

            MergeSort.sort(a, metrics);

            times[run] = metrics.timeNs / 1_000_000.0;
            comparisons[run] = metrics.comparisons;
            depths[run] = metrics.maxDepth;
        }

        writer.println(
                "MergeSort," + input + "," + original.length + "," +
                        median(times) + "," +
                        median(comparisons) + "," +
                        median(depths)
        );
    }

    private static void runQuickSort(int[] original, String input,
                                     PrintWriter writer) {

        double[] times = new double[RUNS];
        long[] comparisons = new long[RUNS];
        int[] depths = new int[RUNS];

        for (int run = 0; run < RUNS; run++) {
            int[] a = original.clone();
            Metrics metrics = new Metrics();

            QuickSort.sort(a, metrics);

            times[run] = metrics.timeNs / 1_000_000.0;
            comparisons[run] = metrics.comparisons;
            depths[run] = metrics.maxDepth;
        }

        writer.println(
                "QuickSort," + input + "," + original.length + "," +
                        median(times) + "," +
                        median(comparisons) + "," +
                        median(depths)
        );
    }

    private static void runQuickSelect(int[] original, String input,
                                       PrintWriter writer) {

        double[] times = new double[RUNS];
        long[] comparisons = new long[RUNS];
        int[] depths = new int[RUNS];

        int k = original.length / 2;

        for (int run = 0; run < RUNS; run++) {
            int[] a = original.clone();
            Metrics metrics = new Metrics();

            QuickSelect.select(a, k, metrics);

            times[run] = metrics.timeNs / 1_000_000.0;
            comparisons[run] = metrics.comparisons;
            depths[run] = metrics.maxDepth;
        }

        writer.println(
                "QuickSelect," + input + "," + original.length + "," +
                        median(times) + "," +
                        median(comparisons) + "," +
                        median(depths)
        );
    }

    private static double median(double[] values) {
        double[] copy = values.clone();
        Arrays.sort(copy);
        return copy[copy.length / 2];
    }

    private static long median(long[] values) {
        long[] copy = values.clone();
        Arrays.sort(copy);
        return copy[copy.length / 2];
    }

    private static int median(int[] values) {
        int[] copy = values.clone();
        Arrays.sort(copy);
        return copy[copy.length / 2];
    }
}