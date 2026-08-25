// Problem: Level Order Traversal
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/level-order-traversal/1
// Solved on: 2026-08-25T17:51:41.275Z

/* Structure of Binary Tree Node
class Node {
    public int data;
    public Node left;
    public Node right;

    // Constructor
    public Node(int val) {
        data = val;
        left = right = null;
    }
};*/

class Solution {
    public ArrayList<Integer> levelOrder(Node root) {
        Queue<Node> q  = new LinkedList<>();
        q.add(root);
        ArrayList<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            Node temp = q.peek();
            q.remove();
            result.add(temp.data);
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
        return result;
        
    }
}