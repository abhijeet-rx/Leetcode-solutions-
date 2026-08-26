// Problem: Diameter of Binary Tree
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/diameter-of-binary-tree/
// Solved on: 2026-08-26T10:19:47.591Z

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
        int right = height(root.right);
        int ans = Math.max(left,right)+1;
        return ans;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;

        }
        int leftside = diameterOfBinaryTree(root.left);
        int rightside = diameterOfBinaryTree(root.right);
        int third  = height(root.left) + height(root.right);
        int ans = Math.max(leftside,Math.max(rightside,third));
        return ans;


        
    }
}