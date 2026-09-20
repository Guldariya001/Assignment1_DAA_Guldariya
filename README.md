# Assignment 1 — Design and Analysis of Algorithms

**Student:** Urazaliyeva Guldariya  
**Group:** SE-2521

## Description

This project implements and analyzes three divide-and-conquer algorithms:

- MergeSort
- QuickSort
- QuickSelect

The purpose of the assignment is to study the theoretical and experimental performance of these algorithms using different input sizes and input types.

The algorithms are evaluated using:

- Running time
- Number of comparisons
- Maximum recursion depth

## Implemented Algorithms

### MergeSort

MergeSort recursively divides the array into two parts, sorts both parts, and merges them.

The implementation uses a reusable auxiliary buffer and Insertion Sort for small subarrays.

Expected time complexity:

`Θ(n log n)`

### QuickSort

QuickSort partitions the array around a pivot and recursively sorts the resulting partitions.

The implementation uses randomized pivot selection and 3-way partitioning. Recursion is performed on the smaller partition while the larger partition is processed iteratively.

Expected time complexity:

`Θ(n log n)` on average.

### QuickSelect

QuickSelect finds the k-th smallest element without completely sorting the array.

It uses partitioning similar to QuickSort but continues only in the part containing the required element.

Expected time complexity:

`Θ(n)` on average.

## Testing

JUnit tests are included for the implemented algorithms.

The tests cover cases such as:

- Empty arrays
- Single-element arrays
- Random arrays
- Sorted arrays
- Arrays with duplicate values
- Invalid values of `k` for QuickSelect

## Benchmark

The benchmark tests the algorithms with the following input sizes:

- 1,000
- 10,000
- 100,000
- 1,000,000

Three types of input are used:

- Random input
- Sorted input
- Input with many duplicate values

The following metrics are collected:

- Running time in milliseconds
- Number of comparisons
- Maximum recursion depth

Each configuration is executed 5 times and the results are averaged.

The complete benchmark results are stored in:

`results.csv`

## Experimental Plots

The project contains three main plots.

### Running Time vs Array Size

`plot_time_vs_n.png`

This plot compares the running time of MergeSort, QuickSort, and QuickSelect for random, sorted, and duplicate-heavy input.

### Maximum Recursion Depth vs Array Size

`plot_depth_vs_n.png`

This plot shows how maximum recursion depth changes as the input size increases.

### Comparison Ratio vs Array Size

`plot_ratio_vs_n.png`

The normalized comparison ratio is calculated as follows.

For MergeSort and QuickSort:

`comparisons / (n * log2(n))`

For QuickSelect:

`comparisons / n`

The ratio plot is used to compare the experimental results with the expected asymptotic growth of the algorithms.

## How to Build and Run

### Requirements

- Java 17
- Maven
- JUnit 5
- IntelliJ IDEA or another Java IDE

### Run Tests

From the project directory, run:

```bash
mvn test
```

This command compiles the project and runs all JUnit tests.

### Run the Benchmark

The benchmark can be run directly from IntelliJ IDEA.

Open:

`src/main/java/daa/Benchmark.java`

and run the `main` method.

The benchmark generates the experimental results stored in `results.csv`.

## Experimental Results

The experimental results show that performance depends on both the algorithm and the structure of the input data.

MergeSort demonstrates stable behavior and logarithmic recursion depth.

QuickSort performs particularly well for arrays containing many duplicate values because the implementation uses 3-way partitioning.

QuickSelect has relatively low measured running times and comparison counts because it finds only the required k-th smallest element instead of sorting the entire array.

QuickSelect therefore should not be considered a direct replacement for MergeSort or QuickSort when a completely sorted array is required.

More detailed theoretical analysis, experimental tables, ratio analysis, and discussion are available in `REPORT.md`.

## Project Structure

```text
Assignment1_DAA/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── daa/
│   │           ├── Benchmark.java
│   │           ├── MergeSort.java
│   │           ├── Metrics.java
│   │           ├── QuickSelect.java
│   │           └── QuickSort.java
│   └── test/
│       └── java/
│           └── daa/
│               ├── MergeSortTest.java
│               ├── QuickSelectTest.java
│               └── QuickSortTest.java
├── .gitignore
├── plot_depth_vs_n.png
├── plot_ratio_vs_n.png
├── plot_time_vs_n.png
├── pom.xml
├── README.md
├── REPORT.md
└── results.csv
```

## Technologies

- Java 17
- Maven
- JUnit 5
- IntelliJ IDEA

## Report

The complete theoretical analysis, experimental results, ratio analysis, and discussion are available in:

`REPORT.md`