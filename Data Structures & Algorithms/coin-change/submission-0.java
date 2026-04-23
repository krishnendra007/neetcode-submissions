class Solution {
    public int fun(int ind, int T, int[] coins, int[][] dp) {
        if (T == 0) return 0;          // base: amount 0 → 0 coins
        if (ind < 0) return Integer.MAX_VALUE; // no coins left, impossible

        if (dp[ind][T] != -1) return dp[ind][T];

        // don't take current coin
        int notTake = fun(ind - 1, T, coins, dp);

        // take current coin if possible
        int take = Integer.MAX_VALUE;
        if (T >= coins[ind]) {
            int res = fun(ind, T - coins[ind], coins, dp);
            if (res != Integer.MAX_VALUE) take = 1 + res;
        }

        return dp[ind][T] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int [][] dp = new int [n][amount+1];

        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);

        int ans = fun(n - 1, amount, coins, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
