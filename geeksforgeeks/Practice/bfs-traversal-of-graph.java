// Problem: Problem: BFS of a graph
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
// Solved on: 2026-09-04T15:30:50.053Z

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int v = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[v];
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
                for(int  neighbour:adj.get(node)){
            if(visited[neighbour]!=true){
            visited[neighbour] = true;
            q.add(neighbour);
                
            }
                    
                }           
        }
        return ans;
        
    }
}