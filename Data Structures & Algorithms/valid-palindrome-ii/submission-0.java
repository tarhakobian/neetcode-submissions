class Solution {
    private boolean found;

    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return isPolindrome(s, left + 1, right) ||
                    isPolindrome(s, left, right - 1);
            }

            left++;
            right--;
        }    

        return true;
    }

    private boolean isPolindrome(String s, int left, int right){
        if(found) return true;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        found = true;
        return true;
    }


}