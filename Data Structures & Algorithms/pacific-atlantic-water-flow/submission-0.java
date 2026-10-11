class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // --- 1. Pacific BFS ---
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    q.offer(new int[]{i, j});
                    pac[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n || pac[nr][nc]) continue;
                if (heights[nr][nc] >= heights[r][c]) {
                    pac[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // --- 2. Atlantic BFS ---
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == m - 1 || j == n - 1) {
                    q.offer(new int[]{i, j});
                    atl[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n || atl[nr][nc]) continue;
                if (heights[nr][nc] >= heights[r][c]) {
                    atl[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // --- 3. Collect intersections ---
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
}