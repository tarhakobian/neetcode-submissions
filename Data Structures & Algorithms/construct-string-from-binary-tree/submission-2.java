class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if (visited.contains(node)) {
                stack.pop();
                sb.append(")");
                continue;
            }

            visited.add(node);
            sb.append("(").append(node.val);

            // Right child is pushed first because stack is LIFO.
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            } else if (node.right != null) {
                sb.append("()");
            }
        }

        return sb.substring(1, sb.length() - 1);
    }
}