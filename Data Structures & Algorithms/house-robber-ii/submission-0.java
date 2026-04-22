class Solution {
    public int rob2(int[] nums) {
        int n=nums.length;

        int dp[]= new int[n+1];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

        return dp[n-1];
    }

    public int rob(int[] nums) {
        int n=nums.length;
         if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);

        int x= nums[0];
        nums[0]=0;
        int maxa=rob2(nums);

        nums[0]=x;
        x=nums[n-1];
        nums[n-1]=0;

        maxa=Math.max(maxa,rob2(nums));

        return maxa;
    
    }
}