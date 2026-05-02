class Solution {
    public void swapP(int []nums, int i, int j){
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void funP(int[] nums,List<List<Integer>> ans, int ind ){
        if(ind==nums.length){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                temp.add(nums[i]);
            }
            ans.add(temp);
            return;
        }

        for(int i=ind;i<nums.length;i++){
            swapP(nums,i,ind);
            funP(nums,ans,ind+1);
            swapP(nums,i,ind);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();

        funP(nums,ans,0);
        return ans;
    }
}