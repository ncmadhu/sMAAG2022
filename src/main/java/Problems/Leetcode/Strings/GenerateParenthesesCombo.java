package Problems.Leetcode.Strings;

import Problems.Problem;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesCombo extends Problem {
    @Override
    public void run() {
        System.out.println("Running Generate Parentheses Combo");
        this.execute(4);
    }

    private void execute(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println("Input: " + i);
            System.out.println("Output: " + this.generateParenthesesCombo(i));
        }
    }

    private List<String> generateParenthesesCombo(int n) {
        List<String> parentheses = new ArrayList<>();
        this.permutate(new StringBuilder(), 0, 0, n, parentheses);
        return parentheses;
    }

    private void permutate(StringBuilder curr, int open, int close, int n, List<String> parentheses) {
        if (open == close && curr.length() == n * 2) {
            parentheses.add(curr.toString());
            return;
        }
        if (open < n) {
            curr.append("(");
            permutate(curr, open + 1, close, n, parentheses);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (close < open) {
            curr.append(")");
            permutate(curr, open, close+1, n, parentheses);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
