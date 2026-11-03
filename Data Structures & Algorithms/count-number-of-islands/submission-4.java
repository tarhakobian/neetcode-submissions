class Solution {
    private int[][] dir = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int islandCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    q.offer(new int[]{i, j});
                    grid[i][j] = '0'; // Mark visited immediately
                    islandCount++;

                    while (!q.isEmpty()) {
                        int[] idx = q.poll();

                        for (int[] d : dir) {
                            int newI = idx[0] + d[0];
                            int newJ = idx[1] + d[1];

                            if (newI < 0 || newJ < 0 || newI >= m || newJ >= n) {
                                continue;
                            }

                            if (grid[newI][newJ] == '1') {
                                grid[newI][newJ] = '0'; // Mark before enqueueing
                                q.offer(new int[]{newI, newJ});
                            }
                        }
                    }
                }
            }
        }

        return islandCount;
    }
}