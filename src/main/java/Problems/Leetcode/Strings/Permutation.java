package Problems.Leetcode.Strings;

import Problems.Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutation extends Problem {
    @Override
    public void run() {
        String[] input = new String[]{"abc","abcd", "AAB"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Permutations (Subset Method): " + this.permutateWithSubset(input[i]));
            System.out.println("Permutations (Recursive): " + this.permutateRecursive(input[i]));
        }
    }

    private void swap(char[] chars, int src, int dest) {
        char temp = chars[src];
        chars[src] = chars[dest];
        chars[dest] = temp;
    }

    private List<String> permutateRecursive(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null || str.length() == 0) return permutations;
        this.permutateRecursive(str.toCharArray(), 0, permutations);
        return permutations;
    }

    private void permutateRecursive(char[] chars, int index, List<String> permutations) {
        if (index == chars.length) {
            permutations.add(String.valueOf(chars));
            return;
        }
        for (int curr = index; curr < chars.length; curr++) {
            this.swap(chars, curr, index);
            this.permutateRecursive(chars, index+1, permutations);
            this.swap(chars, index, curr);
        }
    }

    // O(n * n!) times
    // space is also O(n * n!) times
    private List<String> permutateWithSubset(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null || str.length() == 0) return permutations;
        Queue<List<Character>> holdingQueue = new LinkedList<>();
        holdingQueue.add(new ArrayList<>());
        for (char ch : str.toCharArray()) {
            // Add current character to each permutation in the queue
            int currQueueSize = holdingQueue.size();
            for (int i = 0; i < currQueueSize; i++) { // N! times
                List<Character> currPermutation = holdingQueue.poll();
                // Get the size to infer available index positions to insert the current character
                int currPermutationSize = currPermutation.size();
                // <= is for inserting the character at the end of the list also
                for (int j = 0; j <= currPermutationSize; j++) { // N times
                    List<Character> newPermutation = new ArrayList<>(currPermutation);
                    newPermutation.add(j, ch);
                    // If all the characters has been added, add to the result instead of queue
                    if (newPermutation.size() == str.length()) {
                        StringBuilder sb = new StringBuilder();
                        // Appends characters one by one
                        for (Character c : newPermutation) {
                            sb.append(c);
                        }
                        permutations.add(sb.toString());
                    } else {
                        holdingQueue.add(newPermutation);
                    }
                }
            }
        }
        return permutations;
    }
}
