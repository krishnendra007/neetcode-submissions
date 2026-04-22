class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int ans[]= new int[n];

        int cnt=0;
        int ind=-1;
        int val=1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                cnt++;
                ind=i;
                if(cnt>1) return ans;
            } else{
                val=val*nums[i];
            }
        }

        if(cnt==1){
            ans[ind]=val;
            return ans;
        }

        for(int i=0;i<n;i++){
            ans[i]=val/nums[i];
        }

        return ans;
    }
}
