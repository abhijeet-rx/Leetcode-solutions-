// Problem: Python Solution
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
// Solved on: 2026-09-06T13:15:17.715Z

class pair{
    int node;
    int parent;
    pair(int node , int parent){
        this.node = node;
        this.parent = parent;
    }
}
class Solution {
    void bfs(ArrayList<ArrayList<Integer>> adj ,boolean[] visited,int[] parent , Queue<pair> q , int src){
        visited[src] = true;
        parent[src] = -1;
        q.add(new pair(src,-1));
        while(!q.isEmpty()){
            pair curr = q.poll();
            int node  = curr.node;
            
                for(int neighbour:adj.get(node)){
            if(!visited[neighbour]){
                    visited[neighbour] = true;
                    parent[neighbour] = node;
                    q.add(new pair(neighbour,node));
                }
            }
        }
        
    }
    
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        List<Integer> ans = new ArrayList<>();
      ArrayList<ArrayList<Integer>> adj  = new ArrayList<>();
      boolean[] visited =  new boolean[V];
      int[] parent = new int[V];
      Queue<pair> q = new LinkedList<>();
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        bfs(adj,visited,parent ,q , src);
        if (!visited[dest]) {
                 return -1;
             }
        int currNode = dest;
        while(currNode!=-1){
            ans.add(currNode);
            currNode = parent[currNode];
        }
        Collections.reverse(ans);
        return ans.size()-1;
        
    }
}