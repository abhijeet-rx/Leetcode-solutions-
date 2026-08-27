// Problem: Top View of Binary Tree
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
// Solved on: 2026-08-27T09:49:58.400Z

/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> topView(Node root) {
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
            if(!map.containsKey(value)){
                map.put(value,curr.data);;
            }
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