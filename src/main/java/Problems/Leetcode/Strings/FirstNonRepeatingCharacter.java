package Problems.Leetcode.Strings;

import Problems.Problem;

import java.util.HashMap;

public class FirstNonRepeatingCharacter extends Problem {
    @Override
    public void run() {
        System.out.println("Running First Non Repeating Character From AlgoExpert");
        String[] input = new String[]{"abcdcaf", "aaaaa", "aabbf"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Output: " + this.firstNonRepeatingCharacter(input[i]));
        }
    }

    private int firstNonRepeatingCharacter(String string) {
        int length = string.length();
        if (length == 0) return -1;
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char ch = string.charAt(i);
            if (count.containsKey(ch)) {
                count.put(ch, 1);
            } else {
                count.put(ch, 0);
            }
        }
        for (int i = 0; i < length; i++) {
            if (count.get(string.charAt(i)) == 0) return i;
        }
        return -1;
    }
}
