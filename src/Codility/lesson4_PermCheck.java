package Codility;

import java.util.*;

// RESULT = https://app.codility.com/demo/results/trainingFURC9U-W6M/
public class lesson4_PermCheck {
	public int solution(int[] A) {
        int res = 1;
        int num = 1;
        Arrays.sort(A);
        for(int n : A){
            if(num==n)num++;
            else{
                res=0;
                break;
            }
        }
        return res;
    }
}
