package Leetcode;

public class Solution_33 {
	public int search(int[] nums, int target) {
        int rotated = nums.length-1;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i]>nums[i+1])rotated = i;            
        }
        
        int left = 0;
        int right = rotated;
        int mid;
        while(left<=right){
            mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }            
            if(nums[mid]>target){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        left = rotated+1;
        right = nums.length-1;
        while(left<=right){
            mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }            
            if(nums[mid]>target){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }
}
