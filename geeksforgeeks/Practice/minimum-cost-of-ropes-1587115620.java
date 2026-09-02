// Problem: Min Cost to Connect Ropes
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
// Solved on: 2026-09-02T06:14:10.479Z

import java.util.*;
class Solution {
    public int minCost(int[] arr) {
      PriorityQueue<Integer> pq  = new PriorityQueue<>();
      for(int i =0;i<arr.length;i++){
          pq.add(arr[i]);
      }
      int ans = 0;
    
      while(pq.size()>1){
          int sum = 0;
          int a = pq.peek();
          pq.poll();
          int b = pq.peek();
          pq.poll();
          sum = a+b;
          ans = ans+sum;
          pq.add(sum);
      }
      return ans;
        
    }
}