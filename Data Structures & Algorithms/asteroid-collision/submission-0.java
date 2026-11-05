class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                if (stack.peek() < -a) {
                    // Incoming asteroid is larger
                    stack.pop();
                } else if (stack.peek() == -a) {
                    // Both are destroyed
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    // Incoming asteroid is destroyed
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(a);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}