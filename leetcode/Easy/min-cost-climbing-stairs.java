// Problem: Min Cost Climbing Stairs
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/min-cost-climbing-stairs/
// Solved on: 2026-09-19T17:26:05.743Z

class Solution {static int solve(int[] arr , int n,int[] dp ){
        if(n==1){
            return arr[1];
        }
          if(dp[n]!=-1){
            return dp[n];
        }
        if(n==0) return arr[0];
       dp[n] = Math.min(solve(arr,n-1,dp),solve(arr,n-2,dp))+arr[n];
        return dp[n];
    }
    public int minCostClimbingStairs(int[] cost) {
         int n = cost.length;
            int[] dp = new int[n+1];
            Arrays.fill(dp,-1);
        int  ans = Math.min(solve(cost,n-1,dp),solve(cost,n-2,dp));
        return ans;
    }
}