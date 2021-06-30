package Codility;

import java.util.*;

//RESULT = https://app.codility.com/demo/results/training85D4DZ-CPD/
public class lesson3_PermMissingElem {
	public int solution(int[] A) {
        Arrays.sort(A);
        int current = 1;
        for(int n:A){
            if(current!=n)break;
            current++;
        }
        return current;
    }
}
