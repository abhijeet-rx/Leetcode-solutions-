// Problem: Undirected Graph Cycle
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
// Solved on: 2026-09-05T11:12:14.100Z

class Solution {
    boolean dfs(int node , int parent ,ArrayList<ArrayList<Integer>> adj ,boolean[] visited){
        visited[node] = true;
        for(int neighbour:adj.get(node)){
           
            if(visited[neighbour]==false){
                if (dfs(neighbour,node ,adj, visited)){
                    
                return true;
                }
            }
            
            else if(neighbour!=parent){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
           int u = edge[0];
           int v = edge[1];
           adj.get(u).add(v);
                       adj.get(v).add(u);
        }
        for(int i=0;i<V;i++){
            if(!visited[i]){
               if( dfs(i,-1,adj,visited)){
                    
                return true;
                }
            }
        }
        return false;
        
    }
}