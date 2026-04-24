class Solution {
    public boolean canJump(int[] nums) {
        int maxv=nums[0];
        for(int i=1;i<=Math.min(nums.length-1,maxv);i++){
            if(nums[i]+i>maxv){
                maxv=nums[i]+i;
            }
        }

        return maxv>=nums.length-1;
    }
}