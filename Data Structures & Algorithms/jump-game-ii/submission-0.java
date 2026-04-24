class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            // update farthest reachable
            farthest = Math.max(farthest, i + nums[i]);

            // if we reach current boundary → take jump
            if (i == currEnd) {
                jumps++;
                currEnd = farthest;
            }
        }

        return jumps;
    }
}