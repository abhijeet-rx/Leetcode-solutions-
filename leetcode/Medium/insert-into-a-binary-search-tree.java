// Problem: Insert into a Binary Search Tree
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/insert-into-a-binary-search-tree/
// Solved on: 2026-08-28T12:12:09.942Z

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        if(root.val<val){
            root.right = insertIntoBST(root.right,val);
        }
        if(root.val>val){
            root.left = insertIntoBST(root.left,val);
        }

        return root;
    }
}