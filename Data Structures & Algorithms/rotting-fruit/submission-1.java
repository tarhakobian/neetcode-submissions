class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int m = grid.length, n = grid[0].length;

        int freshCount = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int epochs = 0;

        while (!q.isEmpty()) {
            Set<List<Integer>> toRoat = new HashSet<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] next = q.poll();
                int r = next[0], c = next[1];

                for (int[] d : dir) {
                    int nr = r + d[0], nc = c + d[1];

                    if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                        continue;
                    }

                    if (grid[nr][nc] == 1) {
                        toRoat.add(Arrays.asList(nr, nc));
                    }
                }
            }

            if (toRoat.isEmpty()) {
                break;
            }

            for (List<Integer> idx : toRoat) {
                int r = idx.get(0), c = idx.get(1);

                grid[r][c] = 2;
                freshCount--;
                q.offer(new int[]{r, c});
            }

            epochs++;
        }

        return freshCount == 0 ? epochs : -1;
    }
}