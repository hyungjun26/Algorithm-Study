package Leetcode;

public class Solution_268 {
	public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean[] check = new boolean[n+1];
        for(int num : nums){
            check[num]=true;
        }
        for(int i = 0; i < check.length; i++){
            if(!check[i])return i;
        }
        return -1;
        // Arrays.sort(nums);
        // int current = 0;
        // for(int num : nums){
        //     if(num!=current)return current;
        //     current++;
        // }
        // return current;
    }
}
