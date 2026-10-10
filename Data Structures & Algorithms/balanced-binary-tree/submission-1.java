/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);

        return Math.abs(leftDepth - rightDepth) <= 1
            && isBalanced(root.left) 
            && isBalanced(root.right);
    }

    private int findDepth(TreeNode node) {
        if(node == null) return 0;

        return Math.max(findDepth(node.left), findDepth(node.right)) + 1;
    }
}
