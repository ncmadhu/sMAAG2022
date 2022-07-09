package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.Arrays;

public class BuyAndSellStockMultipleTimes extends Problem {
    @Override
    public void run() {
        System.out.println("Running Buy And Sell Stock Multiple Times");
        int[][] input = new int[][]{{7, 1, 5, 3, 6, 4}, {7, 6, 4, 3, 1}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println(("Input: " + Arrays.toString(input[i])));
            System.out.println("Output: " + this.totalProfit(input[i]));
        }
    }

    private int totalProfit(int[] prices) {
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) totalProfit += prices[i] - prices[i-1];
        }
        return totalProfit;
    }
}
