class Solution {
    private class Pair {
        Character c;
        Integer occ;

        Pair(Character c, Integer occ) {
            this.c = c;
            this.occ = occ;
        }
    }

    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();

        for (Character c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(new Pair(c, 1));
                continue;
            }

            Pair prev = stack.peek();

            if (c == prev.c && prev.occ == k - 1) {
                stack.pop();
            } else if (c == prev.c) {
                prev.occ++;
            } else {
                stack.push(new Pair(c, 1));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            Pair pair = stack.pollLast();

            for (int i = 0; i < pair.occ; i++) {
                sb.append(pair.c);
            }
        }

        return sb.toString();
    }
}