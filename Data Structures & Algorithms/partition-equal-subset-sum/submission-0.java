class Solution {
    private boolean fun(int[] nums, int ind, int sum, Boolean[][] dp) {

        if (sum == 0) return true;

        if (ind == 0) return nums[0] == sum;

        if (dp[ind][sum] != null) return dp[ind][sum];

        // not take
        boolean nt = fun(nums, ind - 1, sum, dp);

        // take (only if possible)
        boolean t = false;
        if (nums[ind] <= sum) {
            t = fun(nums, ind - 1, sum - nums[ind], dp);
        }

        return dp[ind][sum] = nt || t;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x : nums) sum += x;

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        int n = nums.length;

        Boolean[][] dp = new Boolean[n][target + 1];

        return fun(nums, n - 1, target, dp);
    }
}