class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Integer[]> list = new ArrayList<>();
        for(int i = 0; i < position.length; i++){
            list.add(new Integer[]{position[i], speed[i]});
        }
        list.sort((a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for(Integer[] next : list){
            double time = (double)(target - next[0]) / next[1];
            
            while(stack.isEmpty() || stack.peek() < time){
                stack.push(time);
            }
        }

        return stack.size();
    }
}
