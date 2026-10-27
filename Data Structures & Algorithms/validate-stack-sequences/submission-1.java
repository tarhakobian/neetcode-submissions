class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> pushStack = new ArrayDeque<>();
        Deque<Integer> popStack = new ArrayDeque<>();
        
        // Push in reverse order so the front of `popped` is at the top of the stack
        for (int i = popped.length - 1; i >= 0; i--) {
            popStack.push(popped[i]);
        }
        
        for (int i = 0; i < pushed.length; i++) {
            pushStack.push(pushed[i]);
            // Use .equals() for Integer object comparisons
            while (!pushStack.isEmpty() && !popStack.isEmpty() && pushStack.peek().equals(popStack.peek())) {
                pushStack.pop();
                popStack.pop();
            }
        }
        
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}