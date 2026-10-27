class Solution {
    public int compress(char[] chars) {
        int left = 0;
        int write = 0;

        while(left < chars.length){
            int right = left;

            while(right < chars.length && chars[right] == chars[left]){
                right++;
            }

            int count = right - left;
            chars[write++] = chars[left];

            if(count > 1){
                for(char c : Integer.toString(count).toCharArray()){
                    chars[write++] = c;
                }
            }

            left = right;
        }
        return write;
    }
}