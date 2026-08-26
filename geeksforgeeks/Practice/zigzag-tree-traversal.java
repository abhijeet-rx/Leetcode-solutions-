// Problem: Zig-Zag Tree Traversal
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/zigzag-tree-traversal/1
// Solved on: 2026-08-26T17:40:07.169Z

/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;
    Node(int d)
    {
        data = d;
        left = right = null;
    }
}*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
            ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
            Node curr = q.poll();
                if(flag){
                    level.add(curr.data);
                    
                }
                else{
                    level.add(0,curr.data);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            flag = !flag;
        ans.addAll(level);
        }
        return ans;
    }
}