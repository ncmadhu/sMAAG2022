package Problems.educative.Arrays;

import Problems.Problem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxInSlidingWindow extends Problem {
    @Override
    public void run() {
        System.out.println("Running Find Max In Sliding Window");
        int[][] input = new int[][]{{-4,2,-5,3,6}, {3}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {3}};
        this.execute(input);
    }

    public void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i+2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Window Size: " + input[i+1][0]);
            System.out.println("Output: " + Arrays.toString(this.findMaxInSlidingWindow(input[i], input[i+1][0])));
        }

    }

    private int[] findMaxInSlidingWindow(int[] arr, int window) {
        int length = arr.length;
        if (length < window) window = length;
        int[] result = new int[length - window + 1];
        int index = -1;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < window; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) deque.removeLast();
            deque.addLast(i);
        }
        for (int i = window; i < length; i++) {
            result[++index] = arr[deque.peek()];
            while (!deque.isEmpty() && deque.peekFirst() <= i - window) deque.removeFirst();
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) deque.removeLast();
            deque.addLast(i);
        }
        result[++index] = arr[deque.peek()];
        return result;
    }
}
