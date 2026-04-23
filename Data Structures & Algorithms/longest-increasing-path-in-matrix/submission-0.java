class Solution {
    int[] dx= new int[]{1,0,-1,0};
    int[] dy=new int[]{0,-1,0,1};
    private int fun(int x, int y, int[][]ma, int[][] dp){
        int n=ma.length;
        int m=ma[0].length;

        if(x<0||y<0||x>=n||y>=m) return 0;
        if(dp[x][y]!=-1) return dp[x][y];

        int curr=0;
        for(int i=0;i<4;i++){
            int X=x+dx[i];
            int Y=y+dy[i];
            if(X>=0&&X<n&&Y>=0&&Y<m&&ma[X][Y]>ma[x][y]){
                curr=Math.max(curr,fun(X,Y,ma,dp));
            }
        }

        return dp[x][y]=1+curr;
       
    }
    public int longestIncreasingPath(int[][] ma) {
        int n=ma.length;
        int m=ma[0].length;

        int[][] dp= new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        int ans = 0;

        // try starting from every cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans,fun(i, j, ma, dp));
            }
        }

        return ans;
    }
}