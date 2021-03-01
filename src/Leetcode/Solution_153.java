package Leetcode;

public class Solution_153 {
	public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        if(nums[left] < nums[right] || nums.length==1)return nums[left];
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid]>nums[mid+1])return nums[mid+1];
            
            if(nums[mid-1]>nums[mid])return nums[mid];
            if(nums[0]<nums[mid]){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }        
        return -5000;
    }
}
