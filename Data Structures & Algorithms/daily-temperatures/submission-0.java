class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]){
                Integer[] next = stack.pop();
                res[next[1]] = i - next[1];
            }

            stack.push(new Integer[]{temperatures[i], i});
        }

        return res;
    }
}
