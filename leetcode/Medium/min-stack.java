// Problem: Min Stack
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/min-stack/
// Solved on: 2026-08-22T16:51:44.659Z

class MinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> minst = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int value) {
        st.push(value);
        if(minst.isEmpty() || value<=minst.peek()){
            minst.push(value);
        }
        
    }
    
    public void pop() {
        int val = st.pop();
        if(val<=minst.peek())
        minst.pop();
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        int val =st.peek();
        return val;
        
    }
    
    public int getMin() {
       
         return minst.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */