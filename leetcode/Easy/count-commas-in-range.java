// Problem: Count Commas in Range
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/count-commas-in-range/
// Solved on: 2026-09-15T17:29:41.601Z

class Solution {
    public int countCommas(int n) {
        int comma  = 0;
        if(n<1000){
            return 0;
        }
        for(int i =1000;i<=n;i++){
            comma++;
        }
        return comma;
        
    }
}