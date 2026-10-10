/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;

        List<List<Node>> levels = new ArrayList<>();
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int len = q.size();
            List<Node> level = new ArrayList<>();
            
            for(int i = 0; i < len; i++){
                Node node = q.poll();
                level.add(node);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }

            levels.add(level);
        }

        for(List<Node> level : levels){
            for(int i = 0; i < level.size(); i++){
                if(i < level.size() - 1){
                    level.get(i).next = level.get(i + 1);
                }else{
                    level.get(i).next = null;
                    break;
                }
            }
        }

        return root;
    }
}