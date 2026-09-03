// Problem: N-Queen Problem | Backtracking (Brute Force and Optimized Approach)
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/n-queen-problem0315/1
// Solved on: 2026-09-03T18:11:21.897Z

class Solution {
    boolean isSafe(int row , int col , ArrayList<ArrayList<Integer>> board , int n ){
        int x = row;
        int y  =col;
        while(y>=0){
            if(board.get(x).get(y)==1){
                return false;
            }
            y--;
        }
        x = row;
        y = col;
        while(x>=0 && y>=0){
            if(board.get(x).get(y)==1){
                return false;
            }
            y--;
            x--;
        }
         x = row;
        y = col;
        while(x<n && y>=0){
             if(board.get(x).get(y)==1){
                return false;
            }
            y--;
            x++;
        }
        return true;
    }
    void addSol(ArrayList<ArrayList<Integer>> board,ArrayList<ArrayList<Integer>> ans , int n ){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                if(board.get(i).get(j)==1){
                    temp.add(j+1);
                }
            }
        }
        ans.add(temp);
    }
    void solve(int col , ArrayList<ArrayList<Integer>> ans ,ArrayList<ArrayList<Integer>> board, int n ){
        if(col == n){
            addSol(board,ans,n);
            return;
        }
        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board.get(row).set(col,1);
                solve(col+1,ans, board , n);
                board.get(row).set(col,0);
                
            }
        }
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        
        for(int i =0;i<n;i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = 0;j<n;j++){
                row.add(0);
            }
            board.add(row);
        }
        solve(0,ans,board,n);
        return ans;
        
    }
}