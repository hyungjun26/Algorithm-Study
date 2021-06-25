package Codility;

import java.util.*;

// RESULT = https://app.codility.com/demo/results/trainingTTFT5C-7NS/
public class lesson6_MaxProductOfThree {
	public int solution(int[] A) {
        int max = Integer.MIN_VALUE; 
        Arrays.sort(A);
        int first = A[0]*A[1]*A[A.length-1];
        int last = A[A.length-3]*A[A.length-2]*A[A.length-1];
        max = first > last ? first:last;
        return max;
    }
}
