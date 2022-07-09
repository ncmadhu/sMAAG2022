package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreesumSmaller extends Problem {
    @Override
    public void run() {
        System.out.println("Running Three Sum Smaller");
        int[][] input = new int[][]{{-2, 0, 1, 3}, {2}, {3, 5, 2, 8, 1}, {7}, {-1, 0, 2, 3}, {3}, {-1, 4, 2, 1, 3}, {5}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Target: " + input[i+1][0]);
            System.out.println("Triplets less than target: " + this.threeSumSmaller(input[i], input[i+1][0]));
            System.out.println("Triplets less than target: " + this.tripletsLessThanK(input[i], input[i+1][0]));
        }
    }

    private int threeSumSmaller(int[] arr, int k) {
        int count = 0;
        int length = arr.length;
        if (length < 3) return count;
        Arrays.sort(arr);
        for (int i = 0; i < length; i++) {
            int rem = k - arr[i];
            int left = i+1;
            int right = length-1;
            while (left < right) {
                if (arr[left] + arr[right] < rem) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    private List<List<Integer>> tripletsLessThanK(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int length = arr.length;
        if (length < 3) return result;
        Arrays.sort(arr);
        for (int i = 0; i < length; i++) {
            int rem = k - arr[i];
            int left = i+1;
            int right = length-1;
            while (left < right) {
                if (arr[left] + arr[right] < rem) {
                    int curr = left+1;
                    while (curr <= right) {
                        List<Integer> triplets = new ArrayList<>();
                        triplets.add(arr[i]);
                        triplets.add(arr[left]);
                        triplets.add(arr[curr]);
                        result.add(triplets);
                        curr++;
                    }
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
