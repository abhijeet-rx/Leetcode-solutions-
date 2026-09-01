// Problem: Using HashMap
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1
// Solved on: 2026-09-01T05:35:46.916Z

/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/
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
    boolean findTarget(Node root, int target) {
     inorder(root);
     int i = 0;
     int j = ans.size()-1;
     int sum = 0;
     while(i<j){
         sum = ans.get(i)+ans.get(j);
        if(sum ==target){
            return true;
        }
        if(sum>target){
            j--;
        }
        else{
            i++;
        }
         
     }
     return false;
     
     
        
    }
}