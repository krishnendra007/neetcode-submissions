class Pair {
    int x, y;
    Pair(int _x, int _y) {
        x = _x;
        y = _y;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        Queue<Pair> q = new LinkedList<>();

    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

      
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int minutes = 0;

        // BFS
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2; 
                        fresh--;
                        q.add(new Pair(nx, ny));
                    }
                }
            }

            minutes++; 
        }

        return fresh == 0 ? minutes : -1;
    }
}