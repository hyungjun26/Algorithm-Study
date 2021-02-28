package Leetcode;

public class Solution_29 {
	public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor == -1)return Integer.MAX_VALUE;
        int A = Math.abs(dividend);
        int B = Math.abs(divisor);
        int ans = 0;
        while(A-B>=0){
            for(int i = 31; i >= 0; i--){
                if((A >>> i)-B >= 0){
                    ans += 1 << i;
                    A -= B << i;
                }
                
            }
        }
        return (dividend > 0) == (divisor > 0) ? ans : -ans;
    }
}
