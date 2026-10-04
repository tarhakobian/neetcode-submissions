class Solution {
    public String mergeAlternately(String word1, String word2) {
        int minL = Math.min(word1.length(), word2.length());

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < minL; i++){
            res.append(word1.charAt(i));
            res.append(word2.charAt(i));
        }

        for(int i = minL; i < word1.length(); i++){
            res.append(word1.charAt(i));
        }

        for(int i = minL; i < word2.length(); i++){
            res.append(word2.charAt(i));
        }

        return res.toString();
    }
}