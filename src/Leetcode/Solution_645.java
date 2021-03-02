package Leetcode;

public class Solution_645 {
	public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int[] cnt = new int[nums.length+1];
        
        for(int n : nums){
            cnt[n]++;
        }
                
        for(int i = 1; i < cnt.length; i++){
            if(cnt[i]==2)ans[0]=i;
            if(cnt[i]==0)ans[1]=i;
        }
        
        return ans;
    }
}
