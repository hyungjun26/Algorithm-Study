package Leetcode;

import java.util.Arrays;

public class Solution_16 {
	public int threeSumClosest(int[] nums, int target) {
        int ans = 0;        
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){             
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target-sum);
                if(diff < min){
                    ans = sum;
                    min = diff;            
                }
                if(sum > target){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
