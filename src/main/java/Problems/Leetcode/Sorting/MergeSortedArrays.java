package Problems.Leetcode.Sorting;

import Problems.Problem;

import java.util.Arrays;

public class MergeSortedArrays extends Problem {
    @Override
    public void run() {
        System.out.println("Running Merge Sorted Array");
        int[][] input = new int[][]{{1, 3, 5}, {2, 4, 6},
                {1}, {},
                {}, {1},
                {0, 1}, {0,0},
                {1,2,3}, {4,5,6},
                {1,1,1},{2,2,2}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            int[] nums1, nums2, merged;
            nums1 = input[i].clone();
            nums2 = input[i+1].clone();
            System.out.println(("Array 1: " + Arrays.toString(nums1)));
            System.out.println(("Array 2: " + Arrays.toString(nums2)));
            merged = this.merge(nums1, nums2);
            System.out.println(("Merged: " + Arrays.toString(merged)));
        }
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int a1Len = arr1.length;
        int a2Len = arr2.length;
        int[] result = new int[a1Len + a2Len];
        int a1, a2, m;
        a1 = a2 = m = 0;
        while (a1 < a1Len && a2 < a2Len) {
            if (arr1[a1] < arr2[a2]) result[m++] = arr1[a1++];
            else result[m++] = arr2[a2++];
        }
        while (a1 < a1Len) result[m++] = arr1[a1++];
        while (a2 < a2Len) result[m++] = arr2[a2++];
        return result;
    }
}
