// Problem: Construct Binary Tree from Inorder and Postorder Traversal
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// Solved on: 2026-08-28T11:42:04.438Z

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
    static int index;
    static int findpos(int[] inorder, int start ,int end , int element){
        for(int i=start;i<=end;i++){
            if(inorder[i]==element){
                return i;
            }
        }
        return -1;
    }
    TreeNode solve(int[] inorder, int[] postorder,int start , int end , int n ){
        if(start>end || index<0){
            return null;
        }
        int element = postorder[index--];
        TreeNode root = new TreeNode(element);
        int position = findpos(inorder,start,end,element);
        root.right = solve(inorder,postorder,position+1,end,n);
        root.left = solve(inorder,postorder,start,position-1,n);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        index=n-1;
        return solve(inorder,postorder,0,n-1,n);
        
    }
}