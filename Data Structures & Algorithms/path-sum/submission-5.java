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
        if(root == null) return false;
        this.targetSum = targetSum;
        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode node, int currSum){
        if(node.left == null && node.right == null){
            return currSum == targetSum;
        }

        boolean left = false, right = false;
        if(node.left != null){
            currSum += node.left.val;
            left = dfs(node.left, currSum);
            currSum -= node.left.val;
        }
        
        if(node.right != null){
            currSum += node.right.val;
            right = dfs(node.right, currSum);
            currSum -= node.right.val;
        }
        
        return left || right;
    }
}