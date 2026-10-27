class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int result = 0; 
        int di[4] = {1, -1, 0, 0}; 
        int dj[4] = {0, 0, 1, -1};

        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < grid[0].size(); j++) {
                if (!grid[i][j]) continue;

                for(int k = 0; k < 4; k++) {
                    int newI = i + di[k];
                    int newJ = j + dj[k];

                    bool isValidCoord = newI >= 0 && newI < grid.size() && newJ >= 0 && newJ < grid[0].size();
                    if ((isValidCoord && grid[newI][newJ] == 0) || !isValidCoord) {
                        result++;
                    }
                }
            }
        }

        return result;
    }
};