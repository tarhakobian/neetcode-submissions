class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        String minLengthStr;
        for(String s : strs){
            minLength = Math.min(minLength, s.length());

        }
        
        StringBuilder prefix = new StringBuilder("");
        for(int i = 0; i < minLength; i++){
            Character nextChar = strs[0].charAt(i);
            for(int j = 0; j < strs.length; j++){
                if(strs[j].charAt(i) != nextChar) return prefix.toString();
            }
            prefix.append(nextChar);
        }

        return prefix.toString();
    }
}