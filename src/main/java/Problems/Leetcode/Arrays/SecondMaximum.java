package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.Arrays;

public class SecondMaximum extends Problem {
    @Override
    public void run() {
        System.out.println("Running Second Maximum");
        int[][] input = new int[][]{{9, 2, 3, 2, 6, 6}, {1, 2, 3, 4, 5, 6}, {8, 8, 8, 8, 8}};
        this.execute(input);
    }
    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            int[] nums = input[i];
            System.out.println("Input: " + Arrays.toString(nums));
            System.out.println("Output: " + this.findSecondMaximum(nums));
        }
    }

    private int findSecondMaximum(int[] nums) {
        if (nums == null) return -1;
        int length = nums.length;
        if (length < 2) return -1;
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (nums[i] > firstMax) {
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return secondMax;
    }
}
