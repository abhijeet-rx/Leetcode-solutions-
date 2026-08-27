// Problem: Vertical Tree Traversal
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
// Solved on: 2026-08-27T09:19:26.025Z

/* Structure of binary tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}*/

class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
       ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
       if(root==null){
           return ans;
       }
       Queue<Node> q  = new LinkedList<>();
       Queue<Integer> hd  = new LinkedList<>();
       q.add(root);
       hd.add(0);
      Map<Integer,LinkedList<Integer>> map = new TreeMap<>();
       while(!q.isEmpty()){
        Node temp = q.poll();
        int curr = hd.poll();
        if(!map.containsKey(curr)) map.put(curr,new LinkedList<>());
         map.get(curr).add(temp.data);
         if(temp.left!=null){
             q.add(temp.left);
             hd.add(curr-1);
         }
         if(temp.right!=null){
             q.add(temp.right);
             hd.add(curr+1);
         }
         
       }
       for (LinkedList<Integer> list : map.values()) {
                      ans.add(new ArrayList<>(list));
                  }

                  return ans;
        
    }
}