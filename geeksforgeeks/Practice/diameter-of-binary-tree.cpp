// Problem: 💡 Diameter of a Binary Tree (C++)
// Platform: geeksforgeeks
// Language: cpp
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1
// Solved on: 2026-08-26T08:57:15.934Z

/*Structure of binary tree Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
};*/

class Solution {
    static int height(Node root){
        if(root==null){
            return 0;
            
        }
        int left = height(root.left);
        int right = height(root.right);
        int ans = Math.max(left,right)+1;
        return ans;
    }
    public int diameter(Node root) {
        if(root==null){
            return 0;
            
        }
        int left = diameter(root.left);
        int right = diameter(root.right);
        int both  = height(root.left) + height(root.right);
        int ans = Math.max(left,Math.max(right,both));
        return ans;
    }
}