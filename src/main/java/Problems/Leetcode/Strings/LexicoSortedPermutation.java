package Problems.Leetcode.Strings;

import Problems.Problem;

import java.util.*;

public class LexicoSortedPermutation extends Problem {
    @Override
    public void run() {
        String[] input = new String[]{"abc","abcd", "AAB"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Permutations: " + this.permutateLexicographically(input[i]));
        }
    }

    private List<String> permutateLexicographically(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null || str.length() == 0) return permutations;
        char[] chars = str.toCharArray();
        // Count the occurrence of each character in the string
        // permutation = O(n!) / O(n-repeatCount)!
        // TreeMap implements the comparable interface which keeps the keys sorted needed for lexicographically sort
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : chars) {
            countMap.compute(ch, (key, val) -> {
                if (val == null) return 1;
                else return val + 1;
            });
        }
        char[] result = new char[str.length()];
        char[] keys = new char[countMap.size()];
        int[] count = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry: countMap.entrySet()) {
            keys[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        this.permutate(keys, count, result, permutations, 0);
        return permutations;
    }

    private void permutate(char[] keys, int[] count, char[] result, List<String> permutations, int level) {
        if (level == result.length) {
            permutations.add(String.valueOf(result));
            return;
        }
        for (int i = 0; i < keys.length; i++) {
            if (count[i] == 0) continue;
            result[level] = keys[i];
            count[i] = count[i] - 1;
            this.permutate(keys, count, result, permutations, level+1);
            count[i] = count[i] + 1;
        }
    }
}
