class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    int perimeter = 0;

                    while (!q.isEmpty()) {
                        int[] next = q.poll();
                        int r = next[0], c = next[1];
                        
                        for (int[] dir : dirs) {
                            int nr = r + dir[0];
                            int nc = c + dir[1];
                            
                            if (nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] == 0) {
                                perimeter++;
                            } 
                            else if (grid[nr][nc] == 1 && !visited[nr][nc]) {
                                visited[nr][nc] = true;
                                q.offer(new int[]{nr, nc});
                            }
                        }
                    }
                    return perimeter;
                }
            }
        }
        return 0;
    }
}