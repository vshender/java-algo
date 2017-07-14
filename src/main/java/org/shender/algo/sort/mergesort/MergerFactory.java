package org.shender.algo.sort.mergesort;


public class MergerFactory {

  public static enum MergerType { IN_PLACE, EXTRA_STORAGE };

  private MergerFactory() {}

  public static <T extends Comparable<T>> Merger<T> getMerger(MergerType mergerType, int n) {
    switch (mergerType) {
    case IN_PLACE:
      return null;
    case EXTRA_STORAGE:
      return new ExtraStorageMerger<T>(n);
    }

    return null;
  }
}
