package Problems.educative.Arrays;

import Problems.Problem;

import java.util.Arrays;

public class MaxInSlidingWindow extends Problem {
    @Override
    public void run() {
        System.out.println("Running Find Max In Sliding Window");
        int[] arr;
        int window;
        this.execute(new int[]{-4,2,-5,3,6}, 3);
        this.execute(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3);
    }

    public void execute(int[] arr, int window) {
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Window Size: " + window);
        this.findMaxInSlidingWindow(arr, window);
        System.out.println("Output: ");
    }

    private void findMaxInSlidingWindow(int[] arr, int window) {
    }
}
