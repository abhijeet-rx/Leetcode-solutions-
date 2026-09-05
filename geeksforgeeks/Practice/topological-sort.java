// Problem: Topological Sort
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/topological-sort/1
// Solved on: 2026-09-05T17:26:42.512Z

class Solution {
    // TOPOLOGICAL SORT USING KAHN AlGO
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
       ArrayList<Integer> ans = new ArrayList<>();
       Queue<Integer> q = new LinkedList<>();
       int[] indegree = new int[V];
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       for(int i=0;i<V;i++){
           adj.add(new ArrayList<>());
       }
       for(int i = 0;i<edges.length;i++){
           int u = edges[i][0];
           int v = edges[i][1];
           adj.get(u).add(v);
           
       }for(int i=0;i<V;i++){
       for(int neighbour : adj.get(i)){
           indegree[neighbour]++;
       }
           
       }
       for(int i=0;i<V;i++){
           if(indegree[i]==0){
               q.add(i);
           }
       }
       while(!q.isEmpty()){
           int node = q.poll();
           ans.add(node);
           for(int neighbour:adj.get(node)){
               indegree[neighbour]--;
               if(indegree[neighbour]==0){
                   q.add(neighbour);
               }
           }
       }
       return ans;
        
    }
}