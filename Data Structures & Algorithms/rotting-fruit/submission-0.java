class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Deque<int[]> q = new ArrayDeque<>();
        int freshCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // If there are no fresh oranges to begin with, 0 minutes elapsed.
        if (freshCount == 0) return 0;

        int epochs = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean rottedThisRound = false;

            for (int i = 0; i < size; i++) {
                int[] next = q.poll();
                int r = next[0], c = next[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != 1) continue;
                    
                    grid[nr][nc] = 2;
                    q.offer(new int[]{nr, nc});
                    freshCount--;
                    rottedThisRound = true;
                }
            }

            if (rottedThisRound) {
                epochs++;
            }
        }

        // If fresh oranges remain, they couldn't all be reached
        return freshCount == 0 ? epochs : -1;
    }
}