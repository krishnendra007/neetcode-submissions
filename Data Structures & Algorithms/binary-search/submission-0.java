class Solution {
    public int search(int[] nums, int t) {
        int ans=-1;
        int s=0,e=nums.length-1;

        while(s<=e){
            int m=(s+e)/2;
            if(nums[m]==t) return m;
            else if(nums[m]>t) e=m-1;
            else s=m+1;
        }
        return -1;

    }
}