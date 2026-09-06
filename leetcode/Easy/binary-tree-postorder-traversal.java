// Problem: Binary Tree Postorder Traversal
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/binary-tree-postorder-traversal/
// Solved on: 2026-09-06T14:21:30.701Z

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

    void postorder(TreeNode root) {
        if (root == null) {
            return;
        }

       
        postorder(root.left);

        
        postorder(root.right);

        
        ans.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return ans;
    }
}