# Assignment 1 — Design and Analysis of Algorithms
**Student:** Urazaliyeva Guldariya  
**Group:** SE-2521
## Description

This project implements and analyzes three algorithms:

- MergeSort
- QuickSort
- QuickSelect

The purpose of the assignment is to compare their performance using different input sizes and different types of input data.

## Implemented Algorithms

### MergeSort
MergeSort divides the array into smaller parts, recursively sorts them, and then merges the sorted parts.

### QuickSort
QuickSort uses partitioning to divide the array and recursively sort the resulting parts. The implementation uses 3-way partitioning, which is useful when the input contains many duplicate values.

### QuickSelect
QuickSelect uses partitioning to find the k-th smallest element without sorting the entire array.

## Testing

JUnit tests were used to verify the correctness of the implementations.

The tests include:

- Empty arrays
- Arrays with one element
- Random arrays
- Sorted arrays
- Arrays with duplicate values
- Invalid values of k for QuickSelect

## Benchmark

The algorithms were tested with the following input sizes:

- 1,000
- 10,000
- 100,000
- 1,000,000

Three types of input were used:

- Random input
- Sorted input
- Input with many duplicates

Each algorithm was evaluated using:

- Running time in milliseconds
- Number of comparisons
- Maximum recursion depth

The benchmark results are stored in `results.csv`.

## Experimental Results

### Running Time

For random input, the running time increased as the input size increased. At n = 1,000,000, MergeSort took approximately 117.66 ms, QuickSort took 148.91 ms, and QuickSelect took 18.30 ms.

For sorted input, MergeSort took approximately 36.54 ms, QuickSort took 80.82 ms, and QuickSelect took 4.84 ms.

For input with many duplicates, MergeSort took approximately 55.36 ms, QuickSort took 17.37 ms, and QuickSelect took 12.06 ms.

These results show that the type of input data can have a noticeable effect on running time.

### Number of Comparisons

For random input with n = 1,000,000, MergeSort performed 19,889,337 comparisons, QuickSort performed 39,433,739 comparisons, and QuickSelect performed 4,160,679 comparisons.

For sorted input with n = 1,000,000, MergeSort performed 9,071,040 comparisons, QuickSort performed 38,353,712 comparisons, and QuickSelect performed 5,084,132 comparisons.

For input with many duplicates, MergeSort performed 18,922,524 comparisons, QuickSort performed 5,298,558 comparisons, and QuickSelect performed 3,202,181 comparisons.

The results show that the number of comparisons depends on both the algorithm and the structure of the input data.

### Maximum Recursion Depth

For random input with n = 1,000,000, the maximum recursion depth was 18 for MergeSort, 13 for QuickSort, and 31 for QuickSelect.

For sorted input, the maximum recursion depth was 18 for MergeSort, 12 for QuickSort, and 25 for QuickSelect.

For input with many duplicates, the maximum recursion depth was 18 for MergeSort, 2 for QuickSort, and 4 for QuickSelect.

MergeSort showed predictable growth in recursion depth as the input size increased. QuickSort and QuickSelect had very small recursion depths for input containing many duplicate values.

## Conclusion

The experiments show that algorithm performance depends on both the input size and the structure of the input data.

MergeSort showed relatively stable behavior for different types of input. QuickSort performed particularly well on arrays containing many duplicate values with this implementation. QuickSelect had relatively low running times and numbers of comparisons because it searches only for the required k-th smallest element instead of sorting the entire array.

Therefore, QuickSelect should not be considered a direct replacement for MergeSort or QuickSort when a completely sorted array is required. It solves a different problem.

The experiment also demonstrates that running time alone is not enough to analyze algorithm behavior. The number of comparisons and maximum recursion depth provide additional information about the performance of each algorithm.

## Project Structure

```text
Assignment1_DAA/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── daa/
│   │           ├── MergeSort.java
│   │           ├── QuickSort.java
│   │           ├── QuickSelect.java
│   │           ├── Metrics.java
│   │           └── Benchmark.java
│   └── test/
│       └── java/
│           └── daa/
│               ├── MergeSortTest.java
│               ├── QuickSortTest.java
│               └── QuickSelectTest.java
├── pom.xml
├── results.csv
└── README.md