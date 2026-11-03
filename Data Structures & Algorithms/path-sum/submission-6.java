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
        // return dfs(root, root.val);
        return bfs(root);
    }  

    private class Pair{
        TreeNode node;
        Integer prefixSum;

        Pair(TreeNode node, Integer prefixSum){
            this.node = node;
            this.prefixSum = prefixSum;
        }
    }

    private boolean bfs(TreeNode node){
        if(node == null) return false;
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(node, 0));

        while(!q.isEmpty()){
            int count = q.size();
            for(int i = 1; i <= count; i++){
                Pair nextPair = q.poll();
                TreeNode nextNode = nextPair.node;
                Integer currSum = nextPair.prefixSum + nextNode.val;

                if(nextNode.left == null && nextNode.right == null){
                    if(currSum == targetSum){
                        return true;
                    }else{
                        continue;
                    }
                }

                if(nextNode.left != null){
                    q.offer(new Pair(nextNode.left, currSum));
                }

                if(nextNode.right != null){
                    q.offer(new Pair(nextNode.right, currSum));
                }
            }
        }

        return false;
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