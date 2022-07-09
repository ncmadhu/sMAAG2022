package Problems;

import Problems.Leetcode.Arrays.*;
import Problems.Leetcode.Sorting.MergeSortedArrays;
import Problems.Leetcode.Sorting.QuickSort;
import Problems.Leetcode.Strings.*;
import Problems.Leetcode.Tree.SegmentTree;
import Problems.Random.LinkedLists.*;
import Problems.Random.bits.NextPowerOf2;
import Problems.educative.Arrays.MaxInSlidingWindow;
import Problems.educative.Arrays.ProductOfAllExceptItself;

public abstract class Problem {

    public abstract void run();

    public static void main(String[] args) {
        Problem problem = new BitonicArray();
        problem.run();
    }

}
