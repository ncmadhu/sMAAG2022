package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.Arrays;

public class SearchRotatedArray extends Problem {
    @Override
    public void run() {
        System.out.println("Running Search In Rotated Array");
        int[][] input = new int[][]{{6, 7, 1, 2, 3, 4, 5}, {3},
                {6, 7, 1, 2, 3, 4, 5}, {6},
                {4, 5, 6, 1, 2, 3}, {3},
                {4, 5, 6, 1, 2, 3},{6}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i+2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Target: " + input[i+1][0]);
            System.out.println("Output: " + this.binarySearchRotated(input[i], input[i+1][0]));
        }

    }

    private int binarySearchRotated(int[] arr, int target) {
        int length = arr.length;
        if (length == 0) return -1;
        int mid, start = 0;
        int end = length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            if (arr[start] <= arr[mid]) {
                if (arr[start] <= target && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] < target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
