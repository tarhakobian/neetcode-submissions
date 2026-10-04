class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            // Remove characters from the left until the duplicate is gone
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }

            // Add the current character and update max length
            seen.add(s.charAt(right));
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}