class Solution {
    public List<String> generateParenthesis(int n) {
         List<String> ans=new ArrayList<>();

         String temp="";
         fun(temp,ans,0,n,0,0);
         return ans;
    }
    private void fun(String temp, List<String> ans,int ind,int n, int o, int c){
        if(o==n&&c==n){
            ans.add(temp);
            return;
        }
        if(o>n||c>n) return;
        if(c>o) return;
        fun(temp+"(",ans,ind,n,o+1,c);
        fun(temp+")",ans,ind,n,o,c+1);
    }
}