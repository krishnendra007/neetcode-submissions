class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st= new HashSet<>();
        for(String s:wordList){
            st.add(s);
        }

        Queue<String> q= new LinkedList<>();
        q.offer(beginWord);

        int cnt=1;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                String s=q.poll();
                if(s.equals(endWord)) return cnt;

                for(int j=0;j<s.length();j++){
                    char[] temp= s.toCharArray();
                    for(int k=0;k<26;k++){
                        temp[j]=(char)(k+'a');
                        if(st.contains(String.valueOf(temp))){
                            q.offer(String.valueOf(temp));
                            st.remove(String.valueOf(temp));
                        }
                        
                    }

                }
                
            }
            cnt++;
        }
        return 0;
    }
}