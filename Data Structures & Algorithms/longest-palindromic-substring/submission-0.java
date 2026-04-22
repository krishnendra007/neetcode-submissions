class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n<1||s==null) return "";
        int left=0,right=0;

        for(int i=0;i<n;i++){
            int l1=expend(i,i,s);
            int l2=expend(i,i+1,s);

            int len=Math.max(l1,l2);

            if(right-left+1<len){
                right=i+(len)/2;
                left=i-(len-1)/2;
            }
        }

        return s.substring(left,right+1);
    }

    private int expend(int left,int right, String s){
        int ml=0;
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            ml=Math.max(ml,right-left+1);
            left--;
            right++;
        }

        return ml;
    }
}