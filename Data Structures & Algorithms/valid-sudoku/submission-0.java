class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Keep 9 sets for rows, 9 sets for columns, and 9 sets for 3x3 boxes
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                // Skip empty cells
                if (val == '.') continue;

                // Calculate sub-box index (0 through 8)
                int boxIndex = (r / 3) * 3 + (c / 3);

                // If the value is already present in row, col, or box
                if (!rows[r].add(val) || !cols[c].add(val) || !boxes[boxIndex].add(val)) {
                    return false;
                }
            }
        }

        return true;
    }
}
