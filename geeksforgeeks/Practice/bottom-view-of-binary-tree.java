// Problem: Bottom View of Binary Tree
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
// Solved on: 2026-08-27T10:04:20.924Z

/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        if(root==null){
            return ans;

        }
        Queue<Node> q  = new LinkedList<>();
        Queue<Integer> hd = new LinkedList<>(); 
        q.add(root);
        hd.add(0);
        while(!q.isEmpty()){
            Node curr = q.poll();
            int value = hd.poll();
           
                map.put(value,curr.data);;
            if(curr.left!=null){
                q.add(curr.left);
                hd.add(value-1);
            }
            if(curr.right!=null){
                q.add(curr.right);
                hd.add(value+1);
            }

            }
    
        for(int i:map.values()){
            ans.add(i);
        }
        return ans;
}
}
