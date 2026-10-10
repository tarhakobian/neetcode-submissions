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
    private int targetSum;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        this.targetSum = targetSum;

        return dfs(root, 0);
    }

    private boolean dfs(TreeNode node, int currSum){
        if (node == null) return false;

        currSum += node.val;

        if (node.left == null && node.right == null) {
            return currSum == targetSum;
        }

        return dfs(node.left, currSum) || dfs(node.right, currSum);
    }
}