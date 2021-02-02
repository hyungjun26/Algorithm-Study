package Leetcode;

public class Solution_1 {
	public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        outer:for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i]+nums[j]==target){
                    ans[0] = i;
                    ans[1] = j;
                    break outer;
                }
            }
        }
        return ans;
    }
}
