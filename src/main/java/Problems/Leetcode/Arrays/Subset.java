package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.*;

public class Subset extends Problem {
    @Override
    public void run() {
        System.out.println("Running SubSet");
        int[][] input = new int[][]{{1,3}, {1,5,3}, {1,3,3}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Output: " + this.findSubSets(input[i]));
        }
    }

    private Set<List<Integer>> findSubSets(int[] arr) {
        Set<List<Integer>> result = new HashSet<>();
        if (arr == null || arr.length == 0) return result;
        result.add(new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            List<List<Integer>> subSet = new ArrayList<>();
            for (List<Integer> list: result) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(arr[i]);
                subSet.add(newList);
            }
            result.addAll(subSet);
        }
        return result;
    }
}
