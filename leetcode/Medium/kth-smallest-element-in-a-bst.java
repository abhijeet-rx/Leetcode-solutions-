// Problem: Kth Smallest Element in a BST
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// Solved on: 2026-08-31T09:51:08.712Z

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
    int i=0;
    int solve(TreeNode root  , int k){
        if(root==null){
            return -1;

        }
       int left =  solve(root.left , k);
        if(left!=-1){
            return left;
        }
        i++;
        if(i==k) {
            return root.val;
        }
        else{
            return solve(root.right , k);
        }
        
    }
    public int kthSmallest(TreeNode root, int k) {
        int ans  = solve(root,k);
        return ans;
        
    }
}