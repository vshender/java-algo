package org.shender.algo.sort.mergesort;

import org.shender.algo.sort.Sort;
import org.shender.algo.sort.SortTestBase;
import static org.shender.algo.sort.mergesort.MergerFactory.MergerType;


public class BottomUpMergeSortTest extends SortTestBase<BottomUpMergeSort<Integer>> {

  public BottomUpMergeSortTest(int size) {
    super(size);
  }

  @Override
  protected BottomUpMergeSort<Integer> createSorterInstance() {
    return new BottomUpMergeSort<Integer>(
      MergerFactory.<Integer>getMerger(MergerType.EXTRA_STORAGE, size));
  }
}
