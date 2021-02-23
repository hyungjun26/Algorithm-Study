package Leetcode;

public class Solution_240 {
	public boolean searchMatrix(int[][] matrix, int target) {
        boolean ans = false;
        outer:for(int i = 0; i < matrix.length; i++){
            int left = 0;
            int right = matrix[i].length-1;
            while(left<=right){
                int mid = (left+right)/2;
                if(matrix[i][mid]==target){
                    ans = true;
                    break outer;
                }
                if(matrix[i][mid]>target){
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }
        return ans;
    }
}
