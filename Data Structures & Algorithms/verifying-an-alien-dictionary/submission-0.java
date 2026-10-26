class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i];
            String b = words[i + 1];

            int minLen = Math.min(a.length(), b.length());
            boolean foundDifference = false;

            for (int j = 0; j < minLen; j++) {
                int r1 = map.get(a.charAt(j));
                int r2 = map.get(b.charAt(j));

                if (r1 > r2) {
                    return false;
                }

                if (r1 < r2) {
                    foundDifference = true;
                    break;
                }
            }

            if (!foundDifference && a.length() > b.length()) {
                return false;
            }
        }

        return true;
    }
}