class Solution {
    private boolean isCycle(List<Integer>[] g, int[] vis, int i, int par) {
        vis[i] = 1;
        for (int x : g[i]) {
            if (vis[x] == 0) {
                if (isCycle(g, vis, x, i))
                    return true;

            } else if (x != par)
                return true;
        }
        return false;
    }
    public boolean validTree(int num, int[][] pre) {
        if (pre.length != num - 1)
            return false;
        List<Integer>[] g = new ArrayList[num];

        for (int i = 0; i < num; i++) g[i] = new ArrayList<>();
        int[] vis = new int[num];

        for (int[] arr : pre) {
            g[arr[0]].add(arr[1]);
            g[arr[1]].add(arr[0]);
        }

        if (isCycle(g, vis, 0, -1))
            return false;

        for (int i = 0; i < num; i++) {
            if (vis[i] == 0)
                return false;
        }

        return true;
    }
}
