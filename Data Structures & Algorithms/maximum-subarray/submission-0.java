class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum =Integer.MIN_VALUE;
        int maxsoFar=0;

        for(int i=0;i<nums.length;i++){
            maxsoFar+=nums[i];
            maxsum=Math.max(maxsoFar,maxsum);
            if(maxsoFar<0) maxsoFar=0;
        }
        return maxsum;
    }
}