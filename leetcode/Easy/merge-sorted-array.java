// Problem: Merge Sorted Array
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/merge-sorted-array/
// Solved on: 2026-08-29T18:08:49.751Z

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int z = m+n;
        int[] nums3 = new int[z];
        int i =0;
        int j = 0;
        int k = 0;
        while(i<m && j<n){
            if(nums1[i] <= nums2[j]){
                nums3[k++] = nums1[i++];
            }
            else{
                nums3[k++]  = nums2[j++];
            }
            
        }
        while(i<m){
            nums3[k++] = nums1[i++];
        }
        while(j<n){
            nums3[k++] = nums2[j++];
        }
        for(int x=0;x<z;x++){
            nums1[x] = nums3[x];
        }
    }
}