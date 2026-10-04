
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> occT = new HashMap<>();
        for (char c : t.toCharArray()) {
            occT.put(c, occT.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> occWindow = new HashMap<>();
        int need = occT.size();
        int has = 0;

        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            // Add right character to window count if it's in t
            if (occT.containsKey(rightChar)) {
                occWindow.put(rightChar, occWindow.getOrDefault(rightChar, 0) + 1);
                if (occWindow.get(rightChar).equals(occT.get(rightChar))) {
                    has++;
                }
            }

            // Shrink window from the left while it is valid
            while (has == need) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                if (occT.containsKey(leftChar)) {
                    occWindow.put(leftChar, occWindow.get(leftChar) - 1);
                    if (occWindow.get(leftChar) < occT.get(leftChar)) {
                        has--;
                    }
                }
                
                // left must always increment to shrink the window
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}