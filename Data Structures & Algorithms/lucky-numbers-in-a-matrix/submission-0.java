class Solution {
    public int[] luckyNumbers(int[][] matrix) {
        for (int[] row : matrix) {
            int c = 0;

            for (int j = 1; j < row.length; j++) {
                if (row[j] < row[c]) {
                    c = j;
                }
            }

            boolean lucky = true;

            for (int[] other : matrix) {
                if (other[c] > row[c]) {
                    lucky = false;
                    break;
                }
            }

            if (lucky) {
                return new int[]{row[c]};
            }
        }

        return new int[0];
    }
}