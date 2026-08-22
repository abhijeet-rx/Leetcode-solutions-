// Problem: Min Stack
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/min-stack/
// Solved on: 2026-08-22T16:40:18.680Z

import java.util.*;

class MinStack {

    Stack<Integer> st = new Stack<>();
    Stack<Integer> minSt = new Stack<>();

    public MinStack() {
        
    }

    public void push(int x) {
        st.push(x);

        if (minSt.isEmpty() || x <= minSt.peek()) {
            minSt.push(x);
        }
    }

    public void pop() {
        int val = st.pop();

        if (val == minSt.peek()) {
            minSt.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }
}