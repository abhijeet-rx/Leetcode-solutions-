// Problem: ???? Right View of the Binary Tree ????
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/right-view-of-binary-tree/1
// Solved on: 2026-08-27T10:12:52.391Z

/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node temp = q.poll();
                if(i==size-1){
                    ans.add(temp.data);
                }
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }
        return ans;
        
    }
}