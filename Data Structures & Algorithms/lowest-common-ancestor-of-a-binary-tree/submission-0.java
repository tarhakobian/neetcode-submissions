/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode lca;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lca;
    }

    private boolean[] dfs(TreeNode node, TreeNode p, TreeNode q){
        if(node == null || lca!= null){
            return new boolean[]{false, false};
        }

        boolean[] left = dfs(node.left, p, q);
        boolean[] right = dfs(node.right, p, q);
        boolean foundP = left[0] || right[0] || node == p;
        boolean foundQ = left[1] || right[1] || node == q;
        if(foundP && foundQ && lca == null){
            lca = node;
        }
        return new boolean[]{foundP, foundQ};
    }
}