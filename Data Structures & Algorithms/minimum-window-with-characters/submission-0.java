class Solution {
    private boolean check(int[] arr, int[] brr) {
        for (int i = 0; i < 256; i++) {
            if (arr[i] > brr[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int[] arr = new int[256];
        int[] brr = new int[256];

        for (char c : t.toCharArray()) {
            arr[c]++;
        }

        int i = 0, j = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";

        while (j < s.length()) {
            char c = s.charAt(j);
            brr[c]++;

            // shrink ONLY when valid
            while (check(arr, brr)) {

                // update answer (minimum window)
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    ans = s.substring(i, j + 1);
                }

                // shrink
                char left = s.charAt(i);
                brr[left]--;
                i++;
            }

            j++;
        }

        return ans;
    }
}