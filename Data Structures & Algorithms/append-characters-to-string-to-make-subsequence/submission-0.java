class Solution {
    public int appendCharacters(String s, String t) {
        int minAdditions = t.length();
        for(int i = 0, idxS = 0; i < t.length(); i++){
            while(idxS < s.length()){
                if(s.charAt(idxS) == t.charAt(i)){
                    minAdditions--;
                    idxS++;
                    break;
                }else{
                    idxS++;
                }
            }
        }
        return minAdditions;
    }
}