package Problems.Leetcode.Sorting;

import Problems.Problem;

import java.util.Arrays;

public class QuickSort extends Problem {
    @Override
    public void run() {
        System.out.println("Running QuickSort");
        int[][] input = new int[][]{{55, 23, 26, 2, 18, 78, 23, 8, 2, 3}, {1}, {9, 8, 7, 2, 3, 1},
                {10, 20, 30, -1, -2}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            int [] arr;
            arr = input[i].clone();
            this.quickSort(arr);
            System.out.println("Output: " + Arrays.toString(arr));
            arr = input[i].clone();
            this.quickSortEliminateTailRecursion(arr);
            System.out.println("Output (Tail Recursion): " + Arrays.toString(arr));
            arr = input[i].clone();
            this.quickSortIteration(arr);
            System.out.println("Output (Iteration): " + Arrays.toString(arr));
        }
    }

    private void quickSort(int[] arr) {
        if (arr == null) return;
        int length = arr.length;
        if (length <= 1) return;
        this.quickSort(arr, 0, length-1);
    }

    // Time complexity is T(n) = T(k) + T(n-1-k) + O(n)
    // Worst case O(n2)
    // Avg/ Best Case O(nlogn)
    private void quickSort(int[] arr, int low, int high) {
        if (low > high) return;
        int pivot = this.partition(arr, low, high);
        this.quickSort(arr, low, pivot-1);
        this.quickSort(arr, pivot+1, high);
    }


    // All elements are processed only once. Hence, time complexity is O(n)
    private int partition(int[] arr, int low, int high) {
        int pivotVal = arr[low];
        int left = low;
        int right = high;
        while (left < right) {
            while (left <= high && arr[left] <= pivotVal) left++;
            while (right >= low && arr[right] > pivotVal) right--;
            if (left < right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }
        arr[low] = arr[right];
        arr[right] = pivotVal;
        return right;
    }

    // Tail Recursion --- last statement in a method is recursion as above in Quick Sort
    // Eliminate tail recursion to reduce the stack space used
    // In worst case the stack space used could be O(n)
    // Eliminating tail recursion could reduce that to O(logn)
    public void quickSortEliminateTailRecursion(int[] arr) {
        if (arr == null) return;
        int length = arr.length;
        if (length <= 1) return;
        this.quickSortEliminateTailRecursion(arr, 0, length-1);

    }
    public void quickSortEliminateTailRecursion(int[] arr, int low, int high) {
        while (low < high) {
            int pivot = this.partition(arr, low, high);
            // simply replacing the last recursive call would not be helpful if array
            // is already sorted. Hence, call recursion for the smaller part of the array
            if (pivot - low < high - pivot) {
                this.quickSortEliminateTailRecursion(arr, low, pivot-1);
                low = pivot + 1;
            } else {
                this.quickSortEliminateTailRecursion(arr, pivot + 1, high);
                high = pivot - 1;
            }
        }
    }

    public void quickSortIteration(int[] arr) {
        if (arr == null) return;
        int length = arr.length;
        if (length <= 1) return;
        this.quickSortIteration(arr, 0, length-1);

    }

    private void quickSortIteration(int[] arr, int low, int high) {
        int[] stack = new int[arr.length];
        int top = -1;
        stack[++top] = low;
        stack[++top] = high;
        while (top >= 0) {
            high = stack[top--];
            low = stack[top--];
            int pivot = this.partition(arr, low, high);
            if (pivot - 1 > low) {
                stack[++top] = low;
                stack[++top] = pivot-1;
            }
            if (pivot + 1 < high) {
                stack[++top] = pivot+1;
                stack[++top] = high;
            }
        }
    }

}
