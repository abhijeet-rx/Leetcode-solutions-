// Problem: Two Sum IV - Input is a BST
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
// Solved on: 2026-09-01T05:31:22.240Z

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
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int i=0;
        int j = ans.size()-1;
        int sum = 0;
        while(i<j){
            sum = ans.get(i)+ans.get(j);
            if(sum==k){
                return true;
            }
            if(sum>k){
                j--;

            }
            else{
                i++;
            }
        }
        return false;
        
    }
}