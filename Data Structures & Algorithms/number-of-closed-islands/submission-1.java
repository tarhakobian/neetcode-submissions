class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        int closedIslands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 || visited.contains(i + "," + j)) {
                    continue;
                }

                queue.offer(new int[]{i, j});
                visited.add(i + "," + j);

                boolean isClosed = true;

                while (!queue.isEmpty()) {
                    int[] cell = queue.poll();
                    int r = cell[0], c = cell[1];

                    if (r == 0 || c == 0 || r == n - 1 || c == m - 1) {
                        isClosed = false;
                    }

                    for (int[] dir : dirs) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];

                        if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                            continue;
                        }

                        String key = nr + "," + nc;

                        if (grid[nr][nc] == 0 && !visited.contains(key)) {
                            visited.add(key);
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }

                if (isClosed) closedIslands++;
            }
        }

        return closedIslands;
    }
}