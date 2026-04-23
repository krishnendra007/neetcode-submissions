class Solution {
    public int countSubstrings(String s) {
         int n=s.length();
        if(n<1||s==null) return 0;

        int cnt=0;
        

        for(int i=0;i<n;i++){
            int l1=expend(i,i,s);
            int l2=expend(i,i+1,s);
            cnt+=l1+l2;
        
        }

        return cnt;
    }

    private int expend(int left,int right, String s){
        int cnt=0;
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            cnt++;
            left--;
            right++;
        }

        return cnt;
    }
}