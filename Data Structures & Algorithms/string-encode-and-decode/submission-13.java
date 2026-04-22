class Solution {

    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();

        for (String s : strs) {
            ans.append(s.length()).append("#").append(s);
        }

        return ans.toString();
    }

    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int j = i;

            // find '#'
            while (s.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(s.substring(i, j));
            j++; // skip '#'

            String word = s.substring(j, j + len);
            ans.add(word);

            i = j + len;
        }

        return ans;
    }
}