// Problem: First Negative in Windows of Size K
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
// Solved on: 2026-08-22T18:06:15.893Z

class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = arr.length;
        ArrayList<Integer> a = new ArrayList<>();
        for(int i =0;i<k;i++){
            if(arr[i]<0){
                q.add(i);
                
            }
        }
        if(!q.isEmpty() ){
                a.add(arr[q.peek()]);
        }
        else{
            a.add(0);
        }
        for(int i =k;i<n;i++){
            if(!q.isEmpty() && i-q.peek() >=k){
                q.remove();
            }
             if(arr[i]<0){
                q.add(i);
                
            } if(!q.isEmpty() ){
                a.add(arr[q.peek()]);
        }
        else{
            a.add(0);
        }
            
        }
        return a;
    }
}