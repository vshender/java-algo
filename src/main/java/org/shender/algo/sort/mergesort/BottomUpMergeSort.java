package org.shender.algo.sort.mergesort;

import org.shender.algo.sort.Sort;


public class BottomUpMergeSort<T extends Comparable<T>> implements Sort<T> {
  Merger<T> merger;

  public BottomUpMergeSort(Merger<T> merger) {
    this.merger = merger;
  }

  public void sort(T[] array) {
    for (int width = 1; width < array.length; width *= 2)
      for (int i = 0; i < array.length - width; i += 2 * width)
        merger.merge(
          array,
          i, i + width, Math.min(i + 2 * width, array.length));
  }
}
