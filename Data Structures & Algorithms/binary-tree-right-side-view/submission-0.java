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
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if(root == null) return new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){    
            int len = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < len; i++){
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            levels.add(level);
        }
        List<Integer> res = new ArrayList<>();
        for(List<Integer> level : levels){
            res.add(level.get(level.size() - 1));
        }

        return res;
    }
}
