class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st= new HashSet<>();
        for(int x: nums){
            st.add(x);
        }

        int maxl=0;

        for(int x: nums){
            if(!st.contains(x-1)){
                int cnt=0;
                while(st.contains(x)){
                    cnt++;
                    st.remove(x);
                    x++;
                }
                maxl=Math.max(maxl,cnt);
            }
        }
        return maxl;
    }
}