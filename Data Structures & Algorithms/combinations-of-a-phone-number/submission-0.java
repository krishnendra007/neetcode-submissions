class Solution {
    private void words(List<String> res, String digits, String[] map, int n, int ind, String curr) {
        if (ind == n) {
            res.add(curr);
            return;
        }

        String letters = map[digits.charAt(ind) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            words(res, digits, map, n, ind + 1, curr + letters.charAt(i));
        }
    }


    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        words(res, digits, map, digits.length(), 0, "");

        return res; 
    }
}
