class Solution {
    public void islandsAndTreasure(int[][] g) {
        Queue<int[]> q = new LinkedList<>();
        int INF = 2147483647;
        int n = g.length;
        int m = g[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        int dx[] = new int[] {1, 0, -1, 0};
        int dy[] = new int[] {0, -1, 0, 1};
        int dist = 0;
        while (!q.isEmpty()) {
            dist++;
            int k = q.size();

            for (int w = 0; w < k; w++) {
                int[] temp = q.poll();
                int x = temp[0];
                int y = temp[1];
                for (int i = 0; i < 4; i++) {
                    int X = dx[i] + x;
                    int Y = dy[i] + y;

                    if (X >= 0 && Y >= 0 && X < n && Y < m && (g[X][Y] == INF || g[X][Y] > dist)) {
                        g[X][Y] = dist;
                        q.add(new int[] {X, Y});
                    }
                }
            }
        }
    }
}
