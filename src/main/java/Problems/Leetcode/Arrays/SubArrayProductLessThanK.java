package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubArrayProductLessThanK extends Problem {
    @Override
    public void run() {
        System.out.println("Running Sub Array Product Less Than K");
        int[][] input = new int[][]{{2, 5, 3, 10}, {30},{8, 2, 6, 5}, {50},
                {10,5,2,6}, {100}, {1,2,3},{0}, {1,2,3,4,5}, {150}, {2, 1, 3, 25, 2, 1}, {75}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("K: " + input[i+1][0]);
            System.out.println("Sub Array Less Than K: " + this.findSubArraysLessThanK(input[i], input[i+1][0]));
        }
    }
    // Time complexity for just finding the num of sub array is O(n). Creating a sub array takes O(n2)
    // Hence total time complexity is O(n3)
    private List<List<Integer>> findSubArraysLessThanK(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int length = arr.length;
        if (length == 0) return result;
        int left, right;
        left = right = 0;
        int prod =  1;
        while (right < length) {
            prod *= arr[right];
            while (prod >= k && left < length) {
                prod /= arr[left++];
            }
            List<Integer> subList = new LinkedList<>();
            int curr = right;
            while (curr >= left) {
                subList.add(0, arr[curr--]);
                result.add(new ArrayList<>(subList));
            }
            right++;
        }
        return result;
    }
}
