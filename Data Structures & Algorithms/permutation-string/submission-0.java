
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        if (s1Len > s2Len) return false;

        Map<Character, Integer> occS1 = new HashMap<>();
        Map<Character, Integer> occS2Window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            occS1.put(c, occS1.getOrDefault(c, 0) + 1);
        }

        // Initialize the first window
        for (int i = 0; i < s1Len; i++) {
            occS2Window.put(s2.charAt(i), occS2Window.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if (occS1.equals(occS2Window)) return true;

        // Slide the window across s2
        for (int right = s1Len; right < s2Len; right++) {
            // Add the new character entering the window
            char inChar = s2.charAt(right);
            occS2Window.put(inChar, occS2Window.getOrDefault(inChar, 0) + 1);

            // Remove the character leaving the window
            char outChar = s2.charAt(right - s1Len);
            int count = occS2Window.get(outChar);
            if (count == 1) {
                occS2Window.remove(outChar); // Remove key so map comparison .equals() works properly
            } else {
                occS2Window.put(outChar, count - 1);
            }

            if (occS1.equals(occS2Window)) return true;
        }

        return false;
    }
}