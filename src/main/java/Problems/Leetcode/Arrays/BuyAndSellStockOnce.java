package Problems.Leetcode.Arrays;

import Problems.Problem;

import java.util.Arrays;

public class BuyAndSellStockOnce extends Problem {
    @Override
    public void run() {
        System.out.println("Running Buy And Sell Stock Once");
        int[][] input = new int[][]{{7, 1, 5, 3, 6, 4}, {7, 6, 4, 3, 1}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println(("Input: " + Arrays.toString(input[i])));
            System.out.println("Output: " + this.maxProfit(input[i]));
        }
    }

    private int maxProfit(int[] prices) {
        int maxProfit, currProfit;
        currProfit = 0;
        maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            currProfit = Math.max(prices[i] - prices[i-1], currProfit + prices[i] - prices[i-1]);
            maxProfit = Math.max(currProfit, maxProfit);
        }
        return maxProfit;
    }
}
