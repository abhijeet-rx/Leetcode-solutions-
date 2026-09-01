// Problem: Balance a Binary Search Tree
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/balance-a-binary-search-tree/
// Solved on: 2026-09-01T06:20:55.208Z

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
     List<Integer> ans  = new ArrayList<>();
    List<Integer> inorder(TreeNode root){
        if(root==null){
            return ans;
        }
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
        return ans;
    }
    TreeNode balance(int start , int end , List<Integer> ans){
        if(start>end){
            return null;
        }
        int mid = start+(end-start)/2;
        TreeNode newNode = new TreeNode(ans.get(mid));
        newNode.left = balance(start ,mid-1, ans);
        newNode.right = balance(mid+1 ,end, ans);
        return newNode;
    }
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        int start = 0;
        int end = ans.size()-1;
        return balance(start,end,ans);
    }
}