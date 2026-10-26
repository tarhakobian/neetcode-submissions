class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for(String s : strs){
            minLength = Math.min(minLength, s.length());
        }

        int len = 0;
        for(int i = 0; i < minLength; i++){
            boolean allSame = true;
            for(String s : strs){
                if(s.charAt(i) != strs[0].charAt(i)){
                    allSame = false;
                    break;
                }
            }
            if(allSame){
                len++;
            }else{
                break;
            }
        }
        return strs[0].substring(0, len);
    }
}