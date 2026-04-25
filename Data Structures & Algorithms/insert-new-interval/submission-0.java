class Solution {

    public int[][] insert(int[][] inte, int[] newI) {
        int n = inte.length;

        List<int[]> list = new ArrayList<>();

        int i = 0;

        // add all before insertion point
        while (i < n && inte[i][0] < newI[0]) {
            list.add(inte[i]);
            i++;
        }

        // insert new interval
        list.add(newI);

        // add remaining
        while (i < n) {
            list.add(inte[i]);
            i++;
        }

        // merge intervals
        return merge(list);
    }

    private int[][] merge(List<int[]> list) {
        List<int[]> res = new ArrayList<>();

        for (int[] curr : list) {
            if (res.isEmpty() || res.get(res.size() - 1)[1] < curr[0]) {
                res.add(curr);
            } else {
                res.get(res.size() - 1)[1] =
                    Math.max(res.get(res.size() - 1)[1], curr[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}