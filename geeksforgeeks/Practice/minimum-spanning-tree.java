// Problem: Minimum Spanning Tree
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
// Solved on: 2026-09-16T18:47:23.549Z

class pair{
    int node;
    int weight;
    pair(int node , int weight){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public int spanningTree(int V, int[][] edges) {
       ArrayList<ArrayList<pair>> adj = new ArrayList<>();
       for(int i = 0;i<V;i++){
           adj.add(new ArrayList<>());
           
       }
       for(int[] edge:edges){
           int u = edge[0];
           int v = edge[1];
           int weight = edge[2];
           adj.get(u).add(new pair(v,weight));
           adj.get(v).add(new pair(u,weight));
        
    }
   int[] parent = new int[V];
   boolean[] mst = new boolean[V];
   int[] key = new int[V];
    for(int i = 0;i<V;i++){
        parent[i] = -1;
        mst[i] = false;
        key[i] = Integer.MAX_VALUE;
        
    }
    key[0] = 0;
    parent[0] = -1;
    for(int i=0;i<V;i++){
        int mini = Integer.MAX_VALUE;
        int u=-1;
        for(int j = 0;j<V;j++){
            if(mst[j]==false && key[j]<mini){
                mini = key[j];
                u = j;
            }
        }
        mst[u]  = true;
        for(pair k :adj.get(u)){
            int v = k.node;
            int w = k.weight;
            if(mst[v] == false && w<key[v]){
                parent[v] = u;
                key[v] = w;
            }
        }
    }
    int sum = 0;
    for(int i = 0;i<key.length;i++){
        sum +=key[i];
    }
    return sum;
}
}
