// Problem: Flatten BST to Sorted List
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/flatten-bst-to-sorted-list--111950/1
// Solved on: 2026-09-01T05:49:42.382Z

/*  Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */
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
    public Node flattenBST(Node root) {
        inorder(root);
        Node newNode = new Node(ans.get(0));
        Node curr = newNode;
        int n = ans.size();
        for(int i = 1;i<n;i++){
            Node temp = new Node(ans.get(i));
            curr.left = null;
            curr.right = temp;
            curr = temp;
        }
        curr.left = null;
        curr.right = null;
       return newNode;
        
    }
}
