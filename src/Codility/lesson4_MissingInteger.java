package Codility;

import java.util.*;

// RESULT = https://app.codility.com/demo/results/trainingHZRQZZ-T3U/
public class lesson4_MissingInteger {
	public int solution(int[] A) {
        Arrays.sort(A);
        int min = 1;
        int prev = 1;
        for(int n:A){
            if(n > 0){
                if(n==min){
                    prev = min;
                    min++;
                } else if(n > prev && n > min){
                    break;
                }
            }
        }
        return min;
    }
}
