package org.shender.algo.sort.mergesort;


class ExtraStorageMerger<T extends Comparable<T>> implements Merger<T> {
  T[] extraStorage;

  @SuppressWarnings("unchecked")
  ExtraStorageMerger(int n) {
    extraStorage = (T[])new Comparable[n];
  }

  public void merge(T[] array, int l, int m, int r) {
    int lCurIdx = l, rCurIdx = m, k = 0;

    while (lCurIdx < m && rCurIdx < r)
      if (array[lCurIdx].compareTo(array[rCurIdx]) <= 0)
        extraStorage[k++] = array[lCurIdx++];
      else
        extraStorage[k++] = array[rCurIdx++];

    while (lCurIdx < m)
      extraStorage[k++] = array[lCurIdx++];
    while (rCurIdx < r)
      extraStorage[k++] = array[rCurIdx++];

    for (k = 0; k < r - l; k++)
      array[l + k] = extraStorage[k];
  }
}
