package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.Arrays;

public class SmallestSubArrayWithSumOrGreater extends Problem {
    @Override
    public void run() {
        System.out.println("Running Smallest Sub Array With Sum or Greater Than K");
        int[][] input = new int[][]{{2, 1, 5, 2, 3, 2}, {7},{2, 1, 5, 2, 8}, {7}, {3, 4, 1, 1, 6}, {8},
                {2,5,3,4}, {100}, {2,5,1,1,1,4,4,9}, {8}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("K: " + input[i+1][0]);
            System.out.println("Sub Array Equal Greater Than K: " +
                    Arrays.toString(this.findSmallestSubArrayGreaterOrEqual(input[i], input[i+1][0])));
            System.out.println("Sub Array Equal To K: " +
                    Arrays.toString(this.findSmallestSubArrayEqual(input[i], input[i+1][0])));
        }
    }

    private int[] findSmallestSubArrayGreaterOrEqual(int[] arr, int k) {
        if (arr == null || arr.length == 0) return new int[0];
        int minLeft = 0, maxRight = 0;
        int left, right, currSum;
        left = right = currSum = 0;
        int minLength = Integer.MAX_VALUE;
        while (right < arr.length) {
            currSum += arr[right];
            while (currSum >= k) {
                if (right - left + 1 < minLength) {
                    minLeft = left;
                    maxRight = right;
                    minLength = right - left + 1;
                }
                currSum -= arr[left++];
            }
            right++;
        }
        if (minLength != Integer.MAX_VALUE) {
            return Arrays.copyOfRange(arr, minLeft, maxRight+1);
        } else {
            return new int[0];
        }
    }

    private int[] findSmallestSubArrayEqual(int[] arr, int k) {
        if (arr == null || arr.length == 0) return new int[0];
        int left, right, currSum, minLeft, maxRight;
        left = right = currSum = minLeft = maxRight = 0;
        int minLength = Integer.MAX_VALUE;
        while (right < arr.length) {
            currSum += arr[right];
            while (currSum > k) {
                currSum -= arr[left++];
            }
            if (currSum == k) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                    maxRight = right;
                }
            }
            right++;
        }
        if (minLength != Integer.MAX_VALUE) {
            return Arrays.copyOfRange(arr, minLeft, maxRight+1);
        } else {
            return new int[0];
        }
    }


}
