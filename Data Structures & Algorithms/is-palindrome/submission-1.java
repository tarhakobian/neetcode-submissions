class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() -1;
        int max = 0;

        while(left < right && right >= 0 && left < s.length()){
            if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
                continue;
            }

            if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
                continue;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
