package org.shender.algo.sort.mergesort;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.shender.algo.sort.mergesort.MergerFactory.MergerType;


public class MergeSortTest {

  @Test
  public void test1() {
    Integer[] array = {1};

    MergeSort<Integer> sorter = new MergeSort<>(
      MergerFactory.<Integer>getMerger(MergerType.EXTRA_STORAGE, array.length));
    sorter.sort(array);
    assertTrue(checkArraySorted(array));
  }

  @Test
  public void test2() {
    Integer[] array = {2, 1};

    MergeSort<Integer> sorter = new MergeSort<>(
      MergerFactory.<Integer>getMerger(MergerType.EXTRA_STORAGE, array.length));
    sorter.sort(array);
    assertTrue(checkArraySorted(array));
  }

  @Test
  public void test3() {
    Integer[] array = {6, 8, -5, 15, 42, 0, 10, 128, 31, -64};

    MergeSort<Integer> sorter = new MergeSort<>(
      MergerFactory.<Integer>getMerger(MergerType.EXTRA_STORAGE, array.length));
    sorter.sort(array);
    assertTrue(checkArraySorted(array));
  }

  @Test
  public void test4() {
    final Integer[] array = new Integer[4242];
    final Random rnd = new Random();

    for (int i = 0; i < array.length; i++)
      array[i] = rnd.nextInt();

    MergeSort<Integer> sorter = new MergeSort<>(
      MergerFactory.<Integer>getMerger(MergerType.EXTRA_STORAGE, array.length));
    sorter.sort(array);
    assertTrue(checkArraySorted(array));
  }

  private static final boolean checkArraySorted(Integer[] array) {
    for (int i = 1; i < array.length; i++)
      if (array[i - 1] > array[i])
        return false;
    return true;
  }
}
