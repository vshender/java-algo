package org.shender.algo.sort.mergesort;

import org.shender.algo.sort.Sort;


public class NaturalMergeSort<T extends Comparable<T>> implements Sort<T> {
  Merger<T> merger;

  public NaturalMergeSort(Merger<T> merger) {
    this.merger = merger;
  }

  public void sort(T[] array) {
    if (array.length == 0)
      return;

    while (true) {
      int l = 0;

      // Find pairs of runs to merge.
      while (l < array.length) {
        // Find the left run to merge.
        int m = l + 1;
        while (m < array.length && array[m - 1].compareTo(array[m]) <= 0)
          m++;

        if (m == array.length)
          if (l == 0)  // the whole array is sorted
            return;
          else
            break;     // the last items of array are sorted

        // Find the right run to merge.
        int r = m + 1;
        while (r < array.length && array[r - 1].compareTo(array[r]) <= 0)
          r++;

        merger.merge(array, l, m, r);

        l = r;
      }
    }
  }
}
