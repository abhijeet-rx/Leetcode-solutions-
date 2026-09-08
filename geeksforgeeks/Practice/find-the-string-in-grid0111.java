// Problem: Word in Grid - All Occurrences
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/find-the-string-in-grid0111/1
// Solved on: 2026-09-08T12:38:09.616Z

class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int n = mat.length;
        int m = mat[0].length;

        // 8 directions
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // Starting character must match
                if (mat[i][j] != word.charAt(0)) {
                    continue;
                }

                // Try all 8 directions
                for (int d = 0; d < 8; d++) {

                    int x = i;
                    int y = j;
                    int k;

                    for (k = 1; k < word.length(); k++) {

                        x += dx[d];
                        y += dy[d];

                        // Out of bounds
                        if (x < 0 || x >= n || y < 0 || y >= m) {
                            break;
                        }

                        // Character doesn't match
                        if (mat[x][y] != word.charAt(k)) {
                            break;
                        }
                    }

                    // Entire word matched
                    if (k == word.length()) {
                        ArrayList<Integer> pos = new ArrayList<>();
                        pos.add(i);
                        pos.add(j);

                        ans.add(pos);

                        // Same starting cell should be added only once
                        break;
                    }
                }
            }
        }

        return ans;
    }
}