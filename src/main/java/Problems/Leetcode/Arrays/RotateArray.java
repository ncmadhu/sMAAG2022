package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.Arrays;

public class RotateArray extends Problem {
    @Override
    public void run() {
        System.out.println("Running Rotate Array");
        int[] input = new int[]{1, 2, 3, 4, 7, 8};
        this.execute(input);
    }

    private void execute(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
            int k = input[i];
            System.out.println(("Input: " + Arrays.toString(nums)));
            System.out.println(("K: " + k));
            this.rotateArray(nums, k);
            System.out.println("Output: " + Arrays.toString(nums));
        }
    }

    private void rotateArray(int[] arr, int k) {
        int length = arr.length;
        if (length <= 1) return;
        k = k % length;
        int swapped = 0;
        for (int start = 0; swapped < length; start++) {
            int curr = start;
            int prev = arr[curr];
            do {
                int next = (curr + k) % length;
                int temp = arr[next];
                arr[next] = prev;
                prev = temp;
                curr = next;
                swapped++;
            } while (curr != start);
        }
    }
}
