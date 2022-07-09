package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.*;

public class KthSmallestMergeSortedMedian extends Problem {
    @Override
    public void run() {
        System.out.println("Running Kth Smallest / Merge / Median  In M Sorted Arrays");
        Integer[][] input = new Integer[][]{{4,7,9}, {1,3,5}, {4,5,9}, {5},
                {11,23,50}, {1,6,9}, {0,25, 50}, {1},
                {30, 32, 40}, {85, 90}, {30, 32, 40}, {8}};
        this.execute(input);
    }
    private void execute(Integer[][] input) {
        for (int i = 0; i < input.length; i = i + 4) {
            System.out.println("Array 1: " + Arrays.toString(input[i]));
            System.out.println("Array 2: " + Arrays.toString(input[i+1]));
            System.out.println("Array 3: " + Arrays.toString(input[i+2]));
            System.out.println("K: " + input[i+3][0]);
            List<Integer[]> list = new ArrayList<>();
            list.add(input[i]);
            list.add(input[i+1]);
            list.add(input[i+2]);
            System.out.println("Merged: " + Arrays.toString(this.mergeMSortedArrays(list)));
            System.out.println("Kth Smallest: " + this.findKthSmallest(list, input[i+3][0]));
            System.out.println("Median: " + this.findMedianOfMsortedArrays(list));
        }
    }

    class ArrayTracker {
        int arrayIndex;
        int elementIndex;

        public ArrayTracker(int arrayIndex, int elementIndex) {
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }


    private int findMedianOfMsortedArrays(List<Integer[]> list) {
        int length = list.size();
        if (length == 0) return 0;
        int totalLength = 0;
        for (int i = 0; i < length; i++) {
            Integer[] arr = list.get(i);
            totalLength += arr.length;
        }
        int k;
        if (totalLength % 2 == 0) k = totalLength / 2;
        else k = (totalLength / 2) + 1;
        return this.findKthSmallest(list, k);
    }

    private int findKthSmallest(List<Integer[]> list, int k) {
        int length = list.size();
        if (length == 0) return 0;
        PriorityQueue<ArrayTracker> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(at -> list.get(at.arrayIndex)[at.elementIndex]));
        for (int i = 0; i < length; i++) {
            Integer[] arr = list.get(i);
            minHeap.add(new ArrayTracker(i, 0));
        }
        int count = 0;
        while (!minHeap.isEmpty()) {
            ArrayTracker at = minHeap.poll();
            if (++count == k) return list.get(at.arrayIndex)[at.elementIndex];
            at.elementIndex++;
            if (at.elementIndex < list.get(at.arrayIndex).length) minHeap.add(at);
        }
        return 0;
    }


    private int[] mergeMSortedArrays(List<Integer[]> list) {
        int length = list.size();
        if (length == 0) return new int[0];
        PriorityQueue<ArrayTracker> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(at -> list.get(at.arrayIndex)[at.elementIndex]));
        int totalLength = 0;
        for (int i = 0; i < length; i++) {
            Integer[] arr = list.get(i);
            totalLength += arr.length;
            minHeap.add(new ArrayTracker(i, 0));
        }
        int[] result = new int[totalLength];
        int resultIndex = 0;
        while (!minHeap.isEmpty()) {
            ArrayTracker at = minHeap.poll();
            result[resultIndex++] = list.get(at.arrayIndex)[at.elementIndex];
            at.elementIndex++;
            if (at.elementIndex < list.get(at.arrayIndex).length) minHeap.add(at);
        }
        return result;
    }
}
