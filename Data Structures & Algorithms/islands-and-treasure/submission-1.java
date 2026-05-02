class Solution {
    public void islandsAndTreasure(int[][] g) {
        Queue<int[]> q = new LinkedList<>();
        int INF = 2147483647;

        int n = g.length;
        int m = g[0].length;

        // add all treasures (multi-source BFS)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && g[nx][ny] == INF) {
                    g[nx][ny] = g[x][y] + 1; // 🔥 correct distance
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}