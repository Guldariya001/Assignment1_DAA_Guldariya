# Experimental Results Tables

**Student:** Urazaliyeva Guldariya  
**Group:** SE-2521

The following tables contain the benchmark results for MergeSort, QuickSort,
and QuickSelect. The algorithms were tested on random, sorted, and duplicate
input arrays.

---

## 1. Running Time

Running time is measured in milliseconds (ms).

### Random Input

| n         | MergeSort (ms) | QuickSort (ms) | QuickSelect (ms) |
|----------:|---------------:|---------------:|-----------------:|
| 1,000     | 0.2574         | 0.447399       | 0.0310           |
| 10,000    | 1.2371         | 1.212999       | 0.1372           |
| 100,000   | 9.797701       | 11.945301      | 1.3471           |
| 1,000,000 | 117.663499     | 148.909300     | 18.303100        |

### Sorted Input

| n         | MergeSort (ms) | QuickSort (ms) | QuickSelect (ms) |
|----------:|---------------:|---------------:|-----------------:|
| 1,000     | 0.0142         | 0.0489         | 0.006599         |
| 10,000    | 0.1888         | 0.6804         | 0.040001         |
| 100,000   | 2.276301       | 6.7487         | 0.472699         |
| 1,000,000 | 36.5371        | 80.8217        | 4.836501         |

### Duplicates Input

| n         | MergeSort (ms) | QuickSort (ms) | QuickSelect (ms) |
|----------:|---------------:|---------------:|-----------------:|
| 1,000     | 0.0296         | 0.019201       | 0.0135           |
| 10,000    | 0.406899       | 0.1758         | 0.1145           |
| 100,000   | 4.5218         | 1.7286         | 1.3571           |
| 1,000,000 | 55.361199      | 17.3687        | 12.0617          |

---

## 2. Number of Comparisons

The number of comparisons shows how many element comparisons were performed
during the execution of each algorithm.

### Random Input

| n         | MergeSort  | QuickSort  | QuickSelect |
|----------:|-----------:|-----------:|------------:|
| 1,000     | 9,523      | 17,969     | 3,916       |
| 10,000    | 127,212    | 258,125    | 44,568      |
| 100,000   | 1,639,343  | 3,085,496  | 417,157     |
| 1,000,000 | 19,889,337 | 39,433,739 | 4,160,679   |

### Sorted Input

| n         | MergeSort | QuickSort  | QuickSelect |
|----------:|----------:|-----------:|------------:|
| 1,000     | 4,236     | 17,179     | 6,351       |
| 10,000    | 59,248    | 238,570    | 41,721      |
| 100,000   | 744,016   | 3,152,997  | 513,130     |
| 1,000,000 | 9,071,040 | 38,353,712 | 5,084,132   |

### Duplicates Input

| n         | MergeSort  | QuickSort | QuickSelect |
|----------:|-----------:|----------:|------------:|
| 1,000     | 9,036      | 5,291     | 3,432       |
| 10,000    | 121,712    | 57,286    | 39,074      |
| 100,000   | 1,563,025  | 569,162   | 488,456     |
| 1,000,000 | 18,922,524 | 5,298,558 | 3,202,181   |

---

## 3. Maximum Recursion Depth

Maximum recursion depth shows the deepest level of recursion reached during
the execution of each algorithm.

### Random Input

| n         | MergeSort | QuickSort | QuickSelect |
|----------:|----------:|----------:|------------:|
| 1,000     | 8         | 6         | 13          |
| 10,000    | 11        | 8         | 17          |
| 100,000   | 14        | 11        | 20          |
| 1,000,000 | 18        | 13        | 31          |

### Sorted Input

| n         | MergeSort | QuickSort | QuickSelect |
|----------:|----------:|----------:|------------:|
| 1,000     | 8         | 6         | 12          |
| 10,000    | 11        | 9         | 13          |
| 100,000   | 14        | 11        | 21          |
| 1,000,000 | 18        | 12        | 25          |

### Duplicates Input

| n         | MergeSort | QuickSort | QuickSelect |
|----------:|----------:|----------:|------------:|
| 1,000     | 8         | 2         | 4           |
| 10,000    | 11        | 2         | 4           |
| 100,000   | 14        | 2         | 5           |
| 1,000,000 | 18        | 2         | 4           |

---

## Summary

The tables present the measured results used to create the experimental
plots. The results show how running time, number of comparisons, and maximum
recursion depth change as the input size increases from 1,000 to 1,000,000
elements.

The results were collected for three different input types: random input,
sorted input, and input containing many duplicate values.

The complete raw benchmark data are also available in `results.csv`.