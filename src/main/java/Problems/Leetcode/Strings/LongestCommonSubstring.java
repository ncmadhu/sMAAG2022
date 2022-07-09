package Problems.Leetcode.Strings;

import Problems.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LongestCommonSubstring extends Problem {
    @Override
    public void run() {
        System.out.println("Running Longest Common Substring");
        String[] input = new String[]{"abdca", "cbda", "passport", "ppsspt", "adcadce", "bdaadce", "abcd", "efgh",
        "abdc", "ebdc", "aadec", "adecf"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("String 1: " + input[i]);
            System.out.println("String 2: " + input[i+1]);
            //System.out.println("Brute Force: " + this.longestCommonSubstringBF(input[i], input[i+1]));
            System.out.println("Brute Force (Alternate): " + this.longestCommonSubstringBFAlternate(input[i],
                    input[i+1]));
            //System.out.println("Brute Force Length: " + this.longestCommonSubstringLengthBruteForce(input[i],
                    //input[i+1]));
            System.out.println("DP Solution: " + this.longestCommonSubstringDP(input[i], input[i+1]));
        }
    }

    private String longestCommonSubstringBFAlternate(String s1, String s2) {
        String longestSubstring = "";
        if (s1.length() == 0 || s2.length() == 0) return longestSubstring;
        List<String> s1Substrings = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            String subString = String.valueOf(s1.charAt(i));
            s1Substrings.add(subString);
            for (int j = i+1; j < s1.length(); j++) {
                subString = subString + s1.charAt(j);
                s1Substrings.add(subString);
            }
        }
        for (String subString: s1Substrings) {
            if (s2.contains(subString) && subString.length() > longestSubstring.length()) longestSubstring = subString;
        }
        return longestSubstring;
    }

    private String longestCommonSubstringBF(String str1, String str2) {
        String longestSubstring = "";
        int count = 0;
        int out = 0;
        while (out < str1.length()) {
            // Initialize the starting position for str2 string
            // Because each str1 position needs to be compared from the start of the str2 string
            int currOut = out;
            int in = 0;
            while (in < str2.length()) {
                // Initialize the temp variables for incrementing the current position of str1 and str2
                // The original value is still needed because if str1[currOut] != str2[currIn]
                // We need to restart the comparison again from in + 1 for the same out position
                // example bdc --- bbdc
                // b == b
                // d != b
                // Hence to start again from in + 1 to get
                // b == b
                // d == d
                // c == c
                currOut = out;
                int currIn = in;
                while (currOut < str1.length() &&
                        currIn < str2.length() && str1.charAt(currOut) != str2.charAt(currIn)) {
                    currIn++;
                    count++;
                }
                String currCommon = "";
                while (currOut < str1.length() &&
                        currIn < str2.length() && str1.charAt(currOut) == str2.charAt(currIn)) {
                    currCommon += str1.charAt(currOut);
                    currOut++;
                    currIn++;
                    count++;
                }
                if (currCommon.length() > longestSubstring.length()) longestSubstring = currCommon;
                // If currOut has not moved at all. Then no point in incrementing currIn and comparing again
                // example abdc ---- eddc
                // even if we move currIn to d and start there is no use. Since we already compared that with a
                // Hence, break and start comparing from b
                if (currOut == out || currOut == str1.length()) break;
                in++;
            }
            // If you reached end of string 1 already then no more comparison left. since currOut increments only
            // if there is match
            if (currOut == str1.length()) break;
            out++;
        }
        //System.out.println("Loop Count: " + count);
        return longestSubstring;
    }

    private int longestCommonSubstringLengthBruteForce(String str1, String str2) {
        int maxCommonLength = 0;
        if (str1.length() == 0 || str2.length() == 0) return maxCommonLength;
        return this.longestCommonSubstringLengthBruteForce(str1, str2, 0, 0, 0);
    }

    private int longestCommonSubstringLengthBruteForce(String s1, String s2, int s1Index, int s2Index,
                                                       int commonLength) {
        if (s1Index >= s1.length() || s2Index >= s2.length()) return commonLength;
        if (s1.charAt(s1Index) == s2.charAt(s2Index)) commonLength = this.longestCommonSubstringLengthBruteForce(
                s1, s2, s1Index+1, s2Index+1, commonLength+1);
        int subPath1Count = this.longestCommonSubstringLengthBruteForce(s1, s2, s1Index+1, s2Index, 0);
        int subPath2Count = this.longestCommonSubstringLengthBruteForce(s1, s2, s1Index, s2Index+1, 0);
        return Math.max(commonLength, Math.max(subPath1Count, subPath2Count));
    }

    // Million Dollar solution
    private String longestCommonSubstringDP(String s1, String s2) {
        String longestCommonSubstring = "";
        // Check for empty strings and return
        if (s1.length() == 0 || s2.length() == 0) return longestCommonSubstring;
        // Initialize the longestLen and index pos to 0
        int longestLen = 0;
        int pos = 0;
        // Initialize the array to the length of the string representing the column
        // The previous row value is set to 0. It represents one of the string as empty
        int[] prevRow = new int[s2.length() + 1];
        // Start from index 1. Since 0 index represents an empty string
        for (int s1Index = 1; s1Index <= s1.length(); s1Index++) {
            // Initialize a row to store the length of common substring so far
            int[] currRow = new int[s2.length() + 1];
            for (int s2Index = 1; s2Index <= s2.length(); s2Index++) {
                // If values are equal add 1 to the previous row common substring
                if (s1.charAt(s1Index-1) == s2.charAt(s2Index-1)) {
                    currRow[s2Index] = 1 + prevRow[s2Index-1];
                    // Store the index position to retrieve the substring later
                    if (currRow[s2Index] > longestLen) {
                        longestLen = currRow[s2Index];
                        pos = s2Index;
                    }
                } else {
                    currRow[s2Index] = 0;
                }
            }
            // Make the current row as previous row
            prevRow = currRow;
        }
        // Length is greater than 0 common substring is found and retrieve the substring using the position stored
        if (longestLen > 0) {
            longestCommonSubstring = s2.substring(pos-longestLen, pos);
        }
        return longestCommonSubstring;
    }
}
