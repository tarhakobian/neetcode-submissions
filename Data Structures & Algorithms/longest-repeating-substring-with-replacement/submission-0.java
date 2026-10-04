class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> occ = new HashMap<>();
        int left = 0;
        int maxWindowOcc = 0;
        int maxLen = 0;

        for(int right = 0; right < s.length(); right++){
            occ.put(s.charAt(right),occ.getOrDefault(s.charAt(right), 0) + 1);
            maxWindowOcc = Math.max(maxWindowOcc, occ.get(s.charAt(right)));

            while((right - left + 1) - maxWindowOcc > k){
                occ.put(s.charAt(left), occ.get(s.charAt(left)) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }


        return maxLen;
    }
}
