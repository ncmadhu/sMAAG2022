package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.Arrays;

public class ReArrangeMaxMin extends Problem {
    @Override
    public void run() {
        System.out.println("Running Re Arrange Max And Min");
        int[][] input = new int[][]{{1, 2, 3, 4, 5, 6, 7}, {1, 2, 3, 4, 5, 6,}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length;i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            this.reArrange(input[i]);
            System.out.println("Output: " + Arrays.toString(input[i]));
        }
    }

    private void reArrange(int[] arr) {
        int length = arr.length;
        if (length < 2) return;
        int multiplier = arr[length-1] + 1;
        int maxIndex = length-1;
        int minIndex = 0;
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                arr[i] = (arr[maxIndex] % multiplier) * multiplier + arr[i];
                maxIndex--;
            } else {
                arr[i] = (arr[minIndex] % multiplier) * multiplier + arr[i];
                minIndex++;
            }
        }
        for (int i = 0; i < length; i++) {
            arr[i] = arr[i] / multiplier;
        }
    }
}
