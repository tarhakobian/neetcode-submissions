class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int m = grid.length, n = grid[0].length;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int maxSize = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int size = 1;
                    q.offer(new int[]{i, j});
                    grid[i][j] = 0;

                    while(!q.isEmpty()){
                        int[] next = q.poll();
                        int r = next[0], c = next[1];

                        for(int[] d : dir){
                            int nr = r + d[0], nc = c + d[1];

                            if(nr < 0 || nc < 0 || nr == m || nc == n) continue;

                            if(grid[nr][nc] == 1){
                                size++;
                                q.offer(new int[]{nr, nc});
                                grid[nr][nc] = 0;
                            }
                        }
                    }

                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        return maxSize;
    }
}
