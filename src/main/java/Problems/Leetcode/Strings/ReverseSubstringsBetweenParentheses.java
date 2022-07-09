package Problems.Leetcode.Strings;

import Problems.Problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseSubstringsBetweenParentheses extends Problem {
    @Override
    public void run() {
        System.out.println("Running Reverse Substrings Between Parentheses");
        String[] input = new String[]{"(abcd)", "(u(love)i)", "(ed(et(oc))el)", "abcd"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Output: " + this.reverseBetweenParentheses(input[i]));
            System.out.println("Output (Alt): " + this.reverseBetweenParenthesesWithQueue(input[i]));
        }
    }

    private String reverseBetweenParentheses(String str) {
        int length = str.length();
        if (length <= 1) return str;
        Stack<Character> holdingStack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != ')') {
                holdingStack.push(str.charAt(i));
            } else {
                String temp = "";
                while (!holdingStack.isEmpty()) {
                    char ch = holdingStack.pop();
                    if (ch == '(') break;
                    else temp += ch;
                }
                for (int k = 0; k < temp.length(); k++) {
                    holdingStack.push(temp.charAt(k));
                }
            }
        }
        String result = "";
        while (!holdingStack.isEmpty()) {
            result = holdingStack.pop() + result;
        }
        return result;
    }

    private String reverseBetweenParenthesesWithQueue(String s) {
        int length = s.length();
        if (length <= 1) return s;
        Stack<Character> holdingStack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch != ')') {
                holdingStack.push(ch);
            } else {
                Queue<Character> tempQueue = new LinkedList<>();
                while (!holdingStack.isEmpty()) {
                    char tempCh = holdingStack.pop();
                    if (tempCh == '(') break;
                    tempQueue.add(tempCh);
                }
                while (!tempQueue.isEmpty()) {
                    holdingStack.push(tempQueue.poll());
                }
            }
        }
        char[] result = new char[holdingStack.size()];
        for (int i = holdingStack.size() - 1; i >= 0; i--) {
            result[i] = holdingStack.pop();
        }
        return String.valueOf(result);
    }
}
