class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n + 1];

        String vowels = "aeiou";

        // Build prefix sums
        for (int i = 0; i < n; i++) {
            String word = words[i];

            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);

            boolean valid = vowels.indexOf(first) != -1 &&
                            vowels.indexOf(last) != -1;

            prefix[i + 1] = prefix[i] + (valid ? 1 : 0);
        }

        // Answer each query
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            ans[i] = prefix[right + 1] - prefix[left];
        }

        return ans;
    }
}