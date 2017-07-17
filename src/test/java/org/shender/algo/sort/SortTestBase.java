package org.shender.algo.sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertTrue;

import org.shender.algo.sort.Sort;


@RunWith(Parameterized.class)
public abstract class SortTestBase<T extends Sort<Integer>> {

  private static final Random rnd = new Random();

  protected final T sorter;
  protected final int size;
  protected final Integer[][] arraysToSort = new Integer[3][];

  protected abstract T createSorterInstance();

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
      new Object[][] { {0}, {1}, {2}, {7}, {42}, {1000}, {32768} });
  }

  public SortTestBase(int size) {
    int i;

    this.size = size;

    for (i = 0; i < 3; i++)
      arraysToSort[i] = new Integer[size];

    for (i = 0; i < size; i++) {
      arraysToSort[0][i] = i;
      arraysToSort[1][i] = size - i;
      arraysToSort[2][i] = rnd.nextInt();
    }

    sorter = createSorterInstance();
  }

  @Test
  public void testSorter() {

    for (int i = 0; i < 3; i++) {
      sorter.sort(arraysToSort[i]);
      assertTrue(checkArraySorted(arraysToSort[i]));
    }
  }

  private static final boolean checkArraySorted(Integer[] array) {
    for (int i = 1; i < array.length; i++)
      if (array[i - 1] > array[i])
        return false;
    return true;
  }
}
