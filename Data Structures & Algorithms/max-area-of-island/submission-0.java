class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int maxSize = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int size = 1;
                    Deque<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                    grid[i][j] = 0;

                    while(!q.isEmpty()){
                        int[] next = q.poll();
                        int r = next[0], c = next[1];

                        for(int[] dir : directions){
                            int nr = r + dir[0], nc = c + dir[1];
                            if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != 1) continue;

                            size++;
                            grid[nr][nc] = 0;
                            q.offer(new int[]{nr, nc});
                        }
                    }

                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        return maxSize;
    }
}
