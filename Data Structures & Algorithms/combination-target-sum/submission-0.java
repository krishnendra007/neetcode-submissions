class Solution {
    public void fun(int[] candidates, int target, int ind, List<List<Integer>> ans, List<Integer> tempList) {

        if(ind==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(tempList));
            }
            return;
        }

        if(candidates[ind]<=target){
            tempList.add(candidates[ind]);
            fun(candidates,target-candidates[ind],ind,ans,tempList);
            tempList.remove(tempList.size()-1);
        }
         fun(candidates,target,ind+1,ans,tempList);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        fun(candidates, target, 0, ans, tempList);
        return ans;
    }
}