class Solution {
    public void fun(String s,List<List<String>> ans,List<String> tempList,int ind){
        if(ind==s.length()){
            ans.add(new ArrayList(tempList));
        }

        for(int i=ind;i<s.length();i++){
            if(isPeledrom(ind,i,s)){
                tempList.add(s.substring(ind,i+1));
                fun(s,ans,tempList,i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public boolean isPeledrom(int st,int end, String s){
        while(st<=end){
            if(s.charAt(st)!=s.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> tempList = new ArrayList<>();

        fun(s,ans,tempList,0);
        return ans;
    }
}