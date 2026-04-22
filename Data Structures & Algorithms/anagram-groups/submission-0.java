class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp= new HashMap<>();

        for(String s:strs){
            char[] c=s.toCharArray();
            Arrays.sort(c);
            String b= new String(c);

            if(mp.containsKey(b)){
                mp.get(b).add(s);
            } else{
                List<String> temp= new ArrayList<>();
                temp.add(s);
                mp.put(b,temp);
            }

        }

        List<List<String>> ans= new ArrayList<>();

        for(String s: mp.keySet()){
            List<String> temp= mp.get(s);
            ans.add(temp);
        }

        return ans;
    }
}
