// Problem: Count Nodes Equal to Average of Subtree
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
// Solved on: 2026-09-10T16:36:01.721Z

class Solution {

    int ans = 0;

   
    int[] dfs(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;

        int average = sum / count;

        if (average == root.val) {
            ans++;
        }

        return new int[]{sum, count};
    }

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
}