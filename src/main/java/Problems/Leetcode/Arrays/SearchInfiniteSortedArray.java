package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.Arrays;

public class SearchInfiniteSortedArray extends Problem {
    @Override
    public void run() {
        System.out.println("Running Search In Sorted Infinite");
        int[][] input = new int[][]{{4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30}, {16},
                {4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30}, {11},
                {1, 3, 8, 10, 15}, {15}, {1, 3, 8, 10, 15}, {200}, {1}, {1}, {1,2}, {2}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Key: " + input[i+1][0]);
            System.out.println("Output: "+ this.search(input[i], input[i+1][0]));
        }
    }

    class ArrayReader {
        public int[] arr;

        public ArrayReader(int[] arr) {
            this.arr = arr;
        }

        public int getValue(int index) {
            if (index >= arr.length) return Integer.MAX_VALUE;
            return this.arr[index];
        }
    }

    private int search(int[] arr, int target) {
        ArrayReader arrayReader = new ArrayReader(arr);
        int start = 0;
        int end = 1;

        while (arrayReader.getValue(end) < target) {
            int temp = end;
            end = end + (end - start + 1) * 2;
            start = temp; // Move the start also since anyway target will not be below the end
        }
        return this.binarySearch(arrayReader, start, end, target);
    }

    private int binarySearch(ArrayReader arrayReader, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arrayReader.getValue(mid) == target) return mid;
            if (arrayReader.getValue(mid) > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}
