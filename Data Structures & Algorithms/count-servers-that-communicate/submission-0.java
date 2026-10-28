class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] rowCounts = new int[n], colCounts = new int[m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    rowCounts[i]++;
                    colCounts[j]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 &&
                    (rowCounts[i] >= 2 || colCounts[j] >= 2)) {
                    res++;
                }
            }
        }

        return res;
    }
}