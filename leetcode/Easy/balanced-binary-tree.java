// Problem: Balanced Binary Tree
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/balanced-binary-tree/
// Solved on: 2026-08-26T13:09:44.643Z

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
    static int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = height(root.left);
        if(left==-1){
            return -1;
        }
        int right = height(root.right);
        if(right==-1){
            return -1;
        }
        if(Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(height(root)!=-1){
            return true;
        }
        else{
            return false;
        }
    }
}