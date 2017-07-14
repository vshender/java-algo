package org.shender.algo.sort.mergesort;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.shender.algo.sort.mergesort.MergerFactory.MergerType;


public class MergerTest {

  @Test
  public void test1() {
    Integer[] array = {1, 3, 7, 13, 45, 2, 2, 5, 8, 64};

    Merger<Integer> merger = MergerFactory.getMerger(MergerType.EXTRA_STORAGE, 10);
    merger.merge(array, 0, 5, 10);

    assertTrue(checkArraySorted(array));
  }

  @Test
  public void test2() {
    Integer[] array = {1, 13, 3, 7, 45, 2, 5, 8, 2, 64};

    Merger<Integer> merger = MergerFactory.getMerger(MergerType.EXTRA_STORAGE, 10);
    merger.merge(array, 0, 2, 5);
    merger.merge(array, 5, 8, 10);
    merger.merge(array, 0, 5, 10);

    assertTrue(checkArraySorted(array));
  }

  private static final boolean checkArraySorted(Integer[] array) {
    for (int i = 1; i < array.length; i++)
      if (array[i - 1] > array[i])
        return false;
    return true;
  }
}
