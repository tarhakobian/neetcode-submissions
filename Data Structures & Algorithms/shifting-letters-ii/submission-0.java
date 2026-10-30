class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2] == 1 ? 1 : -1;

            diff[start] += direction;
            diff[end + 1] -= direction;
        }

        StringBuilder sb = new StringBuilder(s);
        int totalShift = 0;

        for (int i = 0; i < n; i++) {
            totalShift += diff[i];

            int position = s.charAt(i) - 'a';
            int newPosition = ((position + totalShift) % 26 + 26) % 26;

            sb.setCharAt(i, (char) ('a' + newPosition));
        }

        return sb.toString();
    }
}