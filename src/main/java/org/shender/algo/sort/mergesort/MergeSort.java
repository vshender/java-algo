package org.shender.algo.sort.mergesort;


public class MergeSort<T extends Comparable<T>> {
  Merger<T> merger;

  public MergeSort(Merger<T> merger) {
    this.merger = merger;
  }

  void sort(T[] array) {
    sort(array, 0, array.length);
  }

  void sort(T[] array, int l, int r) {
    if (l + 1 == r)
      return;

    int m = l + (r - l) / 2;

    sort(array, l, m);
    sort(array, m, r);

    merger.merge(array, l, m, r);
  }
}
