class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int originalColor = image[sr][sc];

        if (originalColor == color) return image;

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int[] next = q.poll();
            int r = next[0], c = next[1];

            for (int[] d : dir) {
                int nr = r + d[0], nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= image.length || nc >= image[0].length) continue;

                if (image[nr][nc] == originalColor) {
                    image[nr][nc] = color;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return image;
    }
}