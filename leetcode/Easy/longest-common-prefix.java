// Problem: Longest Common Prefix
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/longest-common-prefix/
// Solved on: 2026-09-03T09:09:48.212Z

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String ans = "";
        for(int i =0;i<strs[0].length();i++){
            char ch = strs[0].charAt(i);
        boolean match = true;
        for(int j=1;j<n;j++){
            if(strs[j].length()<=i || ch!=strs[j].charAt(i) ){
                match = false;
                break;
            }
        }
        if(match==false){
            break;
        }
        else{
            ans = ans+ch;
        }
        
        
        }
        return ans;


        
    }
}