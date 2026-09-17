// Problem: Find Two Non-overlapping Sub-arrays Each With Target Sum
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
// Solved on: 2026-09-17T17:10:41.737Z

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = Integer.MAX_VALUE / 2;

        int[] best = new int[n];
        Arrays.fill(best, INF);

        int left = 0;
        int sum = 0;
        int ans = INF;
        int minLen = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int len = right - left + 1;

               
                if (left > 0 && best[left - 1] != INF) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                minLen = Math.min(minLen, len);
            }

           
            if (right == 0) {
                best[right] = minLen;
            } else {
                best[right] = Math.min(best[right - 1], minLen);
            }
        }

        return ans == INF ? -1 : ans;
    }
}