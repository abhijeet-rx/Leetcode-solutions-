// Problem: Construct Binary Search Tree from Preorder Traversal
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
// Solved on: 2026-09-01T09:37:26.488Z

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
    TreeNode insert(int value , TreeNode root){
        if(root==null){
            return new TreeNode(value);
        }
        if(value>root.val){
            root.right = insert(value,root.right);
        }
        else{
            root.left = insert(value , root.left);
        }
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for(int val :preorder){
            root = insert(val,root);
        }
        return root;
        
    }
}