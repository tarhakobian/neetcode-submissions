class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (board[i][j] == 'O') {
                        board[i][j] = '#';
                        q.offer(new int[]{i, j});
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] next = q.poll();
            int r = next[0], c = next[1];

            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;

                if (board[nr][nc] == 'O') {
                    board[nr][nc] = '#';
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}