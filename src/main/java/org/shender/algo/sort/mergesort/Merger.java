package org.shender.algo.sort.mergesort;


public interface Merger<T extends Comparable<T>> {
  void merge(T[] array, int l, int m, int r);
}
