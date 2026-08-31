// Problem: Check for BST
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/check-for-bst/1
// Solved on: 2026-08-31T09:27:00.206Z

/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    List<Integer> ans = new ArrayList<>();
    List<Integer> inorder(Node root){
        if(root==null){
            return ans;
        }
        inorder(root.left);
        ans.add(root.data);
        inorder(root.right);
        return ans;
        
    }
    public boolean isBST(Node root) {
      inorder(root);
      for(int i =0;i<ans.size()-1;i++){
          if(ans.get(i)>=ans.get(i+1)){
              return false;
          }
      }
      return true;
        
    }
}