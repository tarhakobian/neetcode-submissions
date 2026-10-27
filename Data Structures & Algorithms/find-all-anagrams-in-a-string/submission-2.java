class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> occS = new HashMap<>();
        Map<Character, Integer> occP = new HashMap<>();

        for(Character c : p.toCharArray()){
            occP.put(c, occP.getOrDefault(c, 0) + 1);
        }

        int len = p.length();
        for(int i = 0; i < len; i++){
            occS.put(s.charAt(i), occS.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (occS.equals(occP)) {
            result.add(0);
        }

        for (int i = len; i < s.length(); i++) {
            char rightChar = s.charAt(i);
            occS.put(rightChar, occS.getOrDefault(rightChar, 0) + 1);
            
            char leftChar = s.charAt(i - len);
            if (occS.get(leftChar) == 1) {
                occS.remove(leftChar);
            } else {
                occS.put(leftChar, occS.get(leftChar) - 1);
            }
            
            if (occS.equals(occP)) {
                result.add(i - len + 1);
            }
        }
        
        return result;
    }
}