class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Deque<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) q.offer(new int[]{i, j});
            }
        }

        while(!q.isEmpty()){
            int[] next = q.poll();
            int r = next[0], c = next[1];

            for(int[] dir : directions){
                int nr = r + dir[0], nc = c + dir[1];

                if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != 2147483647) continue;
                grid[nr][nc] = grid[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
    }
}
