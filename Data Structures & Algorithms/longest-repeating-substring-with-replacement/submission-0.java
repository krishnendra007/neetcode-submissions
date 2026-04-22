class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int i = 0, j = 0;
        int maxFreq = 0;
        int maxLen = 0;

        while (j < s.length()) {
            char c = s.charAt(j);
            freq[c - 'A']++;

            // update max frequency in window
            maxFreq = Math.max(maxFreq, freq[c - 'A']);

            // shrink window if invalid
            while ((j - i + 1) - maxFreq > k) {
                freq[s.charAt(i) - 'A']--;
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }
}