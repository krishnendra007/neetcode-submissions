class Solution {
    private int fun(int ind,int sum, int[]c, int[][]dp){
        if(sum==0) return 1;
        
        if(ind==c.length){
            return 0;
        }

        if(dp[ind][sum]!=-1) return dp[ind][sum];

        int cnt=0;

        cnt+=fun(ind+1,sum,c,dp);
        if(c[ind]<=sum){
            cnt+=fun(ind,sum-c[ind],c,dp);
        }
        return dp[ind][sum]=cnt;
    }
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int n=coins.length;
        int [][] dp= new int[n][amount+1];

        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return fun(0,amount,coins,dp);
    }
}