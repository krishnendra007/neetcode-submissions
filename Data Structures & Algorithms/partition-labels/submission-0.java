class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> mp= new HashMap<>();

        for(char c:s.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        List<Integer> ans= new ArrayList<>();

        Set<Character> st= new HashSet<>();
        int sta=0,end=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            st.add(c);
            int val=mp.get(c);
            val--;
            mp.put(c,val);
            if(val==0){
                mp.remove(c);
                st.remove(c);
                if(st.size()==0){
                    ans.add(i-sta+1);
                    sta=i+1;
                }
            }
        }
        return ans;
    }
}