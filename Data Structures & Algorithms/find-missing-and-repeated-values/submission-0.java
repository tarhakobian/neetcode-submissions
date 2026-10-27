class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] occ = new int[n * n];
        int[] res = new int[2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                occ[grid[i][j] - 1]++;
                if(occ[grid[i][j] - 1] == 2){
                    res[0] = grid[i][j];
                }
            }
        }

        for(int i = 0; i < occ.length; i++){
            if(occ[i] == 0){
                res[1] = i + 1;
            }
        }

        return res;
    }
}