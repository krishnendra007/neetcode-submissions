class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp= new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int a= nums[i];
            int b=target-a;

            if(mp.containsKey(b)){
                return new int[]{mp.get(b),i};
            }

            mp.put(a,i);
        }

        return new int[]{-1};
    }
}
