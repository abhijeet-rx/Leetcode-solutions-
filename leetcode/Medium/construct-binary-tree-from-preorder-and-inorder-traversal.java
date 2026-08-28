// Problem: Construct Binary Tree from Preorder and Inorder Traversal
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Solved on: 2026-08-28T07:12:36.342Z

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
    static int index =0;
    static int findpos(int[] inorder, int start ,int end , int element){
        for(int i=start;i<=end;i++){
            if(inorder[i]==element){
                return i;
            }
        }
        return -1;
    }
    TreeNode solve(int[] preorder, int[] inorder,int inorderstart , int inorderend , int n ){
        if(index>=n || inorderstart>inorderend){
            return null;
        }
        int element = preorder[index++];
        TreeNode root = new TreeNode(element);
        int position = findpos(inorder,inorderstart,inorderend,element);
        root.left = solve(preorder,inorder,inorderstart,position-1,n);
        root.right = solve(preorder,inorder,position+1,inorderend,n);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        index=0;
        return solve(preorder,inorder,0,n-1,n);
        
    }
}