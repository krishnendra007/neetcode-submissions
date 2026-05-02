class Solution {
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, -1, 0, 1 };

    public int dfs(int x, int y, int[][] grid, int[][] vis) {
        vis[x][y] = 1;
        int area=1;
    
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && vis[nx][ny] == 0
                    && grid[nx][ny] == 1) {
                area+=dfs(nx, ny, grid, vis);
            }
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];

        int area=0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    area=Math.max(area,dfs(i, j, grid, vis));
                }
            }
        }
        return area;

    }
}