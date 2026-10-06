class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(Integer n : nums2){
            if(stack.isEmpty()){
                stack.push(n);
                continue;
            }

            while(!stack.isEmpty() && stack.peek() < n){
                map.put(stack.pop(), n);
            }

            stack.push(n);
        }

        while(!stack.isEmpty()){
            map.put(stack.pop(), - 1);
        }

        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}