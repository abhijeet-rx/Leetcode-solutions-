// Problem: Validate Binary Search Tree
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/validate-binary-search-tree/
// Solved on: 2026-08-31T09:22:36.565Z

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
        List<Integer> ans = new ArrayList<>();
    List<Integer> inorder(TreeNode root){
        if(root==null){
            return ans;
        }
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
        return ans;
        

    }
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for(int i=0;i<ans.size()-1;i++){
            if(ans.get(i)>=ans.get(i+1)){
                return false;
            }
           
        }
     return true;
    }
}