package Codility;

import java.util.*;

// RESULT = https://app.codility.com/demo/results/trainingHV8MWE-9D3/
public class lesson6_Triangle {
	public int solution(int[] A) {
        long P,Q,R;
        Arrays.sort(A);
        for(int i = 0; i < A.length-2; i++){
            P = A[i];
            Q = A[i+1];
            R = A[i+2];
            if(P+Q>R && Q+R>P && R+P>Q){
                return 1;
            }
        }
        return 0;
    }
}
