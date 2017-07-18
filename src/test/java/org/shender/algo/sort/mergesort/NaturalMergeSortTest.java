package org.shender.algo.sort.mergesort;

import org.shender.algo.sort.Sort;
import org.shender.algo.sort.SortTestBase;
import static org.shender.algo.sort.mergesort.MergerFactory.MergerType;


public class NaturalMergeSortTest extends SortTestBase<NaturalMergeSort<Integer>> {

  public NaturalMergeSortTest(int size) {
    super(size);
  }

  @Override
  protected NaturalMergeSort<Integer> createSorterInstance() {
    return new NaturalMergeSort<Integer>(
      MergerFactory.<Integer>getMerger(MergerType.EXTRA_STORAGE, size));
  }
}
