class Solution {
    public void fun(int[] nums,List<List<Integer>> ans,List<Integer> current,int ind, int n){

        if(ind==n) {
            ans.add(new ArrayList<>(current));
            return;
        }
        
        current.add(nums[ind]);
        fun(nums,ans,current,ind+1,n);
        current.remove(current.size()-1);
        fun(nums,ans,current,ind+1,n);
    }
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        

        fun(nums,ans,current,0,nums.length);

        return ans;
    }
}