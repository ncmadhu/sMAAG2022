package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.Arrays;

public class KadanesAlgorithm extends Problem {
    @Override
    public void run() {
        System.out.println("Running Kadanes Algorithm");
        int[][] input = new int[][]{{3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4},
                {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10},
                {-10, -2, -9, -4, -8, -6, -7, -1, -3, -5}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Max Sum: " + this.kadanesAlgorithm(input[i]));
        }
    }

    private int kadanesAlgorithm(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int left = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
                left = i;

            } else {
                sum = sum + nums[i];
            }
            if (sum > maxSum) {
                maxSum = sum;
                start = left;
                end = i;
            }
        }
        System.out.println("Start: " + start);
        System.out.println("End: " + end);
        return maxSum;
    }
}
