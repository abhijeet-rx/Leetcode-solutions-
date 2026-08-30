// Problem: Search a 2D Matrix
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/search-a-2d-matrix/
// Solved on: 2026-08-30T05:46:43.790Z

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row  = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end  = row*col-1;
        int mid = start+(end-start)/2;
        while(start<=end){
            int element = matrix[mid/col][mid%col];
            
            if(element == target){
                return true;
            }
            else if (element>target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
            mid  = start+(end-start)/2;
        }
        return false;
    }
}