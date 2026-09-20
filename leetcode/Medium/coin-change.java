// Problem: Coin Change
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/coin-change/
// Solved on: 2026-09-20T16:55:38.406Z

class Solution {
    int solve(int[] arr , int x){
        int n = arr.length;
        int[] dp = new int[x+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
      
         for (int i = 0; i <= x; i++) {
            for (int j = 0; j < arr.length; j++) {

                if (i - arr[j] >= 0 && dp[i - arr[j]] != -1) {
                    if (dp[i] == -1) {
                        dp[i] = 1 + dp[i - arr[j]];
                    } else {
                        dp[i] = Math.min(dp[i], 1 + dp[i - arr[j]]);
                    }
                }
            }
        }

        return dp[x];
    }

    
    public int coinChange(int[] coins, int amount) {
      
       return  solve(coins,amount);
    }
}
