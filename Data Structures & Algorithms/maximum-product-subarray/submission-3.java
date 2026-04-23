/*class Solution {
    public int maxProduct(int[] nums) {
        int prod = 1;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            if (prod > max)
                max = prod;
            if (prod == 0)
                prod = 1;
        }
        prod = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            prod *= nums[i];
            if (prod > max)
                max = prod;
            if (prod == 0)
                prod = 1;
        }
        return max;
    }
}*/

class Solution {
    public int maxProduct(int[] nums) {
       int max=nums[0],min=nums[0],res=nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmp=max;
            max=Math.max(nums[i],Math.max(nums[i]*max,nums[i]*min));
            min=Math.min(nums[i],Math.min(nums[i]*tmp,nums[i]*min));

            res=Math.max(res,max);
        }

        return res;
       
    }
}