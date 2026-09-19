// Problem: Valid Palindrome
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/valid-palindrome/
// Solved on: 2026-09-19T10:50:24.054Z

class Solution {
    public boolean isPalindrome(String s) {
        String spc ="";
        int n = s.length()-1;
        for(int i = 0;i<=n;i++){
            char curr = s.charAt(i);
             if (Character.isLetterOrDigit(curr)) {
                spc += Character.toLowerCase(curr);
            }
        }
        
        String rev = "";
        for(int i =spc.length()-1;i>=0;i--){
            char curr = spc.charAt(i);
            rev+= curr;
        }
        if(spc.equals(rev)){

        return true;
        }
        else{
            return false;
        }
        
    }
}