package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreesumToZero extends Problem {
    @Override
    public void run() {
        System.out.println("Running Three Sum To Zero");
        int[][] input = new int[][]{{-3, 0, 1, 2, -1, 1, -2}, {-5, 2, -1, -2, 3}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Output: " + this.searchTriplets(input[i].clone()));
            System.out.println("Output (Hash): " + this.threeSumToZeroHash(input[i]));
        }
    }

    private List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length <= 3) return result;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                if (arr[left] + arr[right] == -arr[i]){
                    result.add(new ArrayList<>(
                            Arrays.asList(arr[i], arr[left], arr[right])));
                    right--;
                    left++;
                } else if (arr[left] + arr[right] > -arr[i]) right--;
                else left++;
            }
        }
        return result;
    }

    private List<List<Integer>> threeSumToZeroHash(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length <= 3) return result;
        for (int i = 0; i < arr.length-2; i++) {
            HashSet<Integer> otherNum = new HashSet<>();
            for (int j = i+1; j < arr.length; j++) {
                if (otherNum.contains(-arr[i]- arr[j])) result.add(new ArrayList<>(
                        Arrays.asList(arr[i], -arr[i]- arr[j], arr[j])));
                else otherNum.add(arr[j]);
            }
        }
        return result;
    }


}
