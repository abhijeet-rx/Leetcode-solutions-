// Problem: Best soln in c++....
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/merge-k-sorted-arrays/1?utm_source=chatgpt.com
// Solved on: 2026-09-02T13:48:15.952Z

class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        int rows = mat.length;
        int col = mat[0].length;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<col;j++){
                ans.add(mat[i][j]);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}