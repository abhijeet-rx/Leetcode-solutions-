// Problem: DFS of Graph
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
// Solved on: 2026-09-04T18:38:49.662Z

class Solution {
    void dfs(int node ,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans, boolean[] visited){
        visited[node] = true;
        ans.add(node);
        for(int neighbour : adj.get(node)){
            if(visited[neighbour]!=true){
                dfs(neighbour,adj,ans,visited);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int size = adj.size();
        ArrayList<Integer> ans  = new ArrayList<>();
        boolean[] visited = new boolean[size];
        Arrays.fill(visited,false);
            dfs(0, adj , ans,visited);
            return ans;
        }
    }
