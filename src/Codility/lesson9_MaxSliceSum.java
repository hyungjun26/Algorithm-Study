package Codility;

import java.util.*;

// RESULT = https://app.codility.com/demo/results/trainingXTMAAT-9KV/
public class lesson9_MaxSliceSum {
	public int solution(int[] A) {
        if(A.length==1)return A[0];
        int[] sum = new int[A.length];
        sum[0] = A[0];
        int MAX = Math.max(Integer.MIN_VALUE, A[0]);
        for(int i = 1; i < A.length; i++){
            sum[i] = Math.max(A[i], sum[i-1]+A[i]);
            MAX = Math.max(MAX, sum[i]);
        }
        
        return MAX;
    }
}
