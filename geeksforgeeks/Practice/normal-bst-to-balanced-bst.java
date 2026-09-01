// Problem: 75 DAYS GFG POTD ARTICLE CHALLENGE DAY 52/75 DAYS
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/normal-bst-to-balanced-bst/1
// Solved on: 2026-09-01T06:17:52.490Z

/* BST Node Structure
class Node
{
    int data;
    Node right, left;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class Solution {
    List<Integer> ans  = new ArrayList<>();
    List<Integer> inorder(Node root){
        if(root==null){
            return ans;
        }
        inorder(root.left);
        ans.add(root.data);
        inorder(root.right);
        return ans;
    }
    Node balance(Node root, int start , int end, List<Integer> ans){
        if(start>end){
            return null;
        }
        int mid = start+(end-start)/2;
        Node newNode = new Node(ans.get(mid));
        newNode.left = balance(root, start,mid-1,ans);
        newNode.right = balance(root,mid+1,end,ans);
        return newNode;
        
    }
     Node balanceBST(Node root) {
        inorder(root);
        int start = 0;
        int end  = ans.size()-1;
        return 
         balance(root,start,end,ans);
        
        
    }
}