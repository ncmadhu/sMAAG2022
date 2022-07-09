package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.Arrays;

public class OrderAgnosticBinarySearch extends Problem {
    @Override
    public void run() {
        System.out.println("Running Order Agnostic Binary Search");
        int[][] input = new int[][]{{4,6,10}, {10}, {1,2,3,4,5,6,7}, {5}, {10,6,4}, {10}, {10,6,4}, {4},
                {1}, {0}, {1}, {1}, {2,2}, {2}, {5,4,3,2} , {2}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Target: " + input[i+1][0]);
            System.out.println("Output: " + this.orderAgnosticBinarySearch(input[i], input[i+1][0]));
        }
    }

    private int orderAgnosticBinarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        int start = 0;
        int end = arr.length-1;
        boolean asc = true;
        if (arr[start] > arr[end]) asc = false;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] > target) {
                if (asc) end = mid - 1;
                else start = mid + 1;
            } else {
                if (asc) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }
}
