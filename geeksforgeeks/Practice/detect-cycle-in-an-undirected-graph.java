// Problem: Undirected Graph Cycle
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
// Solved on: 2026-09-05T12:57:14.093Z

class pair{
    int node;
    int parent;
    pair(int node , int parent ){
        this.node = node;
        this.parent = parent;
    }
}
class Solution {
    boolean bfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited , Queue<pair> q , int start){
        q.add(new pair(start,-1));
        visited[start] = true;
        while(!q.isEmpty()){
            pair current = q.poll();
            int node = current.node;
            int parent = current.parent;
            for(int neighbour:adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.add(new pair(neighbour,node));
                }
                else if(neighbour!=parent){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        Queue<pair> q = new LinkedList<>();
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       boolean[] visited = new boolean[V];
       for(int i =0;i<V;i++){
           adj.add(new ArrayList<>());
       }
       for(int[] edge :edges){
           int u = edge[0];
           int v = edge[1];
           adj.get(u).add(v);
           adj.get(v).add(u);
       }
       for(int i=0;i<V;i++){
           if(visited[i]==false){
       if(bfs(adj,visited,q,i)){
               
           return true;
           }
       }
           
       }
       return false;
        
    }
}