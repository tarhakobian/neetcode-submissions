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
    private int count = 0;

    public int goodNodes(TreeNode root) {
        if(root == null) return count;

        goodNodeHelper(root, Integer.MIN_VALUE);
        return count;
    }

    private void goodNodeHelper(TreeNode node, int maxSeen){
        if(node.val >= maxSeen) count++;

        if(node.left != null){
            goodNodeHelper(node.left, Math.max(maxSeen, node.val));
        }

        if(node.right != null){
            goodNodeHelper(node.right, Math.max(maxSeen, node.val));
        }
    }
}
