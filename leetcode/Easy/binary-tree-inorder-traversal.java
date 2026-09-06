// Problem: Binary Tree Inorder Traversal
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/binary-tree-inorder-traversal/
// Solved on: 2026-09-06T14:15:39.718Z

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
        List<Integer> ans =new ArrayList<>();
    TreeNode inorder(TreeNode root){
        if(root==null){
            return null;
        }
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
        return root;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return ans;

        
    }
}