class Solution {
    
    private int fun(String s, int ind,int[]dp){
        if(ind==s.length()){
            return 1;
        }

        if(dp[ind]!=-1) return dp[ind];

        int cnt=0;

        if(ind<s.length()-1&&(s.charAt(ind)!='0')&&(((s.charAt(ind)-'0')*10+s.charAt(ind+1)-'0')<=26)){
            cnt+=fun(s,ind+2,dp);
        }
        if(s.charAt(ind)-'0'>0) cnt+=fun(s,ind+1,dp);
        return dp[ind]=cnt;
    }
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int n=s.length();
        int dp[]= new int[n];
        Arrays.fill(dp,-1);
        return fun(s,0,dp);
       
    }
}