package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.Arrays;

public class ThreesumCloser extends Problem {
    @Override
    public void run() {
        System.out.println("Running Three Sum Closer");
        int[][] input = new int[][]{{-2, 0, 1, 2}, {2}, {-3, -1, 1, 2}, {0}, {1, 0, 1, 1}, {100}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Target: " + input[i+1][0]);
            System.out.println("Sum Closer: " + this.searchTripletSumCloser(input[i], input[i+1][0]));
        }
    }

    private int searchTripletSumCloser(int[] arr, int target) {
        int closerSum = 0;
        if (arr == null) return closerSum;
        int length = arr.length;
        if (length < 3) return closerSum;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < length - 2; i++) {
            int sum = this.twoSum(arr, i, target);
            if (sum == target) return sum;
            if (Math.abs(target - sum) < minDiff) {
                minDiff = Math.abs(target - sum);
                closerSum = sum;
            }
        }
        return closerSum;

    }

    private int twoSum(int[] arr, int i, int target) {
        int left = i+1;
        int right = arr.length - 1;
        int sum = arr[i];
        while (left < right) {
            sum = arr[i] + arr[left] + arr[right];
            if ( sum == target) return sum;
            else if (sum > target) right--;
            else left++;
        }
        return sum;
    }
}
