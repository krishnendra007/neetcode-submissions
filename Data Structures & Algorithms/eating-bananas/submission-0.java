class Solution {
    private long check(int[] p, int s) {
        long h = 0;
        for (int x : p) {
            h += (x + s - 1) / s;
        }
        return h;
    }

    public int minEatingSpeed(int[] p, int h) {
        int minv = 1, maxv = 0;

        for (int x : p) {
            maxv = Math.max(maxv, x);
        }

        while (minv <= maxv) {
            int mid = minv + (maxv - minv) / 2;

            if (check(p, mid) <= h) {
                maxv = mid - 1;
            } else {
                minv = mid + 1;
            }
        }

        return minv;
    }
}