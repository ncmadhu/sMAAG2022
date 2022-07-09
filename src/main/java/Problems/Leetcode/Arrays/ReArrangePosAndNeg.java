package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.Arrays;

public class ReArrangePosAndNeg extends Problem {
    @Override
    public void run() {
        System.out.println("Running Re Arrange Pos And Neg");
        int[][] input = new int[][]{{10, -1, 20, 4, 5, -9, -6}, {10, 20, 30, -10, -20, -30}, {-10, -20, -30, 10, 20, 30},
                {10, 20, 30}, {-10, -20, -30}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            int[] nums = Arrays.copyOfRange(input[i], 0, input[i].length);
            System.out.println("Input: " + Arrays.toString(nums));
            nums = Arrays.copyOfRange(input[i], 0, input[i].length);
            this.reArrangeWithOrderPreservation(nums);
            System.out.println("Output (In Place With order): " + Arrays.toString(nums));
        }
    }

    private void reArrangeWithOrderPreservation(int[] nums) {
        if (nums == null) return;
        int length = nums.length;
        if (length <= 1) return;
        int write = length - 1;
        int read = length - 1;
        while (read >= 0) {
            if (nums[read] < 0) {
                read--;
                continue;
            }
            int temp = nums[read];
            int j = read;
            while (j < write) {
                nums[j] = nums[j+1];
                j++;
            }
            nums[write] = temp;
            write--;
            read--;
        }
    }
}
