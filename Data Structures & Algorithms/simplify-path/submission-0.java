class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/+");
        Deque<String> stack = new ArrayDeque<>();

        for (String dir : parts) {
            if (dir.equals("") || dir.equals(".")) {
                continue;
            } else if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(dir);
            }
        }

        StringBuilder res = new StringBuilder();

        while (!stack.isEmpty()) {
            res.append("/").append(stack.pollLast());
        }

        return res.length() == 0 ? "/" : res.toString();
    }
}