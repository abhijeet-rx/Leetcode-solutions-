// Problem: Rotate Array
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/rotate-array/
// Solved on: 2026-08-30T04:39:17.468Z

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
            int[] temp = new int[n];
        for(int i =0;i<n;i++){
            temp[(k+i)%n] = nums[i];
        }
        for(int i =0;i<n;i++){
            nums[i] = temp[i];
        }
    }
}