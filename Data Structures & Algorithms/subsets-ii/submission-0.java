class Solution {
    public void fun(int ind,int[] nums,List<List<Integer>> ans,List<Integer> tempList ){
        ans.add(new ArrayList<>(tempList));

        for(int i=ind;i<nums.length;i++){
            if(i!=ind &&nums[i]==nums[i-1]) continue;
            tempList.add(nums[i]);
            fun(i+1,nums,ans,tempList);
            tempList.remove(tempList.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempList= new ArrayList<>();
        fun(0,nums,ans,tempList);
        return ans;
    }
}