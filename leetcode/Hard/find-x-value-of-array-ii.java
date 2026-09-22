// Problem: Find X Value of Array II
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/find-x-value-of-array-ii/
// Solved on: 2026-09-22T16:13:16.534Z

class Solution {

    static class Node {
        long[] prefix;
        int product;

        Node(int k) {
            prefix = new long[k];
        }
    }

    int k;
    Node[] tree;

    Node merge(Node left, Node right) {
        Node res = new Node(k);

        res.product = (int) ((long) left.product * right.product % k);

        for (int r = 0; r < k; r++) {
            res.prefix[r] += left.prefix[r];
        }

        for (int r = 0; r < k; r++) {
            if (right.prefix[r] == 0) continue;

            int rem = (int) ((long) left.product * r % k);
            res.prefix[rem] += right.prefix[r];
        }

        return res;
    }

    void build(int[] nums, int node, int l, int r) {
        if (l == r) {
            Node cur = new Node(k);

            int rem = nums[l] % k;

            cur.product = rem;
            cur.prefix[rem] = 1;

            tree[node] = cur;
            return;
        }

        int mid = l + (r - l) / 2;

        build(nums, node * 2, l, mid);
        build(nums, node * 2 + 1, mid + 1, r);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    void update(
        int node,
        int l,
        int r,
        int index,
        int value
    ) {
        if (l == r) {
            Node cur = new Node(k);

            int rem = value % k;

            cur.product = rem;
            cur.prefix[rem] = 1;

            tree[node] = cur;
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(
                node * 2,
                l,
                mid,
                index,
                value
            );
        } else {
            update(
                node * 2 + 1,
                mid + 1,
                r,
                index,
                value
            );
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    Node query(
        int node,
        int l,
        int r,
        int ql
    ) {
        if (r < ql) {
            return null;
        }

        if (ql <= l) {
            return tree[node];
        }

        int mid = l + (r - l) / 2;

        Node left = query(
            node * 2,
            l,
            mid,
            ql
        );

        Node right = query(
            node * 2 + 1,
            mid + 1,
            r,
            ql
        );

        if (left == null) return right;
        if (right == null) return left;

        return merge(left, right);
    }

    public int[] resultArray(
        int[] nums,
        int k,
        int[][] queries
    ) {
        this.k = k;

        int n = nums.length;

        tree = new Node[4 * n];

        build(nums, 1, 0, n - 1);

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(
                1,
                0,
                n - 1,
                index,
                value
            );

            Node res = query(
                1,
                0,
                n - 1,
                start
            );

            result[i] = (int) res.prefix[x];
        }

        return result;
    }
}