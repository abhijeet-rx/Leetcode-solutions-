// Problem: Bellman-ford Algorithm
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
// Solved on: 2026-09-18T09:19:07.742Z

class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {
    int[] dist = new int[V];
    for(int i = 0;i<V;i++){
        dist[i]  = 100000000;
    }
    dist[src] = 0;
    for(int i =1;i<V;i++){
        for(int j = 0;j<edges.length;j++){
            int u = edges[j][0];
            int v = edges[j][1];
            int weight = edges[j][2];
            if(dist[u]!=100000000&&dist[u]+weight<dist[v]){
                dist[v] = dist[u]+weight;
            }
        }
    }
       
      for(int i =1;i<V;i++){
        for(int j = 0;j<edges.length;j++){
            int u = edges[j][0];
            int v = edges[j][1];
            int weight = edges[j][2];
            if(dist[u]!=100000000 && dist[u]+weight<dist[v]){
               return new ArrayList<>(Arrays.asList(-1));
            }
        }
        
    }
    ArrayList<Integer> ans = new ArrayList<>();
       for(int i = 0;i<V;i++){
           ans.add(dist[i]);
       }
    return ans;
   
}
}