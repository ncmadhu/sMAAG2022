package Problems.Leetcode.Strings;

import Problems.Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LongestCommonSubsequence extends Problem {
    @Override
    public void run() {
        System.out.println("Running Longest Common Subsequence From AlgoExpert");
        String[] input = new String[]{"ZXVVYZW", "XKYKZPW", "passport", "psspt"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i = i+2) {
            System.out.println("String 1: " + input[i]);
            System.out.println("String 2: " + input[i+1]);
            System.out.println("Output: " + this.longestCommonSubsequence(input[i], input[i+1]));
            System.out.println("Length: " + this.longestCommonSubsequenceLength(input[i], input[i+1]));
        }
    }

    private int longestCommonSubsequenceLength(String s1, String s2) {
        int longestCommonSubsequenceLen = 0;
        if (s1.length() == 0 || s2.length() == 0) return longestCommonSubsequenceLen;
        int[] prevRow = new int[s2.length() + 1];
        for (int s1Index = 1; s1Index <= s1.length(); s1Index++) {
            int[] currRow = new int[s2.length()+1];
            for (int s2Index = 1; s2Index <= s2.length(); s2Index++) {
                if (s1.charAt(s1Index-1) == s2.charAt(s2Index-1)) {
                    currRow[s2Index] = 1 + prevRow[s2Index-1];
                } else {
                    currRow[s2Index] = Math.max(currRow[s2Index-1], prevRow[s2Index]);
                }
                longestCommonSubsequenceLen = Math.max(currRow[s2Index], longestCommonSubsequenceLen);
            }
            prevRow = currRow;
        }
        return longestCommonSubsequenceLen;
    }

    private String longestCommonSubsequence(String s1, String s2) {
        String longestCommonSubsequence = "";
        if (s1.length() == 0 || s2.length() == 0) return longestCommonSubsequence;
        int[][] record = new int[s1.length()+1][s2.length()+1];
        for (int s1Index = 1; s1Index <= s1.length(); s1Index++) {
            for (int s2Index = 1; s2Index <= s2.length(); s2Index++) {
                if (s1.charAt(s1Index-1) == s2.charAt(s2Index-1)) {
                    record[s1Index][s2Index] = 1 + record[s1Index-1][s2Index-1];
                } else {
                    record[s1Index][s2Index] = Math.max(record[s1Index-1][s2Index], record[s1Index][s2Index-1]);
                }
            }
        }
        int i = s1.length();
        int j = s2.length();
        List<Character> commonChars = new LinkedList<>();
        // Start from the end of 2D matrix which has the max value
        // Find from which the value comes for record[i][j]
        // If it is not from any of the values above or before
        // add it to the commonChars.
        // If it is from above decrement i
        // If it is from before decrement j
        while (i != 0 && j != 0) {
            if (record[i][j] == record[i-1][j]) i--;
            else if (record[i][j] == record[i][j-1]) j--;
            else {
                commonChars.add(0, s2.charAt(j-1));
                i--;
                j--;
            }
        }
        return commonChars.toString();

    }

    private String longestCommonSubsequenceFirst(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 == 0 | len2 == 0) return "";
        int[][] mem = new int[len1+1][len2+1];
        List<Character> commonChars = new LinkedList<>();
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    mem[i][j] = 1 + mem[i-1][j-1];
                } else {
                    mem[i][j] = Math.max(mem[i-1][j],mem[i][j-1]);
                }
            }
        }
        int i = len1;
        int j = len2;
        while (i != 0 && j != 0) {
            if (mem[i][j] == mem[i-1][j]) i--;
            else if(mem[i][j] == mem[i][j-1])j--;
            else {
                commonChars.add(0, str2.charAt(j-1));
                i--;
                j--;
            }
        }
        return commonChars.toString();
    }
}
