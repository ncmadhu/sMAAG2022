package Problems.Leetcode.Tree;

import Problems.Problem;

import java.util.Arrays;

public class SegmentTree extends Problem {
    @Override
    public void run() {
        System.out.println("Running Segment Tree");
        int[][] input = new int[][]{{0,3,4,2,1,6,-1}, {-1,2,4,1,7,1,3,2}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Output: " + Arrays.toString(this.buildSegmentTree(input[i])));
        }
    }

    private int nextPowerOf2(int n) {
        if (n > 0 && (n & (n-1)) == 0) return n;
        int count = 0;
        while (n != 0) {
            n = n >> 1;
            count += 1;
        }
        return 1 << count;
    }

    private int[] buildSegmentTree(int[] arr) {
        if (arr == null) return null;
        int length = arr.length;
        int nextPowerOf2 = this.nextPowerOf2(length);
        int[] segmentArr = new int[2*nextPowerOf2 - 1];
        for (int i = 0; i < segmentArr.length; i++) {
            segmentArr[i] = Integer.MAX_VALUE;
        }
        this.constructSegmentArr(segmentArr, arr, 0, length-1, 0);
        return segmentArr;
    }

    private void constructSegmentArr(int[] segmentArr, int[] arr, int low, int high, int pos) {
        if (low == high) {
            segmentArr[pos] = arr[low];
            return;
        }
        int mid = low + (high - low) / 2;
        this.constructSegmentArr(segmentArr, arr, low, mid, 2 * pos + 1);
        this.constructSegmentArr(segmentArr, arr, mid+1, high, 2 * pos + 2);
        segmentArr[pos] = Math.min(segmentArr[2 * pos + 1], segmentArr[2 * pos + 2]);
    }
}
