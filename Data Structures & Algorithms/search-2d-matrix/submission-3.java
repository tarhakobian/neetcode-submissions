class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int leftM = 0, rightM = m - 1;

        while (leftM <= rightM) {
            int row = leftM + (rightM - leftM) / 2;
            if (target >= matrix[row][0] && target <= matrix[row][n - 1]) {
                int leftN = 0, rightN = n - 1;

                while (leftN <= rightN) {
                    int mid = leftN + (rightN - leftN) / 2;
                    if (target == matrix[row][mid]) {
                        return true;
                    } else if (target < matrix[row][mid]) {
                        rightN = mid - 1;
                    } else {
                        leftN = mid + 1;
                    }
                }
                return false;
            } else if (target < matrix[row][0]) {
                rightM = row - 1;
            } else {
                leftM = row + 1;
            }
        }

        return false;
    }
}