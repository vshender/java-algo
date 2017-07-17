package org.shender.algo.sort.mergesort;

import org.shender.algo.sort.Sort;
import org.shender.algo.sort.SortTestBase;
import static org.shender.algo.sort.mergesort.MergerFactory.MergerType;


public class TopDownMergeSortTest extends SortTestBase<TopDownMergeSort<Integer>> {

  public TopDownMergeSortTest(int size) {
    super(size);
  }

  @Override
  protected TopDownMergeSort<Integer> createSorterInstance() {
    return new TopDownMergeSort<Integer>(
      MergerFactory.<Integer>getMerger(MergerType.EXTRA_STORAGE, size));
  }
}
