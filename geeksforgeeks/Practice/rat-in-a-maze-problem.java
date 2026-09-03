// Problem: Rat in a Maze
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
// Solved on: 2026-09-03T12:54:54.852Z

class Solution {
    
    boolean isSafe(int[][] maze , int x , int y ,List<String> ans ,int n , boolean[][] visited , String path){
        if(x >= 0 && x < n &&
           y >= 0 && y < n &&
           maze[x][y] != 0 &&
           visited[x][y] == false){
            return true;
        }
        else{
            return false;
        }
    }
    void solve(int[][] maze , int x , int y ,List<String> ans ,int n , boolean[][] visited , String path){
        if(x==n-1 && y==n-1){
            ans.add(path);
            return;
            
        }
            visited[x][y] = true;
        if(isSafe(maze , x+1,y,ans,n,visited,path)){
            solve(maze , x+1,y,ans,n,visited,path+'D');
           
            
        }
        if(isSafe(maze , x,y-1,ans,n,visited,path)){
           
            solve(maze , x,y-1,ans,n,visited,path+'L');
            
        }
        if(isSafe(maze , x,y+1,ans,n,visited,path)){
           
            solve(maze , x,y+1,ans,n,visited,path+"R");
           
            
        }
        if(isSafe(maze , x-1,y,ans,n,visited,path)){
            
            solve(maze , x-1,y,ans,n,visited,path+'U');
            
            
        }
            visited[x][y] = false;
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;
        String path = "";
        if(maze[0][0]==0){
            return ans;
        }
        boolean[][] visited = new boolean[n][n];
        solve(maze , 0,0, ans,n,visited, path);
        return ans;
        
    }
}