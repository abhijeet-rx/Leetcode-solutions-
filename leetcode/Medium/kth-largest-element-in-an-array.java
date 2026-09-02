// Problem: Kth Largest Element in an Array
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/kth-largest-element-in-an-array/
// Solved on: 2026-09-02T13:37:19.601Z

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq  = new PriorityQueue<>();
        for(int i =0;i<n;i++){
            pq.add(nums[i]);
        }
        int size = nums.length-k;
        while(size>0){
            pq.poll();
            size--;
        }
        return pq.peek();
        
    }
}