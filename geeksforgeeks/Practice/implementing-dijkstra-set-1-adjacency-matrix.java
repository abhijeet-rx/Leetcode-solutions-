// Problem: Dijkstra Algorithm
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
// Solved on: 2026-09-07T05:37:00.828Z

class pair{
    int node;
    int weight;
    pair(int node , int weight){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
  
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
                   dist[i] = Integer.MAX_VALUE;

               }
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
            
        }
        dist[src] =0;
        for(int[] edge: edges){
            int u = edge[0];
            int v  = edge[1];
            int weight = edge[2];
            adj.get(u).add(new pair(v,weight));
            adj.get(v).add(new pair(u,weight));
        }
        boolean[] visited = new boolean[V];
       
        PriorityQueue<pair> pq =
                   new PriorityQueue<>((a, b) -> a.weight - b.weight);
                   pq.add(new pair(src,0));
                   
        while(!pq.isEmpty()){
        pair  curr = pq.poll();
        int node  = curr.node;
        int weight = curr.weight;
        if(weight > dist[node]) {
              continue;
          }
        
        for(pair neighbour: adj.get(node)){
            int nextNode = neighbour.node;
            int edgeweight = neighbour.weight;
            
            int newdist = weight+edgeweight;
            if(newdist<dist[nextNode]){
                dist[nextNode] = newdist;
                pq.add(new pair(nextNode,newdist));
            }
        }
       
        
        
        
        
        
        
        
        
        
    }
     for(int i = 0;i<V;i++){
            ans.add(dist[i]);
        }
        return ans;
        
}
}