class Solution {
    public int lengthOfLongestSubstring(String s) {
        int st=0,end=0,n=s.length();
        if(n==0) return 0;

        int arr[]= new int[256];

        int ans=0;

        while(end<n){
            if(arr[s.charAt(end)]==0){
                ans=Math.max(ans, end-st+1);
                arr[s.charAt(end)]=1;
                end++;
            } else{
                arr[s.charAt(st)]=0;
                st++;
            }

        }
        return ans;
    }
}
