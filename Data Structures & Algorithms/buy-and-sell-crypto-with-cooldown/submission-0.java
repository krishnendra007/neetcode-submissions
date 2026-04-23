class Solution {
    int[][] dp;

    private int fun(int[] prices, int i, int buy) {
        if (i >= prices.length) return 0;

        if (dp[i][buy] != -1) return dp[i][buy];

        int profit;

        // buy ==1  you can buy
        if (buy == 1) {
            int take = -prices[i] + fun(prices, i + 1, 0);
            int skip = fun(prices, i + 1, 1);
            profit = Math.max(take, skip);
        }
        // buy ==0  you can hold or sell
        
         else {
            int sell = prices[i] + fun(prices, i + 2, 1); // cooldown
            int skip = fun(prices, i + 1, 0);
            profit = Math.max(sell, skip);
        }

        return dp[i][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];

        for (int[] row : dp) Arrays.fill(row, -1);

        return fun(prices, 0, 1);
    }
}