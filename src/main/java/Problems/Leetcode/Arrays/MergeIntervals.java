package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals extends Problem {
    @Override
    public void run() {
        System.out.println("Running Merge Intervals From LeetCode");
        int[][][] input = new int[][][]{{{1,3}, {2,6}, {8,10}, {15,18}},
                                        {{1,4}, {4,5}},
                                        {{2,6}, {1,3}, {15,18}, {8,10}}};
        this.execute(input);
    }

    private void execute(int[][][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: ");
            int[][] intervals = input[i];
            for (int j = 0; j < intervals.length; j++) {
                System.out.println(Arrays.toString(intervals[j]));
            }
            int[][] result = this.mergeIntervals(intervals);
            System.out.println("Output: ");
            for (int j = 0; j < result.length; j++) {
                System.out.println(Arrays.toString(result[j]));
            }
        }
    }

    private int[][] mergeIntervals(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(n -> n[0]));
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (prev[1] >= intervals[i][0]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                merged.add(new int[]{prev[0], prev[1]});
                prev = intervals[i];
            }
        }
        merged.add(new int[]{prev[0], prev[1]});
        return merged.toArray(new int[merged.size()][]);
    }
}
