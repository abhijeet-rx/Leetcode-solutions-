// Problem: Binary Tree Maximum Path Sum
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/binary-tree-maximum-path-sum/
// Solved on: 2026-09-04T11:12:07.617Z

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
     int maxpathsum =Integer.MIN_VALUE;   
    public int maxPathSum(TreeNode root) {
         path(root);
        return maxpathsum;
        }
        int path(TreeNode root){
            if(root == null) return 0;
            int left = Math.max(path(root.left),0);
            int right = Math.max(path(root.right),0);
            int sum = left + root.val + right;
            maxpathsum = Math.max(maxpathsum,sum);
            return root.val + Math.max(left,right);}
}