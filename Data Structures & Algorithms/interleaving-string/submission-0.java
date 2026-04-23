class Solution {
    private boolean fun(Boolean[][] dp, int ind1, int ind2, int ind3, String s1, String s2, String s3){
        
        if(ind1==s1.length()&&ind2==s2.length()&&ind3==s3.length()) return true;
        if(ind1>s1.length()||ind2>s2.length()||ind3>s3.length()) return false;

        if(dp[ind1][ind2]!=null) return dp[ind1][ind2];

        boolean find=false;
        if(ind1<s1.length()&&ind3<s3.length()&&s1.charAt(ind1)==s3.charAt(ind3)) find=find || fun(dp,ind1+1,ind2,ind3+1,s1,s2,s3);
        if(ind2<s2.length()&&ind2<s3.length()&&s2.charAt(ind2)==s3.charAt(ind3)) find=find || fun(dp,ind1,ind2+1,ind3+1,s1,s2,s3);

        return dp[ind1][ind2]= find;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int n1=s1.length();
        int n2=s2.length();
        int n3=s3.length();
        if(n1+n2!=n3) return false;
        if(n1==0&&n2==0&&n3==0) return true;
        Boolean[][] dp = new Boolean[n1+1][n2+1];

        for(int i=0;i<n1;i++) Arrays.fill(dp[i],null);

        return fun(dp,0,0,0,s1,s2,s3);
    }
}