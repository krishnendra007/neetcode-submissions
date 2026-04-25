class Solution {
    public int eraseOverlapIntervals(int[][] inte) {

        Arrays.sort(inte, (a, b) -> a[1] - b[1]); // sort by end

        int cnt = 0;
        int n = inte.length;

        int st = 0, end = 1;

        while (end < n) {
            if (inte[end][0] < inte[st][1]) {
                // overlap → remove current (end)
                cnt++;
            } else {
                // no overlap → move forward
                st = end;
            }
            end++;
        }

        return cnt;
    }
}