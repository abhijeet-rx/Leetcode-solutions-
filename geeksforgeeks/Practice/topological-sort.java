// Problem: Topological Sort
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/topological-sort/1
// Solved on: 2026-09-05T16:51:00.000Z

class Solution {
    void topological(ArrayList<ArrayList<Integer>> adj,Stack<Integer> s,int node , boolean[] visited ){
        visited[node] = true;
        for(int neighbour:adj.get(node)){
            if(!visited[neighbour]){
                topological(adj,s,neighbour,visited);
            }
        }
        s.push(node);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Stack<Integer> s = new Stack<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
            
            
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            
        }
        for(int i =0;i<V;i++){
            if(!visited[i]){
                topological(adj,s,i,visited);
            }
        }
        while(!s.isEmpty()){
            ans.add(s.peek());
            s.pop();
        }
        return ans;
        
    }
}