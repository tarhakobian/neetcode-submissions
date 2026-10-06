class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
      Deque<Integer> queue = new ArrayDeque<>();
        for (int s : students) {
            queue.offer(s);
        }

        // Push sandwiches onto stack (last element at bottom, first at top)
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }

        int lastServedCount = 0;

        while (!queue.isEmpty() && lastServedCount < queue.size()) {
            if (queue.peek().equals(stack.peek())) {
                queue.poll();
                stack.pop();
                lastServedCount = 0; // Reset counter when a student successfully eats
            } else {
                queue.offer(queue.poll()); // Move student to the back
                lastServedCount++;
            }
        }

        return queue.size();


    }
}