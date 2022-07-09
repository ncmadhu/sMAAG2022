package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.Arrays;

public class FindLowAndHighIndexOfElement extends Problem {
    @Override
    public void run() {
        System.out.println("Running Low High Index Of An Element");
        int[][] input = new int[][]{{1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6}, {5},
                {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 9}, {9},
                {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 9}, {1},
                {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 9}, {0},
                {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 9}, {10}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Target: " + input[i + 1][0]);
            System.out.println("Low Index (Binary Search): " + this.findLowIndex(input[i], input[i + 1][0]));
            System.out.println("High Index (Binary Search): " + this.findHighIndex(input[i], input[i + 1][0]));
        }
    }

    private int findLowIndex(int[] arr, int target) {
        int length = arr.length;
        if (length == 0) return -1;
        if (arr[0] > target || arr[length-1] < target) return -1;
        int start = 0;
        int end = length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            // Move start to the right to find the start of given number
            if (arr[mid] < target) start = mid + 1; // once end settles down, start will eventually cross over and the loop will end
            else end = mid - 1; // end will settle down at the first element from the right which is less than the target
        }
        if (start < length && arr[start] == target) return start;
        return -1;
    }

    private int findHighIndex(int[] arr, int target) {
        int length = arr.length;
        if (length == 0) return -1;
        if (arr[0] > target || arr[length-1] < target) return -1;
        int start = 0;
        int end = length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] <= target) start = mid + 1; // start will settle down at the first element from left greater than the target
            else end = mid - 1; // Once start settles down, end will eventually cross over and the loop will end
        }
        if (end >= 0 && arr[end] == target) return end;
        return -1;
    }
}
