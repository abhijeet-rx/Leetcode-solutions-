// Problem: PYTHON - HEAP
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/k-th-largest-sum-contiguous-subarray/1
// Solved on: 2026-09-02T12:50:28.505Z

class Solution {
    public static int kthLargest(int[] arr, int k) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        for(int i =0;i<n;i++){
            int sum = 0;
            for(int j =i;j<n;j++){
                sum += arr[j];
            ans.add(sum);
            }
        }
        Collections.sort(ans);
        return ans.get(ans.size()-k);
        
    }
}
