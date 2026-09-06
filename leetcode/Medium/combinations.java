// Problem: Combinations
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/combinations/
// Solved on: 2026-09-06T12:34:19.262Z

class Solution {
    void solve(List<List<Integer>> ans,List<Integer> currpath,int start ,int n, int k){
        if(k==0){
            ans.add(new ArrayList<>(currpath));
            return;
        }
        for(int i = start;i<=n;i++){
            currpath.add(i);
            solve(ans,currpath,i+1,n,k-1);
            currpath.remove(currpath.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currpath = new ArrayList<>();
        int start =1;
        solve(ans,currpath,start,n,k);
        return ans;
    }
}