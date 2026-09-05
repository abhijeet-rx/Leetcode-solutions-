// Problem: Directed Graph Cycle
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
// Solved on: 2026-09-05T13:27:49.893Z

class Solution {
    boolean checkCycle(ArrayList<ArrayList<Integer>> adj,boolean[] visited , int node,boolean[] dfscall){
        visited[node] = true;
        dfscall[node] = true;
       for(int neighbour:adj.get(node)){
            if(visited[neighbour]==false){
                boolean t =checkCycle(adj,visited,neighbour,dfscall);
                if(t){
                    return true;
                }
           
       }
                else if (dfscall[neighbour]){
                    return true;
                }
            }
            dfscall[node] = false;

            return false;
        }
    
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
           
        }
        boolean[] visited = new boolean[V];
        boolean[] dfscall = new boolean[V];
        for(int i = 0;i<V;i++){
            if(visited[i]==false){
                boolean check = checkCycle(adj,visited,i,dfscall);
                  if(check==true){
                return true;
            }
            }
          
        }
        return false;
        
    }
}
