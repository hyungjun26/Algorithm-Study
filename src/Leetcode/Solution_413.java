package Leetcode;

public class Solution_413 {	
	public int numberOfArithmeticSlices(int[] A) {        
        int ans = 0;
        if(A.length<3)return ans;
        int left = 0;
        int right = 1;
        int prev = A[0]-A[1];        
        while(left<A.length-2){            
            int sub = A[right-1]-A[right];
            if(sub!=prev){            	
                if(right-left-2>0) {
                	ans += sum(right-left-2);
                }
                if(right<A.length-1){
                    left = right-1;
                    right = left + 1;
                    prev = A[left]-A[right];
                } else {
                	break;
                }
            } else {
                right++;
            }
            if(right >= A.length){
                if(right-left-2>0)ans += sum(right-left-2);
                break;
            }
        }
        return ans;
    }
    private int sum(int n){
        if(n==1)return 1;
        return n + sum(n-1);
    }
}
