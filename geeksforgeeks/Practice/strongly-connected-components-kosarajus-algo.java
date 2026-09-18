// Problem: Intuition
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
// Solved on: 2026-09-18T06:52:24.486Z

class Solution {
    void dfs1(int node ,ArrayList<ArrayList<Integer>> adj , boolean[] visited,Stack<Integer> st){
        visited[node] = true;
        for(int i:adj.get(node)){
            if(!visited[i]){
                dfs1(i,adj,visited,st);
            }
        }
        st.push(node);
    }
    void dfs2(int node , ArrayList<ArrayList<Integer>> rev,boolean[] visited){
        visited[node] = true;
        for(int i:rev.get(node)){
            if(!visited[i]){
                dfs2(i,rev,visited);
            }
        }
    }
    public int countSCC(int V, int[][] edges) {
       boolean[] visited = new boolean[V];
       Stack<Integer> st = new Stack<>();
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
           if(!visited[i])
           dfs1(i,adj,visited,st);
       }
       ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
       for(int i = 0;i<V;i++){
           rev.add(new ArrayList<>());
       }
       for(int u=0;u<V;u++){
       for(int node :adj.get(u)){
        rev.get(node).add(u);   
       }
       }
       int count = 0;
       Arrays.fill(visited,false);
       while(!st.isEmpty()){
           int node = st.pop();
           if(!visited[node]){
               dfs2(node,rev,visited);
           count++;}
       }
       return count;
           
        
    }
}