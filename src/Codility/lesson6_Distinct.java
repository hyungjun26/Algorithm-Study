package Codility;

import java.util.*;

// RESULT = https://app.codility.com/demo/results/trainingESW5ZS-8JF/
public class lesson6_Distinct {
	public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : A){
            set.add(n);
        }
        return set.size();
    }
}
