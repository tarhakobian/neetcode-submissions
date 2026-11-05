class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] prefix = new int[length];
        prefix[0] = 1;
        int[] postfix = new int[length];
        postfix[length - 1] = 1;

        for(int i = 1; i < length; i++){
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for(int i = length - 2; i >= 0; i--){
            postfix[i] = postfix[i + 1] * nums[i + 1];
        }

        int[] res = new int[length];
        for(int i = 0; i < length; i++){
            res[i] = prefix[i] * postfix[i];
        }

        return res;
    }
}  
