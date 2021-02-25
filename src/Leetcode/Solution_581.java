package Leetcode;

import java.util.Arrays;

public class Solution_581 {
	public int findUnsortedSubarray(int[] nums) {
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++)temp[i] = nums[i];
        Arrays.sort(temp);
        int start = 0, end = nums.length-1;
        boolean j = false, k = false;
        while(true){
            if(j&&k)break;
            if(start==nums.length||end<0)break;
            if(temp[start]!=nums[start]){
                j = true;                
            } else {
                start++;
            }
            if(temp[end]!=nums[end]){
                k = true;                
            } else {
                end--;
            }
        }
        if(!j||!k)return 0;
        return end-start+1;
    }
}
