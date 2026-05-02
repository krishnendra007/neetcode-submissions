class Solution {
    public void fun(int[] candidates, int target, int ind, List<List<Integer>> ans, List<Integer> tempList) {

        if (target == 0) {
            ans.add(new ArrayList<>(tempList));
            return;
        }

        for(int i =ind;i<candidates.length;i++){
            if(i!=ind&&candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
            tempList.add(candidates[i]);
            fun(candidates,target-candidates[i],i+1,ans,tempList);
            tempList.remove(tempList.size()-1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        fun(candidates, target, 0, ans, tempList);
        return ans;
    }
}