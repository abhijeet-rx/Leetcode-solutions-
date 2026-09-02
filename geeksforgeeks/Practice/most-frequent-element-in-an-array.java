// Problem: Most Frequent in an Array
// Platform: geeksforgeeks
// Language: unknown
// Verdict: Accepted
// URL: https://www.geeksforgeeks.org/problems/most-frequent-element-in-an-array/1
// Solved on: 2026-09-02T18:06:37.283Z

class Solution {
    public int mostFreqEle(int[] arr) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int maxfreq = 0;
        int ans = Integer.MIN_VALUE;
        for(int key:map.keySet()){
            if(map.get(key)>maxfreq || map.get(key) == maxfreq && key>ans){
                maxfreq = map.get(key);
                ans = key;
            }
        }
        return ans;
    }
}