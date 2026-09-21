// Problem: Find X Value of Array I
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/find-x-value-of-array-i/
// Solved on: 2026-09-21T16:09:34.268Z

class Solution {
    public long[] resultArray(int[] nums, int k) {
     

        long[] ans = new long[k];

        // dp[r] = number of subarrays ending at previous index
        // whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {

            long[] newDp = new long[k];

            // Start a new subarray with just nums[i]
            newDp[num % k]++;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {

                if (dp[r] != 0) {
                    int newRemainder = (int)((r * (long)num) % k);

                    newDp[newRemainder] += dp[r];
                }
            }

            // Every subarray ending here contributes to answer
            for (int r = 0; r < k; r++) {
                ans[r] += newDp[r];
            }

            dp = newDp;
        }

        return ans;
    }
}  
  