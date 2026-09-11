// Problem: Reverse Words in a String
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/reverse-words-in-a-string/
// Solved on: 2026-09-11T06:46:32.296Z

class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        String ans = "";

        for (int i = words.length - 1; i >= 0; i--) {
            ans += words[i];

            if (i != 0) {
                ans += " ";
            }
        }

        return ans;
    }
}