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
    private int target;

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return null;
        this.target = target;
        if(removeHelper(root)) return null;
        return root;
    }

    private Boolean removeHelper(TreeNode node){
        if(node.left != null){
            if(removeHelper(node.left)) node.left = null;
        }

        if(node.right != null){
            if(removeHelper(node.right)) node.right = null;
        }

        return node.left == null && node.right == null && node.val == this.target;
    }
}