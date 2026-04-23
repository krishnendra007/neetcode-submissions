class Solution {
    public int fun(int x, int y, String w1, String w2, int[][]dp){
        if(x<0) return y+1;
        if(y<0) return x+1;

        if(dp[x][y]!=-1) return dp[x][y];


        if(w1.charAt(x)==w2.charAt(y)){
            return dp[x][y]= fun(x-1,y-1,w1,w2,dp);
        }

        return dp[x][y]= 1+ Math.min(Math.min(fun(x-1,y,w1,w2,dp),fun(x,y-1,w1,w2,dp)),fun(x-1,y-1,w1,w2,dp));


    }
    public int minDistance(String word1, String word2) {
        int n= word1.length();
        int m=word2.length();

        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);

        return fun(n-1,m-1,word1,word2,dp);
    }
}