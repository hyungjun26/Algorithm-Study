package Codility;

import java.util.*;

// RESULT = https://app.codility.com/demo/results/trainingD25C9H-X3Q/
public class lesson6_NumberOfDiscIntersections {
	public int solution(int[] A) {
        int len = A.length;
        long[] lower = new long[len];
        long[] upper = new long[len];
        for(int i = 0; i < len; i++){
            lower[i] = i - (long)A[i];
            upper[i] = i + (long)A[i];
        }
        Arrays.sort(lower);
        Arrays.sort(upper);
        int cnt = 0;
        int j = 0;
        for(int i = 0; i < len; i++){
            while(j < len && upper[i]>=lower[j]){
                cnt += j;
                cnt -= i;
                j++;
                
            }
        }        
        if(cnt > 10000000)return -1;
        return cnt;
    }
}
