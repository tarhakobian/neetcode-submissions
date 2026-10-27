class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> occ = new HashMap<>();
        for(Character c : s.toCharArray()){
            if(occ.containsKey(c)){
                occ.put(c, occ.get(c) + 1);
            }else{
                occ.put(c, 1);
            }
        }

        boolean seenOne = false;
        int maxLength = 0;
        for(Map.Entry<Character, Integer> e : occ.entrySet()){
            int val = e.getValue();
            
            if(val % 2 == 0){
                maxLength += val;
            } else {
                maxLength += (val - 1);
                
                if(!seenOne){
                    maxLength++;
                    seenOne = true;
                }
            }
        }

        return maxLength;
    }
}