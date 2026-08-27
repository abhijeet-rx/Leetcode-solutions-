// Problem: Deepest Leaves Sum
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/deepest-leaves-sum/
// Solved on: 2026-08-27T11:28:04.019Z

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
    int  maxDepth=0;
    int sum=0;
    void solve(TreeNode root , int len){
            if(root==null){

            return;
            }
        if(root.left==null && root.right==null){
            if(len>maxDepth){
                maxDepth = len;
                sum = root.val;
            }
           else if(len==maxDepth){
               sum = sum+root.val;
            }

        }
        
        solve(root.left,len+1);
        solve(root.right,len+1);
    }
    public int deepestLeavesSum(TreeNode root) {
        int len =0;

        solve(root,0);
        return sum;
    }
}