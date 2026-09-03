// Problem: N-Queens
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/n-queens/
// Solved on: 2026-09-03T17:57:26.753Z

class Solution {
    void addSol(List<List<String>> ans,List<List<Integer>> board , int n ){
        List<String> temp = new ArrayList<>();
        for(int i =0;i<n;i++){
            StringBuilder row = new StringBuilder();
            for(int  j=0;j<n;j++){
                if(board.get(i).get(j)==1){
                    row.append('Q');
                }
                else{
                    row.append('.');
                }
            }
                temp.add(row.toString());
        }
                ans.add(temp);
    }
    boolean isSafe(int row , int col , List<List<Integer>> board , int n ){
        int x = row;
        int y = col;
        while(y>=0){
            if(board.get(x).get(y)==1){
                return false;
            }
            y--;
        }
        x = row;
        y= col;
        while(x>=0 && y>=0){
            if(board.get(x).get(y)==1){
                return false;
            }
            x--;
            y--;
        }
        x = row;
        y = col;
        while(x<n && y>=0){
            if(board.get(x).get(y)==1){
                return false;
            }
            x++;
            y--;
        }
        return true;
    }
    void solve(List<List<String>> ans,List<List<Integer>> board , int col , int n ){
        if(col==n){
            addSol(ans,board,n);
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(i,col,board,n)){
                board.get(i).set(col,1);
                solve(ans , board , col+1,n);
                board.get(i).set(col,0);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<List<Integer>> board = new ArrayList<>();
        for(int i =0;i<n;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(0);
            }
            board.add(row);
        }
            solve(ans , board , 0 , n);
            return ans;
        
    }
}