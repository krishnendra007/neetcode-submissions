class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n=t.length;

        int[] ans= new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&t[st.peek()]<=t[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                ans[i]=st.peek();
            } else{
                ans[i]=-1;
            }

            st.push(i);
        }

        for(int i=0;i<n;i++){
            if(ans[i]==-1) ans[i]=0;
            else ans[i]=ans[i]-i;
        }
        return ans;
    }
}
