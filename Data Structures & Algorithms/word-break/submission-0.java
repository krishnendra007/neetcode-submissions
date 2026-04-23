class Solution {

    boolean solve(int ind, String s, Set<String> st,Boolean dp[]){
        if (ind == s.length()) return true;
        if (dp[ind] != null) return dp[ind];

        for (int i = ind + 1; i <= s.length(); i++) {
            String split = s.substring(ind, i);
            if (st.contains(split) && solve(i, s, st, dp)) {
                return dp[ind] = true;
            }
        }
        return dp[ind] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>(wordDict);
        Boolean dp[] = new Boolean[s.length() + 1];
        return solve(0, s, st, dp);
        
    }
}