// Problem: Count Commas in Range II
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/count-commas-in-range-ii/
// Solved on: 2026-09-09T04:52:13.151Z

class Solution {
    public long countCommas(long n) {
        long biggest = 999;

        long commaSum = 0;
        while (n > biggest) {
            commaSum += n - biggest;
            biggest = biggest * 1000 + 999;
        }

        return commaSum;
    }
}