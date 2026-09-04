// Problem: Binary Tree Maximum Path Sum
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/binary-tree-maximum-path-sum/
// Solved on: 2026-09-04T11:26:45.700Z

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
    int maxsum = Integer.MIN_VALUE;
    int path(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = Math.max(0,path(root.left));
        int right = Math.max(0,path(root.right));
        int sum = left+ right+root.val;
        maxsum = Math.max(sum,maxsum);
        return root.val+Math.max(left,right);


        
    }
    public int maxPathSum(TreeNode root) {
         path(root);
        return maxsum;
        
    }
}