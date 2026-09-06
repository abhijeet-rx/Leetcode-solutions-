// Problem: Shortest Path in Directed Acyclic Graph
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/shortest-path-in-directed-acyclic-graph/1
// Solved on: 2026-09-06T17:37:06.440Z

class pair{
    int data;
    int weight;
    pair(int data , int weight){
        this.data = data;
        this.weight = weight;
    }
}
class Solution {
    void togologicalSort(ArrayList<ArrayList<pair>> adj,Stack<Integer> s,boolean[] visited , int start , int V){
        visited[start] = true;
       for(pair neighbour:adj.get(start)){
            if(!visited[neighbour.data]){
                togologicalSort(adj,s,visited,neighbour.data,V);
                
           
       }
            }
        s.push(start);
        
    }
   
    public ArrayList<Integer> shortestPath(int V, int[][] edges) {
       ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new pair(v,weight));
        }
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                togologicalSort(adj, s, visited, i, V);
            }
        }
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = Integer.MAX_VALUE;
            
        }
        dist[0] = 0;
        while(!s.isEmpty()){
            int node = s.peek();
            s.pop();
            if(dist[node]!=Integer.MAX_VALUE){
                for(pair neighbour:adj.get(node)){
                    if(dist[neighbour.data]>neighbour.weight+dist[node]){
                        dist[neighbour.data] = dist[node]+ neighbour.weight;
                    }
                }
            }
            }
            for(int i = 0;i<V;i++){
                if(dist[i]==Integer.MAX_VALUE){
                    ans.add(-1);
                }
                else
                ans.add(dist[i]);
        }
        return ans;
       
        
    }
}