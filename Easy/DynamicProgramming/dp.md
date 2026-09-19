## 1107. Min Cost To Make Two Strings Identical

- **Platform**: GeeksforGeeks
- **Problem ID**: 1107
- **Difficulty**: Easy
- **Language**: C++
- **Topics**: Dynamic Programming
- **Solved**: 2026-09-19T05:44:57.134Z

### Problem

*Problem statement not available.*

### Solution

```cpp
class Solution {
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
    

              int n = s1.length();
              int m = s2.length();

              int[][] dp = new int[n + 1][m + 1];

              // Find LCS
              for (int i = 1; i <= n; i++) {
                  for (int j = 1; j <= m; j++) {

                      if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                          dp[i][j] = 1 + dp[i - 1][j - 1];
                      } else {
                          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                      }
                  }
              }

              int lcs = dp[n][m];

              int deleteFromS1 = n - lcs;
              int deleteFromS2 = m - lcs;

              return deleteFromS1 * costS1 + deleteFromS2 * costS2;
          }
      
    }
```
