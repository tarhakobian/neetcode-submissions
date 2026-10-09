/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    private List<Integer> res;

    public List<Integer> postorder(Node root) {
        res = new ArrayList<>();
        traverse(root);
        return res;
    }

    private void traverse(Node node){
        if(node == null) return;

        for(Node child : node.children){
            traverse(child);
        }

        res.add(node.val);
    }
}