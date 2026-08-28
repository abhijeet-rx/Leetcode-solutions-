// Problem: Search in a Binary Search Tree
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/search-in-a-binary-search-tree/
// Solved on: 2026-08-28T17:16:51.028Z

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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode temp = root;
        while(temp!=null){
            if(temp.val==val){
                return temp;
            }
            if(temp.val<val){
                temp = temp.right;
            }
            else{
                temp = temp.left;
            }
        }
        return null;
        
    }
}