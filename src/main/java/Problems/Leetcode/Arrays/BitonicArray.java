package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.Arrays;

public class BitonicArray extends Problem {
    @Override
    public void run() {
        // Bitonic - Monotonically increasing and then monotonically decreasing.
        System.out.println("Running Bitonic Array Checker");
        int[][] input = new int[][]{{1,3,8,12,4,2}, {3,8,3,1}, {1,3,8,12}, {10,9,8}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Peak (BS): " + this.findMaxOptimum(input[i]));
        }
    }

    private int findMaxOptimum(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int start, mid, end;
        start = 0;
        end = arr.length -1;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid+1]) end = mid;
            if (arr[mid] < arr[mid+1]) start = mid+1;
        }
        if (start == end) return arr[start];
        else return -1;
    }
}
