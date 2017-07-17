package org.shender.algo.sort;


public interface Sort<T extends Comparable<T>> {
  void sort(T[] array);
}
