class Solution {
    int fun(int x, int y, String t1, String t2, int [][]dp){
        if(x<0||y<0) return 0;

        if(dp[x][y]!=-1) return dp[x][y];

        if(t1.charAt(x)==t2.charAt(y)){
            return dp[x][y]= 1+ fun(x-1,y-1,t1,t2,dp);
        }

        return dp[x][y]= Math.max(fun(x-1,y,t1,t2,dp),fun(x,y-1,t1,t2,dp));
        
        }
    public int longestCommonSubsequence(String t1, String t2) {
        int n=t1.length();
        int m=t2.length();

        int dp[][]= new int[n][m];

        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);

        return fun(n-1,m-1,t1,t2,dp);
    }
}