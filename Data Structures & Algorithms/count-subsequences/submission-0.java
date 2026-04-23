class Solution {
    private int fun(int indx, int indy, String x, String y,int [][]dp){
        int n=x.length();
        int m=y.length();

        if(indy==m) return 1;
        if(indx==n) return 0;

        if(dp[indx][indy]!=-1) return dp[indx][indy];

        int cnt=0;
        if(x.charAt(indx)==y.charAt(indy)){
            cnt+=fun(indx+1,indy+1,x,y,dp);
        }
        cnt+=fun(indx+1,indy,x,y,dp);
        return dp[indx][indy]=cnt;
    }
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();

        int[][]dp= new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);

        return fun(0,0,s,t,dp);
    }
}